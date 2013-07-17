package org.penguin.motorindex.web.api;

import java.util.Set;

import javax.ws.rs.QueryParam;

import org.penguin.motorindex.domain.BodyType;
import org.penguin.motorindex.domain.CamType;
import org.penguin.motorindex.domain.DeliveryMethod;
import org.penguin.motorindex.domain.DriveType;
import org.penguin.motorindex.domain.EngineCycle;
import org.penguin.motorindex.domain.EngineLocation;
import org.penguin.motorindex.domain.EngineType;
import org.penguin.motorindex.domain.FuelType;
import org.penguin.motorindex.domain.InductionType;
import org.penguin.motorindex.domain.TransmissionType;
import org.penguin.motorindex.services.CarQuery.NumberField;
import org.penguin.motorindex.services.CarQuery.QueryField;

import com.google.common.collect.Sets;

public class CarQueryModel {
    @QueryParam("priceNewLow")
    @NumberSearchField(value = "priceNew", fieldType = NumberField.class)
    private Double priceNewLow;
    @QueryParam("priceNewHigh")
    @NumberSearchField(value = "priceNew", fieldType = NumberField.class)
    private Double priceNewHigh;
    
    @QueryParam("pricePrivateLow")
    @NumberSearchField(value = "pricePrivate", fieldType = NumberField.class)
    private Set<Double> pricePrivateLow;
    @QueryParam("pricePrivateHigh")
    @NumberSearchField(value = "pricePrivate", fieldType = NumberField.class)
    private Set<Double> pricePrivateHigh;
    
    @QueryParam("priceTradeLow")
    @NumberSearchField(value = "priceTrade", fieldType = NumberField.class)
    private Double priceTradeLow;
    @QueryParam("priceTradeHigh")
    @NumberSearchField(value = "priceTrade", fieldType = NumberField.class)
    private Double priceTradeHigh;
    
    @QueryParam("seatsLow")
    @NumberSearchField(value = "seats", fieldType = NumberField.class)
    private Double seatsLow;
    @QueryParam("seatsHigh")
    @NumberSearchField(value = "seats", fieldType = NumberField.class)
    private Double seatsHigh;
    
    @QueryParam("bodyType")
    @NumberSearchField(value = "bodyType", fieldType = NumberField.class)
    private Set<BodyType> bodyType = Sets.newHashSet();
    
    @QueryParam("doorsLow")
    @NumberSearchField(value = "doors", fieldType = NumberField.class)
    private Double doorsLow;
    @QueryParam("doorsHigh")
    @NumberSearchField(value = "doors", fieldType = NumberField.class)
    private Double doorsHigh;
    
    @QueryParam("driveType")
    @NumberSearchField(value = "driveType", fieldType = NumberField.class)
    private Set<DriveType> driveType = Sets.newHashSet();
    
    @QueryParam("engineLocation")
    @NumberSearchField(value = "engineLocation", fieldType = NumberField.class)
    private Set<EngineLocation> engineLocation;
    
    @QueryParam("engineCycle")
    @NumberSearchField(value = "engineCycle", fieldType = NumberField.class)
    private Set<EngineCycle> engineCycle = Sets.newHashSet();
    
    @QueryParam("engineSizeLow")
    @NumberSearchField(value = "engineSize", fieldType = NumberField.class)
    private Double engineSizeLow;
    @QueryParam("engineSizeHigh")
    @NumberSearchField(value = "engineSize", fieldType = NumberField.class)
    private Double engineSizeHigh;
    
    @QueryParam("engineType")
    @NumberSearchField(value = "engineType", fieldType = NumberField.class)
    private Set<EngineType> engineType = Sets.newHashSet();
    
    @QueryParam("tranmissionType")
    @NumberSearchField(value = "tranmissionType", fieldType = NumberField.class)
    private Set<TransmissionType> tranmissionType = Sets.newHashSet();
    
    @QueryParam("gearsLow")
    @NumberSearchField(value = "gears", fieldType = NumberField.class)
    private Double gearsLow;
    @QueryParam("gearsHigh")
    @NumberSearchField(value = "gears", fieldType = NumberField.class)
    private Double gearsHigh;
    
    @QueryParam("cylindersLow")
    @NumberSearchField(value = "cylinders", fieldType = NumberField.class)
    private Double cylindersLow;
    @QueryParam("cylindersHigh")
    @NumberSearchField(value = "cylinders", fieldType = NumberField.class)
    private Double cylindersHigh;
    
    @QueryParam("inductionType")
    @NumberSearchField(value = "inductionType", fieldType = NumberField.class)
    private Set<InductionType> inductionType = Sets.newHashSet();
    
    @QueryParam("compressionLow")
    @NumberSearchField(value = "compression", fieldType = NumberField.class)
    private Double compressionLow;
    @QueryParam("compressionHigh")
    @NumberSearchField(value = "compression", fieldType = NumberField.class)
    private Double compressionHigh;
    
    @QueryParam("fuelType")
    @NumberSearchField(value = "fuelType", fieldType = NumberField.class)
    private Set<FuelType> fuelType = Sets.newHashSet();
    
    @QueryParam("fuelCapacityLow")
    @NumberSearchField(value = "fuelCapacity", fieldType = NumberField.class)
    private Double fuelCapacityLow;
    @QueryParam("fuelCapacityHigh")
    @NumberSearchField(value = "fuelCapacity", fieldType = NumberField.class)
    private Double fuelCapacityHigh;
    
    @QueryParam("fuelDeliveryType")
    @NumberSearchField(value = "fuelDeliveryType", fieldType = NumberField.class)
    private Set<DeliveryMethod> fuelDeliveryType = Sets.newHashSet();
    
    @QueryParam("powerLow")
    @NumberSearchField(value = "power", fieldType = NumberField.class)
    private Double powerLow;
    @QueryParam("powerHigh")
    @NumberSearchField(value = "power", fieldType = NumberField.class)
    private Double powerHigh;
    
    @QueryParam("torqueLow")
    @NumberSearchField(value = "torque", fieldType = NumberField.class)
    private Double torqueLow;
    @QueryParam("torqueHigh")
    @NumberSearchField(value = "torque", fieldType = NumberField.class)
    private Double torqueHigh;
    
    @QueryParam("camType")
    @NumberSearchField(value = "camType", fieldType = NumberField.class)
    private Set<CamType> camType = Sets.newHashSet();
    
    @QueryParam("badge")
    @NumberSearchField(value = "badge", fieldType = NumberField.class)
    private String badge;
    
    @QueryParam("series")
    @NumberSearchField(value = "series", fieldType = NumberField.class)
    private String series;
    
    @QueryParam("fuelRatingUrbanLow")
    @NumberSearchField(value = "fuelRatingUrban", fieldType = NumberField.class)
    private Double fuelRatingUrbanLow;
    @QueryParam("fuelRatingUrbanHigh")
    @NumberSearchField(value = "fuelRatingUrban", fieldType = NumberField.class)
    private Double fuelRatingUrbanHigh;
    
    @QueryParam("fuelRatingExtraUrbanLow")
    @NumberSearchField(value = "fuelRatingExtraUrban", fieldType = NumberField.class)
    private Double fuelRatingExtraUrbanLow;
    @QueryParam("fuelRatingExtraUrbanHigh")
    @NumberSearchField(value = "fuelRatingExtraUrban", fieldType = NumberField.class)
    private Double fuelRatingExtraUrbanHigh;
    
    @QueryParam("fuelRatingCombinedLow")
    @NumberSearchField(value = "fuelRatingCombined", fieldType = NumberField.class)
    private Double fuelRatingCombinedLow;
    @QueryParam("fuelRatingCombinedHigh")
    @NumberSearchField(value = "fuelRatingCombined", fieldType = NumberField.class)
    private Double fuelRatingCombinedHigh;
    
    @QueryParam("valvesPerCylinderLow")
    @NumberSearchField(value = "valvesPerCylinder", fieldType = NumberField.class)
    private Double valvesPerCylinderLow;
    @QueryParam("valvesPerCylinderHigh")
    @NumberSearchField(value = "valvesPerCylinder", fieldType = NumberField.class)
    private Double valvesPerCylinderHigh;
    
    @QueryParam("accelLow")
    @NumberSearchField(value = "accel", fieldType = NumberField.class)
    private Double accelLow;
    @QueryParam("accelHigh")
    @NumberSearchField(value = "accel", fieldType = NumberField.class)
    private Double accelHigh;
    
    @QueryParam("weightKerbLow")
    @NumberSearchField(value = "weightKerb", fieldType = NumberField.class)
    private Double weightKerbLow;
    @QueryParam("weightKerbHigh")
    @NumberSearchField(value = "weightKerb", fieldType = NumberField.class)
    private Double weightKerbHigh;
    
    @QueryParam("weightTareLow")
    @NumberSearchField(value = "weightTare", fieldType = NumberField.class)
    private Double weightTareLow;
    @QueryParam("weightTareHigh")
    @NumberSearchField(value = "weightTare", fieldType = NumberField.class)
    private Double weightTareHigh;
    
    @QueryParam("weightGrossCombinedLow")
    @NumberSearchField(value = "weightGrossCombined", fieldType = NumberField.class)
    private Double weightGrossCombinedLow;
    @QueryParam("weightGrossCombinedHigh")
    @NumberSearchField(value = "weightGrossCombined", fieldType = NumberField.class)
    private Double weightGrossCombinedHigh;
    
    @QueryParam("weightGrossLow")
    @NumberSearchField(value = "weightGross", fieldType = NumberField.class)
    private Double weightGrossLow;
    @QueryParam("weightGrossHigh")
    @NumberSearchField(value = "weightGross", fieldType = NumberField.class)
    private Double weightGrossHigh;
    
    @QueryParam("lengthLow")
    @NumberSearchField(value = "length", fieldType = NumberField.class)
    private Double lengthLow;
    @QueryParam("lengthHigh")
    @NumberSearchField(value = "length", fieldType = NumberField.class)
    private Double lengthHigh;
    
    @QueryParam("widthLow")
    @NumberSearchField(value = "width", fieldType = NumberField.class)
    private Double widthLow;
    @QueryParam("widthHigh")
    @NumberSearchField(value = "width", fieldType = NumberField.class)
    private Double widthHigh;
    
    @QueryParam("heightLow")
    @NumberSearchField(value = "height", fieldType = NumberField.class)
    private Double heightLow;
    @QueryParam("heightHigh")
    @NumberSearchField(value = "height", fieldType = NumberField.class)
    private Double heightHigh;
    
    public static @interface NumberSearchField {
        String value();
        
        Class<? extends QueryField> fieldType();
    }
}