/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Steven;

import Clases.Guardia;
import ClasesSteven.Area;
import ClasesSteven.Control_guardia;
import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import java.util.Date;
import javax.swing.JOptionPane;
import jose.INICIO;

/**
 *
 * @author Steven Zhicay
 */
public class Control_Guardia_CRUD extends javax.swing.JFrame {

    String cod_control_gua;
    Date fecha;
    String descripcion;
    String id_guardia;
    String cod_area;

    public Control_Guardia_CRUD() {
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
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtcodigo = new javax.swing.JTextField();
        txtIdGuardia = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtdescripcion = new javax.swing.JTextArea();
        btnGuardar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        lbl = new javax.swing.JLabel();
        txtCod_area = new javax.swing.JTextField();
        jCalendarFecha = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Registro Control Guardia");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 20, 760, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("*Codigo control:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("*Id_guardia:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Observaciones:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, -1, -1));

        txtcodigo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtcodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 200, 30));

        txtIdGuardia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtIdGuardia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdGuardiaActionPerformed(evt);
            }
        });
        jPanel1.add(txtIdGuardia, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 100, 190, 30));

        txtdescripcion.setColumns(20);
        txtdescripcion.setRows(5);
        txtdescripcion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setViewportView(txtdescripcion);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 190, -1));

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

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Fecha:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, -1, -1));

        lbl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl.setText("*Cod_area:");
        jPanel1.add(lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 150, -1, -1));

        txtCod_area.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtCod_area.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCod_areaActionPerformed(evt);
            }
        });
        jPanel1.add(txtCod_area, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 170, 190, 30));
        jPanel1.add(jCalendarFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 200, 30));

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

    private void txtCod_areaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCod_areaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCod_areaActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        ObjectContainer BaseD = Db4o.openFile(INICIO.direccionBD);
        crearControl(BaseD);
        Cerrar_BD(BaseD);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtIdGuardiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdGuardiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdGuardiaActionPerformed

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
            java.util.logging.Logger.getLogger(Control_Guardia_CRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Control_Guardia_CRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Control_Guardia_CRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Control_Guardia_CRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Control_Guardia_CRUD().setVisible(true);
            }
        });
    }

    public void asignarVariables(ObjectContainer basep) {
        cod_control_gua = txtcodigo.getText();
        fecha = jCalendarFecha.getDate();
        descripcion = txtdescripcion.getText();
        id_guardia = txtIdGuardia.getText();
        cod_area = txtCod_area.getText();

    }

    public void LimpiarCampos() {
        txtcodigo.setText("");
        txtdescripcion.setText("");
        txtIdGuardia.setText("");
        txtCod_area.setText("");
        jCalendarFecha.setDate(null);
    }

    public void crearControl(ObjectContainer basep) {

        boolean error = false;
        if (comprobarControl(basep, cod_control_gua) != 0) {
            error = true;
            JOptionPane.showMessageDialog(this, "Ya existe un control con este codigo", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else if (comprobarGuardia(basep, id_guardia) == 0) {
            error = true;
            JOptionPane.showMessageDialog(null, "No existe ningun guardia registrado con este codigo", "Error (Reglas de integridad)", JOptionPane.ERROR_MESSAGE);
        } else if (comprobarArea(basep, cod_area) == 0) {
            error = true;
            JOptionPane.showMessageDialog(null, "No existe ningun area registrado con este codigo", "Error (Reglas de integridad)", JOptionPane.ERROR_MESSAGE);
        }
        if (!error) {
            Control_guardia crearC = new Control_guardia(cod_control_gua, fecha, descripcion, id_guardia, cod_area);
            basep.set(crearC);
            JOptionPane.showMessageDialog(null, "Negocio registrado");
            LimpiarCampos();
        }

    }

    public static int comprobarControl(ObjectContainer basep, String cod_control_gua) {
        Control_guardia buscarC = new Control_guardia(cod_control_gua, null, null, null, null);
        ObjectSet result = basep.get(buscarC);
        return result.size();
    }

    public static int comprobarGuardia(ObjectContainer basep, String id_guardia) {
        ObjectSet result = basep.get(new Guardia(id_guardia, 0, false, null));
        return result.size();
    }

    public static int comprobarArea(ObjectContainer basep, String cod_area) {
        ObjectSet result = basep.get(new Area(cod_area, null, null, 0, false, null, null, null));
        return result.size();
    }

    public static void Cerrar_BD(ObjectContainer basep) {
        basep.close();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jCalendarFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl;
    private javax.swing.JTextField txtCod_area;
    private javax.swing.JTextField txtIdGuardia;
    private javax.swing.JTextField txtcodigo;
    private javax.swing.JTextArea txtdescripcion;
    // End of variables declaration//GEN-END:variables
}
