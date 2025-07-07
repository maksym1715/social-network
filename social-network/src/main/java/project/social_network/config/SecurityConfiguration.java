package project.social_network.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	    http
	        // Disable CSRF for API (no form used)
	        .csrf(csrf -> csrf.disable())

	        // Authorize HTTP requests
	        .authorizeHttpRequests(auth -> auth
	            // Allow public access to registration, login, and documentation
	            .requestMatchers(
	                "/api/users/register",
	                "/api/users/login",
	                "/api/public/**",
	                "/swagger-ui/**",
	                "/v3/api-docs/**"
	            ).permitAll()

	            // All other requests require authentication
	            .anyRequest().authenticated()
	        )

	        // Enable OAuth2 login
	        .oauth2Login(Customizer.withDefaults())

	        // Enable form-based login
	        .formLogin(Customizer.withDefaults());

	    return http.build();
	}

       
}