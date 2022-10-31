package com.CursoPlatziFundamentos.SprontBoot.fundamentos.CasosUso;

import com.CursoPlatziFundamentos.SprontBoot.fundamentos.entity.User;
import com.CursoPlatziFundamentos.SprontBoot.fundamentos.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class CreateUser {

    private UserService userService;
    public CreateUser(UserService userService) {
        this.userService = userService;
    }

    public User save(User bodi) {
        return userService.save(bodi);
    }
}
