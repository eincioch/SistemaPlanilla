/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c2_aplicacion;

import c3_dominio.entidades.TipoMoneda;
import c4_persistencia.GestorJDBC;
import c4_persistencia.daoPostgreSQL.GestorJDBCPostgre;
import c4_persistencia.daoPostgreSQL.TipoMonedaDAOPostgre;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class GestionarTipoMonedaServicio {
    private GestorJDBC gestorJDBC;  
    private TipoMonedaDAOPostgre tipoMonedaDAO;
    
    public GestionarTipoMonedaServicio() {
        gestorJDBC = new GestorJDBCPostgre(); 
        tipoMonedaDAO = new TipoMonedaDAOPostgre(gestorJDBC);
    }
    
    public List<TipoMoneda> cargarTipoMoneda() throws Exception{             
        gestorJDBC.abrirConexion();        
        List<TipoMoneda> tiposMonedas = tipoMonedaDAO.listar();
        gestorJDBC.cerrarConexion();
        return tiposMonedas;
    }
    
    public TipoMoneda buscarTipoMoneda(int documentoid) throws Exception{     
        gestorJDBC.abrirConexion();        
        TipoMoneda tipoDocumento = tipoMonedaDAO.buscar(documentoid);
        gestorJDBC.cerrarConexion();
        return tipoDocumento;
    }
}
