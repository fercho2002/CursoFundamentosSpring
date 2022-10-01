package com.CursoPlatziFundamentos.SprontBoot.fundamentos.repository;

import com.CursoPlatziFundamentos.SprontBoot.fundamentos.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//con este etiqueta lo podemos inyectar como dependencia
@Repository
//la extencion JPa le pasa lo etidad que quiero mapear y el tipo de dato que tiene el  id,  JpaRepository<User, Long> esta es una interface de lsistema yo no la cree
public interface UserRepository extends JpaRepository<User, Long> {
}
