/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4_persistencia.daoPostgreSQL;

import c3_dominio.entidades.PeriodicidadPago;
import c4_persistencia.GestorJDBC;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author EnriqueDavidJose
 */
public class PeriodicidadPagoDAOPostgre {
    //"GestorJDBC".- contiene todos los metodos para trabajar con la base datos (conexion, ResultSet(select), PreparedStatement(insert, update, delete))
    GestorJDBC gestorJDBC;
    
    //Constructor
    public PeriodicidadPagoDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }
    
    public List<PeriodicidadPago> listar() throws SQLException{
        ArrayList<PeriodicidadPago> periodicidadPagos = new ArrayList();
        PeriodicidadPago periodicidadPago;
        ResultSet resultado;
        String sentenciaSQL = "SELECT periodicidadid, descripcion FROM periodicidadpago;";
        
        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        while(resultado.next()){  
            //para hacer "new Genero" necesito tener un Construtor vacio.
            periodicidadPago = new PeriodicidadPago();
            periodicidadPago.setPeriodicidadid(resultado.getInt("periodicidadid"));
            periodicidadPago.setDescripcion(resultado.getString("descripcion"));
            periodicidadPagos.add(periodicidadPago);
        }
        resultado.close();
        return periodicidadPagos;    
    }
    
    public PeriodicidadPago buscar(int periodicidadid) throws SQLException {
        PeriodicidadPago periodicidadPago = null;
        ResultSet resultado;
        String sentenciaSQL;

        sentenciaSQL = "SELECT periodicidadid, descripcion FROM periodicidadpago"
                             + " where periodicidadid = " + periodicidadid + ";";

        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        if(resultado.next()){            
            periodicidadPago = new PeriodicidadPago();
            periodicidadPago.setPeriodicidadid(resultado.getInt("periodicidadid"));
            periodicidadPago.setDescripcion(resultado.getString("descripcion"));
        }
        resultado.close();
        return periodicidadPago;
    }
}
