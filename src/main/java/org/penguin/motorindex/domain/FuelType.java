package org.penguin.motorindex.domain;

import java.util.Map;

import com.google.common.collect.ImmutableMap;

public enum FuelType {
    PETROL,
    DIESEL;
    
    private static final Map<String, FuelType> fuelTypeMap = new ImmutableMap.Builder()
            .put("Petrol - Premium ULP", PETROL)
            .put("Petrol - Unleaded ULP", PETROL)
            .put("Diesel", DIESEL)
            .put("Petrol", PETROL)
            .build();
}
