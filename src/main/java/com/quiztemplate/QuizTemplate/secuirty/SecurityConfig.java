/*
 * package com.quiztemplate.QuizTemplate.secuirty;
 * 
 * import java.util.ArrayList; import java.util.List;
 * 
 * import org.springframework.context.annotation.Bean; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * WebSecurityConfigurerAdapter; import
 * org.springframework.web.cors.CorsConfiguration; import
 * org.springframework.web.cors.CorsConfigurationSource; import
 * org.springframework.web.cors.UrlBasedCorsConfigurationSource;
 * 
 * public class SecurityConfig extends WebSecurityConfigurerAdapter{ private
 * static final List<String> ImmutableList = null;
 * 
 * @Override protected void configure(HttpSecurity http) throws Exception { //
 * http.csrf().disable(); http.cors(); }
 * 
 * @Bean public CorsConfigurationSource corsConfigurationSource() { final
 * CorsConfiguration configuration = new CorsConfiguration(); List<String>
 * allowedOrigins = new ArrayList<>(); allowedOrigins.add("*");
 * configuration.setAllowedOrigins(allowedOrigins); List<String> allowedMethods
 * = new ArrayList<>(); allowedMethods.add("GET"); allowedMethods.add("POST");
 * allowedMethods.add("PUT"); allowedMethods.add("DELETE");
 * allowedMethods.add("PATCH"); configuration.setAllowedMethods(allowedMethods);
 * // setAllowCredentials(true) is important, otherwise: // The value of the
 * 'Access-Control-Allow-Origin' header in the response must not be the wildcard
 * '*' when the request's credentials mode is 'include'.
 * configuration.setAllowCredentials(true); // setAllowedHeaders is important!
 * Without it, OPTIONS preflight request // will fail with 403 Invalid CORS
 * request // configuration.setAllowedHeaders(new List<String>("Authorization",
 * "Cache-Control", "Content-Type")); final UrlBasedCorsConfigurationSource
 * source = new UrlBasedCorsConfigurationSource();
 * source.registerCorsConfiguration("/**", configuration); return source; } }
 */