/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Freddy;

import Clases.Dueño;
import static Freddy.Crear_Dueño.comprobarID;
import com.db4o.*;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo
 */
public class Modificar_Dueño extends javax.swing.JFrame {

    /**
     * Creates new form Modificar_Dueño
     */
    public Modificar_Dueño() {
        initComponents();
    }

    String Cedula_per_taq = "";
    String nombre_per_taq = "";
    String apellido_per_taq = "";
    int edad_per_taq = 0;
    String genero_per_taq;
    String celular_per_taq = "";
    Date fechanac_per_taq;
    String correo_per_taq = "";
    String tiposangre_per_taq = "";
    String codigo_pais_per_taq = "";
    String codigo_dueño = "";
    String historia_propiedadtxt = "";
    int anios_experiencia;
    String habilidade_financieras = "";

    public void buscar(ObjectContainer basep) {//cargardatos

        Modificarjb.setEnabled(false);
        String IDAux;
        IDAux = id_dueño.getText();

        Crear_Dueño EAux = new Crear_Dueño();

        if (id_dueño.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Ingrese un ID");
        } else {

            if (!EAux.comprobarID(basep, IDAux)) {

                JOptionPane.showMessageDialog(null, "El dueño no existe en la base de datos");
                LimpiarCampos();

            } else {

                Dueño Ebuscar = new Dueño(IDAux, null, 0, null, null, null, null, 0,null, null, null, null, null, null);

                ObjectSet result = basep.get(Ebuscar);
                for (int i = 0; i < result.size(); i++) {

                    Dueño miE = new Dueño();

                    miE = (Dueño) result.get(i);

                    Ced_Taquillero.setText(miE.getCedula_per());
                    nom_taquillero.setText(miE.getNombre_per());
                    ape_tequillero.setText(miE.getApellido());
                    edad_taquillero.setText(String.valueOf(miE.getEdad_per()));
                    cel_taquillero.setText(miE.getCelular_per());
                    fechaNa.setDate((miE.getFecha_nac()));
                    Correo_taquillero.setText(miE.getCorreo());
                    tipo_sangre_txt.setText(miE.getCodigo_tipo_sangre());
                    pais_txt.setText(miE.getCodigo_pais());
                    id_dueño.setText(miE.getId_dueño());
                    Genero_combobox.setSelectedItem(miE.getGenero());
                    historiall_propiedad_txt.setText(miE.getHistorial_propiedad());
                    años_experiencia.setText(String.valueOf(miE.getAños_experiencia()));
                    habilidades_financieras_txt.setText(miE.getHabilidades_finacieras());

                    Modificarjb.setEnabled(true);
                    //Hacer editable los campos de texto
                    
                    HabilitarCampos_deTexto();
                    tipo_sangre_txt.setEditable(false);
                    pais_txt.setEditable(false);
                    id_dueño.setEditable(false);
                    Ced_Taquillero.setEditable(false);

                }

            }

        }
    }

    public void LimpiarCampos() {

        Ced_Taquillero.setText("");
        nom_taquillero.setText("");
        ape_tequillero.setText("");
        edad_taquillero.setText("");
        cel_taquillero.setText("");
        Correo_taquillero.setText("");
        tipo_sangre_txt.setText("");
        pais_txt.setText("");
        id_dueño.setText("");
        historiall_propiedad_txt.setText("");
        años_experiencia.setText("");
        habilidades_financieras_txt.setText("");

    }

    public void HabilitarCampos_deTexto() {
        nom_taquillero.setEditable(true);
        ape_tequillero.setEditable(true);
        edad_taquillero.setEditable(true);
        cel_taquillero.setEditable(true);
        Correo_taquillero.setEditable(true);
        tipo_sangre_txt.setEditable(true);
        pais_txt.setEditable(true);
        historiall_propiedad_txt.setEditable(true);
        años_experiencia.setEditable(true);
        habilidades_financieras_txt.setEditable(true);
        tipo_sangre_txt.setEditable(true);
        pais_txt.setEditable(true);

    }

    public void Modificar_pintura(ObjectContainer basep) {

        Dueño Emodi = new Dueño(id_dueño.getText(), null, 0, null, Ced_Taquillero.getText(), null, null, 0, null, null, null, null, null, null);
        ObjectSet result = basep.get(Emodi);
        Dueño Emodificar = (Dueño) result.next();
        Emodificar.setNombre_per(nom_taquillero.getText());
        Emodificar.setApellido(ape_tequillero.getText());
        Emodificar.setEdad_per(Integer.parseInt(edad_taquillero.getText()));
        Emodificar.setCelular_per(cel_taquillero.getText());
        Emodificar.setCorreo(Correo_taquillero.getText());
        Emodificar.setGenero((String) Genero_combobox.getSelectedItem());
        Emodificar.setHistorial_propiedad(historiall_propiedad_txt.getText());
        Emodificar.setAños_experiencia(Integer.parseInt(años_experiencia.getText()));
        Emodificar.setHabilidades_finacieras(habilidades_financieras_txt.getText());

        Emodificar.setCodigo_tipo_sangre(tipo_sangre_txt.getText());
        Emodificar.setCodigo_pais(pais_txt.getText());
        ;
        basep.set(Emodificar);
        JOptionPane.showMessageDialog(null, "La pintura fue modificado exitosamente");

        
        LimpiarCampos();
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        Ced_Taquillero = new javax.swing.JTextField();
        nom_taquillero = new javax.swing.JTextField();
        ape_tequillero = new javax.swing.JTextField();
        edad_taquillero = new javax.swing.JTextField();
        cel_taquillero = new javax.swing.JTextField();
        Correo_taquillero = new javax.swing.JTextField();
        fechaNa = new com.toedter.calendar.JDateChooser();
        id_dueño = new javax.swing.JTextField();
        historiall_propiedad_txt = new javax.swing.JTextField();
        años_experiencia = new javax.swing.JTextField();
        habilidades_financieras_txt = new javax.swing.JTextField();
        tipo_sangre_txt = new javax.swing.JTextField();
        pais_txt = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        Modificarjb = new javax.swing.JButton();
        Genero_combobox = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setForeground(new java.awt.Color(204, 255, 204));

        jLabel1.setText("DUEÑO MODIFICAR");

        jLabel2.setText("Cedula");

        jLabel3.setText("Nombre");

        jLabel4.setText("Apellidos");

        jLabel5.setText("Edad");

        jLabel6.setText("Genero");

        jLabel7.setText("Celular");

        jLabel8.setText("Fecha Nacimiento");

        jLabel9.setText("Correo");

        jLabel10.setText("cod Tipo Sangre");

        jLabel11.setText("cod Pais");

        jLabel12.setText("ID Dueño");

        jLabel13.setText("Historial propiedad");

        jLabel15.setText("Años Experiencia");

        jLabel16.setText("Habilidades finacieras");

        edad_taquillero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edad_taquilleroActionPerformed(evt);
            }
        });

        jButton2.setText("BUSCAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        Modificarjb.setText("Guardar");
        Modificarjb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarjbActionPerformed(evt);
            }
        });

        Genero_combobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opcion", "Masculino", "Femenino" }));

        jButton3.setText("REGRESAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel8))
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tipo_sangre_txt)
                                    .addComponent(pais_txt))
                                .addGap(515, 515, 515))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cel_taquillero, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fechaNa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                                    .addComponent(Correo_taquillero, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(98, 98, 98)
                                .addComponent(ape_tequillero))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(122, 122, 122)
                                .addComponent(edad_taquillero))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel2))
                                .addGap(105, 105, 105)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nom_taquillero)
                                    .addComponent(Ced_Taquillero)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(Genero_combobox, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 64, Short.MAX_VALUE)))))
                        .addGap(65, 65, 65)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12)
                            .addComponent(jLabel16))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(historiall_propiedad_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(años_experiencia, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(habilidades_financieras_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(id_dueño, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2)))
                        .addGap(21, 21, 21))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(369, 369, 369))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(329, 329, 329)
                .addComponent(Modificarjb, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel12)
                    .addComponent(Ced_Taquillero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(id_dueño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel13)
                    .addComponent(nom_taquillero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(historiall_propiedad_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel15)
                    .addComponent(ape_tequillero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(años_experiencia, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel16)
                    .addComponent(edad_taquillero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(habilidades_financieras_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(Genero_combobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cel_taquillero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(Correo_taquillero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(tipo_sangre_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(pais_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(fechaNa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Modificarjb, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ObjectContainer BaseD = Db4o.openFile(jose.INICIO.direccionBD);
        buscar(BaseD);
        Cerrar_BD(BaseD);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void ModificarjbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarjbActionPerformed
        ObjectContainer BaseD = Db4o.openFile(jose.INICIO.direccionBD);
        Modificar_pintura(BaseD);
        Cerrar_BD(BaseD);
        id_dueño.setEditable(true);
    }//GEN-LAST:event_ModificarjbActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
        jose.INICIO mostrar = new jose.INICIO();
        mostrar.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void edad_taquilleroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edad_taquilleroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edad_taquilleroActionPerformed

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
            java.util.logging.Logger.getLogger(Modificar_Dueño.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Modificar_Dueño.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Modificar_Dueño.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Modificar_Dueño.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Modificar_Dueño().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Ced_Taquillero;
    private javax.swing.JTextField Correo_taquillero;
    private javax.swing.JComboBox<String> Genero_combobox;
    private javax.swing.JButton Modificarjb;
    private javax.swing.JTextField ape_tequillero;
    private javax.swing.JTextField años_experiencia;
    private javax.swing.JTextField cel_taquillero;
    private javax.swing.JTextField edad_taquillero;
    private com.toedter.calendar.JDateChooser fechaNa;
    private javax.swing.JTextField habilidades_financieras_txt;
    private javax.swing.JTextField historiall_propiedad_txt;
    private javax.swing.JTextField id_dueño;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nom_taquillero;
    private javax.swing.JTextField pais_txt;
    private javax.swing.JTextField tipo_sangre_txt;
    // End of variables declaration//GEN-END:variables
}
