package org.penguin.motorindex;

import org.penguin.motorindex.domain.DomainModule;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.servlet.ServletModule;
import com.googlecode.htmleasy.HtmleasyProviders;

public class ApplicationModule implements Module {
    
    @Override
    public void configure(Binder binder) {
        for (Class<?> c : HtmleasyProviders.getClasses()) {
            binder.bind(c);
        }
        binder.install(new ServletModule());
        
        binder.install(new DomainModule());
    }
    
}
