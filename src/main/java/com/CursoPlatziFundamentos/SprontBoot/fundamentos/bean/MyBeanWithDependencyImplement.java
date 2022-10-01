package com.CursoPlatziFundamentos.SprontBoot.fundamentos.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency {

    private Log logger = LogFactory.getLog(MyBeanWithDependencyImplement.class);
    private MyOperation myOperation;
    public MyBeanWithDependencyImplement(MyOperation myOperation){
        this.myOperation = myOperation;
    }

    // aqui sobrescribo el metodo de la interface y lo puedo utilisar cuando llamen a esta clase y las ves
    // el metodo de MyOperation entonces asi esas dos dependencias quedan como realcionasdas jaja
    @Override
    public void printWhitDependency() {
        logger.info("entro al metdo prind desde un log.info");
        int num = 5;
        logger.debug("esta es la variable que recibe lo muestro desde un log.debug jaja "+num);
        System.out.println(myOperation.suma(num));
        System.out.println("este es el pront de el bean con dependencia ajaj ");

        try{
            int r = num/0;
        }catch(Exception e){
            logger.error("la divicion no se puede hacer entre cero "+e.getMessage());
        }
    }
}
