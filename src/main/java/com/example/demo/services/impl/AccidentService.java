package com.example.demo.services.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.AccidentDTO;
import com.example.demo.model.Accident;
import com.example.demo.repository.AccidentRepository;
import com.example.demo.services.IAccidentService;

@Service
@Transactional
public class AccidentService implements IAccidentService {

	@Inject
	public AccidentRepository accidentRepository;

	@Override
	public Collection<AccidentDTO> getAccidents() {
		Collection<AccidentDTO> result = new ArrayList<AccidentDTO>();
		this.getAccidentRepository().findAll().stream().map(a -> new AccidentDTO(a))
				.collect(Collectors.toCollection(() -> result));
		return result;
	}

	@Override
	public void saveAccident(String aReason) {
		Accident newAccident = new Accident(new Date(), aReason);
		this.getAccidentRepository().save(newAccident);

	}

	public AccidentRepository getAccidentRepository() {
		return this.accidentRepository;
	}

	public void setAccidentRepository(AccidentRepository aRepository) {
		this.accidentRepository = aRepository;
	}

}
