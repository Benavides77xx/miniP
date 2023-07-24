/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jose;
import Clases.Juego;
import com.db4o.Db4o;
import jose.Juego_crud;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author jose
 */
public class Juego_modificar extends javax.swing.JFrame {
     String codigo_juego ="" ;
     String descripcion="";
     String nombre_juego="";
     Date año_creacion=null;
     int capacidad=0;
     double duracion=0;
     String id_dueño=""; 
    /**
     * Creates new form Juego_modificar
     */
    public Juego_modificar() {
        initComponents();
    }
    
    public void LimpiarCampos() {
        txtcodJ.setText("");
        txtnombre.setText("");
        txtdes.setText("");
        dateCreacion.setDate(null);
        txtcap.setValue(0);
        txtduracion.setText("");
    }

    public void HabilitarCampos_deTexto() {
        txtnombre.setEditable(true);
        txtdes.setEditable(true);
        dateCreacion.setEnabled(true);
        txtcap.setEnabled(true);
        txtduracion.setEditable(true);
    }    
     
    public void buscar(ObjectContainer basep) {//cargardatos

        btnmodificar.setEnabled(false);
        String IDAux;
        IDAux = txtcodJ.getText();

        Juego_crud EAux = new Juego_crud();

        if (txtcodJ.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Ingrese un ID");
        } else {

            if (EAux.comprobarJuego(basep, IDAux) == 0) {

                JOptionPane.showMessageDialog(null, "El Juego no existe en la base de datos");
                LimpiarCampos();

            } else {

                Juego Ebuscar = new Juego(IDAux, null, null,null,0,0,null);

                ObjectSet result = basep.get(Ebuscar);
                for (int i = 0; i < result.size(); i++) {
                    
                    Juego miE = new Juego();
                    
                    miE = (Juego) result.get(i); 
                    txtcodJ.setText(miE.getCodigo_juego());
                    txtdes.setText(miE.getDescripcion());
                    txtnombre.setText(miE.getNombre_juego());
                    dateCreacion.setDate(miE.getAño_creacion());
                    txtcap.setValue(String.valueOf(miE.getCapacidad()));
                    txtduracion.setText(String.valueOf(miE.getDuracion()));
                    
                    btnmodificar.setEnabled(true);
                    //Hacer editable los campos de texto
                    mostrarDatos(result);
                    HabilitarCampos_deTexto();
                    txtcodJ.setEditable(false);
                }

            }

        }
    }
    public void Modificar_Juego(ObjectContainer basep) {

        Juego Emodi = new Juego(txtcodJ.getText(), null,null,null,0,0,null);
        ObjectSet result = basep.get(Emodi);
        
        Juego Emodificar = (Juego) result.next();
        Emodificar.setDescripcion(txtdes.getText());
        Emodificar.setNombre_juego(txtnombre.getText());
        Emodificar.setAño_creacion(dateCreacion.getDate());
        Emodificar.setCapacidad(Integer.parseInt(txtcap.getValue().toString()));
        Emodificar.setDuracion(Double.parseDouble(txtduracion.getText()));

        basep.set(Emodificar);
        JOptionPane.showMessageDialog(null, "El Juego fue modificado exitosamente");
        mostrarDatos(result);
        LimpiarCampos();
    }    
    
    public void mostrarDatos(ObjectSet result) {
        DefaultTableModel model = (DefaultTableModel) jtable.getModel();
        model.setRowCount(0); // Limpiar la tabla

        if (result.size() == 0) {
            JOptionPane.showMessageDialog(null, "El Juego no existe");
        } else {
            while (result.hasNext()) {
                Juego MostrarDatos = (Juego) result.next();
                Object[] fila = {
                    
                    MostrarDatos.getCodigo_juego(),
                    MostrarDatos.getNombre_juego(),
                    MostrarDatos.getDescripcion(),  
                    MostrarDatos.getAño_creacion(),
                    MostrarDatos.getCapacidad(),
                    MostrarDatos.getDuracion(),
                    MostrarDatos.getId_dueño(),};

                     model.addRow(fila);
            }
        }
    }    
    
    public static void Cerrar_BD(ObjectContainer basep) {

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
        jLabel2 = new javax.swing.JLabel();
        txtcodJ = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtable = new javax.swing.JTable();
        btnmodificar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        txtcap = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtdes = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        dateCreacion = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        txtduracion = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Modificar Juego");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("*Codigo Juego");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, -1, 30));
        jPanel1.add(txtcodJ, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, 250, 30));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscar (1).png"))); // NOI18N
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 80, 40, -1));

        jtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, "", null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "*Codigo_Juego", "Nombre", "Descripcion", "Año_creacion", "Capacidad", "Duracion", "*ID_dueño"
            }
        ));
        jScrollPane1.setViewportView(jtable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 800, 90));

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
        jPanel1.add(btnmodificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 370, 130, 40));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Regresar.png"))); // NOI18N
        jButton3.setText("Regresar");
        jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton3.setContentAreaFilled(false);
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 420, 130, 40));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Capacidad");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 380, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Nombre Juego");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 330, -1, -1));
        jPanel1.add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 350, 240, 30));
        jPanel1.add(txtcap, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 400, 240, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Descripcion");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 390, -1, -1));

        txtdes.setColumns(20);
        txtdes.setRows(5);
        jScrollPane2.setViewportView(txtdes);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 410, 240, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Año creacion");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 330, -1, -1));
        jPanel1.add(dateCreacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 350, 240, 30));

        jLabel4.setText("Duracion");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 440, -1, -1));
        jPanel1.add(txtduracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 460, 240, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 991, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
        Modificar_Juego(BaseD);
        Cerrar_BD(BaseD);
        txtcodJ.setEditable(true);
    }//GEN-LAST:event_btnmodificarActionPerformed

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
            java.util.logging.Logger.getLogger(Juego_modificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Juego_modificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Juego_modificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Juego_modificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Juego_modificar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnmodificar;
    private com.toedter.calendar.JDateChooser dateCreacion;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtable;
    private javax.swing.JSpinner txtcap;
    private javax.swing.JTextField txtcodJ;
    private javax.swing.JTextArea txtdes;
    private javax.swing.JTextField txtduracion;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}