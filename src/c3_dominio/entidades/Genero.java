
package c3_dominio.entidades;

/**
 * @author EnriqueDavidJose
 * @version 1.0
 * @created 26-ago-2015 02:20:29 a.m.
 */

public class Genero {
    
    private int generoid;
    private String genero;
    
    //necesito este constructor para cuando haga un "new Genero" *
    public Genero() {
    }

    public Genero(int generoid, String genero) {
        this.generoid = generoid;
        this.genero = genero;
    }

    public int getGeneroid() {
        return generoid;
    }

    public void setGeneroid(int generoid) {
        this.generoid = generoid;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    
}
