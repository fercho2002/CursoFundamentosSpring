package com.CursoPlatziFundamentos.SprontBoot.fundamentos.CasosUso;

import com.CursoPlatziFundamentos.SprontBoot.fundamentos.entity.User;
import com.CursoPlatziFundamentos.SprontBoot.fundamentos.service.UserService;

import java.util.List;

public class ImplementsGetUser implements GetUser{

    private UserService userService;
    public ImplementsGetUser(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<User> getAll() {
        return userService.todosLosUsuarios();
    }
}
