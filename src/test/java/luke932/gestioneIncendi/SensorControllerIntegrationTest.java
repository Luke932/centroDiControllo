package luke932.gestioneIncendi;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import luke932.gestioneIncendi.controller.SensorController;
import luke932.gestioneIncendi.services.SensorService;

@WebMvcTest(SensorController.class)
public class SensorControllerIntegrationTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private SensorService sensorService;

	@Test
	public void testUpdateSmokeLevel() throws Exception {
		int id = 1;
		int smokeLevel = 6;

		mockMvc.perform(post("/sensor/update-smoke-level").param("id", String.valueOf(id)).param("smokeLevel",
				String.valueOf(smokeLevel))).andExpect(status().isOk());

		verify(sensorService).updateSmokeLevel(id, smokeLevel);
	}
}
