package quest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import quest.rest.request.ConnexionRequest;
import quest.rest.response.ConnexionResponse;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SomeRestTest {
	
	@Autowired
    private WebApplicationContext applicationContext;
    private MockMvc mockMvc;
    
    @Autowired
    private TestRestTemplate template;
    
    @BeforeEach
    public void init(){
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(applicationContext)
                .build();
    }

	@Test
	public void connectionOk() throws Exception {
		// ARRANGE
		StringBuilder connection = new StringBuilder();
		connection.append("{").append("\"login\"").append(":").append("\"admin\"").append(",");
		connection.append("\"password\"").append(":").append("\"123456\"").append("}");

		// ACT et ASSERT
		this.mockMvc.perform(MockMvcRequestBuilders.post("/api/connexion").contentType(MediaType.APPLICATION_JSON)
				.content(connection.toString()))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.jsonPath("$").exists())
				.andExpect(MockMvcResultMatchers.jsonPath("$.success").value("true"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.token").isNotEmpty());
	}
	
	@Test
	public void connectionOkWithRestTemplate() throws Exception {
		// ARRANGE
		ConnexionRequest connexionRequest = new ConnexionRequest("admin", "123456");

		// ACT
		ResponseEntity<ConnexionResponse> connexionResponse = template.postForEntity("/api/connexion", connexionRequest, ConnexionResponse.class);
		
		// ASSERT
		assertEquals(HttpStatus.OK, connexionResponse.getStatusCode());
		assertEquals(MediaType.APPLICATION_JSON, connexionResponse.getHeaders().getContentType());
		assertNotNull(connexionResponse.getBody());
		assertTrue(connexionResponse.getBody().isSuccess());
		
		if(connexionResponse.getBody().getToken().isEmpty()) {
			fail("Token vide");
		}
	}
	
	@Test
	public void listMatieres() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/api/matiere"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.jsonPath("$").exists());
	}
}
