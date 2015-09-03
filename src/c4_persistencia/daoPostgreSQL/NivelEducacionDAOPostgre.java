
package c4_persistencia.daoPostgreSQL;

import c3_dominio.entidades.NivelEducacion;
import c4_persistencia.GestorJDBC;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author EnriqueDavidJose
 */
public class NivelEducacionDAOPostgre {
    //"GestorJDBC".- contiene todos los metodos para trabajar con la base datos (conexion, ResultSet(select), PreparedStatement(insert, update, delete))
    GestorJDBC gestorJDBC;
    
    //Constructor
    public NivelEducacionDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }
    
    public List<NivelEducacion> listar() throws SQLException{
        ArrayList<NivelEducacion> niveleducaciones = new ArrayList();
        NivelEducacion niveleducacion;
        ResultSet resultado;
        String sentenciaSQL = "SELECT niveleducacionid, descripcion FROM niveleducacion;";
        
        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        while(resultado.next()){  
            //para hacer "new Genero" necesito tener un Construtor vacio.
            niveleducacion = new NivelEducacion();
            niveleducacion.setNiveleducacionid(resultado.getInt("niveleducacionid"));
            niveleducacion.setDescripcion(resultado.getString("descripcion"));
            niveleducaciones.add(niveleducacion);
        }
        resultado.close();
        return niveleducaciones;    
    }
    
    public NivelEducacion buscar(int niveleducacionid) throws SQLException {
        NivelEducacion nivelEducacion = null;
        ResultSet resultado;
        String sentenciaSQL;

        sentenciaSQL = "SELECT niveleducacionid, descripcion FROM niveleducacion"
                             + " where niveleducacionid = " + niveleducacionid + ";";

        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        if(resultado.next()){            
            nivelEducacion = new NivelEducacion();
            nivelEducacion.setNiveleducacionid(resultado.getInt("niveleducacionid"));
            nivelEducacion.setDescripcion(resultado.getString("descripcion"));
        }
        resultado.close();
        return nivelEducacion;
    }
}
