package com.example.eurekauser.config;


import com.example.eurekauser.entities.User;
import com.example.eurekauser.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {

     private  final UserRepository userRepository;
       JwtTokenFilter jwtTokenFilter;

    @Bean
    public PasswordEncoder passwordEncoder (){

        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
         return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.cors().and().csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeHttpRequests()
                .requestMatchers( "/public/**").permitAll()
               .anyRequest().anyRequest().authenticated()
               .exceptionHandling().authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
               .addFilterBefore(jwtTokenFilther, UsernamePasswordAuthenticationFilter.class);

        return  http.build();

    }

    @Bean
    public UserDetailsService userDetailsService (){
          return  new UserDetailsService() {
              @Override
              public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
             User user = userRepository.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException(" User Not Found with email:" + email));
                  return null;
              }
          };
    }

}
