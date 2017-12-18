package br.com.xpto.notification.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.xpto.notification.model.Parameter;

@Repository
public interface ParameterRepository extends CrudRepository< Parameter, Long > {

	Parameter findByParameterName( String parameterName );
	
}
