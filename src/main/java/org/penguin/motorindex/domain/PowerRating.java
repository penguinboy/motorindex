package org.penguin.motorindex.domain;

import static java.lang.Integer.parseInt;

import com.google.common.base.Strings;
import com.googlecode.objectify.annotation.Embed;

@Embed
public class PowerRating {
    private double amount;
    private Integer rpm;
    
    private PowerRating() {
    }
    
    public PowerRating(double amount, Integer rpm) {
        this.amount = amount;
        this.rpm = rpm;
    }
    
    public static PowerRating fromString(String str) {
        if (Strings.isNullOrEmpty(str) || !(str.contains("kW") || str.contains("Nm"))) {
            return null;
        }
        
        str = str.replaceAll("[kWNrpm ]", "");
        
        String[] split = str.split("@");
        
        try {
            if (split.length == 1) {
                return new PowerRating(parseInt(split[0]), null);
            }
            
            String rpm = split[1];
            if (rpm.contains("-")) {
                String[] rpmSplit = rpm.split("-");
                rpm = rpmSplit[1];
            }
            
            return new PowerRating(Double.parseDouble(split[0]), parseInt(rpm));
        } catch (NumberFormatException e) {
            return null;
        }
    }
    
    public double getAmount() {
        return amount;
    }
    
    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    public Integer getRpm() {
        return rpm;
    }
    
    public void setRpm(Integer rpm) {
        this.rpm = rpm;
    }
}
