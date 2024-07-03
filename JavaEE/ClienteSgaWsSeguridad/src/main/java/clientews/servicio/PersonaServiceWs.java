
package clientews.servicio;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.10
 * Generated source version: 2.2
 * 
 */
@WebService(name = "PersonaServiceWs", targetNamespace = "http://servicio.sga.gm.com.mx/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface PersonaServiceWs {


    /**
     * 
     * @return
     *     returns java.util.List<clientews.servicio.Persona>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "listarPersonas", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.ListarPersonas")
    @ResponseWrapper(localName = "listarPersonasResponse", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.ListarPersonasResponse")
    @Action(input = "http://servicio.sga.gm.com.mx/PersonaServiceWs/listarPersonasRequest", output = "http://servicio.sga.gm.com.mx/PersonaServiceWs/listarPersonasResponse")
    public List<Persona> listarPersonas();

}
