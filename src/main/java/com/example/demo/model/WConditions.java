package com.example.demo.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.Id;

public class WConditions {

    @Id
    //@Field("Weather_Condition")
    private String Weather_Condition;
    private Integer cantidad;

    public WConditions() {
 
    }

    public WConditions(@Value("Weather_Condition") String aWeather_Condition, @Value("cantidad") Integer aCantidad) {
    this.setCondition(aWeather_Condition);
    this.setCantidad(aCantidad);
}
    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getCondition() {
        return Weather_Condition;
    }

    public void setCondition(String condition) {
        this.Weather_Condition = condition;
    }
}
