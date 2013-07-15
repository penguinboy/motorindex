package org.penguin.motorindex.domain;

import com.google.inject.AbstractModule;
import com.googlecode.objectify.ObjectifyService;

public class DomainModule extends AbstractModule {
    
    @Override
    protected void configure() {
        ObjectifyService.register(Car.class);
    }
    
}
