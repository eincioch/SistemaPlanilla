
package c2_aplicacion;

import c3_dominio.entidades.Nacionalidad;
import c4_persistencia.GestorJDBC;
import c4_persistencia.daoPostgreSQL.GestorJDBCPostgre;
import c4_persistencia.daoPostgreSQL.NacionalidadDAOPostgre;
import java.util.List;

/**
 * @author Ernique Incio
 * @version 1.0
 * @created 26-ago-2015 02:20:29 a.m.
 */
public class GestionarNacionalidadServicio {
    private GestorJDBC gestorJDBC;  
    private NacionalidadDAOPostgre nacionalidadDAO;
    
    public GestionarNacionalidadServicio() {
        gestorJDBC = new GestorJDBCPostgre(); 
        nacionalidadDAO = new NacionalidadDAOPostgre(gestorJDBC);
    }
    
    public List<Nacionalidad> cargarNacionalidad() throws Exception{             
        gestorJDBC.abrirConexion();        
        List<Nacionalidad> nacionalidades = nacionalidadDAO.listar();
        gestorJDBC.cerrarConexion();
        return nacionalidades;
    }
    
    public Nacionalidad buscarNacionalidad(int generoid) throws Exception{     
        gestorJDBC.abrirConexion();        
        Nacionalidad nacionalidad = nacionalidadDAO.buscar(generoid);
        gestorJDBC.cerrarConexion();
        return nacionalidad;
    }
}
