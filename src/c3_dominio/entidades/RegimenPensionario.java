package c3_dominio.entidades;

import java.util.ArrayList;

/**
 * @author EnriqueDavidJose
 * @version 1.0
 * @created 25-ago-2015 12:50:17 p.m.
 */
public class RegimenPensionario {

    private int regimenpensionarioid;
    private String descripcion;

    public int getRegimenpensionarioid() {
        return regimenpensionarioid;
    }

    public void setRegimenpensionarioid(int regimenpensionarioid) {
        this.regimenpensionarioid = regimenpensionarioid;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public static ArrayList datosObligatorios(){
        ArrayList datosObligatorios = new ArrayList();
        datosObligatorios.add("descripcion");
        return datosObligatorios;
    }
    
    public static ArrayList<String> datosUnicos(){
        ArrayList datosUnicos = new ArrayList();
        datosUnicos.add("descripcion");
        return datosUnicos;
    }

}