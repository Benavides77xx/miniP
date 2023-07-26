
package andrea;

import Clases.Mantenimiento;
import com.db4o.*;
import Clases.Tecnico;
import com.db4o.ObjectSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jose.INICIO;
public class Tecnico_ConsultarEliminar extends javax.swing.JFrame {

    
    public Tecnico_ConsultarEliminar() {
        initComponents();
        this.setSize(1200,500);
    }
    
    public void Filtro(ObjectContainer basep) {
        
     if (eleccion.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione una de las opciones");
        } else {

            if (eleccion.getSelectedIndex() == 2) {
                Tecnico bus_tec = new Tecnico(null,null,0,null,null,null,null,0,null,null,null,null,null,null);
                ObjectSet result = basep.get(bus_tec);
                mostrarDatos(result);

            } else {
                if (eleccion.getSelectedIndex() == 1) {
                    String opc = JOptionPane.showInputDialog("Ingrese el ID a consultar");
                    Tecnico buscart = new Tecnico(opc,null,0,null,null,null,null,0,null,null,null,null,null,null);
                    ObjectSet result = basep.get(buscart);
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
                Tecnico mitecnico = (Tecnico) result.next();
                Object[] fila = {
                    mitecnico.getId_tecnico(),
                    mitecnico.getCedula_per(),
                    mitecnico.getNombre_per(),
                    mitecnico.getApellido(),
                    mitecnico.getEdad_per(),
                    mitecnico.getGenero(),
                    mitecnico.getCelular_per(),
                    String.valueOf(mitecnico.getFecha_nac()),
                    mitecnico.getCorreo(),
                    mitecnico.getCodigo_tipo_sangre(),
                    mitecnico.getCodigo_pais(),
                    mitecnico.getNivel_estudio_tec(),
                    mitecnico.getA_experiencia_tec(),
                    mitecnico.getReferencias_tec(),};
                
                modelo.addRow(fila);
            }
        }
    }
//     
//     public void EliminarTecnicos(ObjectContainer basep) {
//        Tecnico_crud Ainterfaz = new Tecnico_crud();
//        if (eliminarid.getText().isEmpty()) {
//            JOptionPane.showMessageDialog(null, "Ingrese el ID del Tecnico ");
//        } else {
//
//            String idelim = eliminarid.getText();
//            Tecnico Abuscar = new Tecnico(idelim,null,0,null,null,null,null,0,'\u0000',null,null,null,null,null);
//            ObjectSet result = basep.get(Abuscar);
//
//            if (Ainterfaz.validar(basep,idelim) == 0) {
//                JOptionPane.showMessageDialog(null, " No exite ningun registro");
//
//            } else {
//                Tecnico elimtec = (Tecnico) result.next();
//                basep.delete(elimtec);
//                JOptionPane.showMessageDialog(null, " Se elimino este registro");
//            }
//
//        }
//        eliminarid.setText("");
//    }
     public static void Cerrar_BD(ObjectContainer basep) {

        basep.close();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        busc = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablatec = new javax.swing.JTable();
        eleccion = new javax.swing.JComboBox<>();
        eliminarid = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(200, 217, 240));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "BUSCAR Y ELIMINAR TECNICOS ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Copperplate Gothic Light", 1, 18))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 12)); // NOI18N
        jLabel1.setText("ingresa el identificador del tecnico a eliminar ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 50, 330, 10));

        busc.setBackground(new java.awt.Color(255, 255, 255));
        busc.setText("BUSCAR ");
        busc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        busc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscActionPerformed(evt);
            }
        });
        jPanel1.add(busc, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 80, 20));

        tablatec.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "CEDULA", "NOMBRE", "APELLIDO", "EDAD", "GENERO", "CELULAR", "FECHA DE NACIMIENTO", "E -MAIL", "Cod_tipoSan", "Cod_pais", "NIVEL DE ESTUDIO", "EXPERIENCIA", "REFERENCIAS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false
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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 1170, 130));

        eleccion.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 10)); // NOI18N
        eleccion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCION", "ID TECNICO", "VER TODOS LOS REGISTROS" }));
        eleccion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.add(eleccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 170, 30));
        jPanel1.add(eliminarid, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 80, 210, -1));

        jLabel2.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 10)); // NOI18N
        jLabel2.setText("SELECCIONA DE LAS SIGUIENTES  OPCIONES ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

        jButton1.setText("ELIMINAR");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 70, 90, 30));

        jButton2.setText("Regresar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 30, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1191, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscActionPerformed
     ObjectContainer BaseD = Db4o.openFile(INICIO.direccionBD);
     Filtro(BaseD);
     Cerrar_BD(BaseD);        
    }//GEN-LAST:event_buscActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     
        String id_tecnico = eliminarid.getText();

        // Abre la base de datos
        ObjectContainer baseDeDatos = Db4o.openFile(INICIO.direccionBD);

        try {
            // Verifica si existen Mantenimientos asociados a este tecnico
            Mantenimiento cass = new Mantenimiento(null, null,null, id_tecnico,null );
            ObjectSet result = baseDeDatos.get(cass);
            if (result.size() > 0) {
                JOptionPane.showMessageDialog(this, "No se puede eliminar Tecnico ya que tiene Mantenimientos asociados","ERROR",0);
                return;
            }

            // Busca el Tecnico
            Tecnico revisar = new Tecnico(id_tecnico,null,0,null, null, null, null,0,null,null,null,null,null,null);
            ObjectSet cassResult = baseDeDatos.get(revisar);

            if (cassResult.size() == 0) {
                JOptionPane.showMessageDialog(null, "El Tecnico no existe");
            } else {
                // Elimina el cassete encontrado
                baseDeDatos.delete(cassResult.get(0));
                JOptionPane.showMessageDialog(null, "El Tecnico se ha eliminado correctamente");

                // Actualiza la tabla después de eliminar el Juego
                Filtro(baseDeDatos);
            }
        } finally {
            // Cierra la base de datos

            baseDeDatos.close();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tablatecMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablatecMouseClicked
              int i = tablatec.getSelectedRow();
                eliminarid.setText(tablatec.getValueAt(i, 0).toString());
    }//GEN-LAST:event_tablatecMouseClicked

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
            java.util.logging.Logger.getLogger(Tecnico_ConsultarEliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tecnico_ConsultarEliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tecnico_ConsultarEliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tecnico_ConsultarEliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tecnico_ConsultarEliminar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton busc;
    private javax.swing.JComboBox<String> eleccion;
    private javax.swing.JTextField eliminarid;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablatec;
    // End of variables declaration//GEN-END:variables
}
