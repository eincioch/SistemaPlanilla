
package c3_dominio.entidades;

/**
 *
 * @author Enrique Incio
 */

public class Banda {
    private String nombre; //1
    private String id;
    private int cod;
 
    public Banda(String nombre, String id){ //2
        this.nombre=nombre;
        this.id=id;
    }

    public Banda(String nombre, int cod) {
        this.nombre = nombre;
        this.cod = cod;
    }

    public int getCod() {
        return cod;
    }
    
    public String getId(){ //3
        return id;
    }
      
 
    @Override
    public String toString(){ //4
        return nombre;
    }
}
