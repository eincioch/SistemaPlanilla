
package c4_persistencia.daoPostgreSQL;

import c3_dominio.entidades.Nacionalidad;
import c4_persistencia.GestorJDBC;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ernique Incio
 * @version 1.0
 * @created 26-ago-2015 02:20:29 a.m.
 */

public class NacionalidadDAOPostgre {
    GestorJDBC gestorJDBC;
    
    public NacionalidadDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }
    
    public List<Nacionalidad> listar() throws SQLException{
        ArrayList<Nacionalidad> nacionalidades = new ArrayList();
        Nacionalidad nacionalidad;
        ResultSet resultado;
        String sentenciaSQL = "SELECT nacionalidadid, pais FROM nacionalidad;";
        
        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        while(resultado.next()){  
            //para hacer "new Genero" necesito tener un Construtor vacio.
            nacionalidad = new Nacionalidad();
            nacionalidad.setNacionalidadid(resultado.getInt("nacionalidadid"));
            nacionalidad.setNacionalidad(resultado.getString("pais"));
            nacionalidades.add(nacionalidad);
        }
        resultado.close();
        return nacionalidades;    
    }
    
    public Nacionalidad buscar(int nacionalidadid) throws SQLException {
        Nacionalidad nacionalidad = null;
        ResultSet resultado;
        String sentenciaSQL;

        sentenciaSQL = "SELECT nacionalidadid, pais FROM nacionalidad"
                             + " where nacionalidadid = " + nacionalidadid + ";";

        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        if(resultado.next()){            
            nacionalidad = new Nacionalidad();
            nacionalidad.setNacionalidadid(resultado.getInt("nacionalidadid"));
            nacionalidad.setNacionalidad(resultado.getString("pais"));
        }
        resultado.close();
        return nacionalidad;
    }
}
