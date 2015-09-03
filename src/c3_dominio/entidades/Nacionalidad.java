
package c3_dominio.entidades;

/**
 * @author Enrique Incio
 * @version 1.0
 * @created 25-ago-2015 12:50:17 p.m.
 */
public class Nacionalidad {

    private int nacionalidadid;
    private String nacionalidad;

    public Nacionalidad() {
    }

    public Nacionalidad(int nacionalidadid, String nacionalidad) {
        this.nacionalidadid = nacionalidadid;
        this.nacionalidad = nacionalidad;
    }
    
    public int getNacionalidadid() {
        return nacionalidadid;
    }

    public void setNacionalidadid(int nacionalidadid) {
        this.nacionalidadid = nacionalidadid;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

}