/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c2_aplicacion;

import c3_dominio.entidades.TipoEmpleado;
import c4_persistencia.GestorJDBC;
import c4_persistencia.daoPostgreSQL.GestorJDBCPostgre;
import c4_persistencia.daoPostgreSQL.TipoEmpleadoDAOPostgre;
import java.util.List;

/**
 *
 * @author EnriqueDavidJose
 */
public class GestionarTipoEmpleadoServicio {
    private GestorJDBC gestorJDBC;  
    private TipoEmpleadoDAOPostgre tipoEmpleadoDAO;
    
    public GestionarTipoEmpleadoServicio() {
        gestorJDBC = new GestorJDBCPostgre(); 
        tipoEmpleadoDAO = new TipoEmpleadoDAOPostgre(gestorJDBC);
    }
    
    public List<TipoEmpleado> cargarTipoEmpleado() throws Exception{             
        gestorJDBC.abrirConexion();        
        List<TipoEmpleado> tipoEmpleados = tipoEmpleadoDAO.listar();
        gestorJDBC.cerrarConexion();
        return tipoEmpleados;
    }
    
    public TipoEmpleado buscarTipoEmpleado(int tipoempleadoid) throws Exception{     
        gestorJDBC.abrirConexion();        
        TipoEmpleado tipoEmpleado = tipoEmpleadoDAO.buscar(tipoempleadoid);
        gestorJDBC.cerrarConexion();
        return tipoEmpleado;
    }
}
