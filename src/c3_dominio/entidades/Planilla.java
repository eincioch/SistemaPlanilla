package c3_dominio.entidades;

import java.util.Date;

/**
 * @author Administrador
 * @version 1.0
 * @created 25-ago-2015 12:50:17 p.m.
 */
public class Planilla {

	private Date fechaproceso;
	private Date fechapago;
	private int estado;
	private double sueldobasico;
	private double asignacionfamiliar;
	private double totalremuneracionbruta;
	private double snponp;
	private double comision;
	private double primaseguro;
	private double aporte;
	private double totalafp;
	private double remuneracionneta;
	private double aporteessalud;
	private double sctr;
	private double totalaporte;
	public PeriodicidadPago periodicidadpago;
	public Periodo periodo;
	public Contrato contrato;
	public Empleado persona;

	public Planilla(){

	}

	public void finalize() throws Throwable {

	}

	public boolean periodoProcesado(){
		return false;
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

	public double calcularTotalDescuentos(){
		return 0;
	}

	public double calcularAporte(){
		return 0;
	}

	public double CalcularRemuneracionNeta(){
		return 0;
	}

	public double calcularEsSalud(){
		return 0;
	}

	public double calcularSCTR(){
		return 0;
	}

	public double calcularTotalAportes(){
		return 0;
	}

}