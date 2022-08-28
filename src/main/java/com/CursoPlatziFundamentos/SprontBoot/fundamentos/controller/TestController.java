package com.CursoPlatziFundamentos.SprontBoot.fundamentos.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    //este controlador lo usa para probar que el puerto y el path si estan funcionando bien jaja
    @RequestMapping  // este tag lo uso para acepar todas los solicitudes a nivel http
    @ResponseBody // esta es para responder un cuerpo a nivel de el servicio
    public ResponseEntity<String> function(){
        return new ResponseEntity<>("esta es la respuesta de el servicvio jaja es una prueba cambio 1  cambio 2 jaja ", HttpStatus.OK);
    }
}
