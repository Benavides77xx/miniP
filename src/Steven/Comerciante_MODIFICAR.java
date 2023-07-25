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
        jScrollPane1 = new javax.swing.JScrollPane();
        jtable = new javax.swing.JTable();
        btnmodificar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txtCedulaPersona = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtNumVentas = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        txtAños_exp = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();

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

        jtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, "", null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "*Codigo_Comerciante", "Años de experiencia", "Numen de ventas", "Cedula"
            }
        ));
        jScrollPane1.setViewportView(jtable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 730, 90));

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
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 550, 130, 40));

        txtCedulaPersona.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtCedulaPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaPersonaActionPerformed(evt);
            }
        });
        jPanel1.add(txtCedulaPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 420, 190, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("*Cedula de persona:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 400, -1, -1));

        txtNumVentas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtNumVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 350, 190, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Número de ventas:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 330, -1, -1));

        txtAños_exp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtAños_exp, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 290, 190, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Años de Experiencia:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 270, -1, -1));

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

    private void txtCedulaPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaPersonaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedulaPersonaActionPerformed

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
        txtAños_exp.setValue(valorInicial);        
        txtNumVentas.setValue(valorInicial);
        txtCedulaPersona.setText("");

    }

    public void HabilitarCampos_deTexto() {

        txtCedulaPersona.setEditable(true);
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

                Comerciante Ebuscar = new Comerciante(codC, 0, 0, null);

                ObjectSet result = basep.get(Ebuscar);
                for (int i = 0; i < result.size(); i++) {

                    Comerciante miE = new Comerciante();

                    miE = (Comerciante) result.get(i);
                    txtcodC.setText(miE.getId_comerciante());                    
                    txtAños_exp.setValue(String.valueOf(miE.getAños_exp()));
                    txtNumVentas.setValue(String.valueOf(miE.getNum_ventas()));
                    txtCedulaPersona.setText(miE.getCedula_persona());
                    
                    btnmodificar.setEnabled(true);
                    //Hacer editable los campos de texto
                    mostrarDatos(result);
                    HabilitarCampos_deTexto();
                    txtcodC.setEditable(false);
                }

            }

        }
    }

    public void Modificar_Comerciante(ObjectContainer basep) {

        Comerciante Emodi = new Comerciante(txtcodC.getText(), 0, 0, null);
        ObjectSet result = basep.get(Emodi);

        Comerciante Emodificar = (Comerciante) result.next();
        Emodificar.setCedula_persona(txtCedulaPersona.getText());
        Emodificar.setAños_exp(Integer.parseInt((String) txtAños_exp.getValue()));
        Emodificar.setNum_ventas(Integer.parseInt((String) txtNumVentas.getValue()));

        basep.set(Emodificar);
        JOptionPane.showMessageDialog(null, "El Comerciante fue modificado exitosamente");
        mostrarDatos(result);
        LimpiarCampos();
    }

    public void mostrarDatos(ObjectSet result) {
        DefaultTableModel model = (DefaultTableModel) jtable.getModel();
        model.setRowCount(0); // Limpiar la tabla

        if (result.size() == 0) {
            JOptionPane.showMessageDialog(null, "El Comerciante no existe");
        } else {
            while (result.hasNext()) {
                Comerciante MostrarDatos = (Comerciante) result.next();
                Object[] fila = {
                    MostrarDatos.getId_comerciante(),
                    MostrarDatos.getAños_exp(),
                    MostrarDatos.getNum_ventas(),
                    MostrarDatos.getCedula_persona()};

                model.addRow(fila);
            }
        }
    }

    public static void Cerrar_BD(ObjectContainer basep) {

        basep.close();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnmodificar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtable;
    private javax.swing.JSpinner txtAños_exp;
    private javax.swing.JTextField txtCedulaPersona;
    private javax.swing.JSpinner txtNumVentas;
    private javax.swing.JTextField txtcodC;
    // End of variables declaration//GEN-END:variables
}
