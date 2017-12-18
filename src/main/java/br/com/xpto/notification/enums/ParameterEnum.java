package br.com.xpto.notification.enums;


public enum ParameterEnum {
	
	TEMPLATE_EMAIL( "TEMPLATE_NOTIFICACAO" );
	
	private String value;
	
	ParameterEnum( String value ) {
		this.value = value;
	}
	
	public String value() {
		return this.value;
	}
	 
}
