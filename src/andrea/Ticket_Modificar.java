/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package andrea;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import javax.swing.JOptionPane;
import andrea.Ticket;
import com.db4o.Db4o;

/**
 *
 * @author Asus
 */
public class Ticket_Modificar extends javax.swing.JFrame {

    /**
     * Creates new form modif_tick
     */
    public Ticket_Modificar() {
        initComponents();
    }
    
     String codigo_ticket;
     double precio_ticket;
     String restrccion;
     String tipo_ticket;
     String id_taquillero;
     
     public void asignarVariables(ObjectContainer BaseD){
   
     codigo_ticket= codigot.getText();
     precio_ticket=Double.parseDouble(preciot.getText());
     restrccion=rest.getText();
     tipo_ticket=tipot.getText();
     id_taquillero=taquilleroid.getText();
    }
    public void limpiar(){
     codigot.setText("");
     preciot.setText("");
     rest.setText("");
     tipot.setText("");
     taquilleroid.setText("");
    }
    public void HabilitarCampos_deTexto() {
        
        preciot.setEditable(true);
        rest.setEditable(true);
        tipot.setEditable(true);

    }
    
    public void buscar(ObjectContainer BaseD) {

        modbtn.setEnabled(false);
        String auxtick;
        auxtick = codigot.getText();

        Ticket_crud auxtn = new Ticket_crud();

        if (codigot.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Ingrese el ID del ticket");
        } else {

            if (auxtn.validar(BaseD,auxtick) == 0) {

                JOptionPane.showMessageDialog(null, "No existe un registro con este código ");
                limpiar();

            } else {

                Ticket buscartc = new Ticket(auxtick, 0, null, null, null);

                ObjectSet result = BaseD.get(buscartc);
                for (int i = 0; i < result.size(); i++) {

                    Ticket tick = new Ticket();

                    tick = (Ticket) result.get(i);

                    codigot.setText(tick.getCodigo_ticket());
                    preciot.setText(String.valueOf(tick.getPrecio_ticket()));
                    rest.setText(tick.getRestrccion());
                    tipot.setText(tick.getTipo_ticket());
                    taquilleroid.setText(tick.getId_taquillero());

                    modbtn.setEnabled(true); 
                    HabilitarCampos_deTexto();
                    codigot.setEditable(false);
                    taquilleroid.setEditable(false);

                }

            }

        }
    }
    public void modificar_tick(ObjectContainer BaseD) {

        Ticket modif_tick = new Ticket (codigo_ticket,0,null,null,null);
        ObjectSet result = BaseD.get(modif_tick);
        Ticket tickm = (Ticket) result.next();
        
        
        tickm.setPrecio_ticket(Double.parseDouble(preciot.getText()));
        tickm.setRestrccion(rest.getText());
        tickm.setTipo_ticket(tipot.getText());
        
        ;
        BaseD.set(tickm);
        JOptionPane.showMessageDialog(null, "Se modifico este registro");
        limpiar();
    }
    public static int validar(ObjectContainer BaseD, String codigo_ticket) {
        Ticket buscartic = new Ticket(codigo_ticket,0.0, null, null,null);
        ObjectSet result = BaseD.get(buscartic);
        return result.size();
    }
    public static void Cerrar_BD(ObjectContainer basep) {
        basep.close();
    }  

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        codigot = new javax.swing.JTextField();
        preciot = new javax.swing.JTextField();
        rest = new javax.swing.JTextField();
        tipot = new javax.swing.JTextField();
        taquilleroid = new javax.swing.JTextField();
        buscbt = new javax.swing.JButton();
        modbtn = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(208, 192, 221));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "MODIFICAR TICKET", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Copperplate Gothic Light", 1, 18))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 12)); // NOI18N
        jLabel1.setText("PRECIO TICKET  : ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        jLabel2.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 12)); // NOI18N
        jLabel2.setText("RESTRICCIONES : ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        jLabel3.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 12)); // NOI18N
        jLabel3.setText("CÓDIGO  TIPO DE JUEGO :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, -1));

        jLabel4.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 12)); // NOI18N
        jLabel4.setText("ID TAQUILLERO : ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, -1, -1));

        jLabel5.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 12)); // NOI18N
        jLabel5.setText("CÓDIGO TICKET  : ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));
        jPanel1.add(codigot, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 190, -1));
        jPanel1.add(preciot, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 190, -1));
        jPanel1.add(rest, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, 190, -1));
        jPanel1.add(tipot, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, 190, -1));
        jPanel1.add(taquilleroid, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 290, 190, -1));

        buscbt.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 12)); // NOI18N
        buscbt.setText("BUSCAR");
        buscbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscbtActionPerformed(evt);
            }
        });
        jPanel1.add(buscbt, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, -1, -1));

        modbtn.setText("MODIFICAR");
        modbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modbtnActionPerformed(evt);
            }
        });
        jPanel1.add(modbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 360, -1, -1));

        jButton2.setText("REGRESAR");
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 360, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscbtActionPerformed
        ObjectContainer BaseD = Db4o.openFile(Tecnico_crud.direccionBD);
        buscar(BaseD);
        Cerrar_BD(BaseD);        
    }//GEN-LAST:event_buscbtActionPerformed

    private void modbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modbtnActionPerformed
        ObjectContainer BaseD = Db4o.openFile(Tecnico_crud.direccionBD);
        modificar_tick(BaseD);
        Cerrar_BD(BaseD);
        codigot.setEditable(true);
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
            java.util.logging.Logger.getLogger(Ticket_Modificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ticket_Modificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ticket_Modificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ticket_Modificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ticket_Modificar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscbt;
    private javax.swing.JTextField codigot;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton modbtn;
    private javax.swing.JTextField preciot;
    private javax.swing.JTextField rest;
    private javax.swing.JTextField taquilleroid;
    private javax.swing.JTextField tipot;
    // End of variables declaration//GEN-END:variables
}
