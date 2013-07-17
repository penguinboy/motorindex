package org.penguin.motorindex.domain;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Car {
    @Id
    private Long id;
    
    private String make;
    private String model;
    
    private IntRange pricePrivate;
    private IntRange priceTrade;
    private IntRange avgKm;
    
    private Integer priceNew;
    
    private BodyType bodyType;
    private Integer doors;
    private Integer seats;
    
    // Engine
    private DriveType driveType;
    private EngineLocation engineLocation;
    private EngineConfiguration engineConfiguration;
    private EngineCycle engineCycle;
    private Integer engineSize;
    private EngineType engineType;
    private TransmissionType transmission;
    private Integer gears;
    private Integer cylinders;
    private InductionType induction;
    private Double compression;
    private FuelType fuel;
    private Integer recommendedFuel;
    private Integer fuelCapacity;
    private FuelDeliveryType fuelDelivery;
    private PowerRating power;
    private PowerRating torque;
    private CamType cam;
    
    // Brand specifics
    private int year;
    private String badge;
    private String series;
    
    private String vin;
    private String engineNumber;
    private String engineCode;
    private String countryOrigin;
    
    private DeliveryMethod deliverMethod;
    
    // Measurements
    private Integer carbonGramsPerKM;
    private Double fuelRatingUrban;
    private Double fuelRatingExtraUrban;
    private Double fuelRatingCombined;
    private Integer valvesPerCylinder;
    private Double accel;
    
    // Size
    private Integer weightKerb;
    private Integer weightTare;
    private Integer weightGrossCombined;
    private Integer weightGross;
    private Double length;
    private Double width;
    private Double height;
    private Integer towingBrakedKg;
    private Integer towingKg;
    private Double trackFront;
    private Double trackRear;
    private Integer wheelBase;
    private Integer payload;
    
    private Integer warrantyKm;
    private Integer warrantyYears;
    
    private SteeringType steering;
    
    private String tyreFront;
    private String rimFront;
    private RimMaterial rimMaterial;
    
    private Car() {
    }
    
    public Car(String make, String model, IntRange pricePrivate, IntRange priceTrade, IntRange avgKm, Integer priceNew, BodyType bodyType, Integer doors, Integer seats, DriveType driveType,
            EngineLocation engineLocation, EngineConfiguration engineConfiguration, EngineCycle engineCycle, Integer engineSize, EngineType engineType, TransmissionType transmission, Integer gears,
            Integer cylinders, InductionType induction, Double compression, FuelType fuel, Integer recommendedFuel, Integer fuelCapacity, FuelDeliveryType fuelDelivery,
            PowerRating power, PowerRating torque, CamType cam, Integer year, String badge, String series, String vin, String engineNumber, String engineCode,
            String countryOrigin, DeliveryMethod deliverMethod, Integer carbonGramsPerKM, Double fuelRatingUrban, Double fuelRatingExtraUrban, Double fuelRatingCombined,
            Integer valvesPerCylinder, Double accel, Integer weightKerb, Integer weightTare, Integer weightGrossCombined, Integer weightGross, Double length,
            Double width, Double height, Integer towingBrakedKg, Integer towingKg, Double trackFront, Double trackRear, Integer wheelBase, Integer payload,
            Integer warrantyKm, Integer warrantyYears, SteeringType steering, String tyreFront, String rimFront, RimMaterial rimMaterial) {
        super();
        
        this.make = make;
        this.model = model;
        this.pricePrivate = pricePrivate;
        this.priceTrade = priceTrade;
        this.avgKm = avgKm;
        this.priceNew = priceNew;
        this.bodyType = bodyType;
        this.doors = doors;
        this.seats = seats;
        this.driveType = driveType;
        this.engineLocation = engineLocation;
        this.engineConfiguration = engineConfiguration;
        this.engineCycle = engineCycle;
        this.engineSize = engineSize;
        this.engineType = engineType;
        this.transmission = transmission;
        this.gears = gears;
        this.cylinders = cylinders;
        this.induction = induction;
        this.compression = compression;
        this.fuel = fuel;
        this.recommendedFuel = recommendedFuel;
        this.fuelCapacity = fuelCapacity;
        this.fuelDelivery = fuelDelivery;
        this.power = power;
        this.torque = torque;
        this.cam = cam;
        this.year = year;
        this.badge = badge;
        this.series = series;
        this.vin = vin;
        this.engineNumber = engineNumber;
        this.engineCode = engineCode;
        this.countryOrigin = countryOrigin;
        this.deliverMethod = deliverMethod;
        this.carbonGramsPerKM = carbonGramsPerKM;
        this.fuelRatingUrban = fuelRatingUrban;
        this.fuelRatingExtraUrban = fuelRatingExtraUrban;
        this.fuelRatingCombined = fuelRatingCombined;
        this.valvesPerCylinder = valvesPerCylinder;
        this.accel = accel;
        this.weightKerb = weightKerb;
        this.weightTare = weightTare;
        this.weightGrossCombined = weightGrossCombined;
        this.weightGross = weightGross;
        this.length = length;
        this.width = width;
        this.height = height;
        this.towingBrakedKg = towingBrakedKg;
        this.towingKg = towingKg;
        this.trackFront = trackFront;
        this.trackRear = trackRear;
        this.wheelBase = wheelBase;
        this.payload = payload;
        this.warrantyKm = warrantyKm;
        this.warrantyYears = warrantyYears;
        this.steering = steering;
        this.tyreFront = tyreFront;
        this.rimFront = rimFront;
        this.rimMaterial = rimMaterial;
    }
    
    public Long getId() {
        return id;
    }
    
    public String getMake() {
        return make;
    }
    
    public String getModel() {
        return model;
    }
    
    public IntRange getPricePrivate() {
        return pricePrivate;
    }
    
    public IntRange getPriceTrade() {
        return priceTrade;
    }
    
    public IntRange getAvgKm() {
        return avgKm;
    }
    
    public Integer getPriceNew() {
        return priceNew;
    }
    
    public BodyType getBodyType() {
        return bodyType;
    }
    
    public Integer getDoors() {
        return doors;
    }
    
    public Integer getSeats() {
        return seats;
    }
    
    public DriveType getDriveType() {
        return driveType;
    }
    
    public EngineLocation getEngineLocation() {
        return engineLocation;
    }
    
    public EngineConfiguration getEngineConfiguration() {
        return engineConfiguration;
    }
    
    public EngineCycle getEngineCycle() {
        return engineCycle;
    }
    
    public Integer getEngineSize() {
        return engineSize;
    }
    
    public EngineType getEngineType() {
        return engineType;
    }
    
    public TransmissionType getTransmission() {
        return transmission;
    }
    
    public Integer getGears() {
        return gears;
    }
    
    public Integer getCylinders() {
        return cylinders;
    }
    
    public InductionType getInduction() {
        return induction;
    }
    
    public Double getCompression() {
        return compression;
    }
    
    public FuelType getFuel() {
        return fuel;
    }
    
    public Integer getRecommendedFuel() {
        return recommendedFuel;
    }
    
    public Integer getFuelCapacity() {
        return fuelCapacity;
    }
    
    public FuelDeliveryType getFuelDelivery() {
        return fuelDelivery;
    }
    
    public PowerRating getPower() {
        return power;
    }
    
    public PowerRating getTorque() {
        return torque;
    }
    
    public CamType getCam() {
        return cam;
    }
    
    public int getYear() {
        return year;
    }
    
    public String getBadge() {
        return badge;
    }
    
    public String getSeries() {
        return series;
    }
    
    public String getVin() {
        return vin;
    }
    
    public String getEngineNumber() {
        return engineNumber;
    }
    
    public String getEngineCode() {
        return engineCode;
    }
    
    public String getCountryOrigin() {
        return countryOrigin;
    }
    
    public DeliveryMethod getDeliverMethod() {
        return deliverMethod;
    }
    
    public Integer getCarbonGramsPerKM() {
        return carbonGramsPerKM;
    }
    
    public Double getFuelRatingUrban() {
        return fuelRatingUrban;
    }
    
    public Double getFuelRatingExtraUrban() {
        return fuelRatingExtraUrban;
    }
    
    public Double getFuelRatingCombined() {
        return fuelRatingCombined;
    }
    
    public Integer getValvesPerCylinder() {
        return valvesPerCylinder;
    }
    
    public Double getAccel() {
        return accel;
    }
    
    public Integer getWeightKerb() {
        return weightKerb;
    }
    
    public Integer getWeightTare() {
        return weightTare;
    }
    
    public Integer getWeightGrossCombined() {
        return weightGrossCombined;
    }
    
    public Integer getWeightGross() {
        return weightGross;
    }
    
    public Double getLength() {
        return length;
    }
    
    public Double getWidth() {
        return width;
    }
    
    public Double getHeight() {
        return height;
    }
    
    public Integer getTowingBrakedKg() {
        return towingBrakedKg;
    }
    
    public Integer getTowingKg() {
        return towingKg;
    }
    
    public Double getTrackFront() {
        return trackFront;
    }
    
    public Double getTrackRear() {
        return trackRear;
    }
    
    public Integer getWheelBase() {
        return wheelBase;
    }
    
    public Integer getPayload() {
        return payload;
    }
    
    public Integer getWarrantyKm() {
        return warrantyKm;
    }
    
    public Integer getWarrantyYears() {
        return warrantyYears;
    }
    
    public SteeringType getSteering() {
        return steering;
    }
    
    public String getTyreFront() {
        return tyreFront;
    }
    
    public String getRimFront() {
        return rimFront;
    }
    
    public RimMaterial getRimMaterial() {
        return rimMaterial;
    }
}
