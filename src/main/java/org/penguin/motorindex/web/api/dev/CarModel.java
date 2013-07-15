package org.penguin.motorindex.web.api.dev;

import org.penguin.motorindex.domain.BodyType;
import org.penguin.motorindex.domain.CamType;
import org.penguin.motorindex.domain.Car;
import org.penguin.motorindex.domain.DeliveryMethod;
import org.penguin.motorindex.domain.DriveType;
import org.penguin.motorindex.domain.EngineConfiguration;
import org.penguin.motorindex.domain.EngineCycle;
import org.penguin.motorindex.domain.EngineLocation;
import org.penguin.motorindex.domain.EngineType;
import org.penguin.motorindex.domain.FuelDeliveryType;
import org.penguin.motorindex.domain.FuelType;
import org.penguin.motorindex.domain.InductionType;
import org.penguin.motorindex.domain.IntRange;
import org.penguin.motorindex.domain.PowerRating;
import org.penguin.motorindex.domain.RimMaterial;
import org.penguin.motorindex.domain.SteeringType;
import org.penguin.motorindex.domain.TransmissionType;

import com.google.common.base.Strings;

public class CarModel {
    private String pricePrivate;
    private String priceTrade;
    private String avgKm;
    private String priceNew;
    private String driveType;
    private String badge;
    private String fuel;
    private String series;
    private String recommendedFuel;
    private String bodyType;
    private String year;
    private String doors;
    private String vin;
    private String seats;
    private String countryOrigin;
    private String transmission;
    private String gears;
    private String engineLocation;
    private String power;
    private String engineConfiguration;
    private String torque;
    private String engineSize;
    private String induction;
    private String cam;
    private String engineCycle;
    private String fuelCapacity;
    private String engineType;
    private String fuelDelivery;
    private String engineNumber;
    private String deliverMethod;
    private String engineCode;
    private String fuelRatingUrban;
    private String cylinders;
    private String carbonGramsPerKM;
    private String valvesPerCylinder;
    private String fuelRatingExtraUrban;
    private String compression;
    private String fuelRatingCombined;
    private String weightKerb;
    private String length;
    private String weightTare;
    private String width;
    private String towingBrakedKg;
    private String height;
    private String towingKg;
    private String trackFront;
    private String wheelBase;
    private String trackRear;
    private String warrantyKm;
    private String warrantyYears;
    private String steering;
    private String tyreFront;
    private String rimFront;
    private String rimMaterial;
    private String weightGross;
    private String payload;
    private String weightGrossCombined;
    private String accel;
    
    public Car asCar() {
        return new Car(
                IntRange.fromString(pricePrivate),
                IntRange.fromString(priceTrade),
                IntRange.fromString(avgKm),
                getPrice(priceNew),
                BodyType.fromString(bodyType),
                getInt(doors),
                getInt(seats),
                DriveType.fromString(driveType),
                EngineLocation.fromString(engineLocation),
                EngineConfiguration.fromString(engineConfiguration),
                EngineCycle.fromString(engineCycle),
                getInt(engineSize),
                EngineType.fromString(engineType),
                TransmissionType.fromString(transmission),
                getInt(gears),
                getInt(cylinders),
                InductionType.fromString(induction),
                getDouble(compression),
                FuelType.fromString(fuel),
                getInt(recommendedFuel),
                getInt(fuelCapacity),
                FuelDeliveryType.fromString(fuelDelivery),
                PowerRating.fromString(power),
                PowerRating.fromString(torque),
                CamType.fromString(cam),
                getInt(year),
                badge,
                series,
                vin,
                engineNumber,
                engineCode,
                countryOrigin,
                DeliveryMethod.fromString(deliverMethod),
                getInt(carbonGramsPerKM),
                getDouble(fuelRatingUrban),
                getDouble(fuelRatingExtraUrban),
                getDouble(fuelRatingCombined),
                getInt(valvesPerCylinder),
                getDouble(accel),
                getInt(weightKerb),
                getInt(weightTare),
                getInt(weightGrossCombined),
                getInt(weightGross),
                getDouble(length),
                getDouble(width),
                getDouble(height),
                getInt(towingBrakedKg),
                getInt(towingKg),
                getDouble(trackFront),
                getDouble(trackRear),
                getInt(wheelBase),
                getInt(payload),
                getInt(warrantyKm),
                getInt(warrantyYears),
                SteeringType.fromString(steering),
                tyreFront,
                rimFront,
                RimMaterial.fromString(rimMaterial));
    }
    
    private static Integer getInt(String str) {
        if (Strings.isNullOrEmpty(str)) {
            return null;
        }
        return Integer.parseInt(str);
    }
    
    private static Double getDouble(String str) {
        if (Strings.isNullOrEmpty(str)) {
            return null;
        }
        return Double.parseDouble(str);
    }
    
    public static Integer getPrice(String str) {
        if (Strings.isNullOrEmpty(str)) {
            return null;
        }
        // $56,990* Price Guide (EGC)
        str = str.replaceAll("[$,]", "");
        String[] split = str.split("\\*");
        
        try {
            return Integer.parseInt(split[0]);
        } catch (NumberFormatException e) {
            return null;
        }
    }
    
    public String getPricePrivate() {
        return pricePrivate;
    }
    
    public void setPricePrivate(String pricePrivate) {
        this.pricePrivate = pricePrivate;
    }
    
    public String getPriceTrade() {
        return priceTrade;
    }
    
    public void setPriceTrade(String priceTrade) {
        this.priceTrade = priceTrade;
    }
    
    public String getAvgKm() {
        return avgKm;
    }
    
    public void setAvgKm(String avgKm) {
        this.avgKm = avgKm;
    }
    
    public String getPriceNew() {
        return priceNew;
    }
    
    public void setPriceNew(String priceNew) {
        this.priceNew = priceNew;
    }
    
    public String getDriveType() {
        return driveType;
    }
    
    public void setDriveType(String driveType) {
        this.driveType = driveType;
    }
    
    public String getBadge() {
        return badge;
    }
    
    public void setBadge(String badge) {
        this.badge = badge;
    }
    
    public String getFuel() {
        return fuel;
    }
    
    public void setFuel(String fuel) {
        this.fuel = fuel;
    }
    
    public String getSeries() {
        return series;
    }
    
    public void setSeries(String series) {
        this.series = series;
    }
    
    public String getRecommendedFuel() {
        return recommendedFuel;
    }
    
    public void setRecommendedFuel(String recommendedFuel) {
        this.recommendedFuel = recommendedFuel;
    }
    
    public String getBodyType() {
        return bodyType;
    }
    
    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }
    
    public String getYear() {
        return year;
    }
    
    public void setYear(String year) {
        this.year = year;
    }
    
    public String getDoors() {
        return doors;
    }
    
    public void setDoors(String doors) {
        this.doors = doors;
    }
    
    public String getVin() {
        return vin;
    }
    
    public void setVin(String vin) {
        this.vin = vin;
    }
    
    public String getSeats() {
        return seats;
    }
    
    public void setSeats(String seats) {
        this.seats = seats;
    }
    
    public String getCountryOrigin() {
        return countryOrigin;
    }
    
    public void setCountryOrigin(String countryOrigin) {
        this.countryOrigin = countryOrigin;
    }
    
    public String getTransmission() {
        return transmission;
    }
    
    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }
    
    public String getGears() {
        return gears;
    }
    
    public void setGears(String gears) {
        this.gears = gears;
    }
    
    public String getEngineLocation() {
        return engineLocation;
    }
    
    public void setEngineLocation(String engineLocation) {
        this.engineLocation = engineLocation;
    }
    
    public String getPower() {
        return power;
    }
    
    public void setPower(String power) {
        this.power = power;
    }
    
    public String getEngineConfiguration() {
        return engineConfiguration;
    }
    
    public void setEngineConfiguration(String engineConfiguration) {
        this.engineConfiguration = engineConfiguration;
    }
    
    public String getTorque() {
        return torque;
    }
    
    public void setTorque(String torque) {
        this.torque = torque;
    }
    
    public String getEngineSize() {
        return engineSize;
    }
    
    public void setEngineSize(String engineSize) {
        this.engineSize = engineSize;
    }
    
    public String getInduction() {
        return induction;
    }
    
    public void setInduction(String induction) {
        this.induction = induction;
    }
    
    public String getCam() {
        return cam;
    }
    
    public void setCam(String cam) {
        this.cam = cam;
    }
    
    public String getEngineCycle() {
        return engineCycle;
    }
    
    public void setEngineCycle(String engineCycle) {
        this.engineCycle = engineCycle;
    }
    
    public String getFuelCapacity() {
        return fuelCapacity;
    }
    
    public void setFuelCapacity(String fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }
    
    public String getEngineType() {
        return engineType;
    }
    
    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }
    
    public String getFuelDelivery() {
        return fuelDelivery;
    }
    
    public void setFuelDelivery(String fuelDelivery) {
        this.fuelDelivery = fuelDelivery;
    }
    
    public String getEngineNumber() {
        return engineNumber;
    }
    
    public void setEngineNumber(String engineNumber) {
        this.engineNumber = engineNumber;
    }
    
    public String getDeliverMethod() {
        return deliverMethod;
    }
    
    public void setDeliverMethod(String deliverMethod) {
        this.deliverMethod = deliverMethod;
    }
    
    public String getEngineCode() {
        return engineCode;
    }
    
    public void setEngineCode(String engineCode) {
        this.engineCode = engineCode;
    }
    
    public String getFuelRatingUrban() {
        return fuelRatingUrban;
    }
    
    public void setFuelRatingUrban(String fuelRatingUrban) {
        this.fuelRatingUrban = fuelRatingUrban;
    }
    
    public String getCylinders() {
        return cylinders;
    }
    
    public void setCylinders(String cylinders) {
        this.cylinders = cylinders;
    }
    
    public String getCarbonGramsPerKM() {
        return carbonGramsPerKM;
    }
    
    public void setCarbonGramsPerKM(String carbonGramsPerKM) {
        this.carbonGramsPerKM = carbonGramsPerKM;
    }
    
    public String getValvesPerCylinder() {
        return valvesPerCylinder;
    }
    
    public void setValvesPerCylinder(String valvesPerCylinder) {
        this.valvesPerCylinder = valvesPerCylinder;
    }
    
    public String getFuelRatingExtraUrban() {
        return fuelRatingExtraUrban;
    }
    
    public void setFuelRatingExtraUrban(String fuelRatingExtraUrban) {
        this.fuelRatingExtraUrban = fuelRatingExtraUrban;
    }
    
    public String getCompression() {
        return compression;
    }
    
    public void setCompression(String compression) {
        this.compression = compression;
    }
    
    public String getFuelRatingCombined() {
        return fuelRatingCombined;
    }
    
    public void setFuelRatingCombined(String fuelRatingCombined) {
        this.fuelRatingCombined = fuelRatingCombined;
    }
    
    public String getWeightKerb() {
        return weightKerb;
    }
    
    public void setWeightKerb(String weightKerb) {
        this.weightKerb = weightKerb;
    }
    
    public String getLength() {
        return length;
    }
    
    public void setLength(String length) {
        this.length = length;
    }
    
    public String getWeightTare() {
        return weightTare;
    }
    
    public void setWeightTare(String weightTare) {
        this.weightTare = weightTare;
    }
    
    public String getWidth() {
        return width;
    }
    
    public void setWidth(String width) {
        this.width = width;
    }
    
    public String getTowingBrakedKg() {
        return towingBrakedKg;
    }
    
    public void setTowingBrakedKg(String towingBrakedKg) {
        this.towingBrakedKg = towingBrakedKg;
    }
    
    public String getHeight() {
        return height;
    }
    
    public void setHeight(String height) {
        this.height = height;
    }
    
    public String getTowingKg() {
        return towingKg;
    }
    
    public void setTowingKg(String towingKg) {
        this.towingKg = towingKg;
    }
    
    public String getTrackFront() {
        return trackFront;
    }
    
    public void setTrackFront(String trackFront) {
        this.trackFront = trackFront;
    }
    
    public String getWheelBase() {
        return wheelBase;
    }
    
    public void setWheelBase(String wheelBase) {
        this.wheelBase = wheelBase;
    }
    
    public String getTrackRear() {
        return trackRear;
    }
    
    public void setTrackRear(String trackRear) {
        this.trackRear = trackRear;
    }
    
    public String getWarrantyKm() {
        return warrantyKm;
    }
    
    public void setWarrantyKm(String warrantyKm) {
        this.warrantyKm = warrantyKm;
    }
    
    public String getWarrantyYears() {
        return warrantyYears;
    }
    
    public void setWarrantyYears(String warrantyYears) {
        this.warrantyYears = warrantyYears;
    }
    
    public String getSteering() {
        return steering;
    }
    
    public void setSteering(String steering) {
        this.steering = steering;
    }
    
    public String getTyreFront() {
        return tyreFront;
    }
    
    public void setTyreFront(String tyreFront) {
        this.tyreFront = tyreFront;
    }
    
    public String getRimFront() {
        return rimFront;
    }
    
    public void setRimFront(String rimFront) {
        this.rimFront = rimFront;
    }
    
    public String getRimMaterial() {
        return rimMaterial;
    }
    
    public void setRimMaterial(String rimMaterial) {
        this.rimMaterial = rimMaterial;
    }
    
    public String getWeightGross() {
        return weightGross;
    }
    
    public void setWeightGross(String weightGross) {
        this.weightGross = weightGross;
    }
    
    public String getPayload() {
        return payload;
    }
    
    public void setPayload(String payload) {
        this.payload = payload;
    }
    
    public String getWeightGrossCombined() {
        return weightGrossCombined;
    }
    
    public void setWeightGrossCombined(String weightGrossCombined) {
        this.weightGrossCombined = weightGrossCombined;
    }
    
    public String getAccel() {
        return accel;
    }
    
    public void setAccel(String accel) {
        this.accel = accel;
    }
}
