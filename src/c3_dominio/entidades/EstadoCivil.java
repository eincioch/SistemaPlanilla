
package c3_dominio.entidades;

/**
 * @author Administrador
 * @version 1.0
 * @created 25-ago-2015 12:50:17 p.m.
 */
public class EstadoCivil {
    
    private int estadocivilid;
    private String descripcion;

    public EstadoCivil() {
    }
    
    public EstadoCivil(int estadocivilid, String descripcion) {
        this.estadocivilid = estadocivilid;
        this.descripcion = descripcion;
    }
        
    public int getEstadocivilid() {
        return estadocivilid;
    }

    public void setEstadocivilid(int estadocivilid) {
        this.estadocivilid = estadocivilid;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
