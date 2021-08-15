/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Ubunt
 */
public class ConexionBDTest {
    
    public ConexionBDTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getConnection method, of class ConexionBD.
     */
    @Test
    public void testGetConnection() {
        System.out.println("getConnection");
        ConexionBD instance = new ConexionBD();
        Connection expResult = null;
        Connection result = instance.getConnection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of closeConnection method, of class ConexionBD.
     */
    @Test
    public void testCloseConnection() {
        System.out.println("closeConnection");
        Connection con = null;
        ConexionBD instance = new ConexionBD();
        instance.closeConnection(con);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of consultarBD method, of class ConexionBD.
     */
    @Test
    public void testConsultarBD() {
        System.out.println("consultarBD");
        String sentencia = "";
        ConexionBD instance = new ConexionBD();
        ResultSet expResult = null;
        ResultSet result = instance.consultarBD(sentencia);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertarBD method, of class ConexionBD.
     */
    @Test
    public void testInsertarBD() {
        System.out.println("insertarBD");
        String sentencia = "";
        ConexionBD instance = new ConexionBD();
        boolean expResult = false;
        boolean result = instance.insertarBD(sentencia);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of borrarBD method, of class ConexionBD.
     */
    @Test
    public void testBorrarBD() {
        System.out.println("borrarBD");
        String sentencia = "";
        ConexionBD instance = new ConexionBD();
        boolean expResult = false;
        boolean result = instance.borrarBD(sentencia);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actualizarBD method, of class ConexionBD.
     */
    @Test
    public void testActualizarBD() {
        System.out.println("actualizarBD");
        String sentencia = "";
        ConexionBD instance = new ConexionBD();
        boolean expResult = false;
        boolean result = instance.actualizarBD(sentencia);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAutoCommitBD method, of class ConexionBD.
     */
    @Test
    public void testSetAutoCommitBD() {
        System.out.println("setAutoCommitBD");
        boolean parametro = false;
        ConexionBD instance = new ConexionBD();
        boolean expResult = false;
        boolean result = instance.setAutoCommitBD(parametro);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cerrarConexion method, of class ConexionBD.
     */
    @Test
    public void testCerrarConexion() {
        System.out.println("cerrarConexion");
        ConexionBD instance = new ConexionBD();
        instance.cerrarConexion();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of commitBD method, of class ConexionBD.
     */
    @Test
    public void testCommitBD() {
        System.out.println("commitBD");
        ConexionBD instance = new ConexionBD();
        boolean expResult = false;
        boolean result = instance.commitBD();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of rollbackBD method, of class ConexionBD.
     */
    @Test
    public void testRollbackBD() {
        System.out.println("rollbackBD");
        ConexionBD instance = new ConexionBD();
        boolean expResult = false;
        boolean result = instance.rollbackBD();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
