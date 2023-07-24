/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jose;
import Clases.Mantenimiento;
import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import javax.swing.JOptionPane;
/**
 *
 * @author jose
 */
public class Mantenimiento_ConsultarEliminar extends javax.swing.JFrame {

    /**
     * Creates new form Mantenimiento_ConsultarEliminar
     */
    public Mantenimiento_ConsultarEliminar() {
        initComponents();
    }
    public void Filtro(ObjectContainer basep) {       
        if (BuscarOpcion.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "SELECCIONA UNA OPCION");
        } else {

            if (BuscarOpcion.getSelectedIndex() == 1) {
                Mantenimiento Jbuscar = new Mantenimiento(null, null,null,null,null);
                ObjectSet result = basep.get(Jbuscar);
                MostrarDatos(result);

            } else {
                if (BuscarOpcion.getSelectedIndex() == 2) {
                    String codigo_mantenimiento = JOptionPane.showInputDialog("INGRESE EL CODIGO A CONSULTAR");
                    Mantenimiento Jbuscar = new Mantenimiento(codigo_mantenimiento, null,null,null,null);
                    ObjectSet result = basep.get(Jbuscar);
                    MostrarDatos(result);
                }         
            }
        }
            //Borrar la eleccion y ponerla al inicio
        BuscarOpcion.setSelectedIndex(0);
    }
    public void MostrarDatos(ObjectSet result) {
          
        String matrizesTabla[][] = new String[result.size()][5];

        if (result.size() == 0) {
            JOptionPane.showMessageDialog(null, "El Mantenimiento no existe");
        } else {
            for (int i = 0; i < result.size(); i++) {
                Mantenimiento Mostrar = new Mantenimiento();

                Mostrar= (Mantenimiento) result.get(i);
                matrizesTabla[i][0] = Mostrar.getCodigo_mantenimiento();
                matrizesTabla[i][1] = Mostrar.getDescripcion_mantenimiento();
                matrizesTabla[i][2] = String.valueOf(Mostrar.getFecha_mantenimiento());
                matrizesTabla[i][3] = Mostrar.getId_tecnico();
                matrizesTabla[i][4] = Mostrar.getCodigo_juego();
                
                tablaConsultar.setModel(new javax.swing.table.DefaultTableModel(matrizesTabla, new String[]{"*Cod_Mantenimiento", "Descripcion",
                    "Fecha_mant","*Id_tecnico","*Codigo_juego"}));
            }
        }
    }
    
    public void Cerrar_BD(ObjectContainer basep) {
        basep.close();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        BuscarOpcion = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaConsultar = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Consultar Mantenimiento");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, -1, -1));

        BuscarOpcion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opción", "Ver todos", "*Codigo Mantenimiento", " ", " " }));
        BuscarOpcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarOpcionActionPerformed(evt);
            }
        });
        jPanel1.add(BuscarOpcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 180, 40));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscar (1).png"))); // NOI18N
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, 40, 40));

        jLabel2.setText("*CODIGO MANTENIMIENTO");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, 140, 30));
        jPanel1.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 130, 120, 30));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/eliminar.png"))); // NOI18N
        jButton3.setContentAreaFilled(false);
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 130, 40, 30));

        tablaConsultar.getTableHeader().setReorderingAllowed(false);
        tablaConsultar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaConsultarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaConsultar);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, 700, 140));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Regresar.png"))); // NOI18N
        jButton1.setText("Regresar");
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 440, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 966, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BuscarOpcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarOpcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BuscarOpcionActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ObjectContainer BaseD = Db4o.openFile(INICIO.direccionBD);
        Filtro(BaseD);
        Cerrar_BD(BaseD);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked

    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //
        //        String codigo_cassete = txtCodigo.getText();
        //
        //        // Abre la base de datos
        //        ObjectContainer baseDeDatos = Db4o.openFile(Inicio.direccionBD);
        //
        //        try {
            //            // Verifica si existen Alquileres asociados a este cassetes
            //            Aquiler cass = new Aquiler(null, null, codigo_cassete, null, null, 0, 0);
            //            ObjectSet result = baseDeDatos.get(cass);
            //            if (result.size() > 0) {
                //                JOptionPane.showMessageDialog(this, "No se puede eliminar el cassete porque tiene alquileres asociados","ERROR",0);
                //                return;
                //            }
            //
            //            // Busca el cassete a eliminar
            //            Cassete cliente = new Cassete(codigo_cassete, null, 0, null, 0);
            //            ObjectSet cassResult = baseDeDatos.get(cliente);
            //
            //            if (cassResult.size() == 0) {
                //                JOptionPane.showMessageDialog(null, "El cassete no existe");
                //            } else {
                //                // Elimina el cassete encontrado
                //                baseDeDatos.delete(cassResult.get(0));
                //                JOptionPane.showMessageDialog(null, "El cassete se ha eliminado correctamente");
                //
                //                // Actualiza la tabla después de eliminar el cliente
                //                Filtro(baseDeDatos);
                //            }
            //        } finally {
            //            // Cierra la base de datos
            //
            //            baseDeDatos.close();
            //        }
        //
        //        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tablaConsultarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaConsultarMouseClicked
        //        int i = tablaConsultar.getSelectedRow();
        //        txtCodigo.setText(tablaConsultar.getValueAt(i, 0).toString());
    }//GEN-LAST:event_tablaConsultarMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Mantenimiento_ConsultarEliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mantenimiento_ConsultarEliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mantenimiento_ConsultarEliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mantenimiento_ConsultarEliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mantenimiento_ConsultarEliminar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> BuscarOpcion;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaConsultar;
    private javax.swing.JTextField txtCodigo;
    // End of variables declaration//GEN-END:variables
}
