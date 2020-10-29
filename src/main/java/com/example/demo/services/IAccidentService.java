package com.example.demo.services;

import java.util.Collection;

import com.example.demo.dto.AccidentDTO;
import com.example.demo.dto.WConditionsDTO;

public interface IAccidentService {

	public Collection<AccidentDTO> getAccidentsDateBetween(String date1, String date2);

	public Collection<AccidentDTO> getAccidentsGeoPoint(Double latitud, Double longitud, int distancia);

	public Collection<AccidentDTO> getAccidentsGeoPointSeverity(Double latitud, Double longitud, int distancia);

	public Collection<WConditionsDTO> getWConditions();

	public Float getPromDistance();

}
