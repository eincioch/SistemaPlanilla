/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c2_aplicacion;

import c3_dominio.entidades.Ubigeo;
import c4_persistencia.GestorJDBC;
import c4_persistencia.daoPostgreSQL.GestorJDBCPostgre;
import c4_persistencia.daoPostgreSQL.UbigeoDAOPostgre;
import java.util.List;

/**
 *
 * @author EnriqueDavidJose
 */
public class GestionarUbigeoServicio {
    private GestorJDBC gestorJDBC;  
    private UbigeoDAOPostgre ubigeoDAO;
    
    public GestionarUbigeoServicio() {
        gestorJDBC = new GestorJDBCPostgre(); 
        ubigeoDAO = new UbigeoDAOPostgre(gestorJDBC);
    }
    
    public List<Ubigeo> cargarDepartamento() throws Exception{             
        gestorJDBC.abrirConexion();        
        List<Ubigeo> ubigeos = ubigeoDAO.listarDepartamento();
        gestorJDBC.cerrarConexion();
        return ubigeos;
    }
    
    public List<Ubigeo> cargarProvincia(String departamentoId) throws Exception{             
        gestorJDBC.abrirConexion();        
        List<Ubigeo> ubigeos = ubigeoDAO.listarProvincia(departamentoId);
        gestorJDBC.cerrarConexion();
        return ubigeos;
    }
    
    public List<Ubigeo> cargarDistrito(String departamentoId, String provinciaId) throws Exception{             
        gestorJDBC.abrirConexion();        
        List<Ubigeo> ubigeos = ubigeoDAO.listarDistrito(departamentoId, provinciaId);
        gestorJDBC.cerrarConexion();
        return ubigeos;
    }
    
    public Ubigeo buscarUbigeo(String ubigeoid) throws Exception{     
        gestorJDBC.abrirConexion();        
        Ubigeo ubigeo = ubigeoDAO.buscar(ubigeoid);
        gestorJDBC.cerrarConexion();
        return ubigeo;
    }
}
