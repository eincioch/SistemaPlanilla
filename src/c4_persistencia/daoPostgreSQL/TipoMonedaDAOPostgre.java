/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4_persistencia.daoPostgreSQL;

import c3_dominio.entidades.TipoMoneda;
import c4_persistencia.GestorJDBC;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class TipoMonedaDAOPostgre {
    GestorJDBC gestorJDBC;
    
    //Constructor
    public TipoMonedaDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }
    
    //listar todo
    public List<TipoMoneda> listar() throws SQLException{
        ArrayList<TipoMoneda> tipoMonedas = new ArrayList();
        TipoMoneda tipoMoneda;
        ResultSet resultado;
        String sentenciaSQL = "SELECT tipomonedaid, descripcion FROM tipomoneda;";
        
        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        while(resultado.next()){  
            //para hacer "new Genero" necesito tener un Construtor vacio.
            tipoMoneda = new TipoMoneda();
            tipoMoneda.setTipomonedaid(resultado.getInt("tipomonedaid"));
            tipoMoneda.setDescripcion(resultado.getString("descripcion"));
            tipoMonedas.add(tipoMoneda);
        }
        resultado.close();
        return tipoMonedas;    
    }
    
    public TipoMoneda buscar(int tipomonedaid) throws SQLException {
        TipoMoneda tipoMoneda = null;
        ResultSet resultado;
        String sentenciaSQL;

        sentenciaSQL = "SELECT tipomonedaid, descripcion FROM tipomoneda"
                + " where tipomonedaid = " + tipomonedaid + ";";

        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        if(resultado.next()){            
            tipoMoneda = new TipoMoneda();
            tipoMoneda.setTipomonedaid(resultado.getInt("tipomonedaid"));
            tipoMoneda.setDescripcion(resultado.getString("descripcion"));
        }
        resultado.close();
        return tipoMoneda;
    }
}
