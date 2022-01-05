package com.example.restaurantapplication.security;


import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//import static com.example.restaurantapplication.security.SecurityConstraints.SIGN_UP_URL;

//@EnableWebSecurity
public class WebSecurity/* extends WebSecurityConfigurerAdapter*/
{
//    private UserDetailsService userDetailsService;
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    public WebSecurity(UserDetailsService userService, BCryptPasswordEncoder bCryptPasswordEncoder)
//    {
//        this.userDetailsService = userService;
//        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception
//    {
//        http.cors().and().csrf().disable().authorizeRequests()
//                .antMatchers(HttpMethod.POST, SIGN_UP_URL).permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .addFilter(new JWTAuthenticationFilter(authenticationManager()))
//                .addFilter(new JWTAuthorizationFilter(authenticationManager()))
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//    }
//
//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception
//    {
//        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
//    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:4200")
                        .allowedMethods("GET", "PUT", "POST", "PATCH", "DELETE", "OPTIONS");
            }
        };
    }
}
















