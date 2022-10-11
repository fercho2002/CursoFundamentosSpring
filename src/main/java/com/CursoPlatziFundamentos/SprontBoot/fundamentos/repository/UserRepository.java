package com.CursoPlatziFundamentos.SprontBoot.fundamentos.repository;

import com.CursoPlatziFundamentos.SprontBoot.fundamentos.dto.UserDTO;
import com.CursoPlatziFundamentos.SprontBoot.fundamentos.entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
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


    //con este findBy(nomre de lcampo que voy a filtrar) con eso tambien puedo hacer una consulta hay puedo cambiar la palabra nombre por id o email y me retorna una lista de los que encuentre
     List<User> findBynombre(String name);


     //estos metodos no tienen el @Query por que vienen como por defecto jaja
     Optional<User> findBynombreAndEmail(String name,String email);

     List<User> findBynombreLike(String name);

    List<User> findBynombreOrEmail(String name,String email);


    // con esta me busca los registros que esten entre las dos fecha que le envie por parametro pero es intervalo abierto
    List<User> findBybithdateBetween(LocalDate desde,LocalDate hasta);


    // con este lo que hago es el filtro jjport el nombre con el like y ordeno por el id de esos registros jaja
    // el Desc lo puedo cambiar por Asc y pues me lo ordena acendente
    List<User> findByNombreLikeOrderByIdDesc(String name);


    // este es parecido al de arriba pero con la palabra containing que viene siendo casi lo mismo que el like jaja
    List<User> findByNombreContainingOrderByIdDesc(String name);

    /*aqu hago una consulta nolmalita un query y sus centencias, pero especifico la clase dto y el paquete
    * por que a esa es a la que le voy a pasar el resultado pormedio de parametros
    * en la parte de abajo con el @param especifico un nombre y con ese nombre lo puedo usar en el query
    * despues d : pongo ese parametro */
    @Query("SELECT new com.CursoPlatziFundamentos.SprontBoot.fundamentos.dto.UserDTO(result.id,result.nombre,result.bithdate) FROM User result where result.bithdate=:parametroFecha and result.email=:parametroEmail")
    List<UserDTO> EncontrarPorParametrosYelDTO(@Param("parametroFecha") LocalDate date, @Param("parametroEmail") String email);


}
