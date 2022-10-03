package com.CursoPlatziFundamentos.SprontBoot.fundamentos.repository;

import com.CursoPlatziFundamentos.SprontBoot.fundamentos.entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


//con este etiqueta lo podemos inyectar como dependencia
@Repository
//la extencion JPa le pasa lo etidad que quiero mapear y el tipo de dato que tiene el  id,  JpaRepository<User, Long> esta es una interface de lsistema yo no la cree
public interface UserRepository extends JpaRepository<User, Long> {


    // en esta anotacion @Query hago la consulta sql y ese ?1 quiere decir que de los parametros de metodo d abajo
    // toma el primero que en este caso es Strin email
    @Query("Select u from User u where u.email=?1")
    Optional<User> buscarUsuarioPorEmail(String email);

    @Query("select u from User u where u.nombre like ?1%")
    List<User> buscarOrdenar(String name, Sort sort);

}
