package br.senai.sc.security.sec.controller;

import br.senai.sc.security.sec.model.dto.LoginDto;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AutenticacaoController {

    //relacionado ao contexto
    private SecurityContextRepository secRepository;

    //não possui injeção de dependência automática
    private AuthenticationManager authManager;


    //isto ja existia, estamos reescrevendo e fazendo denovo oq ja era feito
    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public void login(@RequestBody LoginDto logindto,

                        //auto mapeado
                        HttpServletRequest request,
                        HttpServletResponse response){
        //lógica para login

        //instanciando objeto que implementa authentication
        //poderiamos criar um outro objeto que implementa authentication por exemplo
        Authentication auth = new UsernamePasswordAuthenticationToken(
                logindto.username(), logindto.password());


        //ele aceita qualquer objeto que implementa authentication
        //retornar um objeto do tipo authentication
        auth = authManager.authenticate(auth);


        //checa se é autenticado
        if(auth.isAuthenticated()){
            //salvar no secutiry context repository

            //criando o context (ficara salvo no navegdaor e no servidor)
            SecurityContext secContext = SecurityContextHolder.createEmptyContext();

            //salvando o context
            secContext.setAuthentication(auth);

            secRepository.saveContext(secContext, request, response);

//            //buscando o context caso ja esteja autenticado
//            var usuarioAutenticado = SecurityContextHolder.getContext()
//                    //relacionado ao que fica salvo no navegador
//                    .getAuthentication();
//            usuarioAutenticado.getPrincipal();
            response.setStatus(200);
        }else{
            response.setStatus(401);
        }

    }

}
