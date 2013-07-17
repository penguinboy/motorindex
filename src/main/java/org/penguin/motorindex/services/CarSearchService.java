package org.penguin.motorindex.services;

import static javax.ws.rs.core.UriBuilder.fromResource;

import java.util.Collection;

import org.penguin.motorindex.domain.Car;
import org.penguin.motorindex.web.api.tasks.IndexBuildController;

import com.google.appengine.api.search.Document;
import com.google.appengine.api.search.Index;
import com.google.appengine.api.search.IndexSpec;
import com.google.appengine.api.search.Query;
import com.google.appengine.api.search.QueryOptions;
import com.google.appengine.api.search.Results;
import com.google.appengine.api.search.ScoredDocument;
import com.google.appengine.api.search.SearchService;
import com.google.appengine.api.search.SearchServiceFactory;
import com.google.appengine.api.taskqueue.Queue;
import com.google.appengine.api.taskqueue.QueueFactory;
import com.google.appengine.api.taskqueue.TaskOptions;
import com.googlecode.objectify.Key;

public class CarSearchService {
    private final SearchService searchService;
    private final Index carIndex;
    private final Queue indexQueue;
    
    public CarSearchService() {
        this.searchService = SearchServiceFactory.getSearchService();
        IndexSpec spec = IndexSpec.newBuilder().setName("carindex").build();
        this.carIndex = searchService.getIndex(spec);
        this.indexQueue = QueueFactory.getQueue("searchBuild");
    }
    
    public void indexCars(Collection<Key<Car>> keys) {
        TaskOptions options = TaskOptions.Builder.withUrl(fromResource(IndexBuildController.class).build().getPath());
        for (Key<Car> key : keys) {
            options = options.param("keys", key.getString());
        }
        indexQueue.add(options);
    }
    
    public void indexCarNow(Car car) {
        carIndex.put(getCarDocument(car));
    }
    
    public Results<ScoredDocument> search(CarQuery carQuery) {
        QueryOptions options = QueryOptions.newBuilder()
                .setLimit(100).build();
        
        Query query = Query.newBuilder()
                .setOptions(options)
                .build(carQuery.asQueryString());
        
        return carIndex.search(query);
    }
    
    private Document getCarDocument(Car car) {
        CarDocumentBuilder builder = CarDocumentBuilder.fromCar(car)
                .addNumber("priceNew", car.getPriceNew())
                .addLowerRangeValue("pricePrivate", car.getPricePrivate())
                .addLowerRangeValue("priceTrade", car.getPriceTrade())
                .addAtom("bodyType", car.getBodyType())
                .addNumber("seats", car.getSeats())
                .addNumber("doors", car.getDoors())
                .addAtom("driveType", car.getDriveType())
                .addAtom("engineLocation", car.getEngineLocation())
                .addAtom("engineCycle", car.getEngineCycle())
                .addNumber("engineSize", car.getEngineSize())
                .addAtom("engineType", car.getEngineType())
                .addAtom("tranmissionType", car.getTransmission())
                .addNumber("gears", car.getGears())
                .addNumber("cylinders", car.getCylinders())
                .addAtom("inductionType", car.getInduction())
                .addNumber("compression", car.getCompression())
                .addAtom("fuelType", car.getFuel())
                .addNumber("recommendedFuel", car.getRecommendedFuel())
                .addNumber("fuelCapacity", car.getFuelCapacity())
                .addAtom("fuelDeliveryType", car.getFuelDelivery())
                .addPowerRating("power", car.getPower())
                .addPowerRating("torque", car.getTorque())
                .addAtom("camType", car.getCam())
                .addAtom("badge", car.getBadge())
                .addAtom("series", car.getSeries())
                .addNumber("fuelRatingUrban", car.getFuelRatingUrban())
                .addNumber("fuelRatingExtraUrban", car.getFuelRatingExtraUrban())
                .addNumber("fuelRatingCombined", car.getFuelRatingCombined())
                .addNumber("valvesPerCylinder", car.getValvesPerCylinder())
                .addNumber("accel", car.getAccel())
                .addNumber("weightKerb", car.getWeightKerb())
                .addNumber("weightTare", car.getWeightTare())
                .addNumber("weightGrossCombined", car.getWeightGrossCombined())
                .addNumber("weightGross", car.getWeightGross())
                .addNumber("length", car.getLength())
                .addNumber("width", car.getWidth())
                .addNumber("height", car.getHeight());
        
        return builder.build();
    }
}
