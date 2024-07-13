package gt.com.spring.web;

import gt.com.spring.domain.Persona;
import gt.com.spring.servicio.PersonaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@Slf4j
public class ControladorInicio {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/")
    public String inicio(Model model){
        var personas = personaService.listarPersonas();
        log.info("ejecutando Controlador");
        model.addAttribute("personas", personas);

        return "index";
    }

    @GetMapping("/agregar")
    public String agregar(Persona persona){
        log.info("ejecuatando Agregar");
        return "modificar";
    }

    @PostMapping("/guardar")
    public String guardar(Persona persona){
        personaService.guardar(persona);
        return "redirect:/";
    }

    @GetMapping("/editar/{idPersona}")
    public String editar(Persona persona, Model model){
        persona = personaService.encontrarPersona(persona);
        model.addAttribute("persona", persona);
        return "modificar";
    }

    @GetMapping("/eliminar")
    public String elimnar(Persona persona){
        personaService.eliminar(persona);
        return "redirect:/";
    }

}
