package org.opensprout.sandbox.lifecycle;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component
public class Bean {

	@Autowired(required=false)
	ApplicationContext applicationContext;
	
	@Autowired
	MessageSource messageSource;
	
	@Autowired
	ApplicationEventPublisher applicationEventPublisher;

	@Autowired
	ResourceLoader resourceLoader;
	
	@Autowired
	BeanFactory beanFactory;
	
}
