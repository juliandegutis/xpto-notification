package br.com.xpto.notification.service.impl;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kyros.generics.GenericServiceImpl;
import br.com.xpto.notification.model.Parameter;
import br.com.xpto.notification.repository.ParameterRepository;
import br.com.xpto.notification.service.ParameterService;

@Service
public class ParameterServiceImpl extends GenericServiceImpl< Parameter, Long > implements ParameterService {
	
	private ParameterRepository repository;
	
	@Autowired
	public ParameterServiceImpl( ParameterRepository repository, EntityManager entityManager ) {
		super( repository, entityManager );
		this.repository = repository;
	}

	@Override
	public Parameter findByParameterName( String parameterName ) {
		return repository.findByParameterName( parameterName );
	}

}
