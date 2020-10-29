package com.example.demo.controller;
import java.util.Collection;
import javax.inject.Inject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.AccidentDTO;
import com.example.demo.dto.WConditionsDTO;
import com.example.demo.services.IAccidentService;

@RestController
public class AccidentController {

	@Inject
	private IAccidentService accidentsService;

	@GetMapping(value = "/api/from/{date1}/to/{date2}")
    public ResponseEntity<?> getAccidentsByDates(@PathVariable("date1") String date1, @PathVariable("date2") String date2) {
        ResponseEntity<?> response = null;
        Collection<AccidentDTO> result = this.getAccidentsService().getAccidentsDateBetween(date1, date2);
        response = ResponseEntity.ok(result);
        return response;
	}
	
	@GetMapping(value = "/api/{latitud}/{longitud}/{distancia}")
    public ResponseEntity<?> getAccidentsGeoPoint(@PathVariable("latitud") Double latitud, @PathVariable("longitud") Double longitud, @PathVariable("distancia") int distancia) {
        ResponseEntity<?> response = null;
        Collection<AccidentDTO> result = this.getAccidentsService().getAccidentsGeoPoint(latitud, longitud, distancia);
        response = ResponseEntity.ok(result);
        return response;
	}

	@GetMapping(value = "/api/severity/{latitud}/{longitud}/{distancia}")
    public ResponseEntity<?> getAccidentsGeoPointSeverity(@PathVariable("latitud") Double latitud, @PathVariable("longitud") Double longitud, @PathVariable("distancia") int distancia) {
        ResponseEntity<?> response = null;
        Collection<AccidentDTO> result = this.getAccidentsService().getAccidentsGeoPointSeverity(latitud, longitud, distancia);
        response = ResponseEntity.ok(result);
        return response;
	}

    @GetMapping(value = "/api/WeatherCondition")
    public ResponseEntity<?> getWConditions() {

        ResponseEntity<?> response = null;
        Collection<WConditionsDTO> result = this.getAccidentsService().getWConditions();

        response = ResponseEntity.ok(result);

        return response;
    }

	@GetMapping(value = "/api/DistanciaPromedio")
    public ResponseEntity<?> getPromDistance() {

        ResponseEntity<?> response = null;
        Float result = this.getAccidentsService().getPromDistance();

        response = ResponseEntity.ok(result);

        return response;
    }

	public IAccidentService getAccidentsService() {
		return this.accidentsService;
	}

}
