/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package andrea;


import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class DetalleFactura_modificar extends javax.swing.JFrame {

    /**
     * Creates new form modificar_detallef
     */
    public DetalleFactura_modificar() {
        initComponents();
    }

    String cod_det_fact;
    int cantidad_ticket=0;
    String codigo_ticket;
    double sub_total=0.0;
    String codigo_fact;
    
    public void asignarVariables(ObjectContainer based){
   
     
    cod_det_fact=codigodt.getText();
    cantidad_ticket=Integer.parseInt(numerodt.getText());
    codigo_ticket=codigo2dt.getText();
    sub_total=Double.parseDouble(subtdt.getText());
    codigo_fact=codigo3dt.getText();   
    
    }
    public void limpiar(){
    codigodt.setText("");
    numerodt.setText("");
    codigo2dt.setText("");
    subtdt.setText("");
    codigo3dt.setText("");
    }
    
    public void HabilitarCampos_deTexto() {
        
        numerodt.setEditable(true);
        subtdt.setEditable(true);
     
    }
    
    public void buscar(ObjectContainer BaseD) {

        modbtn.setEnabled(false);
        String auxtick;
        auxtick = codigodt.getText();

        Ticket_crud auxtn = new Ticket_crud();

        if (codigodt.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Ingrese el codigo ");
        } else {

            if (auxtn.validar(BaseD,auxtick) == 0) {

                JOptionPane.showMessageDialog(null, "No existe un registro con este código ");
                limpiar();

            } else {

                Detalle_factura buscartc = new Detalle_factura(auxtick, 0, null, 0.0, null);

                ObjectSet result = BaseD.get(buscartc);
                for (int i = 0; i < result.size(); i++) {

                    Detalle_factura tick = new Detalle_factura();

                    tick = (Detalle_factura) result.get(i);

                    codigodt.setText(tick.getCod_det_fact());
                    numerodt.setText(String.valueOf(tick.getCan_ticket()));
                    codigo2dt.setText(tick.getCodigo_ticket());
                    subtdt.setText(String.valueOf(tick.getSub_total()));
                    codigo3dt.setText(tick.getCodigo_fact());

                    modbtn.setEnabled(true); 
                    HabilitarCampos_deTexto();
                    codigodt.setEditable(false);
                    codigo2dt.setEditable(false);
                    codigo3dt.setEditable(false);

                }

            }

        }
    }
    
    public void modificar_tick(ObjectContainer BaseD) {

        Detalle_factura modif_tick = new Detalle_factura(cod_det_fact,0,null,0.0,null);
        ObjectSet result = BaseD.get(modif_tick);
        Detalle_factura tickm = (Detalle_factura) result.next();
        
        
        tickm.setSub_total(Double.parseDouble(subtdt.getText()));
        tickm.setCan_ticket(Integer.parseInt(numerodt.getText()));
        
        
        ;
        BaseD.set(tickm);
        JOptionPane.showMessageDialog(null, "Se modifico este registro");
        limpiar();
    }
    public static int validar(ObjectContainer BaseD, String cod_det_fac) {
        Detalle_factura buscartic = new Detalle_factura (cod_det_fac,0, null, 0.0,null);
        ObjectSet result = BaseD.get(buscartic);
        return result.size();
    }
    public static void Cerrar_BD(ObjectContainer basep) {
        basep.close();
    } 
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        codigodt = new javax.swing.JTextField();
        numerodt = new javax.swing.JTextField();
        codigo2dt = new javax.swing.JTextField();
        subtdt = new javax.swing.JTextField();
        codigo3dt = new javax.swing.JTextField();
        modbtn = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        jTextField2.setText("jTextField2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(231, 210, 244));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "MODIFICAR DETALLE DE FACTURA ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Copperplate Gothic Light", 1, 18))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 14)); // NOI18N
        jLabel2.setText("CÓDIGO : ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, 30));

        jLabel3.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 13)); // NOI18N
        jLabel3.setText("NÚMERO DE TICKETS : ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, -1, 30));

        jLabel4.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 13)); // NOI18N
        jLabel4.setText("CÓDIGO DE TICKETS : ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, -1, 30));

        jLabel5.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 14)); // NOI18N
        jLabel5.setText("SUBTOTAL  : ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, -1, 30));

        jLabel6.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 14)); // NOI18N
        jLabel6.setText("CÓDIGO  FACTURA : ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, -1, 30));
        jPanel1.add(codigodt, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 190, 30));
        jPanel1.add(numerodt, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 190, 30));

        codigo2dt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigo2dtActionPerformed(evt);
            }
        });
        jPanel1.add(codigo2dt, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, 190, 30));
        jPanel1.add(subtdt, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 250, 190, 30));
        jPanel1.add(codigo3dt, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, 190, 30));

        modbtn.setText("MODIFICAR");
        modbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modbtnActionPerformed(evt);
            }
        });
        jPanel1.add(modbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 380, -1, -1));

        jButton2.setText("BUSCAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 90, -1, -1));

        jButton3.setText("REGRESAR ");
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 380, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void codigo2dtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigo2dtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigo2dtActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ObjectContainer BaseD = Db4o.openFile(Tecnico_crud.direccionBD);
        buscar(BaseD);
        Cerrar_BD(BaseD);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void modbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modbtnActionPerformed
        ObjectContainer BaseD = Db4o.openFile(Tecnico_crud.direccionBD);
        modificar_tick(BaseD);
        Cerrar_BD(BaseD);
        codigodt.setEditable(true);
    }//GEN-LAST:event_modbtnActionPerformed

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
            java.util.logging.Logger.getLogger(DetalleFactura_modificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetalleFactura_modificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetalleFactura_modificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetalleFactura_modificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DetalleFactura_modificar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField codigo2dt;
    private javax.swing.JTextField codigo3dt;
    private javax.swing.JTextField codigodt;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JButton modbtn;
    private javax.swing.JTextField numerodt;
    private javax.swing.JTextField subtdt;
    // End of variables declaration//GEN-END:variables
}
