package c3_dominio.entidades;

import java.util.Date;

/**
 * @author EnriqueDavidJose
 * @version 1.0
 * @created 25-ago-2015 12:49:29 p.m.
 */
public class Contrato {

    private int numerocontrato;
    private Date fecharegistro;
    private Date fechainicio;
    private Date fechatermino;
    private double remuneracionbasica;
    private int horaley;
    private int estado;
    private Empleado empleado;
    private TipoMoneda tipomoneda;
    private Planilla m_Planilla;

    public Contrato() {
    }

    public Contrato(int numerocontrato, Date fecharegistro, Date fechainicio, Date fechatermino, double remuneracionbasica, int horaley, int estado, Empleado empleado, TipoMoneda tipomoneda, Planilla m_Planilla) {
        this.numerocontrato = numerocontrato;
        this.fecharegistro = fecharegistro;
        this.fechainicio = fechainicio;
        this.fechatermino = fechatermino;
        this.remuneracionbasica = remuneracionbasica;
        this.horaley = horaley;
        this.estado = estado;
        this.empleado = empleado;
        this.tipomoneda = tipomoneda;
        this.m_Planilla = m_Planilla;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getNumerocontrato() {
        return numerocontrato;
    }

    public void setNumerocontrato(int numerocontrato) {
        this.numerocontrato = numerocontrato;
    }

    public Date getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Date getFechatermino() {
        return fechatermino;
    }

    public void setFechatermino(Date fechatermino) {
        this.fechatermino = fechatermino;
    }

    public double getRemuneracionbasica() {
        return remuneracionbasica;
    }

    public void setRemuneracionbasica(double remuneracionbasica) {
        this.remuneracionbasica = remuneracionbasica;
    }

    public int getHoraley() {
        return horaley;
    }

    public void setHoraley(int horaley) {
        this.horaley = horaley;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public TipoMoneda getTipomoneda() {
        return tipomoneda;
    }

    public void setTipomoneda(TipoMoneda tipomoneda) {
        this.tipomoneda = tipomoneda;
    }

    public Planilla getM_Planilla() {
        return m_Planilla;
    }

    public void setM_Planilla(Planilla m_Planilla) {
        this.m_Planilla = m_Planilla;
    }

   public boolean estaVigente(){
       return true;
   } 
   
   public boolean periodoProcesado(){
       return true;
   }
   
   public double calcularRemuneracionBruta(){
       return 0;
   }
     
    public double calcularComision(){
       return 0;
   }
    
   public double calcularPrimaSeguro(){
       return 0;
   }
   
//   public double calcularTotalDescuento(){
//       return calcularRemuneracionBruta -(calcularComision+calcularPrimaSeguro);
//   }
   
}