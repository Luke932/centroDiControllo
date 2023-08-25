package luke932.gestioneIncendi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import luke932.gestioneIncendi.services.NotificationService;

public class NotificationServiceTest {

	@InjectMocks
	private NotificationService notificationService;

	@Mock
	private NotificationService mockNotificationService;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testSendFireAlarmNotification() {
		double latitude = 40.712776;
		double longitude = -74.005974;
		int smokeLevel = 6;

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));

		notificationService.sendFireAlarmNotification(latitude, longitude, smokeLevel);

		String expectedOutput = "URL della notifica: http://localhost:3001/alarm?lat=40.712776&long=-74.005974&smokelevel=6";
		assertEquals(expectedOutput, outputStream.toString().trim());
	}
}
