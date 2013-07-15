package org.penguin.motorindex.domain;

import java.util.Map;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;

public enum CamType {
    DOHC,
    DOHC_VVT,
    DOHC_VVT_LIFT,
    OHC,
    OHC_VVT,
    OHC_VVT_LIFT,
    PUSHROD,
    PUSHROD_VVT;
    
    private static final Map<String, CamType> stringToCam = new ImmutableMap.Builder<String, CamType>()
            .put("DOHC with VVT", DOHC_VVT)
            .put("Overhead Cam", OHC)
            .put("DOHC with VVT & Lift", DOHC_VVT_LIFT)
            .put("Double Overhead Cam", DOHC)
            .put("OHC with VVT", OHC_VVT)
            .put("OHC with VVT & Lift", OHC_VVT_LIFT)
            .put("Pushrod", PUSHROD)
            .put("Pushrod with VVT", PUSHROD_VVT)
            .build();
    
    public static CamType fromString(String str) {
        return stringToCam.get(Strings.nullToEmpty(str));
    }
}
