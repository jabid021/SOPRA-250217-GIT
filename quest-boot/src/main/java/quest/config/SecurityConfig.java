package quest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		// Méthode d'authentification par HTTP Basic
		http.httpBasic(Customizer.withDefaults());

		// Autorisations sur URLs
		http.authorizeHttpRequests(auth -> {
			auth.requestMatchers("/api/utilisateur/**").hasRole("ADMIN");
//			auth.requestMatchers("/api/utilisateur/**").hasAuthority("ROLE_ADMIN");
			auth.requestMatchers("/api/**").authenticated();
			auth.requestMatchers("/**").permitAll();
		});
		
		http.csrf(c -> c.ignoringRequestMatchers("/api/**"));

		return http.build();
	}

//	@Bean
//	public UserDetailsService inMemory(PasswordEncoder passwordEncoder) {
//		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//
//		manager.createUser(
//				User.withUsername("eric").password(passwordEncoder.encode("123456")).roles("FORMATEUR").build());
//		manager.createUser(
//				User.withUsername("damien").password(passwordEncoder.encode("123456")).roles("STAGIAIRE").build());
//		manager.createUser(
//				User.withUsername("marina").password(passwordEncoder.encode("123456")).roles("STAGIAIRE").build());
//		manager.createUser(
//				User.withUsername("admin").password(passwordEncoder.encode("123456")).roles("ADMIN").build());
//
//		return manager;
//	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		// Pas d'encadage sur les mots de passe - PAS BIEN
//		return NoOpPasswordEncoder.getInstance();
		
	    return new BCryptPasswordEncoder();
	}
}
