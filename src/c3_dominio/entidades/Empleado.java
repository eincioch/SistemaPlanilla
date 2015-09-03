package c3_dominio.entidades;


/**
 * @author EnriqueDavidJose
 * @version 1.0
 * @created 25-ago-2015 12:49:29 p.m.
 */
public class Empleado {
    
    private int empleadoid;
    private String fecharegistro;
    private String apellidopaterno;
    private String apellidomaterno;
    private String nombre;
    private String fechanacimiento;
    private Genero genero;
    private String numerodocumento;
    private String direccion;
    private EstadoCivil estadocivil;
    private String telefono;
    private String celular;
    private String email;
    private String asignacionfamiliar;
    private String essalud;
    private int estado;
    private TipoDocumento tipodocumento;
    private Nacionalidad nacionalidad;
    private Ubigeo ubigeo;
    private NivelEducacion niveleducativo;
    private TipoEmpleado tipoempleado;
    private CentrosDeCostos centrocosto;
    private Departamento departamento;
    private Cargo cargo;
    private PeriodicidadPago periodicidadpago;
    
    public String getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(String fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public String getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(String fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public EstadoCivil getEstadocivil() {
        return estadocivil;
    }

    public void setEstadocivil(EstadoCivil estadocivil) {
        this.estadocivil = estadocivil;
    }

        
    public int getEmpleadoid() {
        return empleadoid;
    }

    public void setEmpleadoid(int empleadoid) {
        this.empleadoid = empleadoid;
    }

    public String getApellidopaterno() {
        return apellidopaterno;
    }

    public void setApellidopaterno(String apellidopaterno) {
        this.apellidopaterno = apellidopaterno;
    }

    public String getApellidomaterno() {
        return apellidomaterno;
    }

    public void setApellidomaterno(String apellidomaterno) {
        this.apellidomaterno = apellidomaterno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumerodocumento() {
        return numerodocumento;
    }

    public void setNumerodocumento(String numerodocumento) {
        this.numerodocumento = numerodocumento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAsignacionfamiliar() {
        return asignacionfamiliar;
    }

    public void setAsignacionfamiliar(String asignacionfamiliar) {
        this.asignacionfamiliar = asignacionfamiliar;
    }

    public String getEssalud() {
        return essalud;
    }

    public void setEssalud(String essalud) {
        this.essalud = essalud;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public TipoDocumento getTipodocumento() {
        return tipodocumento;
    }

    public void setTipodocumento(TipoDocumento tipodocumento) {
        this.tipodocumento = tipodocumento;
    }

    public Nacionalidad getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(Nacionalidad nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Ubigeo getUbigeo() {
        return ubigeo;
    }

    public void setUbigeo(Ubigeo ubigeo) {
        this.ubigeo = ubigeo;
    }

    public NivelEducacion getNiveleducativo() {
        return niveleducativo;
    }

    public void setNiveleducativo(NivelEducacion niveleducativo) {
        this.niveleducativo = niveleducativo;
    }

    public TipoEmpleado getTipoempleado() {
        return tipoempleado;
    }

    public void setTipoempleado(TipoEmpleado tipoempleado) {
        this.tipoempleado = tipoempleado;
    }

    public CentrosDeCostos getCentrocosto() {
        return centrocosto;
    }

    public void setCentrocosto(CentrosDeCostos centrocosto) {
        this.centrocosto = centrocosto;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public PeriodicidadPago getPeriodicidadpago() {
        return periodicidadpago;
    }

    public void setPeriodicidadpago(PeriodicidadPago periodicidadpago) {
        this.periodicidadpago = periodicidadpago;
    }
 
    public boolean estaActivo(){        
        return estado==1;
    }

    public boolean tieneAsignacionFamiliar(){
        return asignacionfamiliar=="Si";
     }
    


}