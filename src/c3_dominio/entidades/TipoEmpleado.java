package c3_dominio.entidades;

/**
 * @author Enrique Incio
 * @version 1.0
 * @created 25-ago-2015 12:50:17 p.m.
 */
public class TipoEmpleado {

    private int tipoempleadoid;
    private String descripcion;

    public TipoEmpleado() {
    }

    public TipoEmpleado(int tipoempleadoid, String descripcion) {
        this.tipoempleadoid = tipoempleadoid;
        this.descripcion = descripcion;
    }
    
    public int getTipoempleadoid() {
        return tipoempleadoid;
    }

    public void setTipoempleadoid(int tipoempleadoid) {
        this.tipoempleadoid = tipoempleadoid;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    

}