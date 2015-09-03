/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c1_presentacion.util;

import c3_dominio.entidades.Banda;

/**
 *
 * @author Administrador
 */
public class Funciones {
    
    public static int codIntCombo(javax.swing.JComboBox jComboBox){
        Banda banda = (Banda) jComboBox.getSelectedItem();
        return banda.getCod();
    }
            
    public static String codStrCombo(javax.swing.JComboBox jComboBox){
        Banda banda = (Banda) jComboBox.getSelectedItem();
        return banda.getId();
    }
}
