/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4_persistencia.daoPostgreSQL;

import c3_dominio.entidades.AfiliacionRegimenPensionario;
import c4_persistencia.GestorJDBC;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Administrador
 */
public class AfiliacionRegimenPensionarioDAOPostgre {
    GestorJDBC gestorJDBC;
    
    //Constructor
    public AfiliacionRegimenPensionarioDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }
    
    public int ingresar(AfiliacionRegimenPensionario afiliacionRegimenPensionario) throws SQLException {
       
        String sentenciaSQL = "insert into afiliacionregimenpensionario(empleadoid,fechaafiliacion,numerocussp,tipocomision,regimenpensionarioid) "
                + " values(?,?,?,?,?)";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setInt(1, afiliacionRegimenPensionario.getEmpleado().getEmpleadoid());
        sentencia.setDate(2,  new java.sql.Date(afiliacionRegimenPensionario.getFechaafiliacion().getTime()));
        sentencia.setString(3, afiliacionRegimenPensionario.getNumerocuspp());
        sentencia.setString(4, afiliacionRegimenPensionario.getTipocomision());
        sentencia.setInt(5, afiliacionRegimenPensionario.getRegimenpensionario().getRegimenpensionarioid());
        return sentencia.executeUpdate();
    }
}
