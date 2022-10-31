package com.CursoPlatziFundamentos.SprontBoot.fundamentos.CasosUso;

import com.CursoPlatziFundamentos.SprontBoot.fundamentos.service.UserService;
import org.springframework.stereotype.Component;

import java.awt.print.Pageable;
import java.util.List;

@Component
public class PaginasConsulta {

    private UserService userService;
    public PaginasConsulta(UserService userService) {
        this.userService = userService;
    }


}
