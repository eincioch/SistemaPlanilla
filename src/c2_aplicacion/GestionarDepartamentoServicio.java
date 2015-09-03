
package c2_aplicacion;

import c3_dominio.entidades.Departamento;
import c4_persistencia.GestorJDBC;
import c4_persistencia.daoPostgreSQL.DepartamentoDAOPostgre;
import c4_persistencia.daoPostgreSQL.GestorJDBCPostgre;
import java.util.List;

/**
 *
 * @author EnriqueDavidJose
 */
public class GestionarDepartamentoServicio {
    private GestorJDBC gestorJDBC;  
    private DepartamentoDAOPostgre departamentoDAO;
    
    public GestionarDepartamentoServicio() {
        gestorJDBC = new GestorJDBCPostgre(); 
        departamentoDAO = new DepartamentoDAOPostgre(gestorJDBC);
    }
    
    public List<Departamento> cargarDepartamento() throws Exception{             
        gestorJDBC.abrirConexion();        
        List<Departamento> departamentos = departamentoDAO.listar();
        gestorJDBC.cerrarConexion();
        return departamentos;
    }
    
    public Departamento buscarDepartamento(int departamentoid) throws Exception{     
        gestorJDBC.abrirConexion();        
        Departamento departamento = departamentoDAO.buscar(departamentoid);
        gestorJDBC.cerrarConexion();
        return departamento;
    }
}
