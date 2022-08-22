package com.CursoPlatziFundamentos.SprontBoot.fundamentos.bean;

public class MyBeanImplementsTwo implements MyBean{
    @Override
    public void print() {
        System.out.println("Esta es el llamado desde la implementacion de my bean Two");
    }
}
