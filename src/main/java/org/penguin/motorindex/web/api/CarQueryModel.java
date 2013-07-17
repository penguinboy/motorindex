package org.penguin.motorindex.web.api;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Map.Entry;
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
import org.penguin.motorindex.services.CarQuery;
import org.penguin.motorindex.web.api.CarQueryModel.NumberSearchField.LimitType;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

public class CarQueryModel {
    @QueryParam("priceNewLow")
    @NumberSearchField(value = "priceNew", type = LimitType.LOW)
    private Double priceNewLow;
    @QueryParam("priceNewHigh")
    @NumberSearchField(value = "priceNew", type = LimitType.HIGH)
    private Double priceNewHigh;
    
    @QueryParam("pricePrivateLow")
    @NumberSearchField(value = "pricePrivate", type = LimitType.LOW)
    private Double pricePrivateLow;
    @QueryParam("pricePrivateHigh")
    @NumberSearchField(value = "pricePrivate", type = LimitType.HIGH)
    private Double pricePrivateHigh;
    
    @QueryParam("priceTradeLow")
    @NumberSearchField(value = "priceTrade", type = LimitType.LOW)
    private Double priceTradeLow;
    @QueryParam("priceTradeHigh")
    @NumberSearchField(value = "priceTrade", type = LimitType.HIGH)
    private Double priceTradeHigh;
    
    @QueryParam("seatsLow")
    @NumberSearchField(value = "seats", type = LimitType.LOW)
    private Double seatsLow;
    @QueryParam("seatsHigh")
    @NumberSearchField(value = "seats", type = LimitType.HIGH)
    private Double seatsHigh;
    
    @QueryParam("bodyType")
    @AtomSearchField(value = "bodyType")
    private Set<BodyType> bodyType = Sets.newHashSet();
    
    @QueryParam("doorsLow")
    @NumberSearchField(value = "doors", type = LimitType.LOW)
    private Double doorsLow;
    @QueryParam("doorsHigh")
    @NumberSearchField(value = "doors", type = LimitType.HIGH)
    private Double doorsHigh;
    
    @QueryParam("driveType")
    @AtomSearchField(value = "driveType")
    private Set<DriveType> driveType = Sets.newHashSet();
    
    @QueryParam("engineLocation")
    @AtomSearchField(value = "engineLocation")
    private Set<EngineLocation> engineLocation;
    
    @QueryParam("engineCycle")
    @AtomSearchField(value = "engineCycle")
    private Set<EngineCycle> engineCycle = Sets.newHashSet();
    
    @QueryParam("engineSizeLow")
    @NumberSearchField(value = "engineSize", type = LimitType.LOW)
    private Double engineSizeLow;
    @QueryParam("engineSizeHigh")
    @NumberSearchField(value = "engineSize", type = LimitType.HIGH)
    private Double engineSizeHigh;
    
    @QueryParam("engineType")
    @AtomSearchField(value = "engineType")
    private Set<EngineType> engineType = Sets.newHashSet();
    
    @QueryParam("tranmissionType")
    @AtomSearchField(value = "tranmissionType")
    private Set<TransmissionType> tranmissionType = Sets.newHashSet();
    
    @QueryParam("gearsLow")
    @NumberSearchField(value = "gears", type = LimitType.LOW)
    private Double gearsLow;
    @QueryParam("gearsHigh")
    @NumberSearchField(value = "gears", type = LimitType.HIGH)
    private Double gearsHigh;
    
    @QueryParam("cylindersLow")
    @NumberSearchField(value = "cylinders", type = LimitType.LOW)
    private Double cylindersLow;
    @QueryParam("cylindersHigh")
    @NumberSearchField(value = "cylinders", type = LimitType.HIGH)
    private Double cylindersHigh;
    
    @QueryParam("inductionType")
    @AtomSearchField(value = "inductionType")
    private Set<InductionType> inductionType = Sets.newHashSet();
    
    @QueryParam("compressionLow")
    @NumberSearchField(value = "compression", type = LimitType.LOW)
    private Double compressionLow;
    @QueryParam("compressionHigh")
    @NumberSearchField(value = "compression", type = LimitType.HIGH)
    private Double compressionHigh;
    
    @QueryParam("fuelType")
    @AtomSearchField(value = "fuelType")
    private Set<FuelType> fuelType = Sets.newHashSet();
    
    @QueryParam("fuelCapacityLow")
    @NumberSearchField(value = "fuelCapacity", type = LimitType.LOW)
    private Double fuelCapacityLow;
    @QueryParam("fuelCapacityHigh")
    @NumberSearchField(value = "fuelCapacity", type = LimitType.HIGH)
    private Double fuelCapacityHigh;
    
    @QueryParam("fuelDeliveryType")
    @AtomSearchField(value = "fuelDeliveryType")
    private Set<DeliveryMethod> fuelDeliveryType = Sets.newHashSet();
    
    @QueryParam("powerLow")
    @NumberSearchField(value = "power", type = LimitType.LOW)
    private Double powerLow;
    @QueryParam("powerHigh")
    @NumberSearchField(value = "power", type = LimitType.HIGH)
    private Double powerHigh;
    
    @QueryParam("torqueLow")
    @NumberSearchField(value = "torque", type = LimitType.LOW)
    private Double torqueLow;
    @QueryParam("torqueHigh")
    @NumberSearchField(value = "torque", type = LimitType.HIGH)
    private Double torqueHigh;
    
    @QueryParam("camType")
    @AtomSearchField(value = "camType")
    private Set<CamType> camType = Sets.newHashSet();
    
    @QueryParam("badge")
    @SearchField(value = "badge")
    private String badge;
    
    @QueryParam("series")
    @SearchField(value = "series")
    private String series;
    
    @QueryParam("fuelRatingUrbanLow")
    @NumberSearchField(value = "fuelRatingUrban", type = LimitType.LOW)
    private Double fuelRatingUrbanLow;
    @QueryParam("fuelRatingUrbanHigh")
    @NumberSearchField(value = "fuelRatingUrban", type = LimitType.HIGH)
    private Double fuelRatingUrbanHigh;
    
    @QueryParam("fuelRatingExtraUrbanLow")
    @NumberSearchField(value = "fuelRatingExtraUrban", type = LimitType.LOW)
    private Double fuelRatingExtraUrbanLow;
    @QueryParam("fuelRatingExtraUrbanHigh")
    @NumberSearchField(value = "fuelRatingExtraUrban", type = LimitType.HIGH)
    private Double fuelRatingExtraUrbanHigh;
    
    @QueryParam("fuelRatingCombinedLow")
    @NumberSearchField(value = "fuelRatingCombined", type = LimitType.LOW)
    private Double fuelRatingCombinedLow;
    @QueryParam("fuelRatingCombinedHigh")
    @NumberSearchField(value = "fuelRatingCombined", type = LimitType.HIGH)
    private Double fuelRatingCombinedHigh;
    
    @QueryParam("valvesPerCylinderLow")
    @NumberSearchField(value = "valvesPerCylinder", type = LimitType.LOW)
    private Double valvesPerCylinderLow;
    @QueryParam("valvesPerCylinderHigh")
    @NumberSearchField(value = "valvesPerCylinder", type = LimitType.HIGH)
    private Double valvesPerCylinderHigh;
    
    @QueryParam("accelLow")
    @NumberSearchField(value = "accel", type = LimitType.LOW)
    private Double accelLow;
    @QueryParam("accelHigh")
    @NumberSearchField(value = "accel", type = LimitType.HIGH)
    private Double accelHigh;
    
    @QueryParam("weightKerbLow")
    @NumberSearchField(value = "weightKerb", type = LimitType.LOW)
    private Double weightKerbLow;
    @QueryParam("weightKerbHigh")
    @NumberSearchField(value = "weightKerb", type = LimitType.HIGH)
    private Double weightKerbHigh;
    
    @QueryParam("weightTareLow")
    @NumberSearchField(value = "weightTare", type = LimitType.LOW)
    private Double weightTareLow;
    @QueryParam("weightTareHigh")
    @NumberSearchField(value = "weightTare", type = LimitType.HIGH)
    private Double weightTareHigh;
    
    @QueryParam("weightGrossCombinedLow")
    @NumberSearchField(value = "weightGrossCombined", type = LimitType.LOW)
    private Double weightGrossCombinedLow;
    @QueryParam("weightGrossCombinedHigh")
    @NumberSearchField(value = "weightGrossCombined", type = LimitType.HIGH)
    private Double weightGrossCombinedHigh;
    
    @QueryParam("weightGrossLow")
    @NumberSearchField(value = "weightGross", type = LimitType.LOW)
    private Double weightGrossLow;
    @QueryParam("weightGrossHigh")
    @NumberSearchField(value = "weightGross", type = LimitType.HIGH)
    private Double weightGrossHigh;
    
    @QueryParam("lengthLow")
    @NumberSearchField(value = "length", type = LimitType.LOW)
    private Double lengthLow;
    @QueryParam("lengthHigh")
    @NumberSearchField(value = "length", type = LimitType.HIGH)
    private Double lengthHigh;
    
    @QueryParam("widthLow")
    @NumberSearchField(value = "width", type = LimitType.LOW)
    private Double widthLow;
    @QueryParam("widthHigh")
    @NumberSearchField(value = "width", type = LimitType.HIGH)
    private Double widthHigh;
    
    @QueryParam("heightLow")
    @NumberSearchField(value = "height", type = LimitType.LOW)
    private Double heightLow;
    @QueryParam("heightHigh")
    @NumberSearchField(value = "height", type = LimitType.HIGH)
    private Double heightHigh;
    
    private static Map<String, Field> lowNumberFields = Maps.newHashMap();
    private static Map<String, Field> highNumberFields = Maps.newHashMap();
    private static Map<String, Field> atomFields = Maps.newHashMap();
    private static Map<String, Field> stringFields = Maps.newHashMap();
    {
        for (Field field : CarQueryModel.class.getDeclaredFields()) {
            NumberSearchField number = field.getAnnotation(NumberSearchField.class);
            if (number != null) {
                if (number.type() == LimitType.HIGH) {
                    highNumberFields.put(number.value(), field);
                } else {
                    lowNumberFields.put(number.value(), field);
                }
            } else {
                AtomSearchField atom = field.getAnnotation(AtomSearchField.class);
                if (atom != null) {
                    atomFields.put(atom.value(), field);
                } else {
                    SearchField search = field.getAnnotation(SearchField.class);
                    if (search != null) {
                        stringFields.put(search.value(), field);
                    }
                }
            }
        }
    }
    
    public CarQuery asQuery() {
        CarQuery query = new CarQuery();
        for (Entry<String, Field> low : lowNumberFields.entrySet()) {
            try {
                Object raw = low.getValue().get(this);
                if (raw != null) {
                    Double val = (Double) raw;
                    query.setNumberLessThan(low.getKey(), val);
                }
            } catch (IllegalArgumentException | IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        for (Entry<String, Field> high : highNumberFields.entrySet()) {
            try {
                Object raw = high.getValue().get(this);
                if (raw != null) {
                    Double val = (Double) raw;
                    query.setNumberGreaterThan(high.getKey(), val);
                }
            } catch (IllegalArgumentException | IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        for (Entry<String, Field> atom : atomFields.entrySet()) {
            try {
                Object raw = atom.getValue().get(this);
                if (raw != null) {
                    Set<Enum<?>> value = (Set<Enum<?>>) raw;
                    for (Enum e : value) {
                        query.addAtomValue(atom.getKey(), e);
                    }
                }
            } catch (IllegalArgumentException | IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        for (Entry<String, Field> stringField : stringFields.entrySet()) {
            try {
                Object raw = stringField.getValue().get(this);
                if (raw != null) {
                    query.setSearch(stringField.getKey(), (String) raw);
                }
            } catch (IllegalArgumentException | IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return query;
    }
    
    @Retention(RetentionPolicy.RUNTIME)
    public static @interface NumberSearchField {
        public static enum LimitType {
            HIGH,
            LOW
        }
        
        String value();
        
        LimitType type();
    }
    
    @Retention(RetentionPolicy.RUNTIME)
    public static @interface SearchField {
        String value();
    }
    
    @Retention(RetentionPolicy.RUNTIME)
    public static @interface AtomSearchField {
        String value();
    }
}