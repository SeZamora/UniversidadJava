package gt.com.spring.web;



import gt.com.spring.dao.ContactoDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
@Slf4j
public class ControladorInicio {

    @Autowired
    private ContactoDao contactoDao;

    @GetMapping("/")
    public String inicio(Model model){
        var contactos = contactoDao.findAll();
        log.info("ejecutando Controlador");
        model.addAttribute("contactos", contactos);

        return "index";
    }

}
