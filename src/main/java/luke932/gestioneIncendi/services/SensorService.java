package luke932.gestioneIncendi.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import luke932.gestioneIncendi.models.Sensor;

@Service
public class SensorService {
	private final Map<Integer, Sensor> sensorMap = new HashMap<>();
	private final NotificationService notificationService;

	@Autowired
	public SensorService(NotificationService notificationService) {
		this.notificationService = notificationService;
	}

	public void updateSmokeLevel(int id, int smokeLevel) {
		Sensor sensor = sensorMap.get(id);
		if (sensor != null) {
			sensor.setSmokeLevel(smokeLevel);
		}
	}

	public NotificationService getNotificationService() {
		return notificationService;
	}
}
