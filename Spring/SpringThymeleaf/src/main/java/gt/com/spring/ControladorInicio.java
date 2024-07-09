package gt.com.spring;



import gt.com.spring.domain.Persona;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
@Slf4j
public class ControladorInicio {

    @Value("${index.saludo}")
    private String saludo;


    @GetMapping("/")
    public String inicio(Model model){
        String mensaje = "Mensaje con Thymeleaf";
        Persona persona1 = new Persona();
        persona1.setNombre("Jorge");
        persona1.setApellido("Gomez");
        persona1.setEmail("jorge@gmail.com");
        persona1.setTelefono("12334567");

        Persona persona2 = new Persona();
        persona2.setNombre("Maria");
        persona2.setApellido("Perez");
        persona2.setEmail("maria@gmail.com");
        persona2.setTelefono("987654321");

        List<Persona> personas = new ArrayList();
        personas.add(persona1);
        personas.add(persona2);
        log.info("Ejecutando controlador Spring MVC");
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("personas", personas);


        return "index";
    }

}
