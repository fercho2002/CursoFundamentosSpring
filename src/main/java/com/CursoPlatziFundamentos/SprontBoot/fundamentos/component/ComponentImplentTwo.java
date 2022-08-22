package com.CursoPlatziFundamentos.SprontBoot.fundamentos.component;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


//ese @Component es una de las etiquetas de spring boot es como para decir que es una clase general jaja
@Component

public class ComponentImplentTwo implements ComponentDependency{
    @Override
    public void saludar() {
        System.out.println("esta la llamo desde la clase two que implemento ese metodo ");
    }
}
