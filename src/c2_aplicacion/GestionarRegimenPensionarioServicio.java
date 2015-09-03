/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c2_aplicacion;

import c3_dominio.entidades.RegimenPensionario;
import c4_persistencia.GestorJDBC;
import c4_persistencia.daoPostgreSQL.GestorJDBCPostgre;
import c4_persistencia.daoPostgreSQL.RegimenPensionarioDAOPostgre;
import java.util.List;

/**
 *
 * @author EnriqueDavidJose
 */
public class GestionarRegimenPensionarioServicio {
    private GestorJDBC gestorJDBC;  
    private RegimenPensionarioDAOPostgre regimenPensionarioDAO;
    
    public GestionarRegimenPensionarioServicio() {
        gestorJDBC = new GestorJDBCPostgre(); 
        regimenPensionarioDAO = new RegimenPensionarioDAOPostgre(gestorJDBC);
    }
    
    public List<RegimenPensionario> cargarRegimenPensionario() throws Exception{             
        gestorJDBC.abrirConexion();        
        List<RegimenPensionario> regimenPensionarios = regimenPensionarioDAO.listar();
        gestorJDBC.cerrarConexion();
        return regimenPensionarios;
    }
    
    public List<RegimenPensionario> buscarRegimenPensionario(String descripcion) throws Exception{             
        gestorJDBC.abrirConexion();        
        List<RegimenPensionario> regimenPensionarios = regimenPensionarioDAO.buscar(descripcion);
        gestorJDBC.cerrarConexion();
        return regimenPensionarios;
    }   
    
    public int crearRegimenPensionario(RegimenPensionario regimenPensionario) throws Exception{
       gestorJDBC.abrirConexion();
       int registros_afectados = regimenPensionarioDAO.ingresar(regimenPensionario);
       gestorJDBC.cerrarConexion();
       return registros_afectados;
    }
    
        public int modificarRegimenPensionario(RegimenPensionario regimenPensionario) throws Exception{
        gestorJDBC.abrirConexion();        
        int registros_afectados = regimenPensionarioDAO.modificar(regimenPensionario);
        gestorJDBC.cerrarConexion();
        return registros_afectados;
    }
        
        public RegimenPensionario buscarRegimenPensionario(int regimenpensionarioid) throws Exception{     
        gestorJDBC.abrirConexion();        
        RegimenPensionario regimenPensionario = regimenPensionarioDAO.buscar(regimenpensionarioid);
        gestorJDBC.cerrarConexion();
        return regimenPensionario;
    }
}
