package luke932.gestioneIncendi.models;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import luke932.gestioneIncendi.notifications.FireAlarmObserver;
import luke932.gestioneIncendi.services.NotificationService;

@AllArgsConstructor
@Getter
@Setter
public class Sensor {
	private int id;
	private double latitude;
	private double longitude;
	private int smokeLevel;
	private List<FireAlarmObserver> observers = new ArrayList<>();
	private final NotificationService notificationService;

	public void addFireAlarmObserver(FireAlarmObserver observer) {
		observers.add(observer);
	}

	public void setSmokeLevel(int smokeLevel) {
		this.smokeLevel = smokeLevel;
		if (smokeLevel > 5) {
			notifyObservers();
			notificationService.sendFireAlarmNotification(latitude, longitude, smokeLevel);
		}
	}

	private void notifyObservers() {
		for (FireAlarmObserver observer : observers) {
			observer.onFireAlarm(this);
		}
	}
}
