package myPractica;

import com.CursoPlatziFundamentos.SprontBoot.fundamentos.FundamentosApplication;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class practicaMain implements CommandLineRunner {


    private Log LOGGER = LogFactory.getLog(practicaMain.class);
    private PracticaInterfaceUno practicaInterfaceUno;

    public practicaMain(PracticaInterfaceUno practicaInterfaceUno){
        this.practicaInterfaceUno = practicaInterfaceUno;

    }
    public static void main(String[] args) {
        SpringApplication.run(practicaMain.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        practicaInterfaceUno.printUno();
        LOGGER.error("ESTA ES LA PRUEBA DE EL ERROR JAJA ");
    }
}
