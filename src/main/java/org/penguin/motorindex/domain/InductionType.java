package org.penguin.motorindex.domain;

import java.util.Map;

import com.google.common.collect.ImmutableMap;

public enum InductionType {
    NA,
    TURBO,
    TURBO_INTERCOOLED,
    TWIN_TURBO_INTERCOOLED,
    TRIPLE_TURBO_INTERCOOLED,
    SUPERCHARGED,
    SUPERCHARGED_INTERCOOLED,
    TWIN_SUPERCHARGED_INTERCOOLED,
    TURBO_SUPERCHARGED_INTERCOOLED;
    
    private static final Map<String, InductionType> stringToInduction = new ImmutableMap.Builder<String, InductionType>()
            .put("Twin Turbo Intercooled", TWIN_TURBO_INTERCOOLED)
            .put("Aspirated", NA)
            .put("Turbo Intercooled", TURBO_INTERCOOLED)
            .put("Turbo", TURBO)
            .put("Supercharged", SUPERCHARGED)
            .put("Turbo Supercharged Intercooled", TURBO_SUPERCHARGED_INTERCOOLED)
            .put("Supercharged Intercooled", SUPERCHARGED_INTERCOOLED)
            .put("Twin Supercharged Intercooled", TWIN_SUPERCHARGED_INTERCOOLED)
            .put("Triple Turbo Intercooled", TRIPLE_TURBO_INTERCOOLED)
            .build();
}
