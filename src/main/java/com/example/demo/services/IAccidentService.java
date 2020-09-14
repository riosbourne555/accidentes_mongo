package com.example.demo.services;

import java.util.Collection;

import com.example.demo.dto.AccidentDTO;

public interface IAccidentService {

	public Collection<AccidentDTO> getAccidents();

	public void saveAccident(String reason);

}
