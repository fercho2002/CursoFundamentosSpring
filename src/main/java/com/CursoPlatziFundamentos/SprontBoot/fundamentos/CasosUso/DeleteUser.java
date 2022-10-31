package com.CursoPlatziFundamentos.SprontBoot.fundamentos.CasosUso;

import com.CursoPlatziFundamentos.SprontBoot.fundamentos.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class DeleteUser {

    private UserService userService;
    public DeleteUser(UserService userService) {
        this.userService = userService;
    }

    public void delete(Long id) {
        userService.delete(id);
    }
}
