package org.penguin.motorindex.domain;

import java.util.Map;

import com.google.common.collect.ImmutableMap;

public enum TransmissionType {
    MANUAL,
    MANUAL_AUTOCLUTCH,
    AUTO,
    DUAL_CLUTCH_AUTO,
    SEQUENTIAL_MANUAL,
    DUAL_CLUTCH_SEQUENTIAL_MANUAL,
    CVT,
    REDUCTION_GEAR;
    
    private static final Map<String, TransmissionType> stringToTransmission = new ImmutableMap.Builder<String, TransmissionType>()
            .put("Manual", MANUAL)
            .put("Automatic", AUTO)
            .put("Sports Automatic", AUTO)
            .put("Sports Automatic Dual Clutch", DUAL_CLUTCH_AUTO)
            .put("Seq. Manual Auto-Single Clutch", SEQUENTIAL_MANUAL)
            .put("Sports Automatic Single Clutch", AUTO)
            .put("Manual Auto-clutch - H Pattern", MANUAL_AUTOCLUTCH)
            .put("Constantly Variable Transmission", CVT)
            .put("Seq. Manual Auto-Dual Clutch", DUAL_CLUTCH_SEQUENTIAL_MANUAL)
            .put("Reduction Gear", REDUCTION_GEAR)
            .build();
}
