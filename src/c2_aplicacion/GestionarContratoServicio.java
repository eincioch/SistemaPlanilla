/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c2_aplicacion;

import c3_dominio.entidades.Contrato;
import c4_persistencia.GestorJDBC;
import c4_persistencia.daoPostgreSQL.ContratoDAOPostgre;
import c4_persistencia.daoPostgreSQL.GestorJDBCPostgre;

/**
 *
 * @author Administrador
 */
public class GestionarContratoServicio {
    private GestorJDBC gestorJDBC;  
    private ContratoDAOPostgre contratoDAO;
    
    public GestionarContratoServicio() {
        gestorJDBC = new GestorJDBCPostgre(); 
        contratoDAO = new ContratoDAOPostgre(gestorJDBC);
    }
    
    public int crearContrato(Contrato contrato) throws Exception{
       gestorJDBC.abrirConexion();
       int registros_afectados = contratoDAO.ingresar(contrato);
       gestorJDBC.cerrarConexion();
       return registros_afectados;
    }
}
