package com.CursoPlatziFundamentos.SprontBoot.fundamentos.CasosUso;

import com.CursoPlatziFundamentos.SprontBoot.fundamentos.entity.User;
import com.CursoPlatziFundamentos.SprontBoot.fundamentos.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class UpdateUser {

    private UserService userService;
    public UpdateUser(UserService userService) {
        this.userService = userService;
    }

    public User modificar(User bod, Long id) {
        return userService.modificar(bod,id);
    }
}
