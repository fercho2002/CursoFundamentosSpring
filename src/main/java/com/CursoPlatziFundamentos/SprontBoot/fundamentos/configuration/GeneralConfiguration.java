package com.CursoPlatziFundamentos.SprontBoot.fundamentos.configuration;

import com.CursoPlatziFundamentos.SprontBoot.fundamentos.User.UserPojo;
import com.CursoPlatziFundamentos.SprontBoot.fundamentos.bean.MyBeanWithRandom;
import com.CursoPlatziFundamentos.SprontBoot.fundamentos.bean.MyBeanWithRandomImplements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(UserPojo.class)
public class GeneralConfiguration {

    @Value("${value.name}")
    private String name ;

    @Value("${value.apellido}")
    private String apellido ;

    @Value("${value.random}")
    private String random ;

    @Bean
    public MyBeanWithRandom metodo(){
        return new MyBeanWithRandomImplements(name,apellido,random);
    }
}
