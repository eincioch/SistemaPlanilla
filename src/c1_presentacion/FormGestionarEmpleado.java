/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c1_presentacion;

import c1_presentacion.util.Funciones;
import c1_presentacion.util.Mensaje;
import c2_aplicacion.GestionarCargoServicio;
import c2_aplicacion.GestionarCentrosDeCostosServicio;
import c2_aplicacion.GestionarDepartamentoServicio;
import c2_aplicacion.GestionarEmpleadoServicio;
import c2_aplicacion.GestionarEstadoCivilServicio;
import c2_aplicacion.GestionarGeneroServicio;
import c2_aplicacion.GestionarNacionalidadServicio;
import c2_aplicacion.GestionarNivelEducacionServicio;
import c2_aplicacion.GestionarPeriodicidadPagoServicio;
import c2_aplicacion.GestionarTipoDocumentoServicio;
import c2_aplicacion.GestionarTipoEmpleadoServicio;
import c2_aplicacion.GestionarUbigeoServicio;
import c3_dominio.entidades.Banda;
import c3_dominio.entidades.Cargo;
import c3_dominio.entidades.CentrosDeCostos;
import c3_dominio.entidades.Departamento;
import c3_dominio.entidades.Empleado;
import c3_dominio.entidades.EstadoCivil;
import c3_dominio.entidades.Genero;
import c3_dominio.entidades.Nacionalidad;
import c3_dominio.entidades.NivelEducacion;
import c3_dominio.entidades.PeriodicidadPago;
import c3_dominio.entidades.TipoDocumento;
import c3_dominio.entidades.TipoEmpleado;
import c3_dominio.entidades.Ubigeo;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Enrique Incio
 */
public class FormGestionarEmpleado extends javax.swing.JDialog {

    private Empleado empleado;
    private TipoDocumento tipoDocumento;
    private Ubigeo ubigeov;
    private EstadoCivil estadoCivil;
    private TipoEmpleado tipoempleado;
    private Departamento departamento;
    private Cargo cargo;
    private CentrosDeCostos centrosDeCosto;
    private NivelEducacion nivelEducacion;
    private PeriodicidadPago periodicidadPago;
    private Nacionalidad nacionalidad;
    private Genero genero;
            
    private List<Genero> generos;
    private List<Nacionalidad> nacionalidades;
    private List<TipoDocumento> tipodocumentos;
    private List<Ubigeo> ubigeoDepartamentos;
    private List<Ubigeo> ubigeoProvincias;
    private List<Ubigeo> ubigeoDistritos;
    private List<NivelEducacion> nivelEducaciones;
    private List<TipoEmpleado> tipoEmpleados;
    private List<Departamento> departamentos;
    private List<Cargo> cargos;
    private List<CentrosDeCostos> centrosDeCostos;
    private List<PeriodicidadPago> periodicidadPagos;
    private List<EstadoCivil> estadoCiviles;
            
    public FormGestionarEmpleado(java.awt.Frame parent, boolean modal)  {
        super(parent, modal);
        initComponents();
        llenaComboGenero(this.jCboGenero);
        llenaComboNacionalidad(this.jCboNacionalidad);
        llenaComboTipoDocumento(this.jCboTipoDocu);
        llenaComboEstadoCivil(this.jCboEstadoCivil);
        llenaComboUbigeoDepartamento(this.jCboDepartamento);
        jCboDepartamento.setSelectedIndex(0);
        llenaComboNivelEducacion(this.jCboNivelEducativo);
        llenaComboTipoEmpleado(this.jCboTipoEmpleado);
        llenaComboDepartamento(this.jCboDepartamento2);
        llenaComboCargo(this.jCboCargo);
        llenaComboCentrosDeCostos(this.jCboCentroCosto);
        llenaComboPeriodicidadPago(this.jCboPeriodicidadPago);
        
        //Instanciomos Empleado.
        this.empleado = new Empleado();
    }
    
    private void inicializarEmpleado(){
        this.jTxtApePat.setText("");
        this.jTxtApeMat.setText("");
        this.jTxtNombre.setText("");
        this.jCboTipoDocu.setSelectedIndex(0);
    }
    
    private void llenaComboEstadoCivil(javax.swing.JComboBox jComboBox) {
        
        DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
        jComboBox.removeAllItems();

        GestionarEstadoCivilServicio gestionarEstadoCivilServicio = new GestionarEstadoCivilServicio();
        try {
            estadoCiviles = gestionarEstadoCivilServicio.cargarEstadoCivil();
        
            modeloCombo.addElement("Seleccione Estado Civil");
            for(EstadoCivil estadoCivil : estadoCiviles){
                modeloCombo.addElement(new Banda(estadoCivil.getDescripcion(),estadoCivil.getEstadocivilid()));
            }
            jComboBox.setModel(modeloCombo);
            
        } catch (Exception e) {
            Mensaje.mostrarErrorDeConsulta(this);
        }
    }
    
    private void llenaComboGenero(javax.swing.JComboBox jComboBox) {
        
        DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
        jComboBox.removeAllItems();

        GestionarGeneroServicio gestionarGeneroServicio = new GestionarGeneroServicio();
        try {
            generos = gestionarGeneroServicio.cargarGenero();
        
            modeloCombo.addElement(Mensaje.cboMsgGenero);
            for(Genero genero : generos){
                //modeloCombo.addElement(genero.getGenero());
                modeloCombo.addElement(new Banda(genero.getGenero(),genero.getGeneroid()));
            }
            jComboBox.setModel(modeloCombo);
            
        } catch (Exception e) {
            Mensaje.mostrarErrorDeConsulta(this);
        }
    }
    
    private void llenaComboNacionalidad(javax.swing.JComboBox jComboBox) {      
        DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
        jComboBox.removeAllItems();

        GestionarNacionalidadServicio gestionarNacionalidadServicio = new GestionarNacionalidadServicio();
        try {
            nacionalidades = gestionarNacionalidadServicio.cargarNacionalidad();
        
            modeloCombo.addElement(Mensaje.cboMsgNacionalidad);
            for(Nacionalidad nacionalidad : nacionalidades){
                //modeloCombo.addElement(nacionalidad.getNacionalidad());
                modeloCombo.addElement(new Banda(nacionalidad.getNacionalidad(),nacionalidad.getNacionalidadid()));
            }
            jComboBox.setModel(modeloCombo);
            
        } catch (Exception e) {
            Mensaje.mostrarErrorDeConsulta(this);
        }
    }
    
    private void llenaComboUbigeoDepartamento(javax.swing.JComboBox jComboBox) {      
        DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
        jComboBox.removeAllItems();

        GestionarUbigeoServicio gestionarUbigeoServicio = new GestionarUbigeoServicio();
        try {
            ubigeoDepartamentos = gestionarUbigeoServicio.cargarDepartamento();
        
//            modeloCombo.addElement(Mensaje.cboMsgNacionalidad);
            for(Ubigeo ubigeo : ubigeoDepartamentos){
                //modeloCombo.addElement(ubigeo.getDepartamento());
                modeloCombo.addElement(new Banda(ubigeo.getDepartamento(),ubigeo.getDepartamentoid()));
            }
            jComboBox.setModel(modeloCombo);
            
        } catch (Exception e) {
            Mensaje.mostrarErrorDeConsulta(this);
        }
    }
    
    private void llenaComboUbigeoProvincia(javax.swing.JComboBox jComboBox, String departamentoId) {      
        DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
        jComboBox.removeAllItems();

        GestionarUbigeoServicio gestionarUbigeoServicio = new GestionarUbigeoServicio();
        try {
            ubigeoProvincias = gestionarUbigeoServicio.cargarProvincia(departamentoId);
        
            for(Ubigeo ubigeo : ubigeoProvincias){
                //modeloCombo.addElement(ubigeo.getDepartamento());
                modeloCombo.addElement(new Banda(ubigeo.getProvincia(),ubigeo.getProvinciaid()));
            }
            jComboBox.setModel(modeloCombo);
            
        } catch (Exception e) {
            Mensaje.mostrarErrorDeConsulta(this);
        }
    }
    
    private void llenaComboUbigeoDistrito(javax.swing.JComboBox jComboBox, String departamentoId, String provinciaId) {      
        DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
        jComboBox.removeAllItems();

        GestionarUbigeoServicio gestionarUbigeoServicio = new GestionarUbigeoServicio();
        try {
            ubigeoDistritos = gestionarUbigeoServicio.cargarDistrito(departamentoId, provinciaId);
        
            for(Ubigeo ubigeo : ubigeoDistritos){
                //modeloCombo.addElement(ubigeo.getDepartamento());
                modeloCombo.addElement(new Banda(ubigeo.getDistrito(),ubigeo.getDistritoid()));
            }
            jComboBox.setModel(modeloCombo);
            
        } catch (Exception e) {
            Mensaje.mostrarErrorDeConsulta(this);
        }
    }
    
    private void llenaComboTipoDocumento(javax.swing.JComboBox jComboBox) {      
        DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
        jComboBox.removeAllItems();

        GestionarTipoDocumentoServicio gestionarTipoDocumentoServicio = new GestionarTipoDocumentoServicio();
        try {
            tipodocumentos = gestionarTipoDocumentoServicio.cargarTipoDocumento();
        
            modeloCombo.addElement(Mensaje.cboMsgTipoDocumento);
            for(TipoDocumento tipodocumento : tipodocumentos){
                //modeloCombo.addElement(tipodocumento.getDescripcion());
                modeloCombo.addElement(new Banda(tipodocumento.getDescripcion(),tipodocumento.getTipodocumentoid()));
            }
            jComboBox.setModel(modeloCombo);
            
        } catch (Exception e) {
            Mensaje.mostrarErrorDeConsulta(this);
        }
    }
    
    private void llenaComboNivelEducacion(javax.swing.JComboBox jComboBox) {
        
        DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
        jComboBox.removeAllItems();

        GestionarNivelEducacionServicio gestionarNivelEducacionServicio = new GestionarNivelEducacionServicio();
        try {
            nivelEducaciones = gestionarNivelEducacionServicio.cargarNivelEducacion();
        
            modeloCombo.addElement("Seleccione Nivel Educacion");
            for(NivelEducacion nivelEducacion : nivelEducaciones){
               modeloCombo.addElement(new Banda(nivelEducacion.getDescripcion(),nivelEducacion.getNiveleducacionid())); 
            }
            jComboBox.setModel(modeloCombo);
            
        } catch (Exception e) {
            Mensaje.mostrarErrorDeConsulta(this);
        }
    }
    
    private void llenaComboTipoEmpleado(javax.swing.JComboBox jComboBox) {
        
        DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
        jComboBox.removeAllItems();

        GestionarTipoEmpleadoServicio gestionarTipoEmpleadoServicio = new GestionarTipoEmpleadoServicio();
        try {
            tipoEmpleados= gestionarTipoEmpleadoServicio.cargarTipoEmpleado();
        
            modeloCombo.addElement("Seleccione Tipo Empleado");
            for(TipoEmpleado tipoEmpleado : tipoEmpleados){
               modeloCombo.addElement(new Banda(tipoEmpleado.getDescripcion(),tipoEmpleado.getTipoempleadoid())); 
            }
            jComboBox.setModel(modeloCombo);
            
        } catch (Exception e) {
            Mensaje.mostrarErrorDeConsulta(this);
        }
    }
    
    private void llenaComboDepartamento(javax.swing.JComboBox jComboBox) {
        
        DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
        jComboBox.removeAllItems();

        GestionarDepartamentoServicio gestionarDepartamentoServicio = new GestionarDepartamentoServicio();
        try {
            departamentos= gestionarDepartamentoServicio.cargarDepartamento();
        
            modeloCombo.addElement("Seleccione Departamento");
            for(Departamento departamento : departamentos){
               modeloCombo.addElement(new Banda(departamento.getDescripcion(),departamento.getDepartamentoid())); 
            }
            jComboBox.setModel(modeloCombo);
            
        } catch (Exception e) {
            Mensaje.mostrarErrorDeConsulta(this);
        }
    }
    
    private void llenaComboCargo(javax.swing.JComboBox jComboBox) {
        
        DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
        jComboBox.removeAllItems();

        GestionarCargoServicio gestionarCargoServicio = new GestionarCargoServicio();
        try {
            cargos= gestionarCargoServicio.cargarCargo();
        
            modeloCombo.addElement("Seleccione Cargo");
            for(Cargo cargo : cargos){
               modeloCombo.addElement(new Banda(cargo.getDescripcion(),cargo.getCargoid())); 
            }
            jComboBox.setModel(modeloCombo);
            
        } catch (Exception e) {
            Mensaje.mostrarErrorDeConsulta(this);
        }
    }
    
    private void llenaComboCentrosDeCostos(javax.swing.JComboBox jComboBox) {
        
        DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
        jComboBox.removeAllItems();

        GestionarCentrosDeCostosServicio gestionarCentrosDeCostosServicio = new GestionarCentrosDeCostosServicio();
        try {
            centrosDeCostos= gestionarCentrosDeCostosServicio.cargarCentrosDeCostos();
        
            modeloCombo.addElement("Seleccione Centro de Costo");
            for(CentrosDeCostos centrosDeCosto : centrosDeCostos){
               modeloCombo.addElement(new Banda(centrosDeCosto.getDescripcion(),centrosDeCosto.getCentrocostoid())); 
            }
            jComboBox.setModel(modeloCombo);
            
        } catch (Exception e) {
            Mensaje.mostrarErrorDeConsulta(this);
        }
    }
    
    private void llenaComboPeriodicidadPago(javax.swing.JComboBox jComboBox) {
        
        DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
        jComboBox.removeAllItems();

        GestionarPeriodicidadPagoServicio gestionarPeriodicidadPagoServicio = new GestionarPeriodicidadPagoServicio();
        try {
            periodicidadPagos= gestionarPeriodicidadPagoServicio.cargarPeriodicidadPagoDAO();
        
            modeloCombo.addElement("Seleccione Periodicidad Pago");
            for(PeriodicidadPago periodicidadPago : periodicidadPagos){
               modeloCombo.addElement(new Banda(periodicidadPago.getDescripcion(),periodicidadPago.getPeriodicidadid())); 
            }
            jComboBox.setModel(modeloCombo);
            
        } catch (Exception e) {
            Mensaje.mostrarErrorDeConsulta(this);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTxtApePat = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTxtApeMat = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTxtNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jDateChooserFecNaci = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jCboTipoDocu = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jTxtNumero = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jCboDepartamento = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jCboProvincia = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jCboDistrito = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jTxtDireccion = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jCboEstadoCivil = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        jTxtTelefono = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTxtCelular = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTxtEmail = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jCboAsigFamiliar = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        jTxtEssalud = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jCboNivelEducativo = new javax.swing.JComboBox();
        jLabel23 = new javax.swing.JLabel();
        jCboNacionalidad = new javax.swing.JComboBox();
        jLabel24 = new javax.swing.JLabel();
        jCboGenero = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jCboTipoEmpleado = new javax.swing.JComboBox();
        jLabel19 = new javax.swing.JLabel();
        jCboDepartamento2 = new javax.swing.JComboBox();
        jLabel20 = new javax.swing.JLabel();
        jCboCargo = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jCboCentroCosto = new javax.swing.JComboBox();
        jLabel22 = new javax.swing.JLabel();
        jCboPeriodicidadPago = new javax.swing.JComboBox();
        barOpciones = new javax.swing.JToolBar();
        botCrear = new javax.swing.JButton();
        botGuardar = new javax.swing.JButton();
        botSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestionar Empleado");
        setName("formEmpleado"); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Generales"));

        jLabel2.setText("Apellido Paterno");

        jLabel3.setText("Apellido Materno");

        jLabel4.setText("Nombre(s)");

        jTxtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtNombreActionPerformed(evt);
            }
        });

        jLabel5.setText("Fecha Nacimiento");

        jDateChooserFecNaci.setDateFormatString("yyyy/MM/dd");
        jDateChooserFecNaci.setMaxSelectableDate(new java.util.Date(253370786491000L));

        jLabel6.setText("Tipo Documento");

        jLabel7.setText("Numero");

        jLabel8.setText("Departamento");

        jCboDepartamento.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCboDepartamentoItemStateChanged(evt);
            }
        });
        jCboDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCboDepartamentoActionPerformed(evt);
            }
        });

        jLabel9.setText("Provincia");

        jCboProvincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCboProvinciaActionPerformed(evt);
            }
        });

        jLabel10.setText("Distrito");

        jLabel11.setText("Direccion");

        jLabel12.setText("Estado Civil");

        jLabel13.setText("Telefono");

        jLabel14.setText("Celular");

        jLabel15.setText("E-mail");

        jLabel16.setText("Asignación Familia");

        jCboAsigFamiliar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Si", "No" }));

        jLabel17.setText("Es-Salud");

        jLabel21.setText("Nivel Educativo");

        jLabel23.setText("Nacionalidad");

        jLabel24.setText("Genero");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(jLabel17))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel11)
                                        .addComponent(jLabel12))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(jLabel15))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jLabel14))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel5))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel2))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel16)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(216, 216, 216)
                                                .addComponent(jLabel21))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jCboEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel13))))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jCboNivelEducativo, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTxtTelefono)))
                                .addComponent(jTxtNombre)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jTxtEssalud, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(122, 122, 122)
                                        .addComponent(jCboAsigFamiliar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jTxtEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTxtCelular, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jTxtApePat, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTxtApeMat, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jCboNacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jCboProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jCboDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jCboDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(jTxtDireccion))
                            .addComponent(jDateChooserFecNaci, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel23)
                                    .addComponent(jLabel9)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCboTipoDocu, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel10)
                                .addComponent(jLabel24))
                            .addComponent(jLabel7))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCboGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTxtApePat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTxtApeMat, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooserFecNaci, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel24)
                        .addComponent(jCboGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jCboTipoDocu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTxtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCboNacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jCboDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jCboProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jCboDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jCboEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTxtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(jTxtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCboNivelEducativo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel21)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jTxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jCboAsigFamiliar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(jTxtEssalud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Laborales"));

        jLabel18.setText("Tipo Empleado");

        jLabel19.setText("Departamento");

        jLabel20.setText("Cargo");

        jLabel1.setText("Centro Costos");

        jLabel22.setText("Periodo Pago");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel22)
                    .addComponent(jLabel18)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jCboTipoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jLabel19))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jCboCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jCboDepartamento2, 0, 197, Short.MAX_VALUE)
                            .addComponent(jCboCentroCosto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jCboPeriodicidadPago, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jCboTipoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(jCboDepartamento2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jCboCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCboCentroCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCboPeriodicidadPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addGap(158, 158, 158))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        barOpciones.setFloatable(false);
        barOpciones.setRollover(true);

        botCrear.setText("Crear");
        botCrear.setFocusable(false);
        botCrear.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botCrear.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        barOpciones.add(botCrear);

        botGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/c1_presentacion/resources/Save_16x16.png"))); // NOI18N
        botGuardar.setText("Guardar");
        botGuardar.setFocusable(false);
        botGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botGuardarActionPerformed(evt);
            }
        });
        barOpciones.add(botGuardar);

        botSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/c1_presentacion/resources/door_out.png"))); // NOI18N
        botSalir.setText("Salir");
        botSalir.setFocusable(false);
        botSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botSalirActionPerformed(evt);
            }
        });
        barOpciones.add(botSalir);

        getContentPane().add(barOpciones, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTxtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtNombreActionPerformed

    private void jCboDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCboDepartamentoActionPerformed
        //Obtengo Id
        try {
            if (this.jCboDepartamento.getSelectedItem()!=""){
                Banda banda = (Banda) this.jCboDepartamento.getSelectedItem();
                String depaId = banda.getId();

                llenaComboUbigeoProvincia(this.jCboProvincia,depaId);
                jCboProvincia.setSelectedIndex(0);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
//            JOptionPane.showMessageDialog(null,e.getMessage(),"EV-Soft: Advertencia",JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_jCboDepartamentoActionPerformed

    private void jCboProvinciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCboProvinciaActionPerformed
        //Obtengo Id
        try {
            Banda banda = (Banda) this.jCboDepartamento.getSelectedItem();
            String depaId = banda.getId();

            Banda banda1 = (Banda) this.jCboProvincia.getSelectedItem();
            String provId = banda1.getId();

            llenaComboUbigeoDistrito(this.jCboDistrito, depaId, provId);
        } catch (Exception e) {
            e.printStackTrace();
//            JOptionPane.showMessageDialog(null,e.getMessage(),"EV-Soft: Advertencia",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jCboProvinciaActionPerformed

    private void jCboDepartamentoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCboDepartamentoItemStateChanged
        
    }//GEN-LAST:event_jCboDepartamentoItemStateChanged

    private void botGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botGuardarActionPerformed
        Date now = new Date(System.currentTimeMillis());

        int registros_afectados;
        // Guardar Empleado
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        
        try {            
            empleado.setFecharegistro(formatoFecha.format(now));
            
            empleado.setApellidopaterno(this.jTxtApePat.getText());
            empleado.setApellidomaterno(this.jTxtApeMat.getText());
            empleado.setNombre(this.jTxtNombre.getText());
            empleado.setFechanacimiento(formatoFecha.format(this.jDateChooserFecNaci.getDate()));
            //TipoDocumento
            GestionarTipoDocumentoServicio gestionarTipoDocumento =  new GestionarTipoDocumentoServicio();
            tipoDocumento = gestionarTipoDocumento.buscarTipoDocumento(Funciones.codIntCombo(this.jCboTipoDocu));
            empleado.setTipodocumento(tipoDocumento);
            
            empleado.setNumerodocumento(this.jTxtNumero.getText());
            //Ubigeo
            GestionarUbigeoServicio gestionarUbigeoServicio = new GestionarUbigeoServicio();
            String ubigeoid = Funciones.codStrCombo(this.jCboDepartamento) + Funciones.codStrCombo(this.jCboProvincia) + Funciones.codStrCombo(this.jCboDistrito);
            ubigeov = gestionarUbigeoServicio.buscarUbigeo(ubigeoid);
            empleado.setUbigeo(ubigeov);
            empleado.setDireccion(this.jTxtDireccion.getText());
            //EstadoCivil
            GestionarEstadoCivilServicio gestionarEstadoCivil = new GestionarEstadoCivilServicio();
            estadoCivil = gestionarEstadoCivil.buscarEstadoCivil(Funciones.codIntCombo(this.jCboEstadoCivil));       
            empleado.setEstadocivil(estadoCivil);
            empleado.setTelefono(this.jTxtTelefono.getText());
            empleado.setCelular(this.jTxtCelular.getText());
            empleado.setEmail(this.jTxtEmail.getText());
            empleado.setAsignacionfamiliar((String) this.jCboAsigFamiliar.getSelectedItem());
            empleado.setEssalud(this.jTxtEssalud.getText());
            //Tipo Empleado
            GestionarTipoEmpleadoServicio gestionarTipoEmpleadoServicio = new GestionarTipoEmpleadoServicio();
            tipoempleado = gestionarTipoEmpleadoServicio.buscarTipoEmpleado(Funciones.codIntCombo(this.jCboTipoEmpleado));
            empleado.setTipoempleado(tipoempleado );
            //Departamento
            GestionarDepartamentoServicio gestionarDepartamentoServicio = new GestionarDepartamentoServicio();
            departamento = gestionarDepartamentoServicio.buscarDepartamento(Funciones.codIntCombo(this.jCboDepartamento2));
            empleado.setDepartamento(departamento);
            //Cargo
            GestionarCargoServicio gestionarCargoServicio = new GestionarCargoServicio();
            cargo = gestionarCargoServicio.buscarCargo(Funciones.codIntCombo(this.jCboCargo));
            empleado.setCargo(cargo);
            int estado=1;
            empleado.setEstado(estado);
            //Centro de Costo
            GestionarCentrosDeCostosServicio gestionarCentrosDeCostosServicio = new GestionarCentrosDeCostosServicio();
            centrosDeCosto = gestionarCentrosDeCostosServicio.buscarCentroDeCosto(Funciones.codIntCombo(this.jCboCentroCosto));
            empleado.setCentrocosto(centrosDeCosto);
            //Nivel Educacion
            GestionarNivelEducacionServicio gestionarNivelEducacionServicio = new GestionarNivelEducacionServicio();
            nivelEducacion = gestionarNivelEducacionServicio.buscarNivelEducacion(Funciones.codIntCombo(this.jCboNivelEducativo));
            empleado.setNiveleducativo(nivelEducacion );
            //Periodicidad pago
            GestionarPeriodicidadPagoServicio gestionarPeriodicidadPagoServicio = new GestionarPeriodicidadPagoServicio();
            periodicidadPago = gestionarPeriodicidadPagoServicio.buscarPeriodicidadPago(Funciones.codIntCombo(this.jCboPeriodicidadPago));
            empleado.setPeriodicidadpago(periodicidadPago );
            //Nacionalidad
            GestionarNacionalidadServicio gestionarNacionalidadServicio =  new GestionarNacionalidadServicio();
            nacionalidad = gestionarNacionalidadServicio.buscarNacionalidad(Funciones.codIntCombo(this.jCboNacionalidad));
            empleado.setNacionalidad(nacionalidad);
            //Genero
            GestionarGeneroServicio gestionarGeneroServicio = new GestionarGeneroServicio();
            genero = gestionarGeneroServicio.buscarGenero(Funciones.codIntCombo(this.jCboGenero));
            empleado.setGenero(genero);
            
            GestionarEmpleadoServicio gestionarEmpleadoServicio = new GestionarEmpleadoServicio();
            registros_afectados = gestionarEmpleadoServicio.crearEmpleado(empleado);
            
            if (registros_afectados==1){
                Mensaje.mostrarAfirmacionDeCreacion(this);
                inicializarEmpleado();
            }
            else
                Mensaje.mostrarAdvertenciaDeCreacion(this);
        } catch (Exception e) {
            Mensaje.mostrarError(this, e.getMessage());
        }
        
        
    }//GEN-LAST:event_botGuardarActionPerformed

    private void botSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_botSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToolBar barOpciones;
    private javax.swing.JButton botCrear;
    private javax.swing.JButton botGuardar;
    private javax.swing.JButton botSalir;
    private javax.swing.JComboBox jCboAsigFamiliar;
    private javax.swing.JComboBox jCboCargo;
    private javax.swing.JComboBox jCboCentroCosto;
    private javax.swing.JComboBox jCboDepartamento;
    private javax.swing.JComboBox jCboDepartamento2;
    private javax.swing.JComboBox jCboDistrito;
    private javax.swing.JComboBox jCboEstadoCivil;
    private javax.swing.JComboBox jCboGenero;
    private javax.swing.JComboBox jCboNacionalidad;
    private javax.swing.JComboBox jCboNivelEducativo;
    private javax.swing.JComboBox jCboPeriodicidadPago;
    private javax.swing.JComboBox jCboProvincia;
    private javax.swing.JComboBox jCboTipoDocu;
    private javax.swing.JComboBox jCboTipoEmpleado;
    private com.toedter.calendar.JDateChooser jDateChooserFecNaci;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTxtApeMat;
    private javax.swing.JTextField jTxtApePat;
    private javax.swing.JTextField jTxtCelular;
    private javax.swing.JTextField jTxtDireccion;
    private javax.swing.JTextField jTxtEmail;
    private javax.swing.JTextField jTxtEssalud;
    private javax.swing.JTextField jTxtNombre;
    private javax.swing.JTextField jTxtNumero;
    private javax.swing.JTextField jTxtTelefono;
    // End of variables declaration//GEN-END:variables
}
