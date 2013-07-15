package org.penguin.motorindex.domain;

import org.junit.Assert;
import org.junit.Test;

public class PowerRatingTests {
    
    @Test
    public void testKwPower() {
        // arrange
        String powerStr = "172kW @ 6800rpm";
        
        // act
        PowerRating rating = PowerRating.fromString(powerStr);
        
        // assert
        Assert.assertNotNull(rating);
        Assert.assertEquals(172, rating.getAmount(), 0);
        Assert.assertEquals(new Integer(6800), rating.getRpm());
    }
    
    @Test
    public void testKwPowerWithRpmRange() {
        // arrange
        String powerStr = "280kW @ 4000-4400rpm";
        
        // act
        PowerRating rating = PowerRating.fromString(powerStr);
        
        // assert
        Assert.assertNotNull(rating);
        Assert.assertEquals(280, rating.getAmount(), 0);
        Assert.assertEquals(new Integer(4400), rating.getRpm());
    }
    
    @Test
    public void testKwPowerWithoutRpm() {
        // arrange
        String powerStr = "280kW";
        
        // act
        PowerRating rating = PowerRating.fromString(powerStr);
        
        // assert
        Assert.assertNotNull(rating);
        Assert.assertEquals(280, rating.getAmount(), 0);
        Assert.assertNull(rating.getRpm());
    }
    
    @Test
    public void testKwPowerWithDecimal() {
        // arrange
        String powerStr = "89.5kW @ 5750rpm";
        
        // act
        PowerRating rating = PowerRating.fromString(powerStr);
        
        // assert
        Assert.assertNotNull(rating);
        Assert.assertEquals(89.5, rating.getAmount(), 0);
        Assert.assertEquals(new Integer(5750), rating.getRpm());
    }
    
    @Test
    public void testTorque() {
        // arrange
        String powerStr = "284Nm @ 3000rpm";
        
        // act
        PowerRating rating = PowerRating.fromString(powerStr);
        
        // assert
        Assert.assertNotNull(rating);
        Assert.assertEquals(284, rating.getAmount(), 0);
        Assert.assertEquals(new Integer(3000), rating.getRpm());
    }
}
