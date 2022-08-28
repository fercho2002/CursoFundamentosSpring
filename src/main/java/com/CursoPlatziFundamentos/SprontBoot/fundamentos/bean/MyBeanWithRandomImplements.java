package com.CursoPlatziFundamentos.SprontBoot.fundamentos.bean;

public class MyBeanWithRandomImplements implements MyBeanWithRandom{
    private String name;
    private String apellido;
    private String random;

    public MyBeanWithRandomImplements(String name,String apellido,String random){
        this.name = name;
        this.apellido = apellido;
        this.random = random;
    }
    @Override
    public void metodo() {
        System.out.println("name = "+name);
        System.out.println("apellido = "+apellido);
        System.out.println("random = "+random);
    }
}
