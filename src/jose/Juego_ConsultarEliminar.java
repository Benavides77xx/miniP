/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jose;
import Clases.Juego;
import Clases.Mantenimiento;
import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import javax.swing.JOptionPane;
/**
 *
 * @author jose
 */
public class Juego_ConsultarEliminar extends javax.swing.JFrame {

    /**
     * Creates new form Juego_ConsultarEliminar
     */
    public Juego_ConsultarEliminar() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    public void Filtro(ObjectContainer basep) {       
        if (BuscarOpcion.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "SELECCIONA UNA OPCION");
        } else {

            if (BuscarOpcion.getSelectedIndex() == 1) {
                Juego Jbuscar = new Juego(null, null,null,null,0,0,null);
                ObjectSet result = basep.get(Jbuscar);
                MostrarDatos(result);

            } else {
                if (BuscarOpcion.getSelectedIndex() == 2) {
                    String codigo_juego = JOptionPane.showInputDialog("INGRESE EL CODIGO A CONSULTAR");
                    Juego Jbuscar = new Juego(codigo_juego, null,null,null,0,0,null);
                    ObjectSet result = basep.get(Jbuscar);
                    MostrarDatos(result);
                }         
            }
        }
            //Borrar la eleccion y ponerla al inicio
        BuscarOpcion.setSelectedIndex(0);
    }
    public void MostrarDatos(ObjectSet result) {
          
        String matrizesJuego[][] = new String[result.size()][7];

        if (result.size() == 0) {
            JOptionPane.showMessageDialog(null, "El Juego no existe");
        } else {
            for (int i = 0; i < result.size(); i++) {
                Juego miJuego = new Juego();

                miJuego= (Juego) result.get(i);
                matrizesJuego[i][0] = miJuego.getCodigo_juego();
                matrizesJuego[i][1] = miJuego.getNombre_juego();
                matrizesJuego[i][2] = miJuego.getDescripcion();
                matrizesJuego[i][3] = String.valueOf(miJuego.getAño_creacion());
                matrizesJuego[i][4] = String.valueOf(miJuego.getCapacidad());
                matrizesJuego[i][5] = String.valueOf(miJuego.getDuracion());
                matrizesJuego[i][6] = miJuego.getId_dueño();
                
                tablaConsultar.setModel(new javax.swing.table.DefaultTableModel(matrizesJuego, new String[]{"*Cod_juego", "Nombre_juego",
                    "Descripcion","Año_creacion","Capacidad","Duracion","*Id_dueño"}));
            }
        }
    }
    
    public void Cerrar_BD(ObjectContainer basep) {
        basep.close();
    }
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

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Consultar Juego");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, -1, -1));

        BuscarOpcion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opción", "Ver todos", "*Codigo Juego", " ", " " }));
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

        jLabel2.setText("*CODIGO JUEGO");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 130, 110, 30));
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 986, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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

        String codigo_juego = txtCodigo.getText();

        // Abre la base de datos
        ObjectContainer baseDeDatos = Db4o.openFile(INICIO.direccionBD);

        try {
            // Verifica si existen Mantenimiento asociados a este juego
            Mantenimiento cass = new Mantenimiento(null, null, null, null,codigo_juego );
            ObjectSet result = baseDeDatos.get(cass);
            if (result.size() > 0) {
                JOptionPane.showMessageDialog(this, "No se puede eliminar el Juego porque tiene Mantenimientos asociados","ERROR",0);
                return;
            }

            // Busca el Juego a eliminar
            Juego revisar = new Juego(codigo_juego, null,null,null, 0, 0, null);
            ObjectSet cassResult = baseDeDatos.get(revisar);

            if (cassResult.size() == 0) {
                JOptionPane.showMessageDialog(null, "El Juego no existe");
            } else {
                // Elimina el cassete encontrado
                baseDeDatos.delete(cassResult.get(0));
                JOptionPane.showMessageDialog(null, "El Juego se ha eliminado correctamente");

                // Actualiza la tabla después de eliminar el Juego
                Filtro(baseDeDatos);
            }
        } finally {
            // Cierra la base de datos

            baseDeDatos.close();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tablaConsultarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaConsultarMouseClicked
        int i = tablaConsultar.getSelectedRow();
        txtCodigo.setText(tablaConsultar.getValueAt(i, 0).toString());
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
            java.util.logging.Logger.getLogger(Juego_ConsultarEliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Juego_ConsultarEliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Juego_ConsultarEliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Juego_ConsultarEliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Juego_ConsultarEliminar().setVisible(true);
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
