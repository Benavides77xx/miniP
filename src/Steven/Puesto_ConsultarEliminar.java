/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Steven;

import ClasesSteven.Area;
import ClasesSteven.Puesto;
import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import javax.swing.JOptionPane;
import jose.INICIO;

/**
 *
 * @author Steven Zhicay
 */
public class Puesto_ConsultarEliminar extends javax.swing.JFrame {

    /**
     * Creates new form Puesto_ConsultarEliminar
     */
    public Puesto_ConsultarEliminar() {
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
                Puesto buscar = new Puesto(null, null, null, null, null, null);
                ObjectSet result = basep.get(buscar);
                MostrarDatos(result);

            } else {
                if (BuscarOpcion.getSelectedIndex() == 2) {
                    String codigo_puesto = JOptionPane.showInputDialog("INGRESE EL CODIGO A CONSULTAR");
                    Puesto Jbuscar = new Puesto(codigo_puesto, null, null, null, null, null);
                    ObjectSet result = basep.get(Jbuscar);
                    MostrarDatos(result);
                }
            }
        }
        //Borrar la eleccion y ponerla al inicio
        BuscarOpcion.setSelectedIndex(0);
    }

    public void MostrarDatos(ObjectSet result) {

        String matrizes[][] = new String[result.size()][6];

        if (result.size() == 0) {
            JOptionPane.showMessageDialog(null, "El Puesto no existe");
        } else {
            for (int i = 0; i < result.size(); i++) {
                Puesto miObjeto = new Puesto();

                miObjeto = (Puesto) result.get(i);
                matrizes[i][0] = miObjeto.getCod_puesto();
                matrizes[i][1] = miObjeto.getNombre();
                matrizes[i][2] = miObjeto.getDescripcion();
                matrizes[i][3] = miObjeto.getTamaño();
                matrizes[i][4] = miObjeto.getHorario_laboral();
                matrizes[i][5] = miObjeto.getId_comerciante();
                

                tablaConsultar.setModel(new javax.swing.table.DefaultTableModel(matrizes, new String[]{"*Cod_Puesto", "Nombre",
                    "Descripción", "Tamaño", "Horario laboral", "Id_Comerciante"}));
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
        btnBuscar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaConsultar = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Consultar Puesto");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 930, -1));

        BuscarOpcion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opción", "Ver todos", "*Codigo Juego" }));
        BuscarOpcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarOpcionActionPerformed(evt);
            }
        });
        jPanel1.add(BuscarOpcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 180, 40));

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscar (1).png"))); // NOI18N
        btnBuscar.setContentAreaFilled(false);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, 40, 40));

        jLabel2.setText("*CODIGO JUEGO");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 130, 110, 30));
        jPanel1.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 130, 120, 30));

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/eliminar.png"))); // NOI18N
        btnEliminar.setContentAreaFilled(false);
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarMouseClicked(evt);
            }
        });
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 130, 40, 30));

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
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 420, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 928, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BuscarOpcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarOpcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BuscarOpcionActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        ObjectContainer BaseD = Db4o.openFile(INICIO.direccionBD);
        Filtro(BaseD);
        Cerrar_BD(BaseD);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked

    }//GEN-LAST:event_btnEliminarMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        String codigo_puesto = txtCodigo.getText();

        // Abre la base de datos
        ObjectContainer baseDeDatos = Db4o.openFile(INICIO.direccionBD);

        try {
            // Verifica si existen Control Guardia asociados a este juego
            Area cass = new Area(null, null, null, 0, false, null, null, codigo_puesto);
            ObjectSet result = baseDeDatos.get(cass);
            if (result.size() > 0) {
                JOptionPane.showMessageDialog(this, "No se puede eliminar el Puesto porque tiene Areas asociados", "ERROR", 0);
                return;
            }

            // Busca el Area a eliminar    
            Puesto revisar = new Puesto(codigo_puesto, null, null, null, null, null);
            ObjectSet cassResult = baseDeDatos.get(revisar);

            if (cassResult.size() == 0) {
                JOptionPane.showMessageDialog(null, "El Puesto no existe");
            } else {
                // Elimina el cassete encontrado
                baseDeDatos.delete(cassResult.get(0));
                JOptionPane.showMessageDialog(null, "El Puesto se ha eliminado correctamente");

                // Actualiza la tabla después de eliminar el Juego
                Filtro(baseDeDatos);
            }
        } finally {
            // Cierra la base de datos

            baseDeDatos.close();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void tablaConsultarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaConsultarMouseClicked
        int i = tablaConsultar.getSelectedRow();
        txtCodigo.setText(tablaConsultar.getValueAt(i, 0).toString());
    }//GEN-LAST:event_tablaConsultarMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        INICIO ini = new INICIO();
        ini.setVisible(true);
        dispose();
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
            java.util.logging.Logger.getLogger(Puesto_ConsultarEliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Puesto_ConsultarEliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Puesto_ConsultarEliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Puesto_ConsultarEliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Puesto_ConsultarEliminar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> BuscarOpcion;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaConsultar;
    private javax.swing.JTextField txtCodigo;
    // End of variables declaration//GEN-END:variables
}
