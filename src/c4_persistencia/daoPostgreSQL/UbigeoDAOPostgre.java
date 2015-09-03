
package c4_persistencia.daoPostgreSQL;

import c3_dominio.entidades.Ubigeo;
import c4_persistencia.GestorJDBC;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author EnriqueDavidJose
 */
public class UbigeoDAOPostgre {
    //"GestorJDBC".- contiene todos los metodos para trabajar con la base datos (conexion, ResultSet(select), PreparedStatement(insert, update, delete))
    GestorJDBC gestorJDBC;
    
    //Constructor
    public UbigeoDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }
    
    public List<Ubigeo> listarDepartamento() throws SQLException{
        ArrayList<Ubigeo> ubigeos = new ArrayList();
        Ubigeo ubigeo;
        ResultSet resultado;
        String sentenciaSQL = "select distinct max(ubigeoid) ubigeoid, max(departamentoid) departamentoid, departamento " +
                                " from ubigeo" +
                                " group by departamento" +
                                " order by max(ubigeoid);";
        
        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        while(resultado.next()){  
            //para hacer "new Genero" necesito tener un Construtor vacio.
            ubigeo = new Ubigeo();
            ubigeo.setUbigeoid(resultado.getInt("ubigeoid"));
            ubigeo.setDepartamentoid(resultado.getString("departamentoid"));
            ubigeo.setDepartamento(resultado.getString("departamento"));
            ubigeos.add(ubigeo);
        }
        resultado.close();
        return ubigeos;    
    }
    
    public List<Ubigeo> listarProvincia(String departamentoId) throws SQLException{
        ArrayList<Ubigeo> ubigeos = new ArrayList();
        Ubigeo ubigeo;
        ResultSet resultado;
        String sentenciaSQL = "select distinct max(ubigeoid) ubigeoid, max(provinciaid) provinciaid, provincia" +
                                " from ubigeo" +
                                " where departamentoid = '" + departamentoId +
                                "' group by provincia" +
                                " order by max(ubigeoid);";
        
        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        while(resultado.next()){  
            //para hacer "new Genero" necesito tener un Construtor vacio.
            ubigeo = new Ubigeo();
            ubigeo.setUbigeoid(resultado.getInt("ubigeoid"));
            ubigeo.setProvinciaid(resultado.getString("provinciaid"));
            ubigeo.setProvincia(resultado.getString("provincia"));
            ubigeos.add(ubigeo);
        }
        resultado.close();
        return ubigeos;    
    }
    
    public List<Ubigeo> listarDistrito(String departamentoId, String provinciaId) throws SQLException{
        ArrayList<Ubigeo> ubigeos = new ArrayList();
        Ubigeo ubigeo;
        ResultSet resultado;
        String sentenciaSQL = "select distinct max(ubigeoid) ubigeoid, max(distritoid) distritoid, distrito" +
                                " from ubigeo" +
                                " where departamentoid = '" + departamentoId + "' and provinciaid = '" + provinciaId +
                                "' group by distrito" +
                                " order by max(ubigeoid);";
        
        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        while(resultado.next()){  
            //para hacer "new Genero" necesito tener un Construtor vacio.
            ubigeo = new Ubigeo();
            ubigeo.setUbigeoid(resultado.getInt("ubigeoid"));
            ubigeo.setDistritoid(resultado.getString("distritoid"));
            ubigeo.setDistrito(resultado.getString("distrito"));
            ubigeos.add(ubigeo);
        }
        resultado.close();
        return ubigeos;    
    }
    
    public Ubigeo buscar(String ubigeoid) throws SQLException {
        Ubigeo ubigeo = null;
        ResultSet resultado;
        String sentenciaSQL;
        //para concatenar campos en PostgreSQL se utiliza "||" or dejando espacios " || ' ' || "
        sentenciaSQL = "SELECT ubigeoid, departamentoid, provinciaid, distritoid, departamento, provincia, distrito"
                + " FROM ubigeo"
                + " where (departamentoid ||  provinciaid ||  distritoid) = '" + ubigeoid + "';";

        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        if(resultado.next()){            
            ubigeo = new Ubigeo();
            ubigeo.setUbigeoid(resultado.getInt("ubigeoid"));
            ubigeo.setDepartamentoid(resultado.getString("departamentoid"));
            ubigeo.setProvinciaid(resultado.getString("provinciaid"));
            ubigeo.setDistritoid(resultado.getString("distritoid"));
            ubigeo.setDepartamento(resultado.getString("departamento"));
            ubigeo.setProvincia(resultado.getString("provincia"));
            ubigeo.setDistrito(resultado.getString("distrito"));
        }
        resultado.close();
        return ubigeo;
    }
}
