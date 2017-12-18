package br.com.xpto.notification.service.impl;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import br.com.kyros.generics.GenericServiceImpl;
import br.com.xpto.notification.enums.ParameterEnum;
import br.com.xpto.notification.exception.NotificationException;
import br.com.xpto.notification.model.Notification;
import br.com.xpto.notification.model.Parameter;
import br.com.xpto.notification.repository.NotificationRepository;
import br.com.xpto.notification.service.NotificationService;
import br.com.xpto.notification.service.ParameterService;
import br.com.xpto.notification.to.NotificationRequest;

@Service
public class NotificationServiceImpl extends GenericServiceImpl< Notification, Long > implements NotificationService {

	@Autowired
	private ParameterService parameterService;
	
	@Autowired
	private Environment environment;

	private NotificationRepository repository;

	@Autowired
	public NotificationServiceImpl( NotificationRepository repository, EntityManager entityManager ) {
		super( repository, entityManager );
		this.repository = repository;
	}

	@Override
	public Notification sendNotification( NotificationRequest notification ) {

		try {

			Parameter parameter = parameterService.findByParameterName( ParameterEnum.TEMPLATE_EMAIL.value() );
			
			send( notification, parameter );
			
			return save( notification );
			
		} catch ( Exception ex ) {
			throw new NotificationException( ex.getMessage() );
		}

	}

	private void send( NotificationRequest notification, Parameter parameter ) {

		String body = parameter.getParameterValue();
		
		body = body.replace( "#USERNAME#", notification.getUsername() ).replace( "#SMRACODE#", notification.getSmraCode() );
		
		notification.setBody( body );
		
		Properties props = new Properties();

		props.put( "mail.smtp.host", environment.getProperty( "mail.smtp.host" ) );
		props.put( "mail.smtp.socketFactory.port", environment.getProperty( "mail.smtp.socketFactory.port" ) );
		props.put( "mail.smtp.socketFactory.class", environment.getProperty( "mail.smtp.socketFactory.class" ) );
		props.put( "mail.smtp.auth", environment.getProperty( "mail.smtp.auth" ) );
		props.put( "mail.smtp.port", environment.getProperty( "mail.smtp.port" ) );

		Session session = Session.getDefaultInstance( props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication( environment.getProperty( "mail.smtp.username" ), 
					environment.getProperty( "mail.smtp.password" ) );
			}
		} );

		try {

			Message message = new MimeMessage( session );
			message.setFrom( new InternetAddress( environment.getProperty( "mail.smtp.username" ) ) );
			message.setRecipients( Message.RecipientType.TO, InternetAddress.parse( notification.getEmail() ) );
			message.setSubject( "Aviso de Monitoramento" );
			message.setText( body );

			Transport.send( message );
			
		} catch ( Exception ex ) {
			throw new NotificationException( ex.getMessage() );
		}
	}
	
	private Notification save( NotificationRequest notification ) {
		
		try {
		
			Notification persist = new Notification();
			persist.setBody( notification.getBody() );
			persist.setSendingDate( new Date() );
			persist.setUserId( notification.getUserId() );
			
			return repository.save( persist );
			
		} catch( Exception ex ) {
			throw new NotificationException( ex.getMessage() );
		}
		
	}

}
