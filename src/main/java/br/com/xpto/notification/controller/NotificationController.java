package br.com.xpto.notification.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.kyros.generics.GenericController;
import br.com.kyros.generics.GenericService;
import br.com.xpto.notification.model.Notification;
import br.com.xpto.notification.to.NotificationRequestTO;

@RestController
@RequestMapping( value = "/notification" )
public class NotificationController extends GenericController< Notification, Long >{
	
	@Autowired
	public NotificationController( GenericService< Notification, Long > service, HttpServletRequest request ) {
		super( service, request );
	}
	
	@RequestMapping( value = "/", method = RequestMethod.POST )
	public Notification sendNotification( @RequestBody NotificationRequestTO notificationRequest ) {
		return null;
	}

}
