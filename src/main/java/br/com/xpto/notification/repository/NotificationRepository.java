package br.com.xpto.notification.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.xpto.notification.model.Notification;

@Repository
public interface NotificationRepository extends CrudRepository< Notification, Long > {

}
