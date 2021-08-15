/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto5;

import Vista.Vista;
import modelo.ProductoBD;
import controlador.Controlador;
import java.sql.SQLException;
import modelo.ConexionBD;

/**
 *
 * @author Santiago Gutiérrez
 * 
 */
public class Reto5 {
    
    public static void main(String[] args) throws SQLException{
        
        ProductoBD mod = new ProductoBD();
        Vista vista = new Vista();
        
        vista.setVisible(true);
        Controlador ctlr = new Controlador(vista, mod);
        System.out.println("Comenzando programa...");
        ConexionBD con = new ConexionBD();
    }
}
