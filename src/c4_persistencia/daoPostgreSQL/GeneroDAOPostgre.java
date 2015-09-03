
package c4_persistencia.daoPostgreSQL;

import c3_dominio.entidades.Genero;
import c4_persistencia.GestorJDBC;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//import java.awt.List; no se puede mezclar con "util.List"

/**
 * @author Enrique Incio
 * @version 1.0
 * @created 26-ago-2015 02:20:29 a.m.
 */

public class GeneroDAOPostgre {
    GestorJDBC gestorJDBC;
    
    public GeneroDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }
    
    public List<Genero> listar() throws SQLException{
        ArrayList<Genero> generos = new ArrayList();
        Genero genero;
        ResultSet resultado;
        String sentenciaSQL = "SELECT generoid, genero FROM genero;";
        
        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        while(resultado.next()){  
            //para hacer "new Genero" necesito tener un Construtor vacio.
            genero = new Genero();
            genero.setGeneroid(resultado.getInt("generoid"));
            genero.setGenero(resultado.getString("genero"));
            generos.add(genero);
        }
        resultado.close();
        return generos;    
    }
    
    public Genero buscar(int generoid) throws SQLException {
        Genero genero = null;
        ResultSet resultado;
        String sentenciaSQL;

        sentenciaSQL = "SELECT generoid, genero FROM genero"
                             + " where generoid = " + generoid + ";";

        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        if(resultado.next()){            
            genero = new Genero();
            genero.setGeneroid(resultado.getInt("generoid"));
            genero.setGenero(resultado.getString("genero"));
        }
        resultado.close();
        return genero;
    }
}
