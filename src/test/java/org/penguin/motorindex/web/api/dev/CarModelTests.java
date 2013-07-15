package org.penguin.motorindex.web.api.dev;

import junit.framework.Assert;

import org.junit.Test;

public class CarModelTests {
    
    @Test
    public void testPriceParse() {
        // arrange
        String priceStr = "$56,990* Price Guide (EGC)";
        
        // act
        Integer price = CarModel.getPrice(priceStr);
        
        // assert
        Assert.assertEquals(new Integer(56990), price);
    }
}
