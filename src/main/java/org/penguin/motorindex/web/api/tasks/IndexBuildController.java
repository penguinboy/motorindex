package org.penguin.motorindex.web.api.tasks;

import java.util.Collection;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.penguin.motorindex.domain.Car;
import org.penguin.motorindex.services.CarSearchService;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.inject.Inject;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.ObjectifyService;

@Path("/api/tasks/index")
public class IndexBuildController {
    @Inject
    private CarSearchService carSearch;
    
    @POST
    public void buildDocumentsForCars(@FormParam("keys") List<String> keysStr) {
        Collection<Key<Car>> keys = Collections2.transform(keysStr, new Function<String, Key<Car>>() {
            
            @Override
            public Key<Car> apply(String input) {
                return Key.create(input);
            }
        });
        
        Collection<Car> cars = ObjectifyService.ofy().load().keys(keys).values();
        
        for (Car car : cars) {
            carSearch.indexCarNow(car);
        }
    }
}
