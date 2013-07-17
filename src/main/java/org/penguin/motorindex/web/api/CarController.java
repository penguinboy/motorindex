package org.penguin.motorindex.web.api;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.Form;
import org.penguin.motorindex.domain.Car;
import org.penguin.motorindex.services.CarQuery;
import org.penguin.motorindex.services.CarSearchService;

import com.google.appengine.api.search.Results;
import com.google.appengine.api.search.ScoredDocument;
import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.inject.Inject;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.ObjectifyService;

@Path("/api/car")
public class CarController {
    
    @Inject
    private CarSearchService carSearch;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Car> index(@Form CarQueryModel model) {
        CarQuery query = model.asQuery();
        
        Results<ScoredDocument> results = carSearch.search(query);
        
        Collection<Key<Car>> carKeys = Collections2.transform(results.getResults(), new Function<ScoredDocument,
                Key<Car>>() {
                    
                    @Override
                    public Key<Car> apply(ScoredDocument input) {
                        return Key.create(input.getId());
                    }
                });
        
        return ObjectifyService.ofy().load().keys(carKeys).values();
    }
}
