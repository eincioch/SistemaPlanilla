/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c3_dominio.entidades;

/**
 *
 * @author EnriqueDavidJose
 */
public class TipoMoneda {
    
    private int tipomonedaid;
    private String descripcion;

    public TipoMoneda() {
    }

    public TipoMoneda(int tipomonedaid, String descripcion) {
        this.tipomonedaid = tipomonedaid;
        this.descripcion = descripcion;
    }

    
    public int getTipomonedaid() {
        return tipomonedaid;
    }

    public void setTipomonedaid(int tipomonedaid) {
        this.tipomonedaid = tipomonedaid;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
