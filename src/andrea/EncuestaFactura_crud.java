
package andrea;

import Clases.Cliente;
import Clases.Encuesta_factura;
import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import java.util.Date;
import javax.swing.JOptionPane;
import jose.INICIO;
public class EncuestaFactura_crud extends javax.swing.JFrame {

    private String Codigo_enc_fact;
    private Date Fecha;
    private double total;
    private String id_cliente;
    
    public EncuestaFactura_crud() {
        initComponents();
    }
    public void asignarVariables(ObjectContainer basep){
    Codigo_enc_fact=txtcod.getText();
    Fecha = dateFecha.getDate();
    total = Double.parseDouble(txttotal.getText());
    id_cliente=txtidcliente.getText();
    }
    public void LimpiarCampos(){
        txtcod.setText("");
        dateFecha.setCalendar(null);
        txttotal.setText("");
        txtidcliente.setText("");
    }
    
    public void crearEF(ObjectContainer BaseD) {
        
        asignarVariables(BaseD);
        
         boolean error = false;
        if (comprobarEF(BaseD, Codigo_enc_fact) != 0) {
            error = true;
            JOptionPane.showMessageDialog(this, "Ya existe una Encuesta de factura con este codigo", "ERROR", JOptionPane.ERROR_MESSAGE);
            
        } else if (comprobarCliente(BaseD, id_cliente) == 0) {
            error = true;
            JOptionPane.showMessageDialog(null, "No existe ningun cliente con este codigo", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        if (!error) {
            Encuesta_factura miC = new Encuesta_factura (Codigo_enc_fact,Fecha,total,id_cliente);
            BaseD.set(miC);
            JOptionPane.showMessageDialog(null, "Encuesta registrado correctamente");
            LimpiarCampos();
        }
    }
    
   public static int comprobarEF(ObjectContainer base, String Codigo_enc_fact) {
        Encuesta_factura Buscar = new Encuesta_factura(Codigo_enc_fact, null,0, null);
        ObjectSet result = base.get(Buscar);
        return result.size();
    }

    public static int comprobarCliente(ObjectContainer basep, String id_cliente) {
        ObjectSet result = basep.get(new Cliente(id_cliente,null,null,null, null, null,0,null,null,null,null,null,null));
        return result.size();
    }

    
    public static void Cerrar_BD(ObjectContainer basep) {

        basep.close();
    }   
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        registrare = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtcod = new javax.swing.JTextField();
        txtidcliente = new javax.swing.JTextField();
        dateFecha = new com.toedter.calendar.JDateChooser();
        txttotal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(238, 216, 249));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 14)); // NOI18N
        jLabel1.setText("ID CLIENTE : ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

        jLabel3.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 14)); // NOI18N
        jLabel3.setText("CÓDIGO : ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

        jLabel4.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 14)); // NOI18N
        jLabel4.setText("FECHA : ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        jLabel5.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 14)); // NOI18N
        jLabel5.setText("TOTAL : ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        registrare.setText("REGISTRAR ");
        registrare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrareActionPerformed(evt);
            }
        });
        jPanel1.add(registrare, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, -1));

        jButton2.setText("REGRESAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, -1, -1));
        jPanel1.add(txtcod, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 150, -1));
        jPanel1.add(txtidcliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 150, -1));
        jPanel1.add(dateFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 150, -1));
        jPanel1.add(txttotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 150, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("ENCUESTA FACTURA");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
        INICIO mostrar = new INICIO();
        mostrar.setVisible(true);         
    }//GEN-LAST:event_jButton2ActionPerformed

    private void registrareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrareActionPerformed
        ObjectContainer BaseD = Db4o.openFile(INICIO.direccionBD);
        crearEF(BaseD);
        Cerrar_BD(BaseD);
    }//GEN-LAST:event_registrareActionPerformed

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
            java.util.logging.Logger.getLogger(EncuestaFactura_crud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EncuestaFactura_crud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EncuestaFactura_crud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EncuestaFactura_crud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EncuestaFactura_crud().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser dateFecha;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton registrare;
    private javax.swing.JTextField txtcod;
    private javax.swing.JTextField txtidcliente;
    private javax.swing.JTextField txttotal;
    // End of variables declaration//GEN-END:variables
}
