package com.CursoPlatziFundamentos.SprontBoot.fundamentos;

import com.CursoPlatziFundamentos.SprontBoot.fundamentos.User.UserPojo;
import com.CursoPlatziFundamentos.SprontBoot.fundamentos.bean.MyBean;
import com.CursoPlatziFundamentos.SprontBoot.fundamentos.bean.MyBeanWithDependency;
import com.CursoPlatziFundamentos.SprontBoot.fundamentos.bean.MyBeanWithRandom;
import com.CursoPlatziFundamentos.SprontBoot.fundamentos.component.ComponentDependency;
import com.CursoPlatziFundamentos.SprontBoot.fundamentos.entity.User;
import com.CursoPlatziFundamentos.SprontBoot.fundamentos.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private Log logger = LogFactory.getLog(FundamentosApplication.class);
	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private MyBeanWithRandom myBeanWithRandom;
	private UserPojo userPojo;
	private UserRepository userRepository;

	public FundamentosApplication(@Qualifier("componentImplentTwo") ComponentDependency componentDependency,MyBean myBean,MyBeanWithDependency myBeanWithDependency,MyBeanWithRandom myBeanWithRandom,UserPojo userPojo,UserRepository userRepository){
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.userRepository = userRepository;
		this.myBeanWithRandom = myBeanWithRandom;
		this.userPojo = userPojo;
	}
	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
			//ejemplosDeAntes();
			saveUserInDb();
			getInformatioJPQLFromUser();

	}
	private void getInformatioJPQLFromUser(){

		//Con esto lo que hago en llamar al metodo buscar usuario que hace un cuery
		//y si no encuentra por ese email || .orElseThrow(()-> new RuntimeException("NO se encontro al usuario "))
		// esto es una landa en caso de que ocuarra una excepcion o no encuentre o algo asi jaja
		logger.info("@esta es la busqueda por email "+
				userRepository.buscarUsuarioPorEmail("fercho4@gamil.com")
						.orElseThrow(()-> new RuntimeException("NO se encontro al usuario ")));

		//con esta linea llamo al metodo
		//aparte de llamar al metodo en le parametro SOrt le envi por que quiero que me ordene el resultado
		// en este caos por id y el .decendin lo ago decendiente
		// con esto || .forEach(u -> logger.info("@este es el like jaja " + u)
		// lo que hago es que a la lista que me retorne la imprimo jaaj
		userRepository.buscarOrdenar("fer", Sort.by("id").descending()).forEach(u -> logger.info("@este es el like jaja " + u));


	}



	private void saveUserInDb(){
		User user1 = new User("ernando","fercho@gamil.com", LocalDate.of(2022,9,30));
		User user4 = new User("fernando4","fercho4@gamil.com", LocalDate.of(2022,8,30));
		User user3 = new User("fernand3","ferch3@gamil.com", LocalDate.of(2022,7,30));
		User user2 = new User("fernando2","fercho2@gamil.com", LocalDate.of(2022,6,30));

		List<User> list = Arrays.asList(user1,user2,user3,user4);
		for(User a: list){
			userRepository.save(a);
		}

	}
	private void ejemplosDeAntes(){
		/*
		aqui cuando llamo alas interfaces lo que estoy haciendo es llamar los metodos donde los sobre escribi
		gracias al archivo de configuracion
		*/
		componentDependency.saludar();
		myBean.print();
		myBeanWithDependency.printWhitDependency();
		myBeanWithRandom.metodo();
		System.out.println("este es el imail : "+userPojo.getEmail()+" -- password = "+userPojo.getPassword()+" -- edad = "+userPojo.getAge() );

	}
}
