package com.albertocg.conversor;

public class WeightConverter {
    private Double grams;
    private Double ounces;
    private Double pounds;

    public void WeightConverter() {
        this.grams = 0.00;
        this.ounces = 0.00;
        this.pounds = 0.00;
    }

    public void setGrams(Double grams) {
        this.grams = grams;
        this.ounces = grams*0.03527;
        this.pounds = grams*0.0022;
    }

    public void setOunces(Double ounces) {
        this.ounces = ounces;
        this.grams = ounces*28.34952;
        this.pounds = ounces*0.0625;
    }

    public void setPounds(Double pounds) {
        this.pounds = pounds;
        this.grams = pounds*453.5924;
        this.ounces = pounds*16;
    }

    public Double getGrams(){
        return this.grams;
    }

    public Double getKgrams(){
        return this.grams/1000;
    }

    public Double getOunces(){
        return this.ounces;
    }

    public Double getPounds(){
        return this.pounds;
    }

}
