package br.senai.sc.security.sec.config;

import br.senai.sc.security.sec.service.UsuarioAutenticacaoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;

@Configuration
public class SecurityConfiguration {

//    @Bean
//    public UserDetailsService users(){
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//
//        manager.createUser(User.builder()
//                .username("admin").password("123").build());
//
//        manager.createUser(User.builder()
//                .username("user").password("12345").build());
//
//        return manager;
//
//    }

    @Bean
    public AuthenticationManager authManager(
            AuthenticationConfiguration builder
    ) throws Exception {
        return builder.getAuthenticationManager();
    }
    @Bean
    public SecurityContextRepository securityContextRepository(){
        return new HttpSessionSecurityContextRepository();
    }

    //filtro para decidir quais autorizações podem ser feitas sem login
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        //autorizando todos os methods GET
        //apenas checa se esta autenticado normalmente
        http.authorizeHttpRequests(auth ->{
            //metodo do tipo post em tal rota
            auth.requestMatchers(HttpMethod.POST, "/api/auth/login", "/api/auth/logout").permitAll();
        });
        return http.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(
            UsuarioAutenticacaoService uds){

        DaoAuthenticationProvider ap = new DaoAuthenticationProvider();
        ap.setUserDetailsService(uds);
        ap.setPasswordEncoder(passwordEncoder());
        return ap;
    }

//    @Bean
    public PasswordEncoder passwordEncoder(){
        //sem criptografando

        return NoOpPasswordEncoder.getInstance();

        //criptografando
//        return new BCryptPasswordEncoder();
    }

}
