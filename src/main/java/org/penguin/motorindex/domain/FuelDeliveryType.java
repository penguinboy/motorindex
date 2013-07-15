package org.penguin.motorindex.domain;

import java.util.Map;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;

public enum FuelDeliveryType {
    DIRECT_INJECT,
    MULTI_POINT_INJECT,
    SINGLE_POINT_INJECT,
    DIRECT_MULTI_POINT_INJECT,
    CARB_SINGLE,
    CARB_MULTI;
    
    private static final Map<String, FuelDeliveryType> stringToFuelDeliveryType = new ImmutableMap.Builder<String, FuelDeliveryType>()
            .put("Direct Injection", DIRECT_INJECT)
            .put("Multi-Point Injection", MULTI_POINT_INJECT)
            .put("Carburettor Single", CARB_SINGLE)
            .put("Single-Point Injection", SINGLE_POINT_INJECT)
            .put("Direct & Multi-Point Injection", DIRECT_MULTI_POINT_INJECT)
            .put("Carburettor Multiple", CARB_MULTI)
            .build();
    
    public static FuelDeliveryType fromString(String str) {
        return stringToFuelDeliveryType.get(Strings.nullToEmpty(str));
    }
}
