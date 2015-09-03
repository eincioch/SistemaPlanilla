/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c2_aplicacion;

import c3_dominio.entidades.PeriodicidadPago;
import c4_persistencia.GestorJDBC;
import c4_persistencia.daoPostgreSQL.GestorJDBCPostgre;
import c4_persistencia.daoPostgreSQL.PeriodicidadPagoDAOPostgre;
import java.util.List;

/**
 *
 * @author EnriqueDavidJose
 */
public class GestionarPeriodicidadPagoServicio {
    private GestorJDBC gestorJDBC;  
    private PeriodicidadPagoDAOPostgre periodicidadPagoDAO;
    
    public GestionarPeriodicidadPagoServicio() {
        gestorJDBC = new GestorJDBCPostgre(); 
        periodicidadPagoDAO = new PeriodicidadPagoDAOPostgre(gestorJDBC);
    }
    
    public List<PeriodicidadPago> cargarPeriodicidadPagoDAO() throws Exception{             
        gestorJDBC.abrirConexion();        
        List<PeriodicidadPago> periodicidadPagos = periodicidadPagoDAO.listar();
        gestorJDBC.cerrarConexion();
        return periodicidadPagos;
    }
    
    public PeriodicidadPago buscarPeriodicidadPago(int periodicidadid) throws Exception{     
        gestorJDBC.abrirConexion();        
        PeriodicidadPago periodicidadPago = periodicidadPagoDAO.buscar(periodicidadid);
        gestorJDBC.cerrarConexion();
        return periodicidadPago;
    }
}
