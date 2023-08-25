package luke932.gestioneIncendi.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import luke932.gestioneIncendi.notifications.FireAlarmObserver;

@Getter
@Setter
@AllArgsConstructor
public class FireDepartment implements FireAlarmObserver {
	@Override
	public void onFireAlarm(Sensor sensor) {
		double latitude = sensor.getLatitude();
		double longitude = sensor.getLongitude();

		System.out.println("Chiamati i pompieri a " + latitude + ", " + longitude);
	}
}
