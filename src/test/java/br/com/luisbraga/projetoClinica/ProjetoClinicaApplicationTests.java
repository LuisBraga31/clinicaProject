package br.com.luisbraga.projetoClinica;

import br.com.luisbraga.projetoClinica.api.dto.request.PacienteRequest;
import br.com.luisbraga.projetoClinica.domain.service.PacienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ActiveProfiles("test")
@AutoConfigureMockMvc
@SpringBootTest
class ProjetoClinicaApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper objectMapper;

	@SpyBean
	private PacienteService pacienteService;

	@Test
	void contextLoads() {
		Assertions.assertNotNull(mvc);
	}

	@Test
	void dadoUmObjetoValido_quandoChamamosEndpointCriarPaciente_entaoRetornarObjetoMockado() throws Exception {

		PacienteRequest paciente = Fixture.PacienteFake.anyPaciente();

		String pacienteAsJson = objectMapper.writeValueAsString(paciente);

		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
				.post("/v1/pacientes")
				.content(pacienteAsJson)
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON);

		this.mvc.perform(request)
				.andDo(print())
				.andExpect(status().isOk());

	}




}
