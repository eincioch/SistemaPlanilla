/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c2_aplicacion;

import c3_dominio.entidades.AfiliacionRegimenPensionario;
import c4_persistencia.GestorJDBC;
import c4_persistencia.daoPostgreSQL.AfiliacionRegimenPensionarioDAOPostgre;
import c4_persistencia.daoPostgreSQL.GestorJDBCPostgre;

/**
 *
 * @author Administrador
 */
public class GestionarAfiliacionRegimenPensionarioServicio {
    private GestorJDBC gestorJDBC;  
    private AfiliacionRegimenPensionarioDAOPostgre afiliacionRegimenPensionarioDAO;
    
    public GestionarAfiliacionRegimenPensionarioServicio() {
        gestorJDBC = new GestorJDBCPostgre(); 
        afiliacionRegimenPensionarioDAO = new AfiliacionRegimenPensionarioDAOPostgre(gestorJDBC);
    }
    
    public int crearAfiliacionRegimenPensionario(AfiliacionRegimenPensionario afiliacionRegimenPensionario) throws Exception{
       gestorJDBC.abrirConexion();
       int registros_afectados = afiliacionRegimenPensionarioDAO.ingresar(afiliacionRegimenPensionario);
       gestorJDBC.cerrarConexion();
       return registros_afectados;
    }
}
