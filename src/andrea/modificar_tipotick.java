/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package andrea;


import Clases.Tipo_ticket;
import com.db4o.*;
import andrea.TipoTicket_crud;
import javax.swing.JOptionPane;
import jose.INICIO;
/**
 *
 * @author Asus
 */
public class modificar_tipotick extends javax.swing.JFrame {

    /**
     * Creates new form modificar_tipotick
     */
    public modificar_tipotick() {
        initComponents();
    }

    String codigo_tipo_ticket;
    String tipo_ticket;
    int capacidad=0;
    
    public void asignarVariables(ObjectContainer based){
   
     codigo_tipo_ticket= codigott1.getText();
     tipo_ticket=tipot1.getText();
     capacidad = Integer.parseInt(capacidadtt1.getText());
    }
    
    public void limpiar(){
     codigott1.setText("");
     tipot1.setText("");
     capacidadtt1.setText("");
     
    }
    
    public void HabilitarCampos_deTexto() {
        
        tipot1.setEditable(true);
        capacidadtt1.setEditable(true);
    }
    
    public void buscar(ObjectContainer based) {

        modificartt.setEnabled(false);
        String IDAux;
        IDAux = codigott1.getText();

        TipoTicket_crud EAux = new TipoTicket_crud();

        if (codigott1.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Ingrese el codigo ");
        } else {

            if (EAux.comprobarTipoTicket(based, IDAux) == 0) {

                JOptionPane.showMessageDialog(null, "No existe ningunregistro con este codigo ");
                limpiar();

            } else {

                Tipo_ticket Ebuscar = new Tipo_ticket(IDAux, null,0);

                ObjectSet result = based.get(Ebuscar);
                for (int i = 0; i < result.size(); i++) {
                    
                    Tipo_ticket miE = new Tipo_ticket();
                    
                    miE = (Tipo_ticket) result.get(i); 
                    
                    codigott1.setText(miE.getCodigo_tipo_ticket());
                    tipot1.setText(miE.getTipo_ticket());
                    capacidadtt1.setText(String.valueOf(miE.getCapacidad()));;

                    modificartt.setEnabled(true);
                    //Hacer editable los campos de texto
                    HabilitarCampos_deTexto();
                    codigott1.setEditable(false);
                }

            }

        }
    }
    
     public void modificar_tipot(ObjectContainer based) {

        
        Tipo_ticket Emodi = new Tipo_ticket(codigott1.getText(), null,0 );
        ObjectSet result = based.get(Emodi);
        
        Tipo_ticket Emodificar = (Tipo_ticket) result.next();
        
        Emodificar.setTipo_ticket(tipot1.getText());
        Emodificar.setCapacidad(Integer.parseInt(capacidadtt1.getText()));

        based.set(Emodificar);
        JOptionPane.showMessageDialog(null, "Registro modificado exitosamente ");
        
        
    
        limpiar();
    }
    
    
    public static void Cerrar_BD(ObjectContainer based) {
        based.close();
    } 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        codigott1 = new javax.swing.JTextField();
        tipot1 = new javax.swing.JTextField();
        capacidadtt1 = new javax.swing.JTextField();
        buscartt = new javax.swing.JButton();
        modificartt = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(222, 205, 239));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TIPO TICKET MODIFICAR ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Copperplate Gothic Light", 1, 12))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 14)); // NOI18N
        jLabel1.setText("CAPACIDAD : ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        jLabel2.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 14)); // NOI18N
        jLabel2.setText("CÓDIGO  : ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        jLabel3.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 14)); // NOI18N
        jLabel3.setText("TIPO TICKET  : ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));
        jPanel1.add(codigott1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 160, -1));
        jPanel1.add(tipot1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 160, -1));
        jPanel1.add(capacidadtt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 160, -1));

        buscartt.setText("BUSCAR ");
        buscartt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarttActionPerformed(evt);
            }
        });
        jPanel1.add(buscartt, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, -1, -1));

        modificartt.setText("MODIFICAR ");
        modificartt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarttActionPerformed(evt);
            }
        });
        jPanel1.add(modificartt, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, -1, -1));

        jButton3.setText("REGRESAR ");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void modificarttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarttActionPerformed
        ObjectContainer BaseD = Db4o.openFile(jose.INICIO.direccionBD);
        modificar_tipot(BaseD);
        Cerrar_BD(BaseD);
        codigott1.setEditable(true);
    }//GEN-LAST:event_modificarttActionPerformed

    private void buscarttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarttActionPerformed
        ObjectContainer BaseD = Db4o.openFile(jose.INICIO.direccionBD);
        buscar(BaseD);
        Cerrar_BD(BaseD);         
    }//GEN-LAST:event_buscarttActionPerformed

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
            java.util.logging.Logger.getLogger(modificar_tipotick.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(modificar_tipotick.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(modificar_tipotick.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(modificar_tipotick.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new modificar_tipotick().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscartt;
    private javax.swing.JTextField capacidadtt1;
    private javax.swing.JTextField codigott1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton modificartt;
    private javax.swing.JTextField tipot1;
    // End of variables declaration//GEN-END:variables
}
