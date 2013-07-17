package org.penguin.motorindex.web.api.dev;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Properties;
import java.util.Set;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.penguin.motorindex.domain.Car;
import org.penguin.motorindex.services.CarSearchService;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.ObjectifyService;

@Path("/api/dev/car")
public class CarUploadController {
    private String uploadKey = "";
    
    @Inject
    private CarSearchService carSearch;
    
    public CarUploadController() {
        try {
            Properties props = new Properties();
            InputStream in = getClass().getResourceAsStream("dev.properties");
            props.load(in);
            in.close();
            uploadKey = props.getProperty("secret");
        } catch (IOException e) {
            // Swallow
        }
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String uploadCarCollection(@QueryParam("secret") final String secret, final Collection<CarModel> carModels) {
        if (!uploadKey.equals(secret)) {
            return "Secret invalid";
        }
        
        Collection<Car> cars = Lists.newArrayList(Collections2.transform(carModels, new Function<CarModel, Car>() {
            @Override
            public Car apply(CarModel input) {
                return CarModel.asCar(input);
            }
        }));
        
        if (cars.size() > 0) {
            Set<Key<Car>> keys = ObjectifyService.ofy().save().entities(cars).now().keySet();
            carSearch.indexCars(keys);
        }
        return "Content";
    }
}
