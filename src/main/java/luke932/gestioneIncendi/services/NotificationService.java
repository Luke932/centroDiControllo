package luke932.gestioneIncendi.services;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationService {
	private RestTemplate restTemplate = new RestTemplate();

	public void sendFireAlarmNotification(double latitude, double longitude) {
		String url = "http://host/alarm?lat=" + latitude + "&long=" + longitude + "&smokelevel=6";

		try {
			ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
			if (response.getStatusCode() == HttpStatus.OK) {
				System.out.println("Notifica inviata con successo al centro di controllo.");
			} else {
				System.out.println("Errore nell'invio della notifica al centro di controllo.");
			}
		} catch (Exception e) {
			System.out.println("Errore durante l'invio della notifica: " + e.getMessage());
		}
	}
}
