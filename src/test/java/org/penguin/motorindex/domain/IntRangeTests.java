package org.penguin.motorindex.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import junit.framework.Assert;

import org.junit.Test;

public class IntRangeTests {
    
    @Test
    public void testFromString() {
        // arrange
        String priceStr = "$23,000 - $26,000";
        
        // act
        IntRange range = IntRange.fromString(priceStr);
        
        // assert
        assertNotNull(range);
        assertEquals(range.getLow(), 23000);
        assertEquals(range.getHigh(), 26000);
    }
    
    @Test
    public void testFromStringReturnNullIfInvalid() {
        // arrange
        String priceStr = "$23,000 - what";
        
        // act
        IntRange range = IntRange.fromString(priceStr);
        
        // assert
        Assert.assertNull(range);
    }
}
