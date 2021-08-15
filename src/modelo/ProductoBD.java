/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.*;


import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Ubunt
 */
public class ProductoBD extends ConexionBD {
    
    
    public ProductoBD(){
    }
    
    public ArrayList <Producto> listarProductos () throws SQLException{
        //ConexionBD conexion = new ConexionBD();
        String sql = "SELECT * FROM productos;";
        ResultSet res = consultarBD(sql);
        ArrayList <Producto> productos = new ArrayList<>();
        while(res.next()){
            Producto pro = new Producto();
            pro.setId(res.getInt("id"));
            pro.setNombre(res.getString("nombre"));
            pro.setCategoria(res.getString("categoria"));
            pro.setCantidad(res.getInt("cantidad"));
            pro.setPrecio(res.getDouble("precio"));
            productos.add(pro);
        }
        return productos;
    }

    public boolean insertarBD(Producto pro){
        String sql = "INSERT INTO productos (nombre, cantidad, categoria, precio) VALUES(";
        sql += "'" + pro.getNombre() + "',";
        sql +=       pro.getCantidad() + ",";
        sql += "'" + pro.getCategoria() + "',";
        sql +=       pro.getPrecio() + "');";

        return insertarBD(sql);
    }

    public boolean actualizarBD(Producto pro){
        String sql = "UPDATE productos SET";
        sql += "nombre = ' " +pro.getNombre() + "',";
        sql += "cantidad = " +pro.getCantidad()+ ",";
        sql += "categoria = ' " +pro.getCategoria() + "',";
        sql += "precio = " + pro.getPrecio();
        sql += "WHERE id = " + pro.getId()+";" ;
        
        return insertarBD(sql);
    }

    public boolean eliminar(Producto pro){
        String sql = "DELETE FROM productos WHERE id = " +pro.getId();
        return borrarBD(sql);
    }
}
