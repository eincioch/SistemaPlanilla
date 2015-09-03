
package c2_aplicacion;

import c3_dominio.entidades.TipoDocumento;
import c4_persistencia.GestorJDBC;
import c4_persistencia.daoPostgreSQL.GestorJDBCPostgre;
import c4_persistencia.daoPostgreSQL.TipoDocumentoDAOPostgre;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class GestionarTipoDocumentoServicio {
    private GestorJDBC gestorJDBC;  
    private TipoDocumentoDAOPostgre tipoDocumentoDAO;
    
    //Constructor
    public GestionarTipoDocumentoServicio() {
        gestorJDBC = new GestorJDBCPostgre(); 
        tipoDocumentoDAO = new TipoDocumentoDAOPostgre(gestorJDBC);
    }
    
    //Metodos
    public List<TipoDocumento> cargarTipoDocumento() throws Exception{             
        gestorJDBC.abrirConexion();        
        List<TipoDocumento> tipoDocumentos = tipoDocumentoDAO.listar();
        gestorJDBC.cerrarConexion();
        return tipoDocumentos;
    }
    
    public TipoDocumento buscarTipoDocumento(int documentoid) throws Exception{     
        gestorJDBC.abrirConexion();        
        TipoDocumento tipoDocumento = tipoDocumentoDAO.buscar(documentoid);
        gestorJDBC.cerrarConexion();
        return tipoDocumento;
    }
}
