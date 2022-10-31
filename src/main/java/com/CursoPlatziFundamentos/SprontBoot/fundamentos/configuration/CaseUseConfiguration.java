package com.CursoPlatziFundamentos.SprontBoot.fundamentos.configuration;

import com.CursoPlatziFundamentos.SprontBoot.fundamentos.CasosUso.GetUser;
import com.CursoPlatziFundamentos.SprontBoot.fundamentos.CasosUso.ImplementsGetUser;
import com.CursoPlatziFundamentos.SprontBoot.fundamentos.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CaseUseConfiguration {

    //aqui abajo lo que hago es retornarlo pero ya implementado dentro de ImplementsGetUser
    @Bean
    GetUser getUser(UserService userService){
        return new ImplementsGetUser(userService);
    }
}
