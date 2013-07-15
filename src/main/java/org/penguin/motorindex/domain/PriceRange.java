package org.penguin.motorindex.domain;

import com.googlecode.objectify.annotation.Embed;

@Embed
public class PriceRange {
    private int low;
    private int high;
    
    private PriceRange() {
    }
    
    private PriceRange(int high, int low) {
        this.low = low;
        this.high = high;
    }
    
    public int getLow() {
        return low;
    }
    
    public void setLow(int low) {
        this.low = low;
    }
    
    public int getHigh() {
        return high;
    }
    
    public void setHigh(int high) {
        this.high = high;
    }
}
