/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.ProductoBD;
import modelo.Producto;
import Vista.Vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Logger;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.Iterator;



/**
 *
 * @author Ubunt
 */
public class Controlador implements ActionListener {
    
    
    private Vista view;
    private ProductoBD modelo;
    
    public Controlador (Vista view, ProductoBD productoBD) throws SQLException{
        
        this.view = view;
        this.modelo = productoBD;
        
        this.view.bGuardar.addActionListener(this);
        this.view.bActualizar.addActionListener(this);
        this.view.bConsultar.addActionListener(this);
        this.view.bEliminar.addActionListener(this);
        
        this.view.tbConsultar.addMouseListener( new MouseAdapter(){            //Clase abstracta MouseAdapter posee 
            DefaultTableModel model = new DefaultTableModel();                 //el método mouseClicked que recibe
            Iterator <Producto> iter = modelo.listarProductos().iterator();    //un evento de la clase MouseEvent cada que 
            @Override                                                          //se presiona una fila de la tabla, a la que se le añade   
            public void mouseClicked(MouseEvent e){                            //el mouse listener para tal fin 
                int i = view.tbConsultar.getSelectedRow();
                String id = view.tbConsultar.getValueAt(i, 0).toString();
                while(iter.hasNext()){
                    Producto producto = iter.next();
                    if(Integer.toString(producto.getId()).equals(id)) {
                        view.tcId.setText(id);
                        view.tcNombre.setText(producto.getNombre());
                        view.tcCantidad.setText(String.valueOf(producto.getCantidad()));
                        view.tcPrecio.setText(String.valueOf(producto.getPrecio())); 
                        int index;
                        if(producto.getCategoria().equals("ASEO")){
                            index = 0;
                        }
                        else{
                            index = 1;
                        }
                        view.rComboC.setSelectedIndex(index);
                    } 
                }
            }
        });
    }       
            
    public Controlador (){
    }
    
    public void clearConsulta(){
        
        view.tcId.setText(" ");
        view.tcNombre.setText(" ");
        view.tcCantidad.setText(" ");
        view.tcPrecio.setText(" ");
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        DefaultTableModel model = (DefaultTableModel) view.tbConsultar.getModel();  //Se evaluán las diferentes posibilidades 
        if(e.getSource() == view.bGuardar){                                         //del método e.getSource(), buscando la fuente del evento    
            Producto pro = new Producto();                                          //de cliqueo sobre alguno de los botones, a los que se les 
            pro.setNombre(view.trNombre.getText());                                 //añaden también EventListeners
            pro.setCantidad(Integer.valueOf(view.trCantidad.getText()));
            pro.setPrecio(Double.valueOf(view.trPrecio.getText()));
            pro.setCategoria(String.valueOf(view.rComboR.getSelectedItem()));
            
            modelo.insertarBD(pro);
            view.trNombre.setText(" ");
            view.trCantidad.setText(" ");
            view.trPrecio.setText(" ");
            
        }
        else if (e.getSource() == view.bConsultar){
            model.setRowCount(0);
            try{
                for (Producto producto: this.modelo.listarProductos()){
                    model.addRow(new Object[]{producto.getId(), producto.getNombre(), producto.getCantidad(), producto.getCategoria(), producto.getPrecio()});
                }
            }
            catch (SQLException ex){
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                
            }
            view.tbConsultar.setModel(model);
            clearConsulta();
        }
        
        else if (e.getSource() == view.bActualizar){
            Producto pro = new Producto();
            pro.setId(Integer.valueOf(view.tcId.getText()));
            pro.setNombre(view.tcNombre.getText());
            pro.setCantidad(Integer.valueOf(view.tcCantidad.getText()));
            pro.setPrecio(Double.valueOf(view.tcPrecio.getText()));
            pro.setCategoria(String.valueOf(view.rComboC.getSelectedItem()));
            
            modelo.actualizarBD(pro);
            view.tcId.setText(" ");
            view.tcNombre.setText(" ");
            view.tcCantidad.setText(" ");
            view.tcPrecio.setText(" ");  
        }
        
        else if (e.getSource() == view.bEliminar){
            Producto pro = new Producto();
            pro.setId(Integer.valueOf(view.tcId.getText()));
            pro.setNombre(view.tcNombre.getText());
            pro.setCantidad(Integer.valueOf(view.tcCantidad.getText()));
            pro.setPrecio(Double.valueOf(view.tcPrecio.getText()));
            pro.setCategoria(String.valueOf(view.rComboC.getSelectedItem()));
            
            modelo.eliminar(pro);
            view.tcId.setText(" ");
            view.tcNombre.setText(" ");
            view.tcCantidad.setText(" ");
            view.tcPrecio.setText(" "); 
        }  
    }
}

