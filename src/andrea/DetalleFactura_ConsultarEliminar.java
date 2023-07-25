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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
public class DetalleFactura_ConsultarEliminar extends javax.swing.JFrame {

    /**
     * Creates new form buscar_eliminar_detallef
     */
    public DetalleFactura_ConsultarEliminar() {
        initComponents();
    }
    
    public void detallefact (ObjectContainer basep) {
        
     if (eleccion.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione una de las opciones");
        } else {

            if (eleccion.getSelectedIndex() == 2) {
                Detalle_factura bus_tec = new Detalle_factura(null,0,null,0.0,null);
                ObjectSet result = basep.get(bus_tec);
                mostrarDatos(result);

            } else {
                if (eleccion.getSelectedIndex() == 1) {
                    String opc = JOptionPane.showInputDialog("Ingrese el codigo a consultar");
                    Detalle_factura buscartcc = new Detalle_factura(opc,0,null,0.0,null);
                    ObjectSet result = basep.get(buscartcc);
                    mostrarDatos(result);

                }
            }
        }
        eleccion.setSelectedIndex(0);             
    }
    
    public void mostrarDatos(ObjectSet result) {
         
        DefaultTableModel modelo = (DefaultTableModel) tablatec.getModel();
        modelo.setRowCount(0); 

        if (result.size() == 0) {
            JOptionPane.showMessageDialog(null, "No se encontro ningun registro ");
        } else {
            while (result.hasNext()) {
                Detalle_factura mitick = (Detalle_factura) result.next();
                Object[] fila = {
                    mitick.getCod_det_fact(),
                    mitick.getCan_ticket(),
                    mitick.getCodigo_ticket(),
                    mitick.getSub_total(),
                    mitick.getCodigo_fact(),
                    };
                
                modelo.addRow(fila);
            }
        }
    }
    public void eliminardt (ObjectContainer basep) {
        Tecnico_crud Ainterfaz = new Tecnico_crud();
        if (eliminardt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese un ID");
        } else {

            String IDA = eliminardt.getText();
            Detalle_factura Abuscar = new Detalle_factura(IDA, 0, null,0.0,null);
            ObjectSet result = basep.get(Abuscar);

            if (Ainterfaz.validar (basep, IDA) == 0) {
                JOptionPane.showMessageDialog(null, "No existe un  Registro con el codigo diguitado ");

            } else {
                Ticket AsignaturaElim = (Ticket) result.next();
                basep.delete(AsignaturaElim);
                JOptionPane.showMessageDialog(null, "Registro eliminado");
            }

        }

        
        eliminardt.setText("");
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
        eleccion = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        eliminardt = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablatec = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(228, 217, 239));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "BUSCAR Y ELIMINAR DETALLE DE FACTURA ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Copperplate Gothic Light", 1, 18))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 12)); // NOI18N
        jLabel1.setText("diguite el codigo de el ticket que desea eliminar : ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, -1, 20));

        jLabel2.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 12)); // NOI18N
        jLabel2.setText("Seleccione una de las siguientes opciones : ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, 20));

        eleccion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIÓN", "CÓDIGO", "VER TODOS" }));
        jPanel1.add(eleccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 150, 20));

        jButton1.setText("BUSCAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, -1, -1));
        jPanel1.add(eliminardt, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, 190, 30));

        jButton2.setText("ELIMINAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 90, -1, -1));

        tablatec.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "CÓDIGO", "NUMERO DE TICKETS", "CÓDIGO TICKET", "SUBTOTAL", "CODIGO FACTURA"
            }
        ));
        jScrollPane1.setViewportView(tablatec);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 690, 240));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 714, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       ObjectContainer BaseD = Db4o.openFile(Tecnico_crud.direccionBD);
        detallefact(BaseD);
        Cerrar_BD(BaseD);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ObjectContainer BaseD = Db4o.openFile(Tecnico_crud.direccionBD);
        eliminardt(BaseD);
        Cerrar_BD(BaseD);
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
            java.util.logging.Logger.getLogger(DetalleFactura_ConsultarEliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetalleFactura_ConsultarEliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetalleFactura_ConsultarEliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetalleFactura_ConsultarEliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DetalleFactura_ConsultarEliminar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> eleccion;
    private javax.swing.JTextField eliminardt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablatec;
    // End of variables declaration//GEN-END:variables
}
