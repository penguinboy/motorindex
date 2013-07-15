package org.penguin.motorindex.domain;

import static java.lang.Integer.parseInt;

import com.google.common.base.Strings;
import com.googlecode.objectify.annotation.Embed;

@Embed
public class IntRange {
    private int low;
    private int high;
    
    private IntRange() {
    }
    
    private IntRange(int low, int high) {
        this.low = low;
        this.high = high;
    }
    
    public static IntRange fromString(String str) {
        if (Strings.isNullOrEmpty(str) || !str.contains("-")) {
            return null;
        }
        
        str = str.replaceAll("[$, ]", "");
        String[] range = str.split("-");
        
        try {
            return new IntRange(parseInt(range[0]), parseInt(range[1]));
        } catch (NumberFormatException e) {
            return null;
        }
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
