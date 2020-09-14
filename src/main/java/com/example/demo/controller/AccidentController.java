package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AccidentDTO;
import com.example.demo.dto.AccidentRequestDTO;
import com.example.demo.services.IAccidentService;

@RestController
public class AccidentController {

	@Inject
	private IAccidentService accidentsService;

	@GetMapping(value = "/api/accident")
	public ResponseEntity<?> getAccidents() {

		ResponseEntity<?> response = null;
		Collection<AccidentDTO> result = new ArrayList<AccidentDTO>();

		result.addAll(this.getAccidentsService().getAccidents());

		response = ResponseEntity.ok(result);

		return response;
	}

	@PostMapping(value = "/api/accident")
	public ResponseEntity<?> saveAccidents(@RequestBody AccidentRequestDTO request) {

		ResponseEntity<?> response = null;

		this.getAccidentsService().saveAccident(request.getReason());

		response = ResponseEntity.ok().build();

		return response;
	}

	public IAccidentService getAccidentsService() {
		return this.accidentsService;
	}

}
