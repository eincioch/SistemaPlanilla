/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4_persistencia.daoPostgreSQL;

import c3_dominio.entidades.RegimenPensionario;
import c4_persistencia.GestorJDBC;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author EnriqueDavidJose
 */
public class RegimenPensionarioDAOPostgre {
    GestorJDBC gestorJDBC;
    
    //Constructor
    public RegimenPensionarioDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }
    
    public List<RegimenPensionario> listar() throws SQLException{
        ArrayList<RegimenPensionario> regimenPensionarios = new ArrayList();
        RegimenPensionario regimenPensionario;
        ResultSet resultado;
        String sentenciaSQL = "SELECT regimenpensionarioid, descripcion FROM regimenpensionario;";
        
        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        while(resultado.next()){  
            //para hacer "new Genero" necesito tener un Construtor vacio.
            regimenPensionario = new RegimenPensionario();
            regimenPensionario.setRegimenpensionarioid(resultado.getInt("regimenpensionarioid"));
            regimenPensionario.setDescripcion(resultado.getString("descripcion"));
            regimenPensionarios.add(regimenPensionario);
        }
        resultado.close();
        return regimenPensionarios;    
    }
    
    public List<RegimenPensionario> buscar(String nombre) throws SQLException{
        ArrayList<RegimenPensionario> regimenPensionarios = new ArrayList();
        RegimenPensionario regimenPensionario;
        ResultSet resultado;
        String sentenciaSQL;

        sentenciaSQL = "select regimenpensionarioid, descripcion"
                + " from regimenpensionario where descripcion ilike '%" + nombre + "%' order by regimenpensionarioid";

        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        while(resultado.next()){            
            regimenPensionario = new RegimenPensionario();
            regimenPensionario.setRegimenpensionarioid(resultado.getInt("regimenpensionarioid"));
            regimenPensionario.setDescripcion(resultado.getString("descripcion"));
            regimenPensionarios.add(regimenPensionario);
        }
        resultado.close();
        return regimenPensionarios;    
    }
    
    public int ingresar(RegimenPensionario regimenPensionario) throws SQLException {
        String sentenciaSQL = "insert into regimenpensionario(descripcion) "
                + " values(?)";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setString(1, regimenPensionario.getDescripcion());
//        sentencia.setString(2, lector.getDni();
//        sentencia.setString(3, lector.getDireccion());
//        sentencia.setString(4, lector.getCorreoe());
        return sentencia.executeUpdate();
    }
        
    public int modificar(RegimenPensionario regimenPensionario) throws SQLException {
        String sentenciaSQL = "update regimenpensionario set descripcion = ?"
                + "where regimenpensionarioid = ?";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);

        sentencia.setString(1, regimenPensionario.getDescripcion());
        sentencia.setInt(2, regimenPensionario.getRegimenpensionarioid());

        return sentencia.executeUpdate();
    }
        
    public RegimenPensionario buscar(int regimenpensionarioid) throws SQLException {
        RegimenPensionario regimenPensionario = null;
        ResultSet resultado;
        String sentenciaSQL;

        sentenciaSQL = "select regimenpensionarioid, descripcion"
                + " from regimenpensionario where regimenpensionarioid = " + regimenpensionarioid + "; ";

        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        if(resultado.next()){            
            regimenPensionario = new RegimenPensionario();
            regimenPensionario.setRegimenpensionarioid(resultado.getInt("regimenpensionarioid"));
            regimenPensionario.setDescripcion(resultado.getString("descripcion"));
        }
        resultado.close();
        return regimenPensionario;  
    }
        
}
