
package c4_persistencia.daoPostgreSQL;

import c3_dominio.entidades.TipoDocumento;
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
public class TipoDocumentoDAOPostgre {
    //"GestorJDBC".- contiene todos los metodos para trabajar con la base datos (conexion, ResultSet(select), PreparedStatement(insert, update, delete))
    GestorJDBC gestorJDBC;
    
    //Constructor
    public TipoDocumentoDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }
    
    //lista todos los registros de la tabla
    public List<TipoDocumento> listar() throws SQLException{
        ArrayList<TipoDocumento> tipodocumentos = new ArrayList();
        TipoDocumento tipodocumento;
        ResultSet resultado;
        String sentenciaSQL = "SELECT documentoid, descripcion FROM tipodocumento;";
        
        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        while(resultado.next()){  
            //para hacer "new Genero" necesito tener un Construtor vacio.
            tipodocumento = new TipoDocumento();
            tipodocumento.setTipodocumentoid(resultado.getInt("documentoid"));
            tipodocumento.setDescripcion(resultado.getString("descripcion"));
            tipodocumentos.add(tipodocumento);
        }
        resultado.close();
        return tipodocumentos;    
    }
    
    //filtra tipo documento por "documentoid"
    public TipoDocumento buscar(int documentoid) throws SQLException {
        TipoDocumento tipoDocumento = null;
        ResultSet resultado;
        String sentenciaSQL;

        sentenciaSQL = "SELECT documentoid, descripcion FROM tipodocumento"
                + " where documentoid = " + documentoid + ";";

        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        if(resultado.next()){            
            tipoDocumento = new TipoDocumento();
            tipoDocumento.setTipodocumentoid(resultado.getInt("documentoid"));
            tipoDocumento.setDescripcion(resultado.getString("descripcion"));
        }
        resultado.close();
        return tipoDocumento;
    }
}
