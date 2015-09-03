/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c2_aplicacion;

import c3_dominio.entidades.EstadoCivil;
import c4_persistencia.GestorJDBC;
import c4_persistencia.daoPostgreSQL.EstadoCivilDAOPostgre;
import c4_persistencia.daoPostgreSQL.GestorJDBCPostgre;
import java.util.List;

/**
 *
 * @author Enrique Incio
 */
public class GestionarEstadoCivilServicio {
    private GestorJDBC gestorJDBC;  
    private EstadoCivilDAOPostgre estadoCivilDAO;
    
    //Constructor
    public GestionarEstadoCivilServicio() {
        gestorJDBC = new GestorJDBCPostgre(); 
        estadoCivilDAO = new EstadoCivilDAOPostgre(gestorJDBC);
    }
    
    //Metodos
    public List<EstadoCivil> cargarEstadoCivil() throws Exception{             
        gestorJDBC.abrirConexion();        
        List<EstadoCivil> estadoCiviles = estadoCivilDAO.listar();
        gestorJDBC.cerrarConexion();
        return estadoCiviles;
    }
    
    public EstadoCivil buscarEstadoCivil(int estadocivilid) throws Exception{     
        gestorJDBC.abrirConexion();        
        EstadoCivil estadoCivil = estadoCivilDAO.buscar(estadocivilid);
        gestorJDBC.cerrarConexion();
        return estadoCivil;
    }
}
