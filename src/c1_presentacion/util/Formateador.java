/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c1_presentacion.util;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.JLabel;

/**
 *
 * @author Lain
 */
public class Formateador {
    
    public static final Color COLOR_ENTRADA_VALIDO = new Color(255,255,255);
    public static final Color COLOR_ENTRADA_OBLIGATORIO = new Color(230,255,255);
    public static final Color COLOR_ENTRADA_INVALIDO = new Color(250,220,220);
    public static final Color COLOR_ENTRADA_UNICO = new Color(255,100,0);
    
    public static void pintarComponentesDeEntradaObligatoria(ArrayList<JComponent> listaDeDatosDeEntrada, ArrayList<String> datosObligatorios){
        for(JComponent componente : listaDeDatosDeEntrada){
            if(datosObligatorios.contains(componente.getName()))
                componente.setBackground(COLOR_ENTRADA_OBLIGATORIO);
        }
    }
    
    public static void pintarEtiquetasDeValorUnico(ArrayList<JLabel> listaDeEtiquetas, ArrayList<String> datosUnicos){
        for(JLabel etiquetas : listaDeEtiquetas){
            if(datosUnicos.contains(etiquetas.getName()))
                etiquetas.setForeground(COLOR_ENTRADA_UNICO);
        }
    }   
    
    public static void pintarCajaDeTextoValido(JTextField cajaDeTexto){
        cajaDeTexto.setBackground(COLOR_ENTRADA_VALIDO);
    }
    
    public static void pintarCajaDeTextoInvalido(JTextField cajaDeTexto){
        cajaDeTexto.setBackground(COLOR_ENTRADA_INVALIDO);
    }
    
    public static void pintarCajaDeTextoObligatorio(JTextField cajaDeTexto){
        cajaDeTexto.setBackground(COLOR_ENTRADA_OBLIGATORIO);
    }
}
