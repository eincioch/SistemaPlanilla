
package c2_aplicacion;

import c3_dominio.entidades.Genero;
import c4_persistencia.GestorJDBC;
import c4_persistencia.daoPostgreSQL.GeneroDAOPostgre;
import c4_persistencia.daoPostgreSQL.GestorJDBCPostgre;
import java.util.List;

/**
 * @author Ernique Incio
 * @version 1.0
 * @created 26-ago-2015 02:20:29 a.m.
 */
public class GestionarGeneroServicio {
    private GestorJDBC gestorJDBC;  
    private GeneroDAOPostgre generoDAO;
    
    public GestionarGeneroServicio() {
        gestorJDBC = new GestorJDBCPostgre(); 
        generoDAO = new GeneroDAOPostgre(gestorJDBC);
    }
    
    public List<Genero> cargarGenero() throws Exception{             
        gestorJDBC.abrirConexion();        
        List<Genero> generos = generoDAO.listar();
        gestorJDBC.cerrarConexion();
        return generos;
    }
    
    public Genero buscarGenero(int generoid) throws Exception{     
        gestorJDBC.abrirConexion();        
        Genero genero = generoDAO.buscar(generoid);
        gestorJDBC.cerrarConexion();
        return genero;
    }
}
