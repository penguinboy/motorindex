package org.penguin.motorindex.domain;

import java.util.Map;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;

public enum DeliveryMethod {
    ELECTRONIC_SEQ,
    ELECTRONIC,
    MECHANICAL;
    
    private static final Map<String, DeliveryMethod> stringToDeliveryType = new ImmutableMap.Builder<String, DeliveryMethod>()
            .put("Electronic Sequential", ELECTRONIC_SEQ)
            .put("Electronic", ELECTRONIC)
            .put("Mechanical", MECHANICAL)
            .build();
    
    public static DeliveryMethod fromString(String str) {
        return stringToDeliveryType.get(Strings.nullToEmpty(str));
    }
}
