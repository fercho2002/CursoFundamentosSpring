package com.CursoPlatziFundamentos.SprontBoot.fundamentos.service;

import com.CursoPlatziFundamentos.SprontBoot.fundamentos.entity.User;
import com.CursoPlatziFundamentos.SprontBoot.fundamentos.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
}
