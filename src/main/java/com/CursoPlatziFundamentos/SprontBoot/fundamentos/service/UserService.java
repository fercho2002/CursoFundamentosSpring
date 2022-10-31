package com.CursoPlatziFundamentos.SprontBoot.fundamentos.service;

import com.CursoPlatziFundamentos.SprontBoot.fundamentos.entity.User;
import com.CursoPlatziFundamentos.SprontBoot.fundamentos.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.awt.print.Pageable;
import java.util.List;
import java.util.logging.Logger;

@Service
public class UserService {
    //este LOG es de apache y lo uso para mostrar los log pueden ser mensajes o errores entre otros por ahi abajo los utilizo jaja
    private final Log logg = LogFactory.getLog(UserService.class);

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /*con este @Tracsactional lo que hago es que si hay un error en insertar los registros en la base de datos en caso de que sea una lista y falla alguno el devuleve lo
    * que ahbia insertado antes entonces o se insertan todos o ninguno jaja */
    @Transactional
    public void saveTransaciones(List<User> users){
        /*con esto recivo una lista de usuarios u con la calse data factory los voy insertando en la base de datos pero imprimiendo cada usuario que voy insertando y ocn el control de la etiqueta de arriba */
        users.stream().peek(user -> logg.info("se inserto el usuario : "+user)).forEach(user -> userRepository.save(user));
    }

    public List<User> todosLosUsuarios(){
        return userRepository.findAll();
    }

    public User save(User bodi) {
        return userRepository.save(bodi);
    }

    public void delete(Long id) {
        userRepository.delete(new User(id));
    }

    public User modificar(User bod, Long id) {

        //qui abajo lo que ago es primero consultar ese usuario por el metoso findById que es el id que traigo en variable
        //desde el @putmaping entonces con el .map miro si lo encuentra y si lo hace guardo eso en la landa
        // user y ya con eso despues la guardo. siempre es importande abajo poner el .get porque ese findbyid es un optional
        return
        userRepository.findById(id).map(user -> {
            user.setBithdate(bod.getBithdate());
            user.setEmail(bod.getEmail());
            user.setNombre(bod.getNombre());
            return userRepository.save(user);

        }).get();
    }

}
