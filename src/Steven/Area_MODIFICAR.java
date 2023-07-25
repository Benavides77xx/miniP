/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Steven;

import ClasesSteven.Area;
import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jose.INICIO;

/**
 *
 * @author Steven Zhicay
 */
public class Area_MODIFICAR extends javax.swing.JFrame {

    
    String nombre;
    String tamaño;
    int capacidad = 0;
    boolean disponibilidad;
    String descripcion;
    String id_guardia;
    String cod_puesto;
    int valorInicial = 0;

    public Area_MODIFICAR() {
        initComponents();
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
        jLabel2 = new javax.swing.JLabel();
        txtcodA = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtable = new javax.swing.JTable();
        btnmodificar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txtnombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtdescripcion = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        txtTamaño = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCapacidad = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        chxSi = new javax.swing.JCheckBox();
        txtIdGuardia = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        lbl = new javax.swing.JLabel();
        txtCod_puesto = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Modificar Area");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 20, 760, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("*Codigo Area ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, -1, 30));
        jPanel1.add(txtcodA, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 250, 30));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscar (1).png"))); // NOI18N
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 80, 40, -1));

        jtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, "", null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "*Codigo_Area", "Nombre", "Tamaño", "Capacidad", "Disponibilidad", "Descripción", "Id_Guardia", "Codigo_Puesto"
            }
        ));
        jScrollPane1.setViewportView(jtable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 730, 90));

        btnmodificar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnmodificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/editar (1).png"))); // NOI18N
        btnmodificar.setText("Modificar");
        btnmodificar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnmodificar.setContentAreaFilled(false);
        btnmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificarActionPerformed(evt);
            }
        });
        jPanel1.add(btnmodificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 70, 130, 40));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Regresar.png"))); // NOI18N
        jButton3.setText("Regresar");
        jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton3.setContentAreaFilled(false);
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 550, 130, 40));

        txtnombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, 200, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Nombre ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, -1, -1));

        txtdescripcion.setColumns(20);
        txtdescripcion.setRows(5);
        txtdescripcion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane2.setViewportView(txtdescripcion);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 190, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Descripcion");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, -1, -1));

        txtTamaño.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtTamaño, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 280, 200, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Tamaño:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 260, -1, -1));

        txtCapacidad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtCapacidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 340, 190, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Capacidad:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 320, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Disponibilidad:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 380, -1, -1));

        chxSi.setText("Si");
        jPanel1.add(chxSi, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 380, -1, -1));

        txtIdGuardia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtIdGuardia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdGuardiaActionPerformed(evt);
            }
        });
        jPanel1.add(txtIdGuardia, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 430, 190, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("*Id_guardia:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 410, -1, -1));

        lbl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl.setText("*Cod_puesto:");
        jPanel1.add(lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 480, -1, -1));

        txtCod_puesto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtCod_puesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCod_puestoActionPerformed(evt);
            }
        });
        jPanel1.add(txtCod_puesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 500, 190, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 766, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ObjectContainer BaseD = Db4o.openFile(INICIO.direccionBD);
        buscar(BaseD);
        Cerrar_BD(BaseD);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarActionPerformed
        ObjectContainer BaseD = Db4o.openFile(INICIO.direccionBD);
        Modificar_Area(BaseD);
        Cerrar_BD(BaseD);
        txtcodA.setEditable(true);
    }//GEN-LAST:event_btnmodificarActionPerformed

    private void txtIdGuardiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdGuardiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdGuardiaActionPerformed

    private void txtCod_puestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCod_puestoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCod_puestoActionPerformed

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
            java.util.logging.Logger.getLogger(Area_MODIFICAR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Area_MODIFICAR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Area_MODIFICAR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Area_MODIFICAR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Area_MODIFICAR().setVisible(true);
            }
        });
    }

    public void LimpiarCampos() {
        txtcodA.setText("");
        txtdescripcion.setText("");
        txtnombre.setText("");
        txtTamaño.setText("");
        txtCapacidad.setValue(valorInicial);
        chxSi.setSelected(false);
        txtIdGuardia.setText("");
        txtCod_puesto.setText("");

    }

    public void HabilitarCampos_deTexto() {
        txtnombre.setEditable(true);
        txtdescripcion.setEditable(true);
        txtTamaño.setEditable(true);
        txtIdGuardia.setEditable(true);
        txtCod_puesto.setEditable(true);
    }

    public void buscar(ObjectContainer basep) {//cargardatos

        btnmodificar.setEnabled(false);
        String codA;
        codA = txtcodA.getText();

        Area_CRUD areacrud = new Area_CRUD();

        if (txtcodA.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Ingrese un ID/Codigo");
        } else {

            if (areacrud.comprobarArea(basep, codA) == 0) {

                JOptionPane.showMessageDialog(null, "El Area no existe en la base de datos");
                LimpiarCampos();

            } else {

                Area Ebuscar = new Area(codA, null, null, 0, false, null, null, null);

                ObjectSet result = basep.get(Ebuscar);
                for (int i = 0; i < result.size(); i++) {

                    Area miE = new Area();

                    miE = (Area) result.get(i);
                    txtcodA.setText(miE.getCod_area());
                    txtnombre.setText(miE.getNombre());
                    txtTamaño.setText(miE.getTamaño());
                    txtCapacidad.setValue(String.valueOf(miE.getCapacidad()));
                    chxSi.setText(String.valueOf(miE.isDisponibilida()));
                    txtIdGuardia.setText(miE.getId_guardia());
                    txtCod_puesto.setText(miE.getCod_puesto());
                    btnmodificar.setEnabled(true);
                    //Hacer editable los campos de texto
                    mostrarDatos(result);
                    HabilitarCampos_deTexto();
                    txtcodA.setEditable(false);
                }

            }

        }
    }

    public void Modificar_Area(ObjectContainer basep) {

        Area Emodi = new Area(txtcodA.getText(), null, null, 0, false, null, null, null);
        ObjectSet result = basep.get(Emodi);

        Area Emodificar = (Area) result.next();
        Emodificar.setNombre(txtnombre.getText());
        Emodificar.setDescripcion(txtdescripcion.getText());
        Emodificar.setTamaño(txtTamaño.getText());
        Emodificar.setDisponibilida(chxSi.isSelected());
        Emodificar.setCapacidad(Integer.parseInt((String) txtCapacidad.getValue()));

        basep.set(Emodificar);
        JOptionPane.showMessageDialog(null, "El Area fue modificado exitosamente");
        mostrarDatos(result);
        LimpiarCampos();
    }

    public void mostrarDatos(ObjectSet result) {
        DefaultTableModel model = (DefaultTableModel) jtable.getModel();
        model.setRowCount(0); // Limpiar la tabla

        if (result.size() == 0) {
            JOptionPane.showMessageDialog(null, "El Area no existe");
        } else {
            while (result.hasNext()) {
                Area MostrarDatos = (Area) result.next();
                Object[] fila = {
                    MostrarDatos.getCod_area(),
                    MostrarDatos.getNombre(),
                    MostrarDatos.getDescripcion(),
                    MostrarDatos.getTamaño(),
                    MostrarDatos.getCapacidad(),
                    MostrarDatos.isDisponibilida(),
                    MostrarDatos.getId_guardia(),
                    MostrarDatos.getCod_puesto()};

                model.addRow(fila);
            }
        }
    }

    public static void Cerrar_BD(ObjectContainer basep) {

        basep.close();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnmodificar;
    private javax.swing.JCheckBox chxSi;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtable;
    private javax.swing.JLabel lbl;
    private javax.swing.JSpinner txtCapacidad;
    private javax.swing.JTextField txtCod_puesto;
    private javax.swing.JTextField txtIdGuardia;
    private javax.swing.JTextField txtTamaño;
    private javax.swing.JTextField txtcodA;
    private javax.swing.JTextArea txtdescripcion;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}
