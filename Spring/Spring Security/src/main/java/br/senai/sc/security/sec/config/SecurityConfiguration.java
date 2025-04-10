package br.senai.sc.security.sec.config;

import br.senai.sc.security.sec.service.UsuarioAutenticacaoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;


@EnableWebSecurity
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

    SecurityContextRepository securityContextRepository;
    @Bean
    public SecurityContextRepository securityContextRepository(){
        if(securityContextRepository == null){
            securityContextRepository = new HttpSessionSecurityContextRepository();
        }
        return securityContextRepository;
    }

    //filtro para decidir quais autorizações podem ser feitas sem login
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.securityContext(config ->config.securityContextRepository(securityContextRepository()));
        http.csrf(AbstractHttpConfigurer::disable);
        http.formLogin(AbstractHttpConfigurer::disable);
        //autorizando todos os methods GET
        //apenas checa se esta autenticado normalmente
        http.authorizeHttpRequests(auth ->{
            //metodo do tipo post em tal rota
            auth.requestMatchers(HttpMethod.POST, "/api/auth/login", "/api/auth/logout")
                    .permitAll()
            .anyRequest().authenticated();
        });
        return http.build();
    }


    @Bean
    public AuthenticationManager authenticationManager(
            UsuarioAutenticacaoService uds){

        DaoAuthenticationProvider ap = new DaoAuthenticationProvider();
        ap.setUserDetailsService(uds);
        ap.setPasswordEncoder(passwordEncoder());
        return new ProviderManager(ap);
    }

//    @Bean
    public PasswordEncoder passwordEncoder(){
        //sem criptografando

        return NoOpPasswordEncoder.getInstance();

        //criptografando
//        return new BCryptPasswordEncoder();
    }

}
