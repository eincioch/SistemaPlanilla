/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4_persistencia.daoPostgreSQL;

import c3_dominio.entidades.CentrosDeCostos;
import c4_persistencia.GestorJDBC;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author EnriqueDavidJose
 */
public class CentrosDeCostosDAOPostgre {
    //"GestorJDBC".- contiene todos los metodos para trabajar con la base datos (conexion, ResultSet(select), PreparedStatement(insert, update, delete))
    GestorJDBC gestorJDBC;
    
    //Constructor
    public CentrosDeCostosDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }
    
    public List<CentrosDeCostos> listar() throws SQLException{
        ArrayList<CentrosDeCostos> centrosDeCostos = new ArrayList();
        CentrosDeCostos centrosDeCosto;
        ResultSet resultado;
        String sentenciaSQL = "SELECT centrocostoid, descripcion FROM centrocosto;";
        
        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        while(resultado.next()){  
            //para hacer "new Genero" necesito tener un Construtor vacio.
            centrosDeCosto = new CentrosDeCostos();
            centrosDeCosto.setCentrocostoid(resultado.getInt("centrocostoid"));
            centrosDeCosto.setDescripcion(resultado.getString("descripcion"));
            centrosDeCostos.add(centrosDeCosto);
        }
        resultado.close();
        return centrosDeCostos;    
    }
    
    public CentrosDeCostos buscar(int centrocostoid) throws SQLException {
        CentrosDeCostos centrosDeCostos = null;
        ResultSet resultado;
        String sentenciaSQL;

        sentenciaSQL = "SELECT centrocostoid, descripcion FROM centrocosto"
                             + " where centrocostoid = " + centrocostoid + ";";

        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        if(resultado.next()){            
            centrosDeCostos = new CentrosDeCostos();
            centrosDeCostos.setCentrocostoid(resultado.getInt("centrocostoid"));
            centrosDeCostos.setDescripcion(resultado.getString("descripcion"));
        }
        resultado.close();
        return centrosDeCostos;
    }
}
