/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c2_aplicacion;

import c3_dominio.entidades.NivelEducacion;
import c4_persistencia.GestorJDBC;
import c4_persistencia.daoPostgreSQL.GestorJDBCPostgre;
import c4_persistencia.daoPostgreSQL.NivelEducacionDAOPostgre;
import java.util.List;

/**
 *
 * @author EnriqueDavidJose
 */
public class GestionarNivelEducacionServicio {
    private GestorJDBC gestorJDBC;  
    private NivelEducacionDAOPostgre nivelEducacionDAO;
    
    public GestionarNivelEducacionServicio() {
        gestorJDBC = new GestorJDBCPostgre(); 
        nivelEducacionDAO = new NivelEducacionDAOPostgre(gestorJDBC);
    }
    
    public List<NivelEducacion> cargarNivelEducacion() throws Exception{             
        gestorJDBC.abrirConexion();        
        List<NivelEducacion> nivelEducaciones = nivelEducacionDAO.listar();
        gestorJDBC.cerrarConexion();
        return nivelEducaciones;
    }
    
    public NivelEducacion buscarNivelEducacion(int niveleducacionid) throws Exception{     
        gestorJDBC.abrirConexion();        
        NivelEducacion nivelEducacion = nivelEducacionDAO.buscar(niveleducacionid);
        gestorJDBC.cerrarConexion();
        return nivelEducacion;
    }
}
