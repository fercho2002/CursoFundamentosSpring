package com.CursoPlatziFundamentos.SprontBoot.fundamentos;

import com.CursoPlatziFundamentos.SprontBoot.fundamentos.User.UserPojo;
import com.CursoPlatziFundamentos.SprontBoot.fundamentos.bean.MyBean;
import com.CursoPlatziFundamentos.SprontBoot.fundamentos.bean.MyBeanWithDependency;
import com.CursoPlatziFundamentos.SprontBoot.fundamentos.bean.MyBeanWithRandom;
import com.CursoPlatziFundamentos.SprontBoot.fundamentos.component.ComponentDependency;
import com.CursoPlatziFundamentos.SprontBoot.fundamentos.dto.UserDTO;
import com.CursoPlatziFundamentos.SprontBoot.fundamentos.entity.User;
import com.CursoPlatziFundamentos.SprontBoot.fundamentos.repository.UserRepository;
import com.CursoPlatziFundamentos.SprontBoot.fundamentos.service.UserService;
import net.bytebuddy.asm.Advice;
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
import java.util.Optional;
import java.util.logging.Logger;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {


	//este LOG es de apache y lo uso para mostrar los log pueden ser mensajes o errores entre otros por ahi abajo los utilizo jaja
	private Log logger = LogFactory.getLog(FundamentosApplication.class);
	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private MyBeanWithRandom myBeanWithRandom;
	private UserPojo userPojo;
	private UserRepository userRepository;
	private UserService userService;

	public FundamentosApplication(@Qualifier("componentImplentTwo") ComponentDependency componentDependency,MyBean myBean,MyBeanWithDependency myBeanWithDependency,MyBeanWithRandom myBeanWithRandom,UserPojo userPojo,UserRepository userRepository,UserService userService){
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.userRepository = userRepository;
		this.myBeanWithRandom = myBeanWithRandom;
		this.userPojo = userPojo;
		this.userService = userService;
	}
	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	// este metodo es lo que se va a ejecutar cuando yo le de run al programa
	@Override
	public void run(String... args) throws Exception {
			//ejemplosDeAntes();
			saveUserInDb();
			getInformatioJPQLFromUser();
			saveResultsTransactional();

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


		//llamo ese metodo y con el .stream lo movierto la respuesta a stream y con el for each lo imprimo jaja
		userRepository.findBynombre("ernando").stream().forEach(u -> logger.info("@esta es una prueba con el find "+u));

	    // este metodo el que va despues del AND es otro campo pero toca la primera en mayuscula osino no reconoce el campo y este busca solo si hay la coincidencia de nombre y email
		/*
		logger.info("@prueba con el metodo findBynombreANdemail "+userRepository.findBynombreAndEmail("fernando4","fercho8@gamil.com").orElseThrow(()->new RuntimeException("no se encntro por ese nombre y amellido ")));
		*/
		//cuando hay una exception de la forma que esta aqui arriva no me funciona porque detiene todo el flujo
		//aqui abajo voy a probar con try y catch

		//este try creo que solo me va a funcionar si es una lista por que este optional si la respuesta no devuelve nada
		// igual me guarda ese null estonces nunca va a entrar al catch por eso use el if y con ese si puedo validar si eso esta vacio
		try{
			Optional a;
			logger.info("@prueba con el metodo findBynombreANdemail "+userRepository.findBynombreAndEmail("fernando4","fercho8@gamil.com"));
			a = userRepository.findBynombreAndEmail("fernando4","fercho8@gamil.com");

			// si entra a este if es por que no encontro el nombre o el email, eso deben ser los mismo para un registro
			if(a.isEmpty()){
				logger.info("@@@eso esta vacio jaja ");
			}
		}catch (Exception e ){
			logger.info("@ salio un error a buscar por nombre and email este es el error : "+e);
		}


		//como es con like lo paso desde aqui de una vez con el %%
		userRepository.findBynombreLike("%fer%").forEach(u -> logger.info("este es con el like jaja "+u));



		// con este puedo pasar el email o el nombre y el me busca por cualquiera de los dos
		userRepository.findBynombreOrEmail("","fercho@gamil.com").forEach(u -> logger.info("este es con el Or jaja "+u));



		// con este lo que hago es que busco los usuarios pero si estan entre las fecha que les envie el campo birtdate

		//aqui abajo puse el 30 y entonces en un intervalo abierto toma los dos exptremos
		userRepository.findBybithdateBetween(LocalDate.of(2022,06,1),LocalDate.of(2022,07,31)).forEach(u->logger.info("esta fecha entre y hasta "+u));

		// si coincide el name con el like me los imprime pero en orden diferente
		userRepository.findByNombreLikeOrderByIdDesc("%ferna%").forEach(u -> logger.info("este ele por orderby id "+u));


		// si coincide el name con el like me los imprime pero en orden diferente
		userRepository.findByNombreContainingOrderByIdDesc("ferna").forEach(u -> logger.info("este ele por orderby id y el contain  "+u));


		// si coinciden ambos me trae el resultado en forma de dto la clase, pero si no lo encuentra no se va por el else  no se por que jaja tocari probar con try an catch
		List<UserDTO> a;
		a=userRepository.EncontrarPorParametrosYelDTO(LocalDate.of(2022,9,30),"fercho@gamil.com");
		if(a!=null) {
			a.forEach(u -> logger.info("@esto es con el @parametroyDTO" + u));
		}else {
			logger.info("No se encontro nada con la consulta talves esos datos no estan en la base de datos ");
		}

		}





	private void saveResultsTransactional(){
		User test1 = new User("test1","tes1@gmail.com",LocalDate.of(2022,1,1));
		User test2 = new User("test2","tes2@gmail.com",LocalDate.of(2022,1,1));
		User test3 = new User("test3","tes3@gmail.com",LocalDate.of(2022,1,1));
		User test4 = new User("test4","tes4@gmail.com",LocalDate.of(2022,1,1));
		List<User> u = Arrays.asList(test1,test2,test3,test4);
		try {
			//si llego a enviar un email repetido el no me va a insertar ninguno en la base de datos por que tiene la eticketa transacional entonces si alguno falla no insertada nada el la clase UserService
			userService.saveTransaciones(u);
		}catch (Exception e ){
			logger.info("@@@ se presento un error al insetar los datos en la base de datos haci que dibo hacer rollback con el transactional y no insertar ninguno jaja ");
		}
		userService.todosLosUsuarios().forEach(user->logger.info("este es el usuario transacional = "+user));

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
