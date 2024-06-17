/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebas;

import datos.ClienteDaoJDBC;
import dominio.Cliente;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author SEBASTIAN ZAMORA
 */
public class listar {
    public static void main(String[] args) throws SQLException {
        List<Cliente> clientes = null;
        clientes = new ClienteDaoJDBC().listar();
        
         for(Cliente cliente:clientes){
            System.out.println(cliente);
         }
    }
}
