/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4_persistencia.daoPostgreSQL;

import c3_dominio.entidades.EstadoCivil;
import c4_persistencia.GestorJDBC;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class EstadoCivilDAOPostgre {
    //"GestorJDBC".- contiene todos los metodos para trabajar con la base datos (conexion, ResultSet(select), PreparedStatement(insert, update, delete))
    GestorJDBC gestorJDBC;
    
    //Constructor
    public EstadoCivilDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }
    
    public List<EstadoCivil> listar() throws SQLException{
        ArrayList<EstadoCivil> estadoCiviles = new ArrayList();
        EstadoCivil estadoCivil;
        ResultSet resultado;
        String sentenciaSQL = "select estadocivilid, descripcion" +
                                " from estadocivil;" ;
        
        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        while(resultado.next()){  
            //para hacer "new Genero" necesito tener un Construtor vacio.
            estadoCivil = new EstadoCivil();
            estadoCivil.setEstadocivilid(resultado.getInt("estadocivilid"));
            estadoCivil.setDescripcion(resultado.getString("descripcion"));
            estadoCiviles.add(estadoCivil);
        }
        resultado.close();
        return estadoCiviles;    
    }
    
    public EstadoCivil buscar(int estadocivilid) throws SQLException {
        EstadoCivil estadoCivil = null;
        ResultSet resultado;
        String sentenciaSQL;
        //para concatenar campos en PostgreSQL se utiliza "||" or dejando espacios " || ' ' || "
        sentenciaSQL = "select estadocivilid, descripcion"
                        + " FROM estadocivil"
                        + " where estadocivilid = " + estadocivilid + ";";

        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        if(resultado.next()){            
            estadoCivil = new EstadoCivil();
            estadoCivil.setEstadocivilid(resultado.getInt("estadocivilid"));
            estadoCivil.setDescripcion(resultado.getString("descripcion"));
        }
        resultado.close();
        return estadoCivil;
    }
}
