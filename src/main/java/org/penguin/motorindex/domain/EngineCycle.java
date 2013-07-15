package org.penguin.motorindex.domain;

import java.util.Map;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;

public enum EngineCycle {
    TWO_STROKE,
    FOUR_STROKE;
    
    private static final Map<String, EngineCycle> stringToEngineCycle = new ImmutableMap.Builder<String, EngineCycle>()
            .put("2 Stroke", TWO_STROKE)
            .put("4 Stroke", FOUR_STROKE)
            .build();
    
    public static EngineCycle fromString(String str) {
        return stringToEngineCycle.get(Strings.nullToEmpty(str));
    }
}
