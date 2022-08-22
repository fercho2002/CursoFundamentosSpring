package com.CursoPlatziFundamentos.SprontBoot.fundamentos;

import com.CursoPlatziFundamentos.SprontBoot.fundamentos.bean.MyBean;
import com.CursoPlatziFundamentos.SprontBoot.fundamentos.bean.MyBeanWithDependency;
import com.CursoPlatziFundamentos.SprontBoot.fundamentos.component.ComponentDependency;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;

	public FundamentosApplication(@Qualifier("componentImplentTwo") ComponentDependency componentDependency,MyBean myBean,MyBeanWithDependency myBeanWithDependency){
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
	}
	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/*
		aqui cuando llamo alas interfaces lo que estoy haciendo es llamar los metodos donde los sobre escribi
		gracias al archivo de configuracion
		*/
		componentDependency.saludar();
		myBean.print();
		myBeanWithDependency.printWhitDependency();
	}
}
