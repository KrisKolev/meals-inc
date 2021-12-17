//package com.example.restaurantapplication.security;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.example.restaurantapplication.model.Employee;
//import org.codehaus.jackson.map.ObjectMapper;
//import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
//import org.springframework.boot.sql.init.dependency.AbstractBeansOfTypeDatabaseInitializerDetector;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Date;
//
//import static com.example.restaurantapplication.security.SecurityConstraints.EXPIRATION_TIME;
//import static com.example.restaurantapplication.security.SecurityConstraints.SECRET;
//
//public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter
//{
//    private AuthenticationManager authenticationManager;
//
//    public JWTAuthenticationFilter(AuthenticationManager authenticationManager)
//    {
//        this.authenticationManager = authenticationManager;
//
//        setFilterProcessesUrl("/login");
//    }
//
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest req,
//                                               HttpServletResponse res) throws AuthenticationException
//    {
//        try
//        {
//            Employee creds = new ObjectMapper()
//                    .readValue(req.getInputStream(), Employee.class);
//
//            return authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(
//                            creds.getEmployeeUsername(),
//                            creds.getEmployeePassword(),
//                            new ArrayList<>()
//                    )
//            );
//        }
//        catch (IOException e)
//        {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    protected void successfulAuthentication(HttpServletRequest req,
//                                            HttpServletResponse res,
//                                            FilterChain chain,
//                                            Authentication auth) throws IOException
//    {
//        System.out.println("hi");
//        String token = JWT.create()
//                .withSubject(((Employee) auth.getPrincipal()).getEmployeeUsername())
//                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
//                .sign(Algorithm.HMAC512(SECRET.getBytes()));
//
//        String body = ((Employee) auth.getPrincipal()).getEmployeeUsername() + " " + token;
//
//        res.getWriter().write(body);
//        res.getWriter().flush();
//    }
//
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
