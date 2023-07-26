/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package andrea;
import Clases.Detalle_factura;
import Clases.Encuesta_factura;
import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import java.util.Date;
import javax.swing.JOptionPane;
import jose.INICIO;

/**
 *
 * @author Asus
 */
public class DetalleFactura_crud extends javax.swing.JFrame {

    /**
     * Creates new form detalle_fact_vent
     */
    public DetalleFactura_crud() {
        initComponents();
    }
    String cod_det_fact="";
    int cantidad_ticket=0;
    String codigo_ticket="";
    double sub_total=0;
    String codigo_enc_fact="";
    
    public void asignarVariables(ObjectContainer BaseD){

    cod_det_fact=codigodt.getText();
    cantidad_ticket=(Integer) numerodt.getValue();;
    codigo_ticket=codigo2dt.getText();
    sub_total=Double.parseDouble(subtdt.getText());
    codigo_enc_fact=codigo3dt.getText();   
    
    }
    public void limpiar(){
    codigodt.setText("");
    numerodt.setValue(0);
    codigo2dt.setText("");
    subtdt.setText("");
    codigo3dt.setText("");
    }
    
    public void crearDT(ObjectContainer BaseD) {
        
        asignarVariables(BaseD);
        
         boolean error = false;
        if (comprobarDT(BaseD, cod_det_fact) != 0) {
            error = true;
            JOptionPane.showMessageDialog(this, "Ya existe un detalle de factura con este codigo", "ERROR", JOptionPane.ERROR_MESSAGE);
            
        } else if (comprobarEncuesta(BaseD, codigo_enc_fact) == 0) {
            error = true;
            JOptionPane.showMessageDialog(null, "No existe ninguna Encuesta de factura con este codigo", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

        if (!error) {
            Detalle_factura miC = new Detalle_factura (cod_det_fact,cantidad_ticket,sub_total,codigo_ticket,codigo_enc_fact);
            BaseD.set(miC);
            JOptionPane.showMessageDialog(null, "Detalle registrado correctamente");
            limpiar();
        }
    }
    
   public static int comprobarDT(ObjectContainer base, String cod_det_fact) {
        Detalle_factura Buscar = new Detalle_factura(cod_det_fact, 0,0, null,null);
        ObjectSet result = base.get(Buscar);
        return result.size();
    }

    public static int comprobarEncuesta(ObjectContainer basep, String codigo_enc_fact) {
        ObjectSet result = basep.get(new Encuesta_factura(codigo_enc_fact, null, 0, null));
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
        subdt = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        codigodt = new javax.swing.JTextField();
        codigo2dt = new javax.swing.JTextField();
        subtdt = new javax.swing.JTextField();
        codigo3dt = new javax.swing.JTextField();
        btnguardar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        numerodt = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(226, 217, 240));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DETALLE DE FACTURA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Copperplate Gothic Light", 1, 14))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 14)); // NOI18N
        jLabel1.setText("número de tckets :  ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 150, 150, -1));

        jLabel2.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 12)); // NOI18N
        jLabel2.setText("CÓDIGO del ticket : ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 140, -1));

        subdt.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 14)); // NOI18N
        subdt.setText("SUBTOTAL  : ");
        jPanel1.add(subdt, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

        jLabel4.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 14)); // NOI18N
        jLabel4.setText("CÓDIGO  FACTURA : ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, -1, -1));

        jLabel5.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 14)); // NOI18N
        jLabel5.setText("CÓDIGO Det : ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));
        jPanel1.add(codigodt, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 160, 30));
        jPanel1.add(codigo2dt, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, 160, 30));
        jPanel1.add(subtdt, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 160, 30));
        jPanel1.add(codigo3dt, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, 160, 30));

        btnguardar.setText("GUARDAR");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 360, -1, -1));

        jButton2.setText("REGRESAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 360, -1, -1));
        jPanel1.add(numerodt, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 160, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
       ObjectContainer BaseD = Db4o.openFile(INICIO.direccionBD);
        crearDT(BaseD);
        Cerrar_BD(BaseD);
    }//GEN-LAST:event_btnguardarActionPerformed

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
            java.util.logging.Logger.getLogger(DetalleFactura_crud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetalleFactura_crud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetalleFactura_crud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetalleFactura_crud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DetalleFactura_crud().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnguardar;
    private javax.swing.JTextField codigo2dt;
    private javax.swing.JTextField codigo3dt;
    private javax.swing.JTextField codigodt;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner numerodt;
    private javax.swing.JLabel subdt;
    private javax.swing.JTextField subtdt;
    // End of variables declaration//GEN-END:variables
}
