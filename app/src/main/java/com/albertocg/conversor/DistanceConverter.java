package com.albertocg.conversor;

public class DistanceConverter {
    private Double cm;
    private Double m;
    private Double km;
    private Double inch;
    private Double feet;
    private Double mile;

    public DistanceConverter() {
        this.cm = 0.00;
        this.m = 0.00;
        this.km = 0.00;
        this.inch = 0.00;
        this.feet = 0.00;
        this.mile = 0.00;
    }

    public void setCm(Double cm) {
        this.cm = cm;
        this.inch = cm * 0.3937;
    }

    public void setKm(Double km) {
        this.km = km;
        this.mile = km * 0.6214;
    }

    public void setM(Double m) {
        this.m = m;
        this.feet = 3.2808;
    }

    public void setInch(Double inch) {
        this.inch = inch;
        this.cm = inch * 2.54;
    }

    public void setFeet(Double feet) {
        this.feet = feet;
        this.m = feet * 0.3048;
    }

    public void setMile(Double mile) {
        this.mile = mile;
        this.km = mile * 1.6093;
    }

    public Double getCm() {
        return cm;
    }

    public Double getFeet() {
        return feet;
    }

    public Double getInch() {
        return inch;
    }

    public Double getKm() {
        return km;
    }

    public Double getM() {
        return m;
    }

    public Double getMile() {
        return mile;
    }
}
