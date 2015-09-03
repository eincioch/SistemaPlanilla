/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c1_presentacion.util;

import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;

/**
 *
 * @author Lain
 */
public class ValidadorDeDatosDeEntrada { 
    
    public static boolean validarCorreoE(JTextField cajaDeTexto, boolean esDatoObligatorio){
        boolean datocorrecto;
        String correoe = cajaDeTexto.getText().trim();
        if(correoe.isEmpty() || (correoe.contains("@") && correoe.contains("."))){
            if(esDatoObligatorio)
                Formateador.pintarCajaDeTextoObligatorio(cajaDeTexto);
            else
                Formateador.pintarCajaDeTextoValido(cajaDeTexto);
            datocorrecto = true;
        }
        else{
            Formateador.pintarCajaDeTextoInvalido(cajaDeTexto);
            datocorrecto = false;
        }
        return datocorrecto;
    }
    
    public static boolean validarFecha(JTextField cajaDeTexto, boolean esDatoObligatorio){
        boolean datocorrecto;
        String textofecha = cajaDeTexto.getText().trim();
        if(textofecha.isEmpty()){
            if(esDatoObligatorio)
                Formateador.pintarCajaDeTextoObligatorio(cajaDeTexto);
            else
                Formateador.pintarCajaDeTextoValido(cajaDeTexto);
            datocorrecto = true;
        }
        else{
            try{
                LocalDate.parse(textofecha); 
                if(esDatoObligatorio)
                    Formateador.pintarCajaDeTextoObligatorio(cajaDeTexto);
                else
                    Formateador.pintarCajaDeTextoValido(cajaDeTexto);
                datocorrecto = true;
            } 
            catch (Exception ex) {
                Formateador.pintarCajaDeTextoInvalido(cajaDeTexto);
                datocorrecto = false;
            }                
        }
        return datocorrecto;
    }
    
    public static void validarActivacionDeBotonDeComando(ArrayList<JComponent> listaDeDatosDeEntrada, 
                            ArrayList<String> datosObligatorios, 
                            int totalDeDatosDeEntradaInValidos, JButton boton){
        if(totalDeDatosDeEntradaInValidos > 0){
            boton.setEnabled(false);
            return;
        }            
        for(JComponent componente : listaDeDatosDeEntrada){
            if(datosObligatorios.contains(componente.getName())){   
                if(componente instanceof JTextField){
                    JTextField texto = (JTextField)componente;
                    if(texto.getText().trim().isEmpty()){
                        boton.setEnabled(false);
                        return;
                    }      
                } 
                if(componente instanceof JComboBox){
                    JComboBox combo = (JComboBox)componente;
                    if(combo.getSelectedIndex() == -1){
                        boton.setEnabled(false);
                        return;
                    }
                }
            }            
        }
        boton.setEnabled(true);
    }
    
}
