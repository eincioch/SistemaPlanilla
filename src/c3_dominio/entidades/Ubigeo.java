package c3_dominio.entidades;

/**
 * @author Enrique Incio
 * @version 1.0
 * @created 25-ago-2015 12:50:18 p.m.
 */
public class Ubigeo {
        
    private int ubigeoid;
    private String departamentoid;
    private String provinciaid;
    private String distritoid;
    private String departamento;
    private String provincia;
    private String distrito;

    public Ubigeo() {
    }

    public Ubigeo(String departamentoid, String provinciaid, String distritoid, String departamento, String provincia, String distrito) {
        this.departamentoid = departamentoid;
        this.provinciaid = provinciaid;
        this.distritoid = distritoid;
        this.departamento = departamento;
        this.provincia = provincia;
        this.distrito = distrito;
    }
    
    public int getUbigeoid() {
        return ubigeoid;
    }

    public void setUbigeoid(int ubigeoid) {
        this.ubigeoid = ubigeoid;
    }

    public String getDepartamentoid() {
        return departamentoid;
    }

    public void setDepartamentoid(String departamentoid) {
        this.departamentoid = departamentoid;
    }

    public String getProvinciaid() {
        return provinciaid;
    }

    public void setProvinciaid(String provinciaid) {
        this.provinciaid = provinciaid;
    }

    public String getDistritoid() {
        return distritoid;
    }

    public void setDistritoid(String distritoid) {
        this.distritoid = distritoid;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

}