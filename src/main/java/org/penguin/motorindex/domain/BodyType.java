package org.penguin.motorindex.domain;

import java.util.Map;

import com.google.common.collect.ImmutableMap;

public enum BodyType {
    COUPE,
    WAGON,
    SEDAN,
    HATCHBACK,
    CONVERTIBLE,
    TARGA,
    CABRILET,
    VAN,
    UTILITY,
    CAB_CHASSIS,
    LIFTBACK,
    BUS,
    TRAYTOP,
    HARDTOP,
    ROADSTER;
    
    private static final Map<String, BodyType> stringtoBodyType = new ImmutableMap.Builder<String, BodyType>()
            .put("Coupe", COUPE)
            .put("Wagon", WAGON)
            .put("Sedan", SEDAN)
            .put("Hatchback", HATCHBACK)
            .put("Convertible", CONVERTIBLE)
            .put("Targa", TARGA)
            .put("Cabriolet", CABRILET)
            .put("Van", VAN)
            .put("Utility", UTILITY)
            .put("Cab Chassis", CAB_CHASSIS)
            .put("Liftback", LIFTBACK)
            .put("Bus", BUS)
            .put("Traytop", TRAYTOP)
            .put("Hardtop", HARDTOP)
            .put("Roadster", ROADSTER)
            .build();
}
