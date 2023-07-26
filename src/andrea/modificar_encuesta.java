/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package andrea;


import Clases.Encuesta_factura;
import com.db4o.*;
import java.util.Date;
import javax.swing.JOptionPane;
import jose.INICIO;

/**
 *
 * @author Asus
 */
public class modificar_encuesta extends javax.swing.JFrame {

    /**
     * Creates new form modificar_encuesta
     */
    public modificar_encuesta() {
        initComponents();
    }

   
     String Codigo_fact;
     Date Fecha;
     double total=0.0;
     String id_cliente;
     public void asignarVariables(ObjectContainer based){
   
     
    Codigo_fact=mcodigo.getText();
    Fecha=mfecha.getDate();
    total=Double.parseDouble(mtotal.getText());
    id_cliente=mcliente.getText();   
    
    }
    public void limpiar(){
    mcodigo.setText("");
    mfecha.setDate(null);
    mtotal.setText("");
    mcliente.setText("");
    
    }
    
    public void HabilitarCampos_deTexto() {
        
        mfecha.setEnabled(true);
        mtotal.setEditable(true);
     
    }
     
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        mcodigo = new javax.swing.JTextField();
        mfecha = new com.toedter.calendar.JDateChooser();
        mtotal = new javax.swing.JTextField();
        mcliente = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        modbtn = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(216, 207, 240));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 14)); // NOI18N
        jLabel3.setText("ID CLIENTE : ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 120, -1));

        jLabel4.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 14)); // NOI18N
        jLabel4.setText("CÓDIGO : ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 120, -1));

        jLabel5.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 14)); // NOI18N
        jLabel5.setText("FECHA : ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 120, -1));

        jLabel6.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 14)); // NOI18N
        jLabel6.setText("TOTAL : ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 110, 20));
        jPanel1.add(mcodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 170, -1));
        jPanel1.add(mfecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 170, -1));
        jPanel1.add(mtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 170, -1));
        jPanel1.add(mcliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 170, -1));

        jButton1.setText("CALCULAR ");
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 220, -1, -1));

        modbtn.setText("MODIFICAR ");
        modbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modbtnActionPerformed(evt);
            }
        });
        jPanel1.add(modbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 370, -1, -1));

        jButton3.setText("REGRESAR ");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 370, -1, -1));

        jButton4.setText("BUSCAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        ObjectContainer baseDeDatos = Db4o.openFile(jose.INICIO.direccionBD);
       try{
        modbtn.setEnabled(false);
        String auxtick;
        auxtick = mcodigo.getText();

        EncuestaFactura_crud auxtn = new EncuestaFactura_crud();

        if (mcodigo.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Ingrese el codigo ");
        } else {

            if (auxtn.comprobarEF(baseDeDatos,auxtick) == 0) {

                JOptionPane.showMessageDialog(null, "No existe un registro con este código ");
                limpiar();

            } else {

                Encuesta_factura buscarfc = new Encuesta_factura (auxtick,null,0,null);

                ObjectSet result = baseDeDatos.get(buscarfc);
                for (int i = 0; i < result.size(); i++) {

                    Encuesta_factura tick = new Encuesta_factura();

                    tick = (Encuesta_factura) result.get(i);

                    mcodigo.setText(tick.getCodigo_enc_fact());
                    mfecha.setDate(tick.getFecha());
                    mtotal.setText(String.valueOf(tick.getTotal()));
                    mcliente.setText(tick.getId_cliente());

                    modbtn.setEnabled(true); 
                    HabilitarCampos_deTexto();
                    mcodigo.setEditable(false);
                    mcliente.setEditable(false);

                }

            }

        }
       }finally{
           baseDeDatos.close();
       }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void modbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modbtnActionPerformed
        
        ObjectContainer baseDeDatos = Db4o.openFile(jose.INICIO.direccionBD);
        try{
            
        Encuesta_factura modif_tick = new Encuesta_factura(mcodigo.getText(),null,0,null);
        ObjectSet result = baseDeDatos.get(modif_tick);
        
        Encuesta_factura tickm = (Encuesta_factura) result.next();
        tickm.setTotal(Double.parseDouble(mtotal.getText()));
        tickm.setFecha(mfecha.getDate());
        
        
        
        baseDeDatos.set(tickm);
        JOptionPane.showMessageDialog(null, "Se modifico este registro");
        limpiar();
        }finally{
        
        baseDeDatos.close();
        }
    }//GEN-LAST:event_modbtnActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
        INICIO mostrar = new INICIO();
        mostrar.setVisible(true);         // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(modificar_encuesta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(modificar_encuesta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(modificar_encuesta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(modificar_encuesta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new modificar_encuesta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField mcliente;
    private javax.swing.JTextField mcodigo;
    private com.toedter.calendar.JDateChooser mfecha;
    private javax.swing.JButton modbtn;
    private javax.swing.JTextField mtotal;
    // End of variables declaration//GEN-END:variables
}
