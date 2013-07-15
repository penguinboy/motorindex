package org.penguin.motorindex.domain;

import java.util.Map;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;

public enum EngineType {
    PISTON,
    PISTON_ELECTRIC,
    ROTARY,
    ELECTRIC;
    
    private static final Map<String, EngineType> stringToEngineType = new ImmutableMap.Builder<String, EngineType>()
            .put("Piston", PISTON)
            .put("Piston - Electric", PISTON_ELECTRIC)
            .put("Rotary", ROTARY)
            .put("Electric", ELECTRIC)
            .build();
    
    public static EngineType fromString(String str) {
        return stringToEngineType.get(Strings.nullToEmpty(str));
    }
}
