package com.example.demo.services.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;
import javax.inject.Inject;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.dto.AccidentDTO;
import com.example.demo.dto.WConditionsDTO;
import com.example.demo.repository.AccidentRepository;
import com.example.demo.services.IAccidentService;

@Service
@Transactional
public class AccidentService implements IAccidentService {

	@Inject
	public AccidentRepository accidentRepository;

	@Override
    public Collection<AccidentDTO> getAccidentsDateBetween(String date1, String date2) {
        Collection<AccidentDTO> result = new ArrayList<AccidentDTO>();

        this.getAccidentRepository().findByStartTimeBetween(date1, date2, PageRequest.of(0, 10000))
                .stream().map(a -> new AccidentDTO(a))
                .collect(Collectors.toCollection(() -> result));
        return result;
	}
	
	@Override
    public Collection<AccidentDTO> getAccidentsGeoPoint(Double latitud, Double longitud, int distancia) {
        Collection<AccidentDTO> result = new ArrayList<AccidentDTO>();

        this.getAccidentRepository().findByStartLocationNear(new Point(longitud, latitud),new Distance(distancia, Metrics.KILOMETERS), PageRequest.of(0, 10000))
                .stream().map(a -> new AccidentDTO(a))
                .collect(Collectors.toCollection(() -> result));
        return result;
    }

	@Override
    public Collection<AccidentDTO> getAccidentsGeoPointSeverity(Double latitud, Double longitud, int distancia) {
        Collection<AccidentDTO> result = new ArrayList<AccidentDTO>();

        this.getAccidentRepository().findByStartLocationNear(new Point(longitud, latitud),new Distance(distancia, Metrics.KILOMETERS), PageRequest.of(0, 5, Sort.by(Sort.Direction.DESC, "Severity")))
                .stream().map(a -> new AccidentDTO(a))
                .collect(Collectors.toCollection(() -> result));
        return result;
    }

	@Override
    public Collection<WConditionsDTO> getWConditions() {
        Collection<WConditionsDTO> result = new ArrayList<WConditionsDTO>();

		result = this.getAccidentRepository().findWConditions()
				.stream().map(a -> new WConditionsDTO(a)).collect(Collectors.toCollection(ArrayList::new));
        return result;
    }

    @Override
    public Float getPromDistance() {
        Float promDistance;
        promDistance = this.getAccidentRepository().findPromDistance();
        return promDistance;
    }

	public AccidentRepository getAccidentRepository() {
		return this.accidentRepository;
	}

	public void setAccidentRepository(AccidentRepository aRepository) {
		this.accidentRepository = aRepository;
	}

}
