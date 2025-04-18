package quest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import quest.config.jwt.JwtUtil;

@SpringBootTest
public class JwtTest {

	@Test
	public void generateToken() {
		// ARRANGE
		Authentication authentication = new UsernamePasswordAuthenticationToken("esultan", "motDePasse");
		
		// ACT
		String token = JwtUtil.generate(authentication);
		
		Optional<String> username = JwtUtil.getUsername(token);		
		
		// ASSERT
		assertTrue(username.isPresent());
		assertEquals(username.get(), "esultan");
	}
	
}
