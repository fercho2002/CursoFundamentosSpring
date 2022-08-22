package com.CursoPlatziFundamentos.SprontBoot.fundamentos.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentImplement implements ComponentDependency{
    @Override
    public void saludar() {
        System.out.println("hola mundo desde component");
    }
}
