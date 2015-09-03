
package c2_aplicacion;

import c3_dominio.entidades.Cargo;
import c4_persistencia.GestorJDBC;
import c4_persistencia.daoPostgreSQL.CargoDAOPostgre;
import c4_persistencia.daoPostgreSQL.GestorJDBCPostgre;
import java.util.List;

/**
 *
 * @author EnriqueDavidJose
 */
public class GestionarCargoServicio {
    private GestorJDBC gestorJDBC;  
    private CargoDAOPostgre cargoDAO;
    
    public GestionarCargoServicio() {
        gestorJDBC = new GestorJDBCPostgre(); 
        cargoDAO = new CargoDAOPostgre(gestorJDBC);
    }
    
    public List<Cargo> cargarCargo() throws Exception{             
        gestorJDBC.abrirConexion();        
        List<Cargo> cargos = cargoDAO.listar();
        gestorJDBC.cerrarConexion();
        return cargos;
    }
    
    public Cargo buscarCargo(int cargoid) throws Exception{     
        gestorJDBC.abrirConexion();        
        Cargo cargo = cargoDAO.buscar(cargoid);
        gestorJDBC.cerrarConexion();
        return cargo;
    }
}
