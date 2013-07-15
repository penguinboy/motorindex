package org.penguin.motorindex.domain;

import java.util.Map;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;

public enum RimMaterial {
    ALLOY,
    STEEL;
    
    private static final Map<String, RimMaterial> stringToRimMaterial = new ImmutableMap.Builder<String, RimMaterial>()
            .put("Alloy", ALLOY)
            .put("Steel", STEEL)
            .build();
    
    public static RimMaterial fromString(String str) {
        return stringToRimMaterial.get(Strings.nullToEmpty(str));
    }
}
