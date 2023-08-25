package luke932.gestioneIncendi.notifications;

import luke932.gestioneIncendi.models.Sensor;

public interface FireAlarmObserver {
	void onFireAlarm(Sensor sensor);
}
