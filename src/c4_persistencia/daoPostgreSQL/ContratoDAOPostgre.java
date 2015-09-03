/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4_persistencia.daoPostgreSQL;

import c3_dominio.entidades.Contrato;
import c4_persistencia.GestorJDBC;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Administrador
 */
public class ContratoDAOPostgre {
    GestorJDBC gestorJDBC;
    
    //Constructor
    public ContratoDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }
    
    public int ingresar(Contrato contrato) throws SQLException {
        String sentenciaSQL = "insert into contrato(fecharegistro, empleadoid, fechainicio, fechatermino, " +
                                "       remuneracionbasica, horaley, estado, tipomonedaid) "
                                + " values(?,?,?,?,?,?,?,?)";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setDate(1,new java.sql.Date(contrato.getFecharegistro().getTime()));
        sentencia.setInt(2, contrato.getEmpleado().getEmpleadoid());
        sentencia.setDate(3,new java.sql.Date(contrato.getFechainicio().getTime()));
        sentencia.setDate(4,new java.sql.Date(contrato.getFechatermino().getTime()));
        sentencia.setDouble(5, contrato.getRemuneracionbasica());
        sentencia.setInt(6,contrato.getHoraley());
        sentencia.setInt(7,contrato.getEstado());
        sentencia.setInt(8,contrato.getTipomoneda().getTipomonedaid());
        
        return sentencia.executeUpdate();
    }
}
