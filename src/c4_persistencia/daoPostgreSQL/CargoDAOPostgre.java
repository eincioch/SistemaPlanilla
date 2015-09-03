
package c4_persistencia.daoPostgreSQL;

import c3_dominio.entidades.Cargo;
import c4_persistencia.GestorJDBC;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author EnriqueDavidJose
 */
public class CargoDAOPostgre {
    //"GestorJDBC".- contiene todos los metodos para trabajar con la base datos (conexion, ResultSet(select), PreparedStatement(insert, update, delete))
    GestorJDBC gestorJDBC;
    
    //Constructor
    public CargoDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }
    
    public List<Cargo> listar() throws SQLException{
        ArrayList<Cargo> cargos = new ArrayList();
        Cargo cargo;
        ResultSet resultado;
        String sentenciaSQL = "SELECT cargoid, descripcion FROM cargo;";
        
        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        while(resultado.next()){  
            //para hacer "new Genero" necesito tener un Construtor vacio.
            cargo = new Cargo();
            cargo.setCargoid(resultado.getInt("cargoid"));
            cargo.setDescripcion(resultado.getString("descripcion"));
            cargos.add(cargo);
        }
        resultado.close();
        return cargos;    
    }
    
    public Cargo buscar(int cargoid) throws SQLException {
        Cargo cargo = null;
        ResultSet resultado;
        String sentenciaSQL;

        sentenciaSQL = "SELECT cargoid, descripcion FROM cargo"
                             + " where cargoid = " + cargoid + ";";

        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        if(resultado.next()){            
            cargo = new Cargo();
            cargo.setCargoid(resultado.getInt("cargoid"));
            cargo.setDescripcion(resultado.getString("descripcion"));
        }
        resultado.close();
        return cargo;
    }
}
