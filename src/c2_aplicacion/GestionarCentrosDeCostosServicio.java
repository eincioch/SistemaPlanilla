/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c2_aplicacion;

import c3_dominio.entidades.CentrosDeCostos;
import c4_persistencia.GestorJDBC;
import c4_persistencia.daoPostgreSQL.CentrosDeCostosDAOPostgre;
import c4_persistencia.daoPostgreSQL.GestorJDBCPostgre;
import java.util.List;
 
/**
 *
 * @author EnriqueDavidJose
 */
public class GestionarCentrosDeCostosServicio {
    private GestorJDBC gestorJDBC;  
    private CentrosDeCostosDAOPostgre centrosDeCostosDAO;
    
    public GestionarCentrosDeCostosServicio() {
        gestorJDBC = new GestorJDBCPostgre(); 
        centrosDeCostosDAO = new CentrosDeCostosDAOPostgre(gestorJDBC);
    }
    
    public List<CentrosDeCostos> cargarCentrosDeCostos() throws Exception{             
        gestorJDBC.abrirConexion();        
        List<CentrosDeCostos> centrosDeCostos = centrosDeCostosDAO.listar();
        gestorJDBC.cerrarConexion();
        return centrosDeCostos;
    }
    
    public CentrosDeCostos buscarCentroDeCosto(int centrocostoid) throws Exception{     
        gestorJDBC.abrirConexion();        
        CentrosDeCostos centroDeCosto = centrosDeCostosDAO.buscar(centrocostoid);
        gestorJDBC.cerrarConexion();
        return centroDeCosto;
    }
}
