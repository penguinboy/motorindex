package org.penguin.motorindex.services;

import static com.google.appengine.api.search.Field.newBuilder;

import org.penguin.motorindex.domain.Car;
import org.penguin.motorindex.domain.IntRange;
import org.penguin.motorindex.domain.PowerRating;

import com.google.appengine.api.search.Document;
import com.google.appengine.api.search.Field;
import com.googlecode.objectify.Ref;

public class CarDocumentBuilder {
    private final Document.Builder builder;
    
    private CarDocumentBuilder(Document.Builder builder) {
        this.builder = builder;
    }
    
    public static CarDocumentBuilder fromCar(Car car) {
        Document.Builder builder = Document.newBuilder().setId(Ref.create(car).getKey().getString())
                .addField(newBuilder().setName("make").setAtom(car.getMake()).build())
                .addField(newBuilder().setName("model").setAtom(car.getModel()).build())
                .addField(newBuilder().setName("year").setNumber(car.getYear()).build());
        
        return new CarDocumentBuilder(builder);
    }
    
    public CarDocumentBuilder addNumber(String key, Integer number) {
        if (number == null) {
            return this;
        }
        return new CarDocumentBuilder(builder.addField(Field.newBuilder().setName(key).setNumber(number).build()));
    }
    
    public CarDocumentBuilder addNumber(String key, Double number) {
        if (number == null) {
            return this;
        }
        return new CarDocumentBuilder(builder.addField(Field.newBuilder().setName(key).setNumber(number).build()));
    }
    
    public CarDocumentBuilder addAtom(String key, Enum<?> enumm) {
        if (enumm == null) {
            return this;
        }
        return new CarDocumentBuilder(builder.addField(Field.newBuilder().setName(key).setAtom(enumm.name()).build()));
    }
    
    public CarDocumentBuilder addAtom(String key, String value) {
        if (value == null) {
            return this;
        }
        return new CarDocumentBuilder(builder.addField(Field.newBuilder().setName(key).setAtom(value).build()));
    }
    
    public CarDocumentBuilder addLowerRangeValue(String key, IntRange range) {
        if (range == null) {
            return this;
        }
        return this.addNumber(key, range.getLow());
    }
    
    public CarDocumentBuilder addPowerRating(String key, PowerRating rating) {
        if (rating == null) {
            return this;
        }
        return this.addNumber(key, rating.getAmount());
    }
    
    public Document build() {
        return this.builder.build();
    }
}
