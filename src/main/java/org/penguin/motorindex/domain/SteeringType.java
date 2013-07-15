package org.penguin.motorindex.domain;

import java.util.Map;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;

public enum SteeringType {
    RACK_PINION,
    REC_BALL,
    FOUR_WHEEL;
    
    private static final Map<String, SteeringType> stringToSteeringType = new ImmutableMap.Builder<String, SteeringType>()
            .put("Rack and Pinion", RACK_PINION)
            .put("Recirculating Ball", REC_BALL)
            .put("4 Wheel Steering", FOUR_WHEEL)
            .build();
    
    public static SteeringType fromString(String str) {
        return stringToSteeringType.get(Strings.nullToEmpty(str));
    }
}
