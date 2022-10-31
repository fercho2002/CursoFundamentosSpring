package com.CursoPlatziFundamentos.SprontBoot.fundamentos.controller;

import com.CursoPlatziFundamentos.SprontBoot.fundamentos.CasosUso.*;
import com.CursoPlatziFundamentos.SprontBoot.fundamentos.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//*ereda de la eticketa ontroller pero todo lo que se cree se formatea con formato json*/
@RestController
// con este defino el endpoint que voy a utilizar pero para esta clase porque para cada metodo usu el @GetMapping de abajo
@RequestMapping("/api/users")
public class UserRestController {

    private GetUser getUser;
    private DeleteUser deleteUser;
    private UpdateUser updateUser;
    private CreateUser createUser;
    private PaginasConsulta paginasConsulta;

    public UserRestController(PaginasConsulta paginasConsulta,GetUser getUser,CreateUser createUser,DeleteUser deleteUser,UpdateUser updateUser) {
        this.getUser = getUser;
        this.paginasConsulta = paginasConsulta;
        this.updateUser = updateUser;
        this.deleteUser = deleteUser;
        this.createUser = createUser;

    }

    @GetMapping("/")
    List<User> get(){
       return getUser.getAll();
    }
    //con este get lo qeu hago es obtener registros
    @GetMapping("/prueba")
    public String ss(){
        return "esta es una prueba de los enpoints jaja ";
    }

    //con los response entity lo que puedo hacer es responder estado http como el ok o el estus code 200
    //

    //con este post lo que hago es insertar registros
    @PostMapping("/")
    ResponseEntity<User> newUser(@RequestBody User bodi){
        //ese create es de una clase que tiene esos codigo y eso es un 201
       return new ResponseEntity<>(createUser.save(bodi), HttpStatus.CREATED);
    }

    //pongo entre {y hay viene el nombre de la variable }
    @DeleteMapping("/{id}")
    //esa variable la capturo aqui abajo con el @PathVariable y debo colovar el mismo nombre que aqui arriva
    //con los response entity lo que puedo hacer es responder estado http como el ok o el estus code 200
    ResponseEntity deleteUser(@PathVariable Long id){
        deleteUser.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
    @PutMapping("/{id}")
    ResponseEntity<User> modificar(@RequestBody User Bod,@PathVariable Long id ){
        return new ResponseEntity<>(updateUser.modificar(Bod,id),HttpStatus.OK);
    }


}
