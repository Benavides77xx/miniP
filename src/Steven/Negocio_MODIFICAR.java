/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Steven;

import ClasesSteven.Negocio;
import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jose.INICIO;

/**
 *
 * @author Steven Zhicay
 */
public class Negocio_MODIFICAR extends javax.swing.JFrame {

    /**
     * Creates new form Negocio_MODIFICAR
     */
    public Negocio_MODIFICAR() {
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
        jLabel3 = new javax.swing.JLabel();
        txtTipoNegocio = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtdescripcion = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Modificar Negocio");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 20, 760, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("*Codigo Especialidad:");
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
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 410, 130, 40));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Tipo Negocio:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, -1, -1));

        txtTipoNegocio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtTipoNegocio, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, 200, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Descripcion");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 200, -1, -1));

        txtdescripcion.setColumns(20);
        txtdescripcion.setRows(5);
        txtdescripcion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane2.setViewportView(txtdescripcion);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 220, 190, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 766, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ObjectContainer BaseD = Db4o.openFile(INICIO.direccionBD);
        buscar(BaseD);
        Cerrar_BD(BaseD);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarActionPerformed
        ObjectContainer BaseD = Db4o.openFile(INICIO.direccionBD);
        Modificar_Negocio(BaseD);
        Cerrar_BD(BaseD);
        txtcodC.setEditable(true);
    }//GEN-LAST:event_btnmodificarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        INICIO ini = new INICIO();
        ini.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Negocio_MODIFICAR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Negocio_MODIFICAR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Negocio_MODIFICAR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Negocio_MODIFICAR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Negocio_MODIFICAR().setVisible(true);
            }
        });
    }

    public void LimpiarCampos() {
        txtcodC.setText("");
        txtdescripcion.setText("");
        txtTipoNegocio.setText("");
        

    }

    public void HabilitarCampos_deTexto() {
        
        txtdescripcion.setEditable(true);
        txtTipoNegocio.setEditable(true);
        
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

                JOptionPane.showMessageDialog(null, "El negocio no existe en la base de datos");
                LimpiarCampos();

            } else {

                Negocio Ebuscar = new Negocio(codC, null, null);

                ObjectSet result = basep.get(Ebuscar);
                for (int i = 0; i < result.size(); i++) {

                    Negocio miE = new Negocio();

                    miE = (Negocio) result.get(i);
                    txtcodC.setText(miE.getCod_negocio());
                    txtTipoNegocio.setText(miE.getTipo_negocio());
                    txtdescripcion.setText(miE.getDescripcion());
                    

                    btnmodificar.setEnabled(true);
                    //Hacer editable los campos de texto
                    
                    HabilitarCampos_deTexto();
                    txtcodC.setEditable(false);
                }

            }

        }
    }

    public void Modificar_Negocio(ObjectContainer basep) {

        Negocio Emodi = new Negocio(txtcodC.getText(), null, null);
        ObjectSet result = basep.get(Emodi);

        Negocio Emodificar = (Negocio) result.next();
        Emodificar.setTipo_negocio(txtTipoNegocio.getText());
        Emodificar.setDescripcion(txtdescripcion.getText());
        

        basep.set(Emodificar);
        JOptionPane.showMessageDialog(null, "El negocio fue modificado exitosamente");
        
        LimpiarCampos();
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
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtTipoNegocio;
    private javax.swing.JTextField txtcodC;
    private javax.swing.JTextArea txtdescripcion;
    // End of variables declaration//GEN-END:variables
}
