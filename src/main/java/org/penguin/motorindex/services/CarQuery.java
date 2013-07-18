package org.penguin.motorindex.services;

import static com.google.common.collect.Sets.newHashSet;
import static com.google.common.collect.Sets.union;

import java.util.Set;

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

import com.google.common.base.Strings;
import com.google.common.collect.Sets;

public class CarQuery {
    private StringField make = new StringField("make");
    private StringField model = new StringField("model");
    private StringField badge = new StringField("badge");
    private StringField series = new StringField("series");
    
    private AtomField<CamType> camType = new AtomField<>("camType");
    private AtomField<BodyType> bodyType = new AtomField<>("bodyType");
    private AtomField<DriveType> driveType = new AtomField<>("driveType");
    private AtomField<EngineLocation> engineLocation = new AtomField<>("engineLocation");
    private AtomField<EngineCycle> engineCycle = new AtomField<>("engineCycle");
    private AtomField<EngineType> engineType = new AtomField<>("engineType");
    private AtomField<TransmissionType> transmissionType = new AtomField<>("tranmissionType");
    private AtomField<InductionType> inductionType = new AtomField<>("inductionType");
    private AtomField<FuelType> fuelType = new AtomField<>("fuelType");
    private AtomField<DeliveryMethod> fuelDevliveryType = new AtomField<>("fuelDeliveryType");
    
    private NumberField year = new NumberField("year");
    private NumberField priceNew = new NumberField("priceNew");
    private NumberField pricePrivate = new NumberField("pricePrivate");
    private NumberField priceTrade = new NumberField("priceTrade");
    private NumberField seats = new NumberField("seats");
    private NumberField doors = new NumberField("doors");
    private NumberField engineSize = new NumberField("engineSize");
    private NumberField gears = new NumberField("gears");
    private NumberField cylinders = new NumberField("cylinders");
    private NumberField compression = new NumberField("compression");
    private NumberField fuelCapacity = new NumberField("fuelCapacity");
    private NumberField power = new NumberField("power");
    private NumberField torque = new NumberField("torque");
    private NumberField fuelRatingUrban = new NumberField("fuelRatingUrban");
    private NumberField fuelRatingExtraUrban = new NumberField("fuelRatingExtraUrban");
    private NumberField fuelRatingCombined = new NumberField("fuelRatingCombined");
    private NumberField valvesPerCylinder = new NumberField("valvesPerCylinder");
    private NumberField accel = new NumberField("accel");
    private NumberField weightKerb = new NumberField("weightKerb");
    private NumberField weightTare = new NumberField("weightTare");
    private NumberField weightGrossCombined = new NumberField("weightGrossCombined");
    private NumberField weightGross = new NumberField("weightGross");
    private NumberField length = new NumberField("length");
    private NumberField width = new NumberField("width");
    private NumberField height = new NumberField("height");
    
    Set<StringField> stringFields = newHashSet(make, model, badge, series);
    Set<AtomField> atomFields = fields(camType, bodyType, driveType, engineLocation, engineCycle,
            engineType, transmissionType, inductionType, fuelType, fuelDevliveryType);
    
    Set<NumberField> numberFields = newHashSet(year, priceNew, pricePrivate, priceTrade, seats, doors,
            engineSize, gears, cylinders, compression, fuelCapacity, power, torque, fuelRatingUrban,
            fuelRatingExtraUrban, fuelRatingCombined, valvesPerCylinder, accel, weightKerb, weightTare,
            weightGrossCombined, weightGross, length, width, height);
    
    Set<QueryField> all = union(union(stringFields, atomFields), numberFields);
    
    public String asQueryString() {
        
        StringBuilder builder = new StringBuilder();
        for (QueryField field : all) {
            builder.append(field.asQueryString());
            builder.append(' ');
        }
        return builder.toString().trim();
    }
    
    private Set<AtomField> fields(AtomField... fields) {
        return Sets.newHashSet(fields);
    }
    
    public void addAtomValue(String key, Enum val) {
        if (val == null) {
            return;
        }
        for (AtomField field : atomFields) {
            if (field.key.equals(key)) {
                field.addValue(val);
                return;
            }
        }
    }
    
    public void setNumberLessThan(String key, Double value) {
        if (value == null) {
            return;
        }
        for (NumberField field : numberFields) {
            if (field.key.equals(key)) {
                field.setLesserEqualThan(value);
                return;
            }
        }
    }
    
    public void setNumberGreaterThan(String key, Double value) {
        if (value == null) {
            return;
        }
        
        for (NumberField field : numberFields) {
            if (field.key.equals(key)) {
                field.setGreaterEqualThan(value);
                return;
            }
        }
    }
    
    public void setSearch(String key, String value) {
        if (Strings.isNullOrEmpty(value)) {
            return;
        }
        
        for (StringField field : stringFields) {
            if (field.key.equals(key)) {
                field.setValue(value);
                return;
            }
        }
    }
    
    public StringField getMake() {
        return make;
    }
    
    public StringField getModel() {
        return model;
    }
    
    public StringField getBadge() {
        return badge;
    }
    
    public StringField getSeries() {
        return series;
    }
    
    public AtomField<CamType> getCamType() {
        return camType;
    }
    
    public AtomField<BodyType> getBodyType() {
        return bodyType;
    }
    
    public AtomField<DriveType> getDriveType() {
        return driveType;
    }
    
    public AtomField<EngineLocation> getEngineLocation() {
        return engineLocation;
    }
    
    public AtomField<EngineCycle> getEngineCycle() {
        return engineCycle;
    }
    
    public AtomField<EngineType> getEngineType() {
        return engineType;
    }
    
    public AtomField<TransmissionType> getTransmissionType() {
        return transmissionType;
    }
    
    public AtomField<InductionType> getInductionType() {
        return inductionType;
    }
    
    public AtomField<FuelType> getFuelType() {
        return fuelType;
    }
    
    public AtomField<DeliveryMethod> getFuelDevliveryType() {
        return fuelDevliveryType;
    }
    
    public NumberField getPriceNew() {
        return priceNew;
    }
    
    public NumberField getPricePrivate() {
        return pricePrivate;
    }
    
    public NumberField getPriceTrade() {
        return priceTrade;
    }
    
    public NumberField getSeats() {
        return seats;
    }
    
    public NumberField getDoors() {
        return doors;
    }
    
    public NumberField getEngineSize() {
        return engineSize;
    }
    
    public NumberField getGears() {
        return gears;
    }
    
    public NumberField getCylinders() {
        return cylinders;
    }
    
    public NumberField getCompression() {
        return compression;
    }
    
    public NumberField getFuelCapacity() {
        return fuelCapacity;
    }
    
    public NumberField getPower() {
        return power;
    }
    
    public NumberField getTorque() {
        return torque;
    }
    
    public NumberField getFuelRatingUrban() {
        return fuelRatingUrban;
    }
    
    public NumberField getFuelRatingExtraUrban() {
        return fuelRatingExtraUrban;
    }
    
    public NumberField getFuelRatingCombined() {
        return fuelRatingCombined;
    }
    
    public NumberField getValvesPerCylinder() {
        return valvesPerCylinder;
    }
    
    public NumberField getAccel() {
        return accel;
    }
    
    public NumberField getWeightKerb() {
        return weightKerb;
    }
    
    public NumberField getWeightTare() {
        return weightTare;
    }
    
    public NumberField getWeightGrossCombined() {
        return weightGrossCombined;
    }
    
    public NumberField getWeightGross() {
        return weightGross;
    }
    
    public NumberField getLength() {
        return length;
    }
    
    public NumberField getWidth() {
        return width;
    }
    
    public NumberField getHeight() {
        return height;
    }
    
    public static class AtomField<T extends Enum> implements QueryField {
        private final String key;
        private final Set<T> values = Sets.newHashSet();
        
        public AtomField(String key) {
            this.key = key;
        }
        
        public void addValue(T v) {
            values.add(v);
        }
        
        public String asQueryString() {
            StringBuilder builder = new StringBuilder("(");
            for (T value : values) {
                if (builder.length() > 1) {
                    builder.append("OR ");
                }
                builder.append(key + ":" + value.name() + " ");
            }
            builder.append(")");
            if (builder.length() <= 2) {
                return "";
            }
            return builder.toString().trim();
        }
    }
    
    public static class NumberField implements QueryField {
        private final String key;
        private Double greaterEqualThan;
        private Double lesserEqualThan;
        
        public NumberField(String key) {
            this.key = key;
        }
        
        public void setGreaterEqualThan(Double greaterEqualThan) {
            this.greaterEqualThan = greaterEqualThan;
        }
        
        public void setLesserEqualThan(Double lesserEqualThan) {
            this.lesserEqualThan = lesserEqualThan;
        }
        
        public String asQueryString() {
            StringBuilder builder = new StringBuilder();
            if (greaterEqualThan != null) {
                builder.append(key + " >= " + greaterEqualThan + " ");
            }
            if (lesserEqualThan != null) {
                builder.append(key + " <= " + lesserEqualThan);
            }
            return builder.toString().trim();
        }
    }
    
    public static class StringField implements QueryField {
        private final String key;
        private String value;
        
        public StringField(String key) {
            this.key = key;
        }
        
        public void setValue(String value) {
            this.value = value;
        }
        
        public String asQueryString() {
            if (Strings.isNullOrEmpty(value)) {
                return "";
            }
            return key + ":\"" + value + "\"";
        }
    }
    
    public static interface QueryField {
        String asQueryString();
    }
}
