package quest.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

@Configuration
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

	@Bean
	// public SecurityFilterChain filterChain(HttpSecurity http, JwtHeaderAuthorizationFilter jwtFilter) throws Exception {
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		// Méthode d'authentification par HTTP Basic
		http.httpBasic(Customizer.withDefaults());

		// Autorisations sur URLs
		http.authorizeHttpRequests(auth -> {
			auth.requestMatchers("/api/connexion", "/api/demo-reactif/**").permitAll();
			auth.requestMatchers("/api/utilisateur/**").hasRole("ADMIN");
//			auth.requestMatchers("/api/utilisateur/**").hasAuthority("ROLE_ADMIN");
			auth.requestMatchers("/api/**").authenticated();
			auth.requestMatchers("/**").permitAll();
		});

		http.csrf(c -> c.ignoringRequestMatchers("/api/**"));

		// Configurer les CORS (Cross-Origine Resources Sharing)
		http.cors(c -> {
			CorsConfigurationSource source = request -> {
				CorsConfiguration config = new CorsConfiguration();

				// On autorise tout le monde
				config.setAllowedOrigins(List.of("*"));

				// On autorise toutes les commandes HTTP (GET, POST, PUT, ...)
				config.setAllowedMethods(List.of("*"));

				// On autorise toutes les en-têtes HTTP
				config.setAllowedHeaders(List.of("*"));

				return config;
			};

			c.configurationSource(source);
		});

		Converter<Jwt, AbstractAuthenticationToken> converter = jwt -> {
			List<String> roles = jwt.getClaimAsStringList("roles");

			List<SimpleGrantedAuthority> authorities = roles.stream()
				.map(r -> new SimpleGrantedAuthority(r))
				.toList()
			;

			return new JwtAuthenticationToken(jwt, authorities);
		};

		http.oauth2ResourceServer(oauth2 -> {
			oauth2.jwt(jwt -> jwt.jwtAuthenticationConverter(converter));
		});

		// Positionner le filtre JWT AVANT le filter
		// UsernamePasswordAuthenticationFilter
		// http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}

	// Grace à ce Bean, on pourra injecter un AuthenticationManager directement
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
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
