package org.penguin.motorindex.domain;

import java.util.Map;

import com.google.common.collect.ImmutableMap;

public enum EngineConfiguration {
    INLINE,
    V,
    V90,
    V60,
    V65,
    V15,
    V75,
    V72,
    HORIZONTAL,
    W72_15;
    
    private static final Map<String, EngineConfiguration> stringToEngineConfiguration = new ImmutableMap.Builder<String, EngineConfiguration>()
            .put("In-line", INLINE)
            .put("V90", V90)
            .put("V60", V60)
            .put("V65", V65)
            .put("Horizontal", HORIZONTAL)
            .put("W72/15", W72_15)
            .put("V", V)
            .put("V15", V15)
            .put("V75", V75)
            .put("V72", V72)
            .build();
}
