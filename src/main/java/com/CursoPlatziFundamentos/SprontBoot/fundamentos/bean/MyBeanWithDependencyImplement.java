package com.CursoPlatziFundamentos.SprontBoot.fundamentos.bean;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency {


    private MyOperation myOperation;
    public MyBeanWithDependencyImplement(MyOperation myOperation){
        this.myOperation = myOperation;
    }

    // aqui sobrescribo el metodo de la interface y lo puedo utilisar cuando llamen a esta clase y las ves
    // el metodo de MyOperation entonces asi esas dos dependencias quedan como realcionasdas jaja
    @Override
    public void printWhitDependency() {
        int num = 5;
        System.out.println(myOperation.suma(num));
        System.out.println("este es el pront de el bean con dependencia ajaj ");
    }
}
