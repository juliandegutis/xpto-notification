package br.com.xpto.notification.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "tb_parametro" )
public class Parameter implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6405954383597314170L;
	
	@Id
	@Column( name = "id_parametro" )
	private Long parameterId;
	
	@Column( name = "nm_parametro" )
	private String parameterName;
	
	@Column( name = "vl_parametro" )
	private String parameterValue;
	
	public Parameter() {
		
	}

	
	public Long getParameterId() {
		return parameterId;
	}

	
	public void setParameterId( Long parameterId ) {
		this.parameterId = parameterId;
	}

	
	public String getParameterName() {
		return parameterName;
	}

	
	public void setParameterName( String parameterName ) {
		this.parameterName = parameterName;
	}

	
	public String getParameterValue() {
		return parameterValue;
	}

	
	public void setParameterValue( String parameterValue ) {
		this.parameterValue = parameterValue;
	}
	
}
