
package c3_dominio.entidades;

/**
 * @author Enrique Incio
 * @version 1.0
 * @created 25-ago-2015 12:49:29 p.m.
 */
public class Departamento {
    
    private int departamentoid;
    private String descripcion;

    public Departamento() {
    }

    public Departamento(int departamentoid, String descripcion) {
        this.departamentoid = departamentoid;
        this.descripcion = descripcion;
    }

    public int getDepartamentoid() {
        return departamentoid;
    }

    public void setDepartamentoid(int departamentoid) {
        this.departamentoid = departamentoid;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    

}