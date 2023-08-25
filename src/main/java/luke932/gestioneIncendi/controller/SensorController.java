package luke932.gestioneIncendi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import luke932.gestioneIncendi.services.SensorService;

@RestController
@RequestMapping("/sensor")
public class SensorController {
	private final SensorService sensorService;

	@Autowired
	public SensorController(SensorService sensorService) {
		this.sensorService = sensorService;
	}

	@PostMapping("/update-smoke-level")
	public ResponseEntity<String> updateSmokeLevel(@RequestParam int id, @RequestParam int smokeLevel) {
		sensorService.updateSmokeLevel(id, smokeLevel);
		return ResponseEntity.ok("Smoke level updated.");
	}
}
