package c3_dominio.entidades;

import java.util.Date;

/**
 * @author Administrador
 * @version 1.0
 * @created 25-ago-2015 12:49:29 p.m.
 */
public class AfiliacionRegimenPensionario {

    private Date fechaafiliacion;
    private String numerocuspp;
    private String tipocomision;
    public Empleado empleado;
    public RegimenPensionario regimenpensionario;

    public AfiliacionRegimenPensionario() {
    }

    public AfiliacionRegimenPensionario(Date fechaafiliacion, String numerocuspp, String tipocomision, Empleado empleado, RegimenPensionario regimenpensionario) {
        this.fechaafiliacion = fechaafiliacion;
        this.numerocuspp = numerocuspp;
        this.tipocomision = tipocomision;
        this.empleado = empleado;
        this.regimenpensionario = regimenpensionario;
    }

    public Date getFechaafiliacion() {
        return fechaafiliacion;
    }

    public void setFechaafiliacion(Date fechaafiliacion) {
        this.fechaafiliacion = fechaafiliacion;
    }

    public String getNumerocuspp() {
        return numerocuspp;
    }

    public void setNumerocuspp(String numerocuspp) {
        this.numerocuspp = numerocuspp;
    }

    public String getTipocomision() {
        return tipocomision;
    }

    public void setTipocomision(String tipocomision) {
        this.tipocomision = tipocomision;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public RegimenPensionario getRegimenpensionario() {
        return regimenpensionario;
    }

    public void setRegimenpensionario(RegimenPensionario regimenpensionario) {
        this.regimenpensionario = regimenpensionario;
    }

    public boolean estaAfiliado(){
        return true;
    }
    	
}