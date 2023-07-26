/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Steven;

import Clases.Pais;
import Clases.Persona;
import Clases.Tipo_sangre;
import ClasesSteven.Comerciante;
import static Freddy.Crear_Guardia.comprobarCedula;
import static andrea.Tecnico_crud.comprobarPais;
import static andrea.Tecnico_crud.comprobarTS;
import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;
import java.util.Date;
import javax.swing.JOptionPane;
import jose.INICIO;

/**
 *
 * @author Steven Zhicay
 */
public class Comerciante_CRUD extends javax.swing.JFrame {

    String id_comerciante;
    int años_exp;
    int num_ventas;    
    String Cedula_per = "";
    String nombre_per = "";
    String apellido_per = "";
    int edad_per = 0;
    String genero_per;
    String celular_per = "";
    Date fechanac_per;
    String correo_per = "";
    String tiposangre_per = "";
    String codigo_pais_per = "";
    int valorInicial = 0;

    public Comerciante_CRUD() {
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
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtcodigo = new javax.swing.JTextField();
        txtTipoSangre = new javax.swing.JTextField();
        txtCedulaPersona = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtNumVentas = new javax.swing.JSpinner();
        txtAños_exp = new javax.swing.JSpinner();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        Genero_combobox = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        fechaNa = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtCelular = new javax.swing.JTextField();
        txtTipoPais = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtEdad = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Registro Comerciante");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 20, 760, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("*Codigo Comerciante:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 170, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Años de Experiencia:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 230, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Fecha de nacimiento:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Número de ventas:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 290, -1, -1));

        txtcodigo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtcodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 190, 190, 30));

        txtTipoSangre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtTipoSangre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipoSangreActionPerformed(evt);
            }
        });
        jPanel1.add(txtTipoSangre, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, 190, 30));

        txtCedulaPersona.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtCedulaPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaPersonaActionPerformed(evt);
            }
        });
        jPanel1.add(txtCedulaPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 190, 30));

        btnGuardar.setBackground(new java.awt.Color(255, 102, 51));
        btnGuardar.setText("Guardar");
        btnGuardar.setBorderPainted(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 430, 290, 30));

        jButton2.setBackground(new java.awt.Color(255, 102, 51));
        jButton2.setText("Regresar");
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 470, 290, 30));

        txtNumVentas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtNumVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 310, 190, 30));

        txtAños_exp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtAños_exp, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 250, 190, 30));

        txtNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 190, 30));

        txtApellido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoActionPerformed(evt);
            }
        });
        jPanel1.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 190, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("*Cedula de persona:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Nombre:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Apellido:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Edad:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, -1, -1));

        Genero_combobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opcion", "Masculino", "Femenino" }));
        jPanel1.add(Genero_combobox, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, 190, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("Genero:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, -1, -1));
        jPanel1.add(fechaNa, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, 190, 30));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setText("Cod Tipo_Pais:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 350, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setText("Celular:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, -1, -1));

        txtCelular.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtCelular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCelularActionPerformed(evt);
            }
        });
        jPanel1.add(txtCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, 190, 30));

        txtTipoPais.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtTipoPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipoPaisActionPerformed(evt);
            }
        });
        jPanel1.add(txtTipoPais, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 370, 190, 30));

        txtCorreo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });
        jPanel1.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 250, 190, 30));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setText("Correo:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, -1, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel17.setText("Cod Tipo_Sangre:");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 290, -1, -1));

        txtEdad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 190, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        ObjectContainer BaseD = Db4o.openFile(INICIO.direccionBD);
        crearComerciante(BaseD);
        Cerrar_BD(BaseD);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtCedulaPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaPersonaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedulaPersonaActionPerformed

    private void txtTipoSangreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoSangreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoSangreActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoActionPerformed

    private void txtCelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCelularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCelularActionPerformed

    private void txtTipoPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoPaisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoPaisActionPerformed

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        INICIO ini = new INICIO();
        ini.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Comerciante_CRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Comerciante_CRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Comerciante_CRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Comerciante_CRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Comerciante_CRUD().setVisible(true);
            }
        });
    }

    public void asignarVariables(ObjectContainer basep) {
        Cedula_per = txtCedulaPersona.getText();
        nombre_per = txtNombre.getText();
        apellido_per = txtApellido.getText();
        edad_per = (Integer) txtEdad.getValue();
        genero_per = Genero_combobox.getSelectedItem().toString();
        celular_per = txtCelular.getText();
        fechanac_per = fechaNa.getDate();
        correo_per = txtCorreo.getText();
        tiposangre_per = txtTipoSangre.getText();
        codigo_pais_per = txtTipoPais.getText();
        id_comerciante = txtcodigo.getText();
        años_exp = (Integer) txtAños_exp.getValue();
        num_ventas = (Integer) txtNumVentas.getValue();

    }

    public void LimpiarCampos() {
        txtcodigo.setText("");
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
        txtCedulaPersona.setText("");

    }

    public void crearComerciante(ObjectContainer basep) {
        asignarVariables(basep);
        boolean error = false;
        if (comprobarComerciante(basep, id_comerciante) != 0) {
            error = true;
            JOptionPane.showMessageDialog(this, "Ya existe un comerciante con este codigo", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else if (comprobarCedula(basep, Cedula_per)) {
            error = true;
            JOptionPane.showMessageDialog(this, "Ya existe un comerciante con esta cédula registrada", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        if (comprobarTS(basep, tiposangre_per) == 0) {
            error = true;
            JOptionPane.showMessageDialog(null, "No existe ningun tipo de sangre con este codigo");
        }
        if (comprobarPais(basep, codigo_pais_per) == 0) {
            error = true;
            JOptionPane.showMessageDialog(null, "No existe ningun Pais con este codigo");
        }
        if (!error) {
            Comerciante crearC = new Comerciante(id_comerciante, años_exp, num_ventas, Cedula_per, nombre_per
                    , apellido_per, edad_per, genero_per, celular_per, fechanac_per, correo_per, tiposangre_per, codigo_pais_per);
            basep.set(crearC);
            JOptionPane.showMessageDialog(null, "Comerciante registrado");
            LimpiarCampos();
        }

    }


    public static int comprobarComerciante(ObjectContainer basep, String id_comerciante) {
        Comerciante buscarC = new Comerciante(id_comerciante, 0, 0, null, null, null, 0, null, null, null, null, null, null);
        ObjectSet result = basep.get(buscarC);
        return result.size();
    }

    public static int comprobarTS(ObjectContainer basep, String codigo_tipo_sangre) {

        ObjectSet result = basep.get(new Tipo_sangre(codigo_tipo_sangre, null, 0));
        return result.size();
    }

    public static boolean comprobarCedula(ObjectContainer BaseD, String Cedula_per_due) {
        Query query = BaseD.query();
        query.constrain(Persona.class);
        query.descend("cedula_per").constrain(Cedula_per_due).equal();
        ObjectSet result = query.execute();
        return !result.isEmpty();
    }

    public static int comprobarPais(ObjectContainer basep, String codigo_pais_per_taq) {

        ObjectSet result = basep.get(new Pais(codigo_pais_per_taq, null, 0));
        return result.size();
    }

    public static void Cerrar_BD(ObjectContainer basep) {
        basep.close();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Genero_combobox;
    private javax.swing.JButton btnGuardar;
    private com.toedter.calendar.JDateChooser fechaNa;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
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
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JSpinner txtEdad;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JSpinner txtNumVentas;
    private javax.swing.JTextField txtTipoPais;
    private javax.swing.JTextField txtTipoSangre;
    private javax.swing.JTextField txtcodigo;
    // End of variables declaration//GEN-END:variables
}
