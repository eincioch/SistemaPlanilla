/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c1_presentacion;

import c1_presentacion.util.Funciones;
import c1_presentacion.util.Mensaje;
import c2_aplicacion.GestionarContratoServicio;
import c2_aplicacion.GestionarEmpleadoServicio;
import c2_aplicacion.GestionarTipoDocumentoServicio;
import c2_aplicacion.GestionarTipoMonedaServicio;
import c3_dominio.entidades.Banda;
import c3_dominio.entidades.Contrato;
import c3_dominio.entidades.Empleado;
import c3_dominio.entidades.TipoDocumento;
import c3_dominio.entidades.TipoMoneda;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class FormGestionarContrato extends javax.swing.JDialog {

    private Contrato contrato;
    private Empleado empleado;
    private TipoMoneda tipoMoneda;
    private List<TipoDocumento> tipodocumentos;
    private List<TipoMoneda> tipoMonedas;
    /**
     * Creates new form FormGestionarContrato
     */
    public FormGestionarContrato(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        llenaComboTipoDocumento(this.jCboTipDocu);
        llenaComboTipoMoneda(this.jCboTipoMoneda);
        this.contrato = new Contrato();
    }

    private void llenaComboTipoDocumento(javax.swing.JComboBox jComboBox) {      
        DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
        jComboBox.removeAllItems();

        GestionarTipoDocumentoServicio gestionarTipoDocumentoServicio = new GestionarTipoDocumentoServicio();
        try {
            tipodocumentos = gestionarTipoDocumentoServicio.cargarTipoDocumento();
        
            for(TipoDocumento tipodocumento : tipodocumentos){
                modeloCombo.addElement(new Banda(tipodocumento.getDescripcion(),tipodocumento.getTipodocumentoid()));
            }
            jComboBox.setModel(modeloCombo);
            
        } catch (Exception e) {
            Mensaje.mostrarErrorDeConsulta(this);
        }
    }
    
    private void llenaComboTipoMoneda(javax.swing.JComboBox jComboBox) {      
        DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
        jComboBox.removeAllItems();

        GestionarTipoMonedaServicio gestionarTipoMonedaServicio = new GestionarTipoMonedaServicio();
        try {
            tipoMonedas = gestionarTipoMonedaServicio.cargarTipoMoneda();
        
            for(TipoMoneda tipoMoneda : tipoMonedas){
                modeloCombo.addElement(new Banda(tipoMoneda.getDescripcion(),tipoMoneda.getTipomonedaid()));
            }
            jComboBox.setModel(modeloCombo);
            
        } catch (Exception e) {
            Mensaje.mostrarErrorDeConsulta(this);
        }
    }
    
    private void activarBotonBuscar(){
        if(empleado != null) //&& ejemplar != null)
            botBuscar.setEnabled(true);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jCboTipDocu = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jTxtNumero = new javax.swing.JTextField();
        botBuscar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLblEmpleado = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jDtChsFecIni = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jCboTipoMoneda = new javax.swing.JComboBox();
        botGrabar = new javax.swing.JButton();
        botCancelar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jDtChsFecFin = new com.toedter.calendar.JDateChooser();
        jTxtSueldo = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestionar Contrato");

        jToolBar1.setRollover(true);

        jButton1.setText("Nuevo Contrato");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton1);

        getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Afiliación Regimen Pensionario"));

        jPanel3.setBackground(new java.awt.Color(255, 255, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Empleado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(153, 51, 0))); // NOI18N

        jLabel1.setText("Tipo Documento");

        jLabel2.setText("Numero");

        botBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/c1_presentacion/resources/Find_16x16.png"))); // NOI18N
        botBuscar.setText("Buscar");
        botBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botBuscarActionPerformed(evt);
            }
        });

        jLabel3.setText("Empleado");

        jLblEmpleado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLblEmpleado.setForeground(new java.awt.Color(102, 0, 0));
        jLblEmpleado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLblEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCboTipDocu, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botBuscar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jCboTipDocu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTxtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLblEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel5.setText("Fecha Inicio");

        jLabel6.setText("Remuneración");

        jLabel7.setText("Tipo Moneda");

        botGrabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/c1_presentacion/resources/Save_16x16.png"))); // NOI18N
        botGrabar.setText("Guardar");
        botGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botGrabarActionPerformed(evt);
            }
        });

        botCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/c1_presentacion/resources/Cancel_16x16.png"))); // NOI18N
        botCancelar.setText("Cancelar");

        jLabel9.setText("Fecha Termino");

        jTxtSueldo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00"))));
        jTxtSueldo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jCboTipoMoneda, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDtChsFecIni, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jLabel9))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(jLabel6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDtChsFecFin, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxtSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(botGrabar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botCancelar)
                .addGap(50, 50, 50))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jDtChsFecIni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jDtChsFecFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jCboTipoMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jTxtSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botGrabar)
                    .addComponent(botCancelar))
                .addGap(76, 76, 76))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botBuscarActionPerformed
        // TODO add your handling code here:
        try {
            GestionarEmpleadoServicio gestionarEmpleadoServicio = new GestionarEmpleadoServicio();
                    
            empleado = gestionarEmpleadoServicio.buscarEmpleado(Funciones.codIntCombo(this.jCboTipDocu), this.jTxtNumero.getText());
            if(empleado != null)
                this.jLblEmpleado.setText(empleado.getApellidopaterno() + " " + empleado.getApellidomaterno() + ", " + empleado.getNombre());
            else
                Mensaje.mostrarAdvertencia(this, "El empleado no se encuentra registrado");
                activarBotonBuscar();
        } catch (Exception e) {
            Mensaje.mostrarErrorDeConsulta(this);
        }

    }//GEN-LAST:event_botBuscarActionPerformed

    private void botGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botGrabarActionPerformed
        // TODO add your handling code here:
        int registros_afectados;
        try {
            
            contrato.setFecharegistro(this.jDtChsFecIni.getDate());
            contrato.setEmpleado(empleado); //empleado ya lo tengo desde la busqueda.
            contrato.setFechainicio(this.jDtChsFecIni.getDate());
            contrato.setFechatermino(this.jDtChsFecFin.getDate());
            contrato.setRemuneracionbasica( Double.valueOf(this.jTxtSueldo.getValue().toString()));
            contrato.setHoraley(8);
            contrato.setEstado(1);

            GestionarTipoMonedaServicio gestionarTipoMonedaServicio =  new GestionarTipoMonedaServicio();
            tipoMoneda = gestionarTipoMonedaServicio.buscarTipoMoneda(Funciones.codIntCombo(this.jCboTipoMoneda));
            contrato.setTipomoneda(tipoMoneda);

            GestionarContratoServicio gestionarContratoServicio = new GestionarContratoServicio();
            registros_afectados = gestionarContratoServicio.crearContrato(contrato);

            if (registros_afectados==1){
                Mensaje.mostrarAfirmacionDeCreacion(this);
                //inicializarEmpleado();
            }
            else
            Mensaje.mostrarAdvertenciaDeCreacion(this);
        } catch (Exception e) {
            //Mensaje.mostrarError(this, e.getMessage());
            JOptionPane.showMessageDialog(null,e,"EV-Soft: Advertencia",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_botGrabarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botBuscar;
    private javax.swing.JButton botCancelar;
    private javax.swing.JButton botGrabar;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jCboTipDocu;
    private javax.swing.JComboBox jCboTipoMoneda;
    private com.toedter.calendar.JDateChooser jDtChsFecFin;
    private com.toedter.calendar.JDateChooser jDtChsFecIni;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLblEmpleado;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField jTxtNumero;
    private javax.swing.JFormattedTextField jTxtSueldo;
    // End of variables declaration//GEN-END:variables
}
