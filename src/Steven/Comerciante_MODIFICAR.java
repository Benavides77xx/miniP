/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Steven;

import ClasesSteven.Comerciante;
import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.foundation.Coercion4;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jose.INICIO;

/**
 *
 * @author Steven Zhicay
 */
public class Comerciante_MODIFICAR extends javax.swing.JFrame {

    int valorInicial = 0;
    
    public Comerciante_MODIFICAR() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtcodC = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnmodificar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txtNumVentas = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        txtAños_exp = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtEdad = new javax.swing.JSpinner();
        jLabel13 = new javax.swing.JLabel();
        Genero_combobox = new javax.swing.JComboBox<>();
        txtCelular = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        fechaNa = new com.toedter.calendar.JDateChooser();
        jLabel16 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtTipoSangre = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtTipoPais = new javax.swing.JTextField();
        txtCedulaPersona = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtCodNegocio = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Modificar Comerciante");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 20, 760, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("*Codigo Comerciante:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, -1, 30));
        jPanel1.add(txtcodC, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 250, 30));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscar (1).png"))); // NOI18N
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 80, 40, -1));

        btnmodificar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnmodificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/editar (1).png"))); // NOI18N
        btnmodificar.setText("Modificar");
        btnmodificar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnmodificar.setContentAreaFilled(false);
        btnmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificarActionPerformed(evt);
            }
        });
        jPanel1.add(btnmodificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 70, 130, 40));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Regresar.png"))); // NOI18N
        jButton3.setText("Regresar");
        jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton3.setContentAreaFilled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 550, 130, 40));

        txtNumVentas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtNumVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 390, 190, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Número de ventas:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 370, -1, -1));

        txtAños_exp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtAños_exp, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 330, 190, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Años de Experiencia:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 310, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Nombre:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, -1, -1));

        txtNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 190, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Apellido:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, -1, -1));

        txtApellido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoActionPerformed(evt);
            }
        });
        jPanel1.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 190, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Edad:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, -1, -1));

        txtEdad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, 190, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("Genero:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 490, -1, -1));

        Genero_combobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opcion", "Masculino", "Femenino" }));
        jPanel1.add(Genero_combobox, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 510, 190, 30));

        txtCelular.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtCelular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCelularActionPerformed(evt);
            }
        });
        jPanel1.add(txtCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 270, 190, 30));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setText("Celular:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Fecha de nacimiento:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 310, -1, -1));
        jPanel1.add(fechaNa, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 330, 190, 30));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setText("Correo:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 370, -1, -1));

        txtCorreo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });
        jPanel1.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 390, 190, 30));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel17.setText("Cod Tipo_Sangre:");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 430, -1, -1));

        txtTipoSangre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtTipoSangre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipoSangreActionPerformed(evt);
            }
        });
        jPanel1.add(txtTipoSangre, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 450, 190, 30));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setText("Cod Tipo_Pais:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 490, -1, -1));

        txtTipoPais.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtTipoPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipoPaisActionPerformed(evt);
            }
        });
        jPanel1.add(txtTipoPais, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 510, 190, 30));

        txtCedulaPersona.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtCedulaPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaPersonaActionPerformed(evt);
            }
        });
        jPanel1.add(txtCedulaPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 190, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("*Cedula de persona:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, -1));

        txtCodNegocio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtCodNegocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodNegocioActionPerformed(evt);
            }
        });
        jPanel1.add(txtCodNegocio, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 270, 190, 30));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel18.setText("Cod Negocio:");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 250, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 766, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ObjectContainer BaseD = Db4o.openFile(INICIO.direccionBD);
        buscar(BaseD);
        Cerrar_BD(BaseD);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarActionPerformed
        ObjectContainer BaseD = Db4o.openFile(INICIO.direccionBD);
        Modificar_Comerciante(BaseD);
        Cerrar_BD(BaseD);
        txtcodC.setEditable(true);
    }//GEN-LAST:event_btnmodificarActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoActionPerformed

    private void txtCelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCelularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCelularActionPerformed

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void txtTipoSangreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoSangreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoSangreActionPerformed

    private void txtTipoPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoPaisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoPaisActionPerformed

    private void txtCedulaPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaPersonaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedulaPersonaActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        INICIO ini = new INICIO();
        ini.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtCodNegocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodNegocioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodNegocioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Comerciante_MODIFICAR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Comerciante_MODIFICAR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Comerciante_MODIFICAR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Comerciante_MODIFICAR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Comerciante_MODIFICAR().setVisible(true);
            }
        });
    }
    public void LimpiarCampos() {
        txtcodC.setText("");
        txtCedulaPersona.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtEdad.setValue(valorInicial);
        Genero_combobox.setSelectedItem(-1);
        txtCelular.setText("");
        fechaNa.setDate(null);
        txtCorreo.setText("");
        txtTipoSangre.setText("");
        txtTipoPais.setText("");
        txtAños_exp.setValue(valorInicial);        
        txtNumVentas.setValue(valorInicial);
        

    }

    public void HabilitarCampos_deTexto() {
        txtcodC.setEditable(true);
        txtCedulaPersona.setEditable(true);
        txtNombre.setEditable(true);
        txtApellido.setEditable(true);
        txtCelular.setEditable(true);
        txtCorreo.setEditable(true);
        txtTipoSangre.setEditable(true);
        txtTipoPais.setEditable(true);
    }

    public void buscar(ObjectContainer basep) {//cargardatos

        btnmodificar.setEnabled(false);
        String codC;
        codC = txtcodC.getText();

        Area_CRUD areacrud = new Area_CRUD();

        if (txtcodC.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Ingrese un ID/Codigo");
        } else {

            if (areacrud.comprobarArea(basep, codC) == 0) {

                JOptionPane.showMessageDialog(null, "El Comerciante no existe en la base de datos");
                LimpiarCampos();

            } else {

                Comerciante Ebuscar = new Comerciante(codC, 0, 0, null, null, null, null, 0, null, null, null, null, null, null);

                ObjectSet result = basep.get(Ebuscar);
                for (int i = 0; i < result.size(); i++) {

                    Comerciante miE = new Comerciante();

                    miE = (Comerciante) result.get(i);
                    txtcodC.setText(miE.getId_comerciante());
                    txtCedulaPersona.setText(miE.getCelular_per());
                    txtNombre.setText(miE.getNombre_per());
                    txtApellido.setText(miE.getApellido());
                    txtEdad.setValue(miE.getEdad_per());
                    Genero_combobox.setSelectedItem(miE.getGenero());
                    txtCelular.setText(miE.getCelular_per());
                    fechaNa.setDate(miE.getFecha_nac());
                    txtCorreo.setText(miE.getCorreo());
                    txtTipoSangre.setText(miE.getCodigo_tipo_sangre());
                    txtTipoPais.setText(miE.getCodigo_pais());
                    txtAños_exp.setValue(miE.getAños_exp());
                    txtNumVentas.setValue(miE.getNum_ventas());
                    
                    
                    
                    btnmodificar.setEnabled(true);
                    //Hacer editable los campos de texto
                    
                    HabilitarCampos_deTexto();
                    txtcodC.setEditable(false);
                }

            }

        }
    }

    public void Modificar_Comerciante(ObjectContainer basep) {

        Comerciante Emodi = new Comerciante(txtcodC.getText(), 0, 0, null, null, null, null, 0, null, null, null, null, null, null);
        ObjectSet result = basep.get(Emodi);

        Comerciante Emodificar = (Comerciante) result.next();
        Emodificar.setNombre_per(txtNombre.getText());
        Emodificar.setApellido(txtApellido.getText());
        Emodificar.setEdad_per(Integer.parseInt((String) txtEdad.getValue()));
        Emodificar.setGenero(Genero_combobox.getSelectedItem().toString());
        Emodificar.setCelular_per(txtCelular.getText());
        Emodificar.setFecha_nac(fechaNa.getDate());
        Emodificar.setCorreo(txtCorreo.getText());
        Emodificar.setCodigo_tipo_sangre(txtTipoSangre.getText());
        Emodificar.setCodigo_pais(txtTipoPais.getText());
        Emodificar.setCod_negocio(txtCodNegocio.getText());     
        Emodificar.setAños_exp(Integer.parseInt((String) txtAños_exp.getValue()));
        Emodificar.setNum_ventas(Integer.parseInt((String) txtNumVentas.getValue()));
        

        basep.set(Emodificar);
        JOptionPane.showMessageDialog(null, "El Comerciante fue modificado exitosamente");
        
        LimpiarCampos();
    }


    public static void Cerrar_BD(ObjectContainer basep) {

        basep.close();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Genero_combobox;
    private javax.swing.JButton btnmodificar;
    private com.toedter.calendar.JDateChooser fechaNa;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JSpinner txtAños_exp;
    private javax.swing.JTextField txtCedulaPersona;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtCodNegocio;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JSpinner txtEdad;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JSpinner txtNumVentas;
    private javax.swing.JTextField txtTipoPais;
    private javax.swing.JTextField txtTipoSangre;
    private javax.swing.JTextField txtcodC;
    // End of variables declaration//GEN-END:variables
}
