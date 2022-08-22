package myPractica;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configuaracion {
    @Bean
    public PracticaInterfaceUno practice(){
        return new PracticaImplementacion();
    }
}
