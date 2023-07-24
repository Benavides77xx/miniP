
package jose;
import Clases.Dueño;
import Clases.Juego;
import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import java.util.Date;
import javax.swing.JOptionPane;


public class Juego_crud extends javax.swing.JFrame {

    
     String codigo_juego ="" ;
     String descripcion="";
     String nombre_juego="";
     Date año_creacion=null;
     int capacidad=0;
     double duracion=0;
     String id_dueño="";   
    
    public static String direccionBD = ("C:\\Users\\jose\\Documents\\Base guia\\guia.yap");
    
    public Juego_crud() {
        initComponents();
    }
    
    public void asignarVariables(ObjectContainer basep){
    codigo_juego=txtcodigo.getText();
    descripcion=txtdescripcion.getText();
    nombre_juego=txtnombre.getText();
    año_creacion = dateCreacion.getDate();
    capacidad = (Integer) txtcapacidad.getValue();
    duracion = Double.parseDouble(txtduracion.getText());
    id_dueño=txtiddueño.getText();
    }
    public void LimpiarCampos(){
        txtcodigo.setText("");
        txtdescripcion.setText("");
        txtnombre.setText("");
        dateCreacion.setCalendar(null);
        txtcapacidad.setValue(0);
        txtduracion.setText("");
        txtiddueño.setText("");
        
    }
    
    public void crearJuego(ObjectContainer basep){

        boolean error = false;
        if (comprobarJuego(basep, codigo_juego) != 0) {
            error = true;
            JOptionPane.showMessageDialog(this, "YYa existe un juego con este codigo", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else if (comprobarDueño(basep, id_dueño) == 0) {
            error = true;
            JOptionPane.showMessageDialog(null, "No existe ningun dueño registrado con este codigo", "Error (Reglas de integridad)", JOptionPane.ERROR_MESSAGE);
        }

        if (!error) {
            Juego crearJuego = new Juego(codigo_juego, descripcion, nombre_juego, año_creacion, capacidad,duracion,id_dueño);
            basep.set(crearJuego);
            JOptionPane.showMessageDialog(null, "Juego registrado");
            LimpiarCampos();
        }        
        
    }
    public static int comprobarJuego(ObjectContainer basep, String codigo_juego) {
        Juego buscarJ = new Juego(codigo_juego, null, null, null, 0,0,null);
        ObjectSet result = basep.get(buscarJ);
        return result.size();
    }

    public static int comprobarDueño(ObjectContainer basep, String id_dueño) {
        ObjectSet result = basep.get(new Dueño(id_dueño, null, 0,null));
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
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtcodigo = new javax.swing.JTextField();
        txtnombre = new javax.swing.JTextField();
        txtiddueño = new javax.swing.JTextField();
        txtduracion = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtdescripcion = new javax.swing.JTextArea();
        txtcapacidad = new javax.swing.JSpinner();
        dateCreacion = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Registro Juego");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("*Codigo juego");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Nombre ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Duracion");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 170, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Año creacion");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 240, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Capacidad");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 110, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("*Id_dueño");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 310, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Descripcion");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, -1, -1));

        txtcodigo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtcodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 200, 30));

        txtnombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 200, 30));

        txtiddueño.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtiddueño, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 330, 190, 30));

        txtduracion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtduracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 190, 190, 30));

        txtdescripcion.setColumns(20);
        txtdescripcion.setRows(5);
        txtdescripcion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setViewportView(txtdescripcion);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 190, -1));

        txtcapacidad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtcapacidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 130, 190, 30));

        dateCreacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(dateCreacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 260, 190, 30));

        jButton1.setBackground(new java.awt.Color(255, 102, 51));
        jButton1.setText("Guardar");
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 390, 290, 30));

        jButton2.setBackground(new java.awt.Color(255, 102, 51));
        jButton2.setText("Regresar");
        jButton2.setBorderPainted(false);
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 430, 290, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ObjectContainer BaseD = Db4o.openFile(direccionBD);
        crearJuego(BaseD);
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
            java.util.logging.Logger.getLogger(Juego_crud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Juego_crud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Juego_crud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Juego_crud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Juego_crud().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser dateCreacion;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner txtcapacidad;
    private javax.swing.JTextField txtcodigo;
    private javax.swing.JTextArea txtdescripcion;
    private javax.swing.JTextField txtduracion;
    private javax.swing.JTextField txtiddueño;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}
