
package c3_dominio.entidades;

/**
 * @author Enrique Incio
 * @version 1.0
 * @created 25-ago-2015 12:49:29 p.m.
 */
public class Cargo {

    private int cargoid;
    private String descripcion;

    public int getCargoid() {
        return cargoid;
    }

    public void setCargoid(int cargoid) {
        this.cargoid = cargoid;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


}