/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jose;
import Clases.Mantenimiento;
import com.db4o.Db4o;
import jose.Mantenimiento_crud;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author jose
 */
public class Mantenimiento_modificar extends javax.swing.JFrame {
     String codigo_mantenimiento ="" ;
     String descripcion_mantenimiento="";
     Date Fecha_mantenimiento=null;
     String id_tecnico="";
     String codigo_juego="";
    /**
     * Creates new form Mantenimiento_modificar
     */
    public Mantenimiento_modificar() {
        initComponents();
    }
    public void LimpiarCampos() {
        txtcodM.setText("");
        txtdes.setText("");
        dateMan.setDate(null);
    }

    public void HabilitarCampos_deTexto() {
        txtcodM.setEditable(true);
        dateMan.setEnabled(true);
    }    
     
    public void buscar(ObjectContainer basep) {//cargardatos

        btnmodificar.setEnabled(false);
        String IDAux;
        IDAux = txtcodM.getText();

        Mantenimiento_crud EAux = new Mantenimiento_crud();

        if (txtcodM.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Ingrese un ID");
        } else {

            if (EAux.comprobarMantenimiento(basep, IDAux) == 0) {

                JOptionPane.showMessageDialog(null, "El Mantenimiento no existe en la base de datos");
                LimpiarCampos();

            } else {

                Mantenimiento Ebuscar = new Mantenimiento(IDAux, null, null,null,null);

                ObjectSet result = basep.get(Ebuscar);
                for (int i = 0; i < result.size(); i++) {
                    
                    Mantenimiento miE = new Mantenimiento();
                    
                    miE = (Mantenimiento) result.get(i); 
                    txtcodM.setText(miE.getCodigo_mantenimiento());
                    txtdes.setText(miE.getDescripcion_mantenimiento());
                    dateMan.setDate(miE.getFecha_mantenimiento());

                    btnmodificar.setEnabled(true);
                    //Hacer editable los campos de texto
                    mostrarDatos(result);
                    HabilitarCampos_deTexto();
                    txtcodM.setEditable(false);
                }

            }

        }
    }
    public void Modificar_Mantenimiento(ObjectContainer basep) {

        Mantenimiento Emodi = new Mantenimiento(txtcodM.getText(), null,null,null,null );
        ObjectSet result = basep.get(Emodi);
        
        Mantenimiento Emodificar = (Mantenimiento) result.next();
        Emodificar.setDescripcion_mantenimiento(txtdes.getText());
        Emodificar.setFecha_mantenimiento(dateMan.getDate());

        basep.set(Emodificar);
        JOptionPane.showMessageDialog(null, "El Mantenimiento fue modificado exitosamente");
        mostrarDatos(result);
        LimpiarCampos();
    }    
    
    public void mostrarDatos(ObjectSet result) {
        DefaultTableModel model = (DefaultTableModel) jtable.getModel();
        model.setRowCount(0); // Limpiar la tabla

        if (result.size() == 0) {
            JOptionPane.showMessageDialog(null, "El Mantenimiento no existe");
        } else {
            while (result.hasNext()) {
                Mantenimiento MostrarDatos = (Mantenimiento) result.next();
                Object[] fila = {
                    
                    MostrarDatos.getCodigo_mantenimiento(),
                    MostrarDatos.getDescripcion_mantenimiento(),
                    MostrarDatos.getFecha_mantenimiento(),
                    MostrarDatos.getId_tecnico(),
                    MostrarDatos.getCodigo_juego(),};

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
        txtcodM = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnmodificar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtdes = new javax.swing.JTextArea();
        dateMan = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Modificar Mantenimiento");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("*Codigo mantenimiento ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, -1, 30));
        jPanel1.add(txtcodM, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, 250, 30));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscar (1).png"))); // NOI18N
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 80, 40, -1));

        jtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, "", null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "*Codigo_mantenimiento", "Descripcion", "Fecha_mantenimiento", "*ID_tecnicio", "*Codigo_juego"
            }
        ));
        jScrollPane1.setViewportView(jtable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 770, 90));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Descripcion");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Fecha Mantenimiento");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 490, -1, -1));

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
        jPanel1.add(btnmodificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 450, 130, 40));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Regresar.png"))); // NOI18N
        jButton3.setText("Regresar");
        jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton3.setContentAreaFilled(false);
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 500, 130, 40));

        txtdes.setColumns(20);
        txtdes.setRows(5);
        jScrollPane2.setViewportView(txtdes);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, 290, 110));
        jPanel1.add(dateMan, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 510, 250, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 845, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE)
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
        Modificar_Mantenimiento(BaseD);
        Cerrar_BD(BaseD);
        txtcodM.setEditable(true);
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
            java.util.logging.Logger.getLogger(Mantenimiento_modificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mantenimiento_modificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mantenimiento_modificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mantenimiento_modificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mantenimiento_modificar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnmodificar;
    private com.toedter.calendar.JDateChooser dateMan;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtable;
    private javax.swing.JTextField txtcodM;
    private javax.swing.JTextArea txtdes;
    // End of variables declaration//GEN-END:variables
}
