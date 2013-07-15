package org.penguin.motorindex.domain;

import java.util.Map;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;

public enum EngineLocation {
    FRONT,
    REAR,
    MID_REAR,
    MID_FRONT;
    
    private static final Map<String, EngineLocation> stringToLocation = new ImmutableMap.Builder<String, EngineLocation>()
            .put("Front", FRONT)
            .put("Mid-Rear", MID_REAR)
            .put("Rear", REAR)
            .put("Mid-Front", MID_FRONT)
            .build();
    
    public static EngineLocation fromString(String str) {
        return stringToLocation.get(Strings.nullToEmpty(str));
    }
}
