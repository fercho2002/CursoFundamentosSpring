package com.CursoPlatziFundamentos.SprontBoot.fundamentos.configuration;

import com.CursoPlatziFundamentos.SprontBoot.fundamentos.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigurationBean {
    @Bean
    public MyBean beanOperation(){
        return new MyBeanImplementsTwo();
    }


    // con esto lo que se hace es como decir cual de los implements es el que se va a usar en
    // la interface ya que se puede implementar desde varias clases pero aqui le decimos cual es la que va a tomar
    @Bean
    public MyOperation beanOperationSuma(){
        return new MyOperationImplement();
    }

    @Bean
    public MyBeanWithDependency beanOperationSumaWithDependency(MyOperation myOperation){
        return new MyBeanWithDependencyImplement(myOperation);
    }
}
