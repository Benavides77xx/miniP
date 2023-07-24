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
import java.util.Date;
import javax.swing.JOptionPane;
public class Mantenimiento_crud extends javax.swing.JFrame {

     String codigo_mantenimiento ="" ;
     String descripcion_mantenimiento="";
     Date Fecha_mantenimiento=null;
     String id_tecnico="";
     String codigo_juego="";

    public Mantenimiento_crud() {
        initComponents();
    }
    
    public void asignarVariables(ObjectContainer basep){
    codigo_mantenimiento=txtcodman.getText();
    descripcion_mantenimiento=txtdescripcion.getText();
    Fecha_mantenimiento = dateFecha.getDate();
    id_tecnico=txtidtec.getText();
    codigo_juego=txtcodju.getText();
    }
    public void LimpiarCampos(){
        txtcodman.setText("");
        txtdescripcion.setText("");
        dateFecha.setCalendar(null);
        txtcodju.setText("");      
    }
        public void crearMantenimiento(ObjectContainer basep) {
            boolean error=false;
            if (comprobarMantenimiento(basep, codigo_mantenimiento) != 0) {
                error = true;
                JOptionPane.showMessageDialog(this, "Ya existe un mantenimiento con este codigo registrado","ERROR",0);     
            } else {
                txtcodman.setText("");
            }       
            if (comprobarTecnico(basep,id_tecnico) == 0) {
                error = true;
                JOptionPane.showMessageDialog(null, "No existe ningun tecnico con este codigo registrado");
            }       
            if (comprobarJuego(basep,codigo_juego) == 0 ) {
                error = true;
                JOptionPane.showMessageDialog(null, "No existe ningun juego con este codigo registrado");
            }
            
            if (!error) {
                Mantenimiento crearM = new Mantenimiento (codigo_mantenimiento,descripcion_mantenimiento,Fecha_mantenimiento,id_tecnico,codigo_juego);
                basep.set(crearM);
                JOptionPane.showMessageDialog(null, "Mantenimiento registrado correctamente");
                LimpiarCampos();
        }           
    }   
    public static int comprobarMantenimiento(ObjectContainer base, String codigo_mantenimiento) {
            Mantenimiento buscarM = new Mantenimiento(codigo_mantenimiento, null, null, null, null);
            ObjectSet result = base.get(buscarM);
            return result.size();
    }
//    public static int comprobarTecnico(ObjectContainer basep, String id_tecnico) {
//
//            ObjectSet result = basep.get(new Tecnico(codigo_cassete, null, 0, null, 0));
//            return result.size();
//    }        
    public static int comprobarJuego(ObjectContainer basep, String codigo_juego) {

            ObjectSet result = basep.get(new Juego(codigo_juego,  null, null, null, 0,0,null));          
            return result.size();
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtcodman = new javax.swing.JTextField();
        txtidtec = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtdescripcion = new javax.swing.JTextArea();
        dateFecha = new com.toedter.calendar.JDateChooser();
        txtcodju = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Registro de mantenimiento del Juego");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("*Codigo del mantenimiento");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Descripcion:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Fecha mantenimiento");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("*Id tecnico");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 170, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("*Codigo juego");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 230, -1, -1));
        jPanel1.add(txtcodman, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 240, 30));
        jPanel1.add(txtidtec, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, 190, 30));

        txtdescripcion.setColumns(20);
        txtdescripcion.setRows(5);
        jScrollPane1.setViewportView(txtdescripcion);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 240, -1));
        jPanel1.add(dateFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, 190, 30));
        jPanel1.add(txtcodju, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 250, 190, 30));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Guardar.png"))); // NOI18N
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 330, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Regresar.png"))); // NOI18N
        jButton2.setContentAreaFilled(false);
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 330, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ObjectContainer BaseD = Db4o.openFile(direccionBD);
        crearMantenimiento(BaseD);
        Cerrar_BD(BaseD);
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
            java.util.logging.Logger.getLogger(Mantenimiento_crud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mantenimiento_crud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mantenimiento_crud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mantenimiento_crud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mantenimiento_crud().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser dateFecha;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtcodju;
    private javax.swing.JTextField txtcodman;
    private javax.swing.JTextArea txtdescripcion;
    private javax.swing.JTextField txtidtec;
    // End of variables declaration//GEN-END:variables
}
