package org.penguin.motorindex.domain;

public class Car {
    private PriceRange pricePrivate;
    private PriceRange priceTrade;
    private String avgKm;
    
    private Integer priceNew;
    
    private BodyType bodyType;
    private Integer doors;
    private Integer seats;
    
    // Engine
    private DriveType driveType;
    private EngineLocation engineLocation;
    private EngineConfiguration engineConfiguration;
    private EngineCycle engineCycle;
    private int engineSize;
    private EngineType engineType;
    private TransmissionType transmission;
    private Integer gears;
    private Integer cylinders;
    private InductionType induction;
    private String compression;
    private FuelType fuel;
    private Integer recommendedFuel;
    private Integer fuelCapacity;
    private String fuelDelivery;
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
    
    private String deliverMethod;
    
    // Measurements
    private Integer carbonGramsPerKM;
    private Double fuelRatingUrban;
    private Double fuelRatingExtraUrban;
    private Double fuelRatingCombined;
    private String valvesPerCylinder;
    private Double accel;
    
    // Size
    private Integer weightKerb;
    private Integer weightTare;
    private Integer weightGrossCombined;
    private String weightGross;
    private Double length;
    private Double width;
    private Double height;
    private Integer towingBrakedKg;
    private Integer towingKg;
    private Double trackFront;
    private Double trackRear;
    private Double wheelBase;
    private Double payload;
    
    private Integer warrantyKm;
    private Integer warrantyYears;
    
    private String steering;
    
    private String tyreFront;
    private String rimFront;
    private String rimMaterial;
    
    private Car() {
    }
    
    public Car(PriceRange pricePrivate, PriceRange priceTrade, String avgKm, int priceNew, BodyType bodyType, int doors, int seats, DriveType driveType,
            EngineLocation engineLocation, EngineConfiguration engineConfiguration, EngineCycle engineCycle, int engineSize, EngineType engineType, TransmissionType transmission, int gears,
            int cylinders, InductionType induction, String compression, FuelType fuel, Integer recommendedFuel, Integer fuelCapacity, String fuelDelivery,
            PowerRating power, PowerRating torque, CamType cam, int year, String badge, String series, String vin, String engineNumber, String engineCode,
            String countryOrigin, String deliverMethod, int carbonGramsPerKM, double fuelRatingUrban, double fuelRatingExtraUrban, double fuelRatingCombined,
            String valvesPerCylinder, double accel, int weightKerb, int weightTare, int weightGrossCombined, String weightGross, double length,
            double width, double height, int towingBrakedKg, int towingKg, double trackFront, double trackRear, double wheelBase, double payload,
            int warrantyKm, int warrantyYears, String steering, String tyreFront, String rimFront, String rimMaterial) {
        super();
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
    
}
