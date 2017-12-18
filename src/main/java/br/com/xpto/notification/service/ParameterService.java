package br.com.xpto.notification.service;

import br.com.kyros.generics.GenericService;
import br.com.xpto.notification.model.Parameter;

public interface ParameterService extends GenericService< Parameter, Long > { 
 
	Parameter findByParameterName( String parameterName );
	
}
