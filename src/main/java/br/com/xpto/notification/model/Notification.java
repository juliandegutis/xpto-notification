package br.com.xpto.notification.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "tb_notificacao" )
public class Notification implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3728071663903210464L;
	
	@Id
	@Column( name = "id_notificacao" )
	private Long notificationId;
	
	@Column( name = "id_usuario" )
	private Long userId;
	
	@Column( name = "dt_envio" )
	private Date sendingDate;
	
	@Column( name = "ds_notificacao" )
	private String body;
	
	public Notification() {
		
	}

	
	public Long getNotificationId() {
		return notificationId;
	}

	
	public void setNotificationId( Long notificationId ) {
		this.notificationId = notificationId;
	}

	
	public Long getUserId() {
		return userId;
	}

	
	public void setUserId( Long userId ) {
		this.userId = userId;
	}

	
	public Date getSendingDate() {
		return sendingDate;
	}

	
	public void setSendingDate( Date sendingDate ) {
		this.sendingDate = sendingDate;
	}

	
	public String getBody() {
		return body;
	}

	
	public void setBody( String body ) {
		this.body = body;
	}
	
}
