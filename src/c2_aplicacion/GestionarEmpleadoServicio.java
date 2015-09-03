/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c2_aplicacion;

import c3_dominio.entidades.Empleado;
import c4_persistencia.GestorJDBC;
import c4_persistencia.daoPostgreSQL.EmpleadoDAOPostgre;
import c4_persistencia.daoPostgreSQL.GestorJDBCPostgre;

/**
 * @author EnriqueDavidJose
 * @version 1.0
 * @created 25-ago-2015 12:49:29 p.m.
 */
public class GestionarEmpleadoServicio {
    private GestorJDBC gestorJDBC;  
    private EmpleadoDAOPostgre empleadoDAO;
    
    //Constructor
    public GestionarEmpleadoServicio() {
        gestorJDBC = new GestorJDBCPostgre(); 
        empleadoDAO = new EmpleadoDAOPostgre(gestorJDBC);
    }
    
    public int crearEmpleado(Empleado empleado) throws Exception{
       gestorJDBC.abrirConexion();
       int registros_afectados = empleadoDAO.ingresar(empleado);
       gestorJDBC.cerrarConexion();
       return registros_afectados;
    }
    
    public Empleado buscarEmpleado(int tipodocumentoid,String numerodocumento) throws Exception{     
        gestorJDBC.abrirConexion();        
        Empleado empleado = empleadoDAO.buscar(tipodocumentoid,numerodocumento);
        gestorJDBC.cerrarConexion();
        return empleado;
    }
}
