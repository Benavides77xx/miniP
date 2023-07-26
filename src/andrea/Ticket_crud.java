
package andrea;

import Clases.Taquillero;
import Clases.Ticket;
import Clases.Tipo_ticket;
import com.db4o.ObjectContainer;
import com.db4o.Db4o;
import com.db4o.ObjectSet;
import javax.swing.JOptionPane;
import jose.INICIO;

/**
 *
 * @author Asus
 */
public class Ticket_crud extends javax.swing.JFrame {

    /**
     * Creates new form ticket_vent
     */
    public Ticket_crud() {
        initComponents();
    }
 
     String codigo_ticket;
     double precio_ticket=0.0;
     String restrccion;
     String codigo_tipo_ticket;
     String id_taquillero;
     
     public void asignarVariables(ObjectContainer based){
   
     codigo_ticket= codigot.getText();
     precio_ticket=Double.parseDouble(preciot.getText());
     restrccion=rest.getText();
     codigo_tipo_ticket=tipot.getText();
     id_taquillero=taquilleroid.getText();
    }
    public void limpiar(){
     codigot.setText("");
     preciot.setText("");
     rest.setText("");
     tipot.setText("");
     taquilleroid.setText("");
    }
    public void crearticket(ObjectContainer BaseD) {
        asignarVariables(BaseD);
              boolean error=false;
            if (comprobarTicket(BaseD, codigo_ticket) != 0) {
                error = true;
                JOptionPane.showMessageDialog(this, "Ya existe un ticket con este codigo registrado","ERROR",0);     
            } else {
                codigot.setText("");
            }       
            if (comprobarTipoTicket(BaseD,codigo_tipo_ticket) == 0) {
                error = true;
                JOptionPane.showMessageDialog(null, "No existe Tiopo de ticket con este codigo registrado");
            }       
            if (comprobarTaquillero(BaseD,id_taquillero) == 0 ) {
                error = true;
                JOptionPane.showMessageDialog(null, "No existe ningun Taquillero con este ID registrado");
            }
            
            if (!error) {
                Ticket miticket = new Ticket(codigo_ticket,precio_ticket,restrccion, codigo_tipo_ticket,id_taquillero);
                BaseD.set(miticket);
                JOptionPane.showMessageDialog(null, "Ticket registrado correctamente");
                limpiar();
        }  
    }
    
    public static int comprobarTicket(ObjectContainer base, String codigo_ticket) {
            Ticket buscarM = new Ticket(codigo_ticket, 0, null, null, null);
            ObjectSet result = base.get(buscarM);
            return result.size();
    }
    public static int comprobarTipoTicket(ObjectContainer basep, String codigo_tipo_ticket) {

            ObjectSet result = basep.get(new Tipo_ticket(codigo_tipo_ticket, null, 0));
            return result.size();
    }        
    public static int comprobarTaquillero(ObjectContainer basep, String id_taquillero) {

            ObjectSet result = basep.get(new Taquillero(id_taquillero,null, null, 0, null, null, null, null, null, 0, null, null, null, null, null, null));          
            return result.size();
    }

        

    public static void Cerrar_BD(ObjectContainer based) {
        based.close();
    }  
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField4 = new javax.swing.JTextField();
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jTextField4.setText("jTextField4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(207, 207, 240));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TICKET ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Copperplate Gothic Light", 1, 18))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("*ID TAQUILLERO : ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 140, 20));

        jLabel2.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("CÓDIGO TICKET  : ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 140, 20));

        jLabel3.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("PRECIO DE TICKET : ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 140, 20));

        jLabel4.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("RESTRICCIÓN : ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 140, 20));

        jLabel5.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("*COD_TIPO _TICKET : ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 140, 20));
        jPanel1.add(codigot, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 150, -1));
        jPanel1.add(preciot, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 150, -1));
        jPanel1.add(rest, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 150, -1));
        jPanel1.add(tipot, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, 150, -1));
        jPanel1.add(taquilleroid, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 280, 150, -1));

        jButton1.setText("GUARDAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, -1, -1));

        jButton2.setText("REGRESAR ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 340, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ObjectContainer BaseD = Db4o.openFile(INICIO.direccionBD);
        crearticket(BaseD);
        Cerrar_BD(BaseD);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
        INICIO mostrar = new INICIO();
        mostrar.setVisible(true);         // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(Ticket_crud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ticket_crud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ticket_crud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ticket_crud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ticket_crud().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField codigot;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField preciot;
    private javax.swing.JTextField rest;
    private javax.swing.JTextField taquilleroid;
    private javax.swing.JTextField tipot;
    // End of variables declaration//GEN-END:variables
}
