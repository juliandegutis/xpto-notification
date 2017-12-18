package br.com.xpto.notification.service.impl;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kyros.generics.GenericServiceImpl;
import br.com.xpto.notification.model.Notification;
import br.com.xpto.notification.repository.NotificationRepository;
import br.com.xpto.notification.service.NotificationService;

@Service
public class NotificationServiceImpl extends GenericServiceImpl< Notification, Long > implements NotificationService {

	@Autowired
	public NotificationServiceImpl( NotificationRepository repository, EntityManager entityManager ) {
		super( repository, entityManager );
	}

}
