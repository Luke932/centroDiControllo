package luke932.gestioneIncendi.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationService {
	private RestTemplate restTemplate = new RestTemplate();

	public void sendFireAlarmNotification(double latitude, double longitude, int smokeLevel) {
		String url = "http://localhost:3001/alarm?lat=" + latitude + "&long=" + longitude + "&smokelevel=" + smokeLevel;
		System.out.println("URL della notifica: " + url);

		// Implementazione nel caso in cui avessimo un centro di controllo con questo
		// URL nel caso scommentassi questo
		// codice avremmo un messaggio di errore, on questa applicazione stampo a video
		// l'url che arriverebbe al centro di
		// controllo con i livelli di fumo superiori a 5.

//		try {
//			ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
//			if (response.getStatusCode() == HttpStatus.OK) {
//				System.out.println("Notifica inviata con successo al centro di controllo.");
//			} else {
//				System.out.println("Errore nell'invio della notifica al centro di controllo.");
//			}
//		} catch (Exception e) {
//			System.out.println("Errore durante l'invio della notifica: " + e.getMessage());
//		}
	}
}
