/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package andrea;

import Clases.Detalle_factura;
import andrea.Ticket_crud;
import Clases.Ticket;
import Clases.Tecnico;
import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jose.INICIO;

/**
 *
 * @author Asus
 */
public class Ticket_ConsultarEliminar extends javax.swing.JFrame {

    /**
     * Creates new form buscar_eliminar_tick
     */
    public Ticket_ConsultarEliminar() {
        initComponents();
    }

    public void Filtro (ObjectContainer basep) {
        
     if (eleccion.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione una de las opciones");
        } else {

            if (eleccion.getSelectedIndex() == 2) {
                Ticket bus_tec = new Ticket(null,0,null,null,null);
                ObjectSet result = basep.get(bus_tec);
                mostrarDatos(result);

            } else {
                if (eleccion.getSelectedIndex() == 1) {
                    String Cod_tick = JOptionPane.showInputDialog("Ingrese el codigo a consultar");
                    Ticket buscartcc = new Ticket(Cod_tick,0,null,null,null);
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
                Ticket mitick = (Ticket) result.next();
                Object[] fila = {
                    mitick.getCodigo_ticket(),
                    mitick.getPrecio_ticket(),
                    mitick.getRestrccion(),
                    mitick.getCodigo_tipo_ticket(),
                    mitick.getId_taquillero(),
                    };
                
                modelo.addRow(fila);
            }
        }
    }
    
//    public void Eliminartc(ObjectContainer basep) {
//        
//        Tecnico_crud Ainterfaz = new Tecnico_crud();
//        if (eliminarcod.getText().isEmpty()) {
//            JOptionPane.showMessageDialog(null, "Ingrese el código");
//        } else {
//
//            String IDA = eliminarcod.getText();
//            Ticket Abuscar = new Ticket(IDA,0, null, null, null);
//            ObjectSet result = basep.get(Abuscar);
//
//            if (Ainterfaz.comprobarTicket(basep, IDA) == 0) {
//                JOptionPane.showMessageDialog(null, "No existen registro con el  id especificado ");
//
//            } else {
//                Ticket AsignaturaElim = (Ticket) result.next();
//                basep.delete(AsignaturaElim);
//                JOptionPane.showMessageDialog(null, "Registro eleiminado");
//            }
//
//        }
//
//        
//        eliminarcod.setText("");
//    }
    public static void Cerrar_BD(ObjectContainer basep) {

        basep.close();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        eleccion = new javax.swing.JComboBox<>();
        eliminarcod = new javax.swing.JTextField();
        buscarbtn = new javax.swing.JButton();
        eliminarbtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablatec = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(189, 206, 233));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "BUSCAR Y ELIMINAR TICKETS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Copperplate Gothic Light", 1, 18))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 12)); // NOI18N
        jLabel1.setText("diguite el codigo de el ticket que desea eliminar : ");
        jLabel1.setToolTipText("");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 340, 20));

        eleccion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIÓN", "CÓDIGO TICKET", "VER TODOS" }));
        jPanel1.add(eleccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 210, -1));

        eliminarcod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarcodActionPerformed(evt);
            }
        });
        jPanel1.add(eliminarcod, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, 190, -1));

        buscarbtn.setText("BUSCAR ");
        buscarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarbtnActionPerformed(evt);
            }
        });
        jPanel1.add(buscarbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        eliminarbtn.setText("ELIMINAR");
        eliminarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarbtnActionPerformed(evt);
            }
        });
        jPanel1.add(eliminarbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 120, -1, -1));

        jLabel3.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 12)); // NOI18N
        jLabel3.setText("Seleccione una de las siguientes opciones : ");
        jLabel3.setToolTipText("");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 290, 20));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, 10, 100));

        tablatec.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "CÓDIGO", "PRECIO", "RESTRICCION", "COD_TIPO_TICKET", "ID TAQUILLERO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablatec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablatecMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablatec);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 730, 100));

        jButton1.setText("REGRESAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 30, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 758, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void eliminarcodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarcodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eliminarcodActionPerformed

    private void buscarbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarbtnActionPerformed
     ObjectContainer BaseD = Db4o.openFile(INICIO.direccionBD);
     Filtro(BaseD);
     Cerrar_BD(BaseD); 
    }//GEN-LAST:event_buscarbtnActionPerformed

    private void eliminarbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarbtnActionPerformed
   String codigo_ticket = eliminarcod.getText();

        // Abre la base de datos
        ObjectContainer baseDeDatos = Db4o.openFile(INICIO.direccionBD);

        try {
            // Verifica si existen Detalles de facturas asociados a este ticket
            Detalle_factura cass = new Detalle_factura(null, 0, 0, codigo_ticket,null );
            ObjectSet result = baseDeDatos.get(cass);
            if (result.size() > 0) {
                JOptionPane.showMessageDialog(this, "No se puede eliminar el Ticket porque tiene Detalles de facturas asociados","ERROR",0);
                return;
            }

            // Busca el Ticket
            Ticket revisar = new Ticket(codigo_ticket,  0, null, null,null);
            ObjectSet cassResult = baseDeDatos.get(revisar);

            if (cassResult.size() == 0) {
                JOptionPane.showMessageDialog(null, "El Ticket no existe");
            } else {
                // Elimina el cassete encontrado
                baseDeDatos.delete(cassResult.get(0));
                JOptionPane.showMessageDialog(null, "El Ticket se ha eliminado correctamente");

                // Actualiza la tabla después de eliminar el Juego
                Filtro(baseDeDatos);
            }
        } finally {
            // Cierra la base de datos

            baseDeDatos.close();
        }
    }//GEN-LAST:event_eliminarbtnActionPerformed

    private void tablatecMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablatecMouseClicked
                 int i = tablatec.getSelectedRow();
                eliminarcod.setText(tablatec.getValueAt(i, 0).toString());
    }//GEN-LAST:event_tablatecMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        INICIO mostrar = new INICIO();
        mostrar.setVisible(true);         // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Ticket_ConsultarEliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ticket_ConsultarEliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ticket_ConsultarEliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ticket_ConsultarEliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ticket_ConsultarEliminar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscarbtn;
    private javax.swing.JComboBox<String> eleccion;
    private javax.swing.JButton eliminarbtn;
    private javax.swing.JTextField eliminarcod;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tablatec;
    // End of variables declaration//GEN-END:variables
}
