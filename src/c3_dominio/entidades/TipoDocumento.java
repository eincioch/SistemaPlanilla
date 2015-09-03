
package c3_dominio.entidades;

/**
 * @author Administrador
 * @version 1.0
 * @created 25-ago-2015 12:50:17 p.m.
 */
public class TipoDocumento {
        
    private int tipodocumentoid;
    private String descripcion;

    public TipoDocumento() {
    }
    
    public TipoDocumento(int tipodocumentoid, String descripcion) {
        this.tipodocumentoid = tipodocumentoid;
        this.descripcion = descripcion;
    }
    
    public int getTipodocumentoid() {
        return tipodocumentoid;
    }

    public void setTipodocumentoid(int tipodocumentoid) {
        this.tipodocumentoid = tipodocumentoid;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    

}