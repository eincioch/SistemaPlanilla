package c3_dominio.entidades;

import java.util.Date;

/**
 * @author EnriqueDavidJose
 * @version 1.0
 * @created 25-ago-2015 12:50:17 p.m.
 */
public class Periodo {

	private String descripcion;
	private int flag;
	private Date periodoinicio;
	private Date periodofin;
	private int estado;

	public Periodo(){

	}

	public void finalize() throws Throwable {

	}

	public boolean periodoAbierto(){
		return false;
	}

}