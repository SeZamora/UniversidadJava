package test;

import beans.HolaMundoEjbRemote;
import javax.naming.*;

public class TestHolaMundoEJB {

    public static void main(String[] args) {
        System.out.println("Iniciando llamada EJB desde el cliente");
        try {
            Context jndi = new InitialContext();
            HolaMundoEjbRemote holaMundoEJB = (HolaMundoEjbRemote) jndi.lookup("java:global/HolaMundoEJB/HolaMundoEjbImpl!beans.HolaMundoEjbRemote");
            int resultado = holaMundoEJB.sumar(5, 3);
            System.out.println("Resultado de 5+3: " + resultado);
        } catch (NamingException e) {
            e.printStackTrace(System.out);
        }
    }

}
