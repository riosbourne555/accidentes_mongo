package com.example.demo.dto;

import com.example.demo.model.WConditions;

public class WConditionsDTO {

    public String condicion_climatica;
    public Integer cantidad;

    public WConditionsDTO(String acondition, Integer acantidad) {
        this.condicion_climatica = acondition;
        this.cantidad = acantidad;
    }

    public WConditionsDTO(WConditions a) {
        this.setCondicion_climatica(a.getCondition());
        this.setCantidad(a.getCantidad());
	}

	public static WConditionsDTO factory(String acondition, Integer acantidad) {
        return new WConditionsDTO(acondition, acantidad);
    }

    public Integer getCantidad() {
        return cantidad;
    }
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getCondicion_climatica() {
        return condicion_climatica;
    }

    public void setCondicion_climatica(String condicion_climatica) {
        this.condicion_climatica = condicion_climatica;
    }

}
