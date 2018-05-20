package com.albertocg.conversor;

public class TemperatureConverter {
    private float celsius;
    private float fahrenheit;

    public TemperatureConverter() {
        this.celsius = 0;
        this.fahrenheit = 0;
    }

    public float getCelsius() {
        return this.celsius;
    }

    public float getFahrenheit() {
        return this.fahrenheit;
    }

    public void setCelsius(float temp) {
        this.celsius = temp;
        this.fahrenheit = ((temp*9)/5)+32;
    }

    public void setFahrenheit(float temp) {
        this.fahrenheit = temp;
        this.celsius = ((temp - 32)*5)/9;
    }
}
