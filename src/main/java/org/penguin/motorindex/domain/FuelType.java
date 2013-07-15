package org.penguin.motorindex.domain;

import java.util.Map;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;

public enum FuelType {
    PETROL,
    DIESEL,
    ELECTRIC,
    LPG,
    PETROL_OR_LPG;
    
    private static final Map<String, FuelType> fuelTypeMap = new ImmutableMap.Builder()
            .put("Petrol - Premium ULP", PETROL)
            .put("Petrol - Unleaded ULP", PETROL)
            .put("Diesel", DIESEL)
            .put("Petrol", PETROL)
            .put("Petrol or LPG (Dual)", PETROL_OR_LPG)
            .put("LPG only", LPG)
            .put("Electric", ELECTRIC)
            .build();
    
    public static FuelType fromString(String str) {
        return fuelTypeMap.get(Strings.nullToEmpty(str));
    }
}
