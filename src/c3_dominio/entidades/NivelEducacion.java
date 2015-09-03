
package c3_dominio.entidades;

/**
 * @author Enrique Incio
 * @version 1.0
 * @created 25-ago-2015 12:50:17 p.m.
 */
public class NivelEducacion {

    private int niveleducacionid;
    private String Descripcion;

    public NivelEducacion() {
    }

    public NivelEducacion(int niveleducacionid, String Descripcion) {
        this.niveleducacionid = niveleducacionid;
        this.Descripcion = Descripcion;
    }

    public int getNiveleducacionid() {
        return niveleducacionid;
    }

    public void setNiveleducacionid(int niveleducacionid) {
        this.niveleducacionid = niveleducacionid;
    }
    
    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

}