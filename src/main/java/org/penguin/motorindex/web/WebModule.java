package org.penguin.motorindex.web;

import org.penguin.motorindex.web.api.CarController;
import org.penguin.motorindex.web.api.dev.CarUploadController;
import org.penguin.motorindex.web.api.tasks.IndexBuildController;

import com.google.inject.AbstractModule;

public class WebModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(CarUploadController.class);
        bind(CarController.class);
        bind(IndexBuildController.class);
        bind(CarController.class);
    }
}
