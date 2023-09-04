package com.sparta.andbackoffice.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.andbackoffice.jwt.JwtAuthorizationFilter;
import com.sparta.andbackoffice.jwt.JwtUtil;
import com.sparta.andbackoffice.security.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity // Spring Security 지원을 가능하게 함
@RequiredArgsConstructor
public class WebSecurityConfig {

	private final JwtUtil jwtUtil;
	private final UserDetailsServiceImpl userDetailsService;
	private final ObjectMapper objectMapper;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
		return configuration.getAuthenticationManager();
	}

	@Bean
	public JwtAuthorizationFilter jwtAuthorizationFilter() {
		return new JwtAuthorizationFilter(jwtUtil, userDetailsService, objectMapper);
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		// CSRF 설정
		http.csrf((csrf) -> csrf.disable());

		// 기본 설정인 Session 방식은 사용하지 않고 JWT 방식을 사용하기 위한 설정
		http.sessionManagement((sessionManagement) ->
				sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		);

		http.authorizeHttpRequests((authorizeHttpRequests) ->
				authorizeHttpRequests
						.requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll() // resources 접근 허용 설정
						.requestMatchers("/api/admin/signup").permitAll() // '/admin/signup' 으로 시작하는 요청 접근 허가
						.requestMatchers("/api/admin/file/**").permitAll() //
						.requestMatchers("/api/admin/login").permitAll() // '/admin/login' 으로 시작하는 요청 모두 접근 허가
						.requestMatchers("/api/admin/**").authenticated()
						.anyRequest().authenticated() //
		);

		http.addFilterBefore(jwtAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}
}