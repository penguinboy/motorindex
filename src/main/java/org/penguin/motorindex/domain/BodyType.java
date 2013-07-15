package org.penguin.motorindex.domain;

import java.util.Map;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;

public enum BodyType {
    COUPE,
    WAGON,
    SEDAN,
    HATCHBACK,
    CONVERTIBLE,
    TARGA,
    CABRIOLET,
    VAN,
    UTILITY,
    CAB_CHASSIS,
    LIFTBACK,
    BUS,
    TRAYTOP,
    HARDTOP,
    FASTBACK,
    ROADSTER,
    TIPPER;
    
    private static final Map<String, BodyType> stringToBodyType = new ImmutableMap.Builder<String, BodyType>()
            .put("Coupe", COUPE)
            .put("Wagon", WAGON)
            .put("Sedan", SEDAN)
            .put("Hatchback", HATCHBACK)
            .put("Convertible", CONVERTIBLE)
            .put("Targa", TARGA)
            .put("Cabriolet", CABRIOLET)
            .put("Van", VAN)
            .put("Utility", UTILITY)
            .put("Cab Chassis", CAB_CHASSIS)
            .put("Liftback", LIFTBACK)
            .put("Bus", BUS)
            .put("Traytop", TRAYTOP)
            .put("Hardtop", HARDTOP)
            .put("Roadster", ROADSTER)
            .put("Fastback", FASTBACK)
            .put("Tipper", TIPPER)
            .put("Van Wagon", VAN)
            .put("Softtop", CONVERTIBLE)
            .build();
    
    public static BodyType fromString(String str) {
        return stringToBodyType.get(Strings.nullToEmpty(str));
    }
}
