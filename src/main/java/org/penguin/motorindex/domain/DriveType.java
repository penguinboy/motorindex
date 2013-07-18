package org.penguin.motorindex.domain;

import java.util.Map;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;

public enum DriveType {
    RWD,
    FWD,
    FOURWD,
    FOURBYFOUR,
    FOURBYFOUR_ON_DEMAND,
    FOURBYFOUR_DUALRANGE;
    
    private static final Map<String, DriveType> keyToEnum = new ImmutableMap.Builder<String, DriveType>()
            .put("Rear Wheel Drive", RWD)
            .put("Front Wheel Drive", FWD)
            .put("Four Wheel Drive", FOURWD)
            .put("4X4", FOURBYFOUR)
            .put("4X4 On Demand", FOURBYFOUR_ON_DEMAND)
            .put("4X4 Constant", FOURBYFOUR)
            .put("4X4 Dual Range", FOURBYFOUR_DUALRANGE)
            .build();
    
    public static DriveType fromString(String str) {
        return keyToEnum.get(Strings.nullToEmpty(str));
    }
    
}
