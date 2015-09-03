
package c4_persistencia.daoPostgreSQL;

import c3_dominio.entidades.Departamento;
import c4_persistencia.GestorJDBC;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author EnriqueDavidJose
 */
public class DepartamentoDAOPostgre {
    //"GestorJDBC".- contiene todos los metodos para trabajar con la base datos (conexion, ResultSet(select), PreparedStatement(insert, update, delete))
    GestorJDBC gestorJDBC;
    
    //Constructor
    public DepartamentoDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }
    
    public List<Departamento> listar() throws SQLException{
        ArrayList<Departamento> departamentos = new ArrayList();
        Departamento departamento;
        ResultSet resultado;
        String sentenciaSQL = "SELECT departamentoid, descripcion FROM departamento;";
        
        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        while(resultado.next()){  
            //para hacer "new Genero" necesito tener un Construtor vacio.
            departamento = new Departamento();
            departamento.setDepartamentoid(resultado.getInt("departamentoid"));
            departamento.setDescripcion(resultado.getString("descripcion"));
            departamentos.add(departamento);
        }
        resultado.close();
        return departamentos;    
    }
    
    public Departamento buscar(int departamentoid) throws SQLException {
        Departamento departamento = null;
        ResultSet resultado;
        String sentenciaSQL;

        sentenciaSQL = "SELECT departamentoid, descripcion FROM departamento"
                             + " where departamentoid = " + departamentoid + ";";

        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        if(resultado.next()){            
            departamento = new Departamento();
            departamento.setDepartamentoid(resultado.getInt("departamentoid"));
            departamento.setDescripcion(resultado.getString("descripcion"));
        }
        resultado.close();
        return departamento;
    }
}
