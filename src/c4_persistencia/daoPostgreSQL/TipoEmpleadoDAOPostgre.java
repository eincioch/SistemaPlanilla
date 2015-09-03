/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4_persistencia.daoPostgreSQL;

import c3_dominio.entidades.TipoEmpleado;
import c4_persistencia.GestorJDBC;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author EnriqueDavidJose
 */
public class TipoEmpleadoDAOPostgre {
    //"GestorJDBC".- contiene todos los metodos para trabajar con la base datos (conexion, ResultSet(select), PreparedStatement(insert, update, delete))
    GestorJDBC gestorJDBC;
    
    //Constructor
    public TipoEmpleadoDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }
    
    public List<TipoEmpleado> listar() throws SQLException{
        ArrayList<TipoEmpleado> tipoEmpleados = new ArrayList();
        TipoEmpleado tipoEmpleado;
        ResultSet resultado;
        String sentenciaSQL = "SELECT tipoempleadoid, descripcion FROM tipoempleado;";
        
        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        while(resultado.next()){  
            //para hacer "new Genero" necesito tener un Construtor vacio.
            tipoEmpleado = new TipoEmpleado();
            tipoEmpleado.setTipoempleadoid(resultado.getInt("tipoempleadoid"));
            tipoEmpleado.setDescripcion(resultado.getString("descripcion"));
            tipoEmpleados.add(tipoEmpleado);
        }
        resultado.close();
        return tipoEmpleados;    
    }
    
    public TipoEmpleado buscar(int tipoempleadoid) throws SQLException {
        TipoEmpleado tipoEmpleado = null;
        ResultSet resultado;
        String sentenciaSQL;

        sentenciaSQL = "SELECT tipoempleadoid, descripcion FROM tipoempleado"
                + " where tipoempleadoid = " + tipoempleadoid + ";";

        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        if(resultado.next()){            
            tipoEmpleado = new TipoEmpleado();
            tipoEmpleado.setTipoempleadoid(resultado.getInt("tipoempleadoid"));
            tipoEmpleado.setDescripcion(resultado.getString("descripcion"));
        }
        resultado.close();
        return tipoEmpleado;
    }
}
