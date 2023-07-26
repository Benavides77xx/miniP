/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package andrea;
import Clases.Ticket;
import Clases.Tipo_ticket;
import com.db4o.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jose.INICIO;

/**
 *
 * @author Asus
 */
public class TipoTicket_ConsultarEliminar extends javax.swing.JFrame {

    /**
     * Creates new form buuscar_eliminar_tipotick
     */
    public TipoTicket_ConsultarEliminar() {
        initComponents();
    }

    public void Filtro (ObjectContainer basep) {
        
     if (elecciontt.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione una de las opciones");
        } else {

            if (elecciontt.getSelectedIndex() == 2) {
                Tipo_ticket bus_tec = new Tipo_ticket(null,null,0);
                ObjectSet result = basep.get(bus_tec);
                mostrarDatos(result);

            } else {
                if (elecciontt.getSelectedIndex() == 1) {
                    String codigo_tt = JOptionPane.showInputDialog("Ingrese el codigo a consultar");
                    Tipo_ticket buscartcc = new Tipo_ticket(codigo_tt,null,0);
                    ObjectSet result = basep.get(buscartcc);
                    mostrarDatos(result);

                }
            }
        }
        elecciontt.setSelectedIndex(0);             
    }
    public void mostrarDatos(ObjectSet result) {
         
        DefaultTableModel modelo = (DefaultTableModel) tablatt.getModel();
        modelo.setRowCount(0); 

        if (result.size() == 0) {
            JOptionPane.showMessageDialog(null, "No se encontro ningun registro ");
        } else {
            while (result.hasNext()) {
                Tipo_ticket mitickt = (Tipo_ticket) result.next();
                Object[] fila = {
                    mitickt.getCodigo_tipo_ticket(),
                    mitickt.getTipo_ticket(),
                    mitickt.getCapacidad(),
                    
                    };
                
                modelo.addRow(fila);
            }
        }
    }
//    public void Eliminartt(ObjectContainer basep) {
//        
//        Tecnico_vent Ainterfaz = new Tecnico_vent();
//        if (eliminartxt.getText().isEmpty()) {
//            JOptionPane.showMessageDialog(null, "Ingrese el código");
//        } else {
//
//            String IDA = eliminartxt.getText();
//            tipoticket Abuscar = new tipoticket (IDA,null,0);
//            ObjectSet result = basep.get(Abuscar);
//
//            if (Ainterfaz.validar(basep, IDA) == 0) {
//                JOptionPane.showMessageDialog(null, "No existen registro con el  id especificado ");
//
//            } else {
//                tipoticket AsignaturaElim = (tipoticket) result.next();
//                basep.delete(AsignaturaElim);
//                JOptionPane.showMessageDialog(null, "Registro eliminado");
//            }
//
//        }
//
//        
//        eliminartxt.setText("");
//    }
    public static void Cerrar_BD(ObjectContainer basep) {

        basep.close();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        buscartt = new javax.swing.JButton();
        eliminartxt = new javax.swing.JTextField();
        eliminartt = new javax.swing.JButton();
        elecciontt = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablatt = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();

        jLabel2.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 12)); // NOI18N
        jLabel2.setText("Seleccione una de las siguientes opciones : ");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(208, 192, 233));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "BUSCAR Y ELIMINAR TIPO TICKETS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Copperplate Gothic Light", 1, 12))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 12)); // NOI18N
        jLabel1.setText("Seleccione una de las siguientes opciones : ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 308, -1));

        buscartt.setText("BUSCAR");
        buscartt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarttActionPerformed(evt);
            }
        });
        jPanel1.add(buscartt, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, 90, -1));
        jPanel1.add(eliminartxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 170, 30));

        eliminartt.setText("ELIMINAR ");
        eliminartt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarttActionPerformed(evt);
            }
        });
        jPanel1.add(eliminartt, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 90, -1));

        elecciontt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIÓN", "CÓDIGO TIPO TEXTO", "VER TODOS" }));
        jPanel1.add(elecciontt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 166, -1));

        jLabel3.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 12)); // NOI18N
        jLabel3.setText("Seleccione una de las siguientes opciones : ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 308, -1));

        tablatt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "CÓDIGO ", "TIPO DE TICKET", "CAPACIDAD "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablatt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablattMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablatt);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 480, 90));

        jButton3.setText("REGRESAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 40, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarttActionPerformed
     ObjectContainer BaseD = Db4o.openFile(INICIO.direccionBD);
     Filtro(BaseD);
     Cerrar_BD(BaseD); 
    }//GEN-LAST:event_buscarttActionPerformed

    private void eliminarttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarttActionPerformed
        
        String codigo_tt = eliminartxt.getText();
        
                // Abre la base de datos
                ObjectContainer baseDeDatos = Db4o.openFile(INICIO.direccionBD);
        
                try {
                    
                     // Verifica si existen tickets asociados a este tipo de ticket
                   Ticket cass = new Ticket(null, 0, null, codigo_tt,null );
                ObjectSet result = baseDeDatos.get(cass);
                 if (result.size() > 0) {
                JOptionPane.showMessageDialog(this, "No se puede eliminar el tipo tikcet por que existen tickets asociados","ERROR",0);
                  return;
                   }
                    
                    
                    
                        // Busca el Tipo ticket a eliminar
                        Tipo_ticket cliente = new Tipo_ticket(codigo_tt, null, 0);
                        ObjectSet cassResult = baseDeDatos.get(cliente);
            
                        if (cassResult.size() == 0) {
                                JOptionPane.showMessageDialog(null, "El Tipo Ticket no existe");
                            } else {
                                // Elimina el Mantenimiento encontrado
                                baseDeDatos.delete(cassResult.get(0));
                                JOptionPane.showMessageDialog(null, "El Tipo Ticket se ha eliminado correctamente");
                
                                // Actualiza la tabla después de eliminar el cliente
                                Filtro(baseDeDatos);
                            }
                    } finally {
                        // Cierra la base de datos
            
                        baseDeDatos.close();
                    }  
                //
    }//GEN-LAST:event_eliminarttActionPerformed

    private void tablattMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablattMouseClicked
                  int i = tablatt.getSelectedRow();
                eliminartxt.setText(tablatt.getValueAt(i, 0).toString());
    }//GEN-LAST:event_tablattMouseClicked

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
            java.util.logging.Logger.getLogger(TipoTicket_ConsultarEliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TipoTicket_ConsultarEliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TipoTicket_ConsultarEliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TipoTicket_ConsultarEliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TipoTicket_ConsultarEliminar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscartt;
    private javax.swing.JComboBox<String> elecciontt;
    private javax.swing.JButton eliminartt;
    private javax.swing.JTextField eliminartxt;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablatt;
    // End of variables declaration//GEN-END:variables
}
