package org.penguin.motorindex.domain;

import com.googlecode.objectify.annotation.Embed;

@Embed
public class PowerRating {
    private int amount;
    private int rpm;
    
    private PowerRating() {
    }
    
    public PowerRating(int amount, int rpm) {
        this.amount = amount;
        this.rpm = rpm;
    }
    
    public int getAmount() {
        return amount;
    }
    
    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    public int getRpm() {
        return rpm;
    }
    
    public void setRpm(int rpm) {
        this.rpm = rpm;
    }
}
