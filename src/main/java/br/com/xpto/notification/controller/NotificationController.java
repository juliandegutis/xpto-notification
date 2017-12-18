package br.com.xpto.notification.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.kyros.generics.GenericController;
import br.com.xpto.notification.model.Notification;
import br.com.xpto.notification.service.NotificationService;
import br.com.xpto.notification.to.NotificationRequest;

@RestController
@RequestMapping( value = "/notification" )
public class NotificationController extends GenericController< Notification, Long >{
	
	private NotificationService service;
	
	@Autowired
	public NotificationController( NotificationService service, HttpServletRequest request ) {
		super( service, request );
		this.service = service;
	}
	
	@RequestMapping( value = "/send", method = RequestMethod.POST )
	public Notification sendNotification( @RequestBody NotificationRequest notificationRequest ) {
		return service.sendNotification( notificationRequest );
	}

}
