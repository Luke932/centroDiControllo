package luke932.gestioneIncendi;

import java.util.Random;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.javafaker.Faker;

import luke932.gestioneIncendi.services.SensorService;

@SpringBootApplication
public class GestioneIncendiApplication {
	public static void main(String[] args) {
		SpringApplication.run(GestioneIncendiApplication.class, args);

		SensorService sensorService = ApplicationContextProvider.getBean(SensorService.class);
		Faker faker = new Faker();
		Random random = new Random();

		for (int i = 1; i <= 5; i++) {
			double latitude = faker.number().randomDouble(6, -90, 90);
			double longitude = faker.number().randomDouble(6, -180, 180);
			sensorService.createSensor(i, latitude, longitude);
		}

		sensorService.updateSmokeLevel(1, 6);
		sensorService.updateSmokeLevel(2, 8);
		sensorService.updateSmokeLevel(3, 7);
		sensorService.updateSmokeLevel(4, 10);
		sensorService.updateSmokeLevel(5, 9);
	}
}
