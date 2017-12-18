package br.com.xpto.notification.service;

import br.com.kyros.generics.GenericService;
import br.com.xpto.notification.model.Notification;
import br.com.xpto.notification.to.NotificationRequest;

public interface NotificationService extends GenericService< Notification, Long > {
	
	Notification sendNotification( NotificationRequest notification );
	
}
