/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Freddy;

import Clases.Guardia;
import com.db4o.*;

import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo
 */
public class Modificar_Guardia extends javax.swing.JFrame {

    /**
     * Creates new form Modificar_Guardia
     */
    public Modificar_Guardia() {
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
    String id_guardia_per = "";
    int años_expreriencia_guar;
    boolean disponibilidad_guar;
    String especialidad_guar = "";

    public void buscar(ObjectContainer basep) {//cargardatos

        Modificarjb.setEnabled(false);
        String IDAux;
        IDAux = id_guardia.getText();

        Crear_Guardia EAux = new Crear_Guardia();

        if (id_guardia.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Ingrese un ID");
        } else {

            if (!EAux.comprobarID(basep, IDAux)) {

                JOptionPane.showMessageDialog(null, "El guardia no existe en la base de datos");
                LimpiarCampos();

            } else {

                Guardia Ebuscar = new Guardia(IDAux, 0, false, null, null, null, null, 0, null, null, null, null, null, null);

                ObjectSet result = basep.get(Ebuscar);
                for (int i = 0; i < result.size(); i++) {

                    Guardia miE = new Guardia();

                    miE = (Guardia) result.get(i);

                    Ced_Taquillero.setText(miE.getCedula_per());
                    nom_taquillero.setText(miE.getNombre_per());
                    ape_tequillero.setText(miE.getApellido());
                    edad_taquillero.setText(String.valueOf(miE.getEdad_per()));
                    cel_taquillero.setText(miE.getCelular_per());
                    fechaNa.setDate((miE.getFecha_nac()));
                    Correo_taquillero.setText(miE.getCorreo());
                    tipo_sangre_txt.setText(miE.getCodigo_tipo_sangre());
                    pais_txt.setText(miE.getCodigo_pais());
                    id_guardia.setText(miE.getId_guardia());
                    años_experienca.setText(String.valueOf(miE.getAños_expreriencia()));
                    disponibilidad_guardia.setText(String.valueOf(miE.isDisponibilidad()));
                    especialidad_guardia.setText(miE.getCod_especialidad());

                    Modificarjb.setEnabled(true);
                    //Hacer editable los campos de texto
                    mostrarDatos(result);
                    HabilitarCampos_deTexto();
                    id_guardia.setEditable(false);
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
        id_guardia.setText("");
        años_experienca.setText("");
        disponibilidad_guardia.setText("");
        especialidad_guardia.setText("");

    }

    public void HabilitarCampos_deTexto() {
        nom_taquillero.setEditable(true);
        ape_tequillero.setEditable(true);
        edad_taquillero.setEditable(true);
        cel_taquillero.setEditable(true);
        Correo_taquillero.setEditable(true);

        años_experienca.setEditable(true);
        disponibilidad_guardia.setEditable(true);
        especialidad_guardia.setEditable(true);
        tipo_sangre_txt.setEditable(true);
        pais_txt.setEditable(true);

    }

    public void Modificar_pintura(ObjectContainer basep) {

        Guardia Emodi = new Guardia(id_guardia.getText(), 0, false, null, null, null, null, 0,null, null, null, null, null, null);
        ObjectSet result = basep.get(Emodi);
        Guardia Emodificar = (Guardia) result.next();
        Emodificar.setNombre_per(nom_taquillero.getText());
        Emodificar.setApellido(ape_tequillero.getText());
        Emodificar.setEdad_per(Integer.parseInt(edad_taquillero.getText()));
        Emodificar.setCelular_per(cel_taquillero.getText());
        Emodificar.setCorreo(Correo_taquillero.getText());
        Emodificar.setAños_expreriencia(Integer.parseInt(años_experienca.getText()));
        Emodificar.setDisponibilidad(Boolean.parseBoolean(disponibilidad_guardia.getText()));
        Emodificar.setCod_especialidad(especialidad_guardia.getText());
        Emodificar.setCodigo_tipo_sangre(tipo_sangre_txt.getText());
        Emodificar.setCodigo_pais(pais_txt.getText());
        ;
        basep.set(Emodificar);
        JOptionPane.showMessageDialog(null, "La pintura fue modificado exitosamente");

        mostrarDatos(result);
        LimpiarCampos();
    }

    public static void Cerrar_BD(ObjectContainer basep) {

        basep.close();
    }

    public void mostrarDatos(ObjectSet result) {
        DefaultTableModel model = (DefaultTableModel) jtableregistro.getModel();
        model.setRowCount(0); // Limpiar la tabla

        if (result.size() == 0) {
            JOptionPane.showMessageDialog(null, "El usuario no existe");
        } else {
            while (result.hasNext()) {
                Guardia mitaquillero = (Guardia) result.next();
                Object[] fila = {
                    mitaquillero.getId_guardia(),
                    mitaquillero.getCedula_per(),
                    mitaquillero.getNombre_per(),
                    mitaquillero.getApellido(),
                    mitaquillero.getEdad_per(),
                    mitaquillero.getGenero(),
                    mitaquillero.getCelular_per(),
                    String.valueOf(mitaquillero.getFecha_nac()),
                    mitaquillero.getCorreo(),
                    mitaquillero.getCodigo_tipo_sangre(),
                    mitaquillero.getCodigo_pais(),
                    mitaquillero.getAños_expreriencia(),
                    mitaquillero.isDisponibilidad(),
                    mitaquillero.getCod_especialidad()
                };
                model.addRow(fila);
            }
        }
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
        Ced_Taquillero = new javax.swing.JTextField();
        nom_taquillero = new javax.swing.JTextField();
        ape_tequillero = new javax.swing.JTextField();
        edad_taquillero = new javax.swing.JTextField();
        cel_taquillero = new javax.swing.JTextField();
        Correo_taquillero = new javax.swing.JTextField();
        fechaNa = new com.toedter.calendar.JDateChooser();
        id_guardia = new javax.swing.JTextField();
        años_experienca = new javax.swing.JTextField();
        disponibilidad_guardia = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtableregistro = new javax.swing.JTable();
        tipo_sangre_txt = new javax.swing.JTextField();
        pais_txt = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        especialidad_guardia = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        Modificarjb = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Cliente");

        jLabel2.setText("Cedula");

        jLabel3.setText("Nombre");

        jLabel4.setText("Apellidos");

        jLabel5.setText("Edad");

        jLabel6.setText("Genero");

        jLabel7.setText("Celular");

        jLabel8.setText("Fecha Nacimiento");

        jLabel9.setText("Correo");

        jLabel10.setText("Tipo Sangre");

        jLabel11.setText("Pais");

        jLabel12.setText("ID Guardia");

        jLabel13.setText("Años Expreriencia");

        jLabel15.setText("Disponibilidad");

        jtableregistro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Cliente", "Cedula", "Nombre", "Apellido", "Edad", "Genero", "Celular", "Fecha Nacimiento", "Correo", "Tipo Sangre", "Pais", "Habilidades", "Intereses Personales"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jtableregistro);

        jLabel16.setText("Especialidad");

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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(239, 239, 239)
                                .addComponent(jLabel1)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fechaNa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Correo_taquillero)
                                    .addComponent(cel_taquillero)
                                    .addComponent(tipo_sangre_txt)
                                    .addComponent(pais_txt))
                                .addGap(197, 197, 197)
                                .addComponent(Modificarjb)
                                .addGap(218, 218, 218))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(111, 111, 111)
                                .addComponent(Ced_Taquillero))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(105, 105, 105)
                                .addComponent(nom_taquillero))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(98, 98, 98)
                                .addComponent(ape_tequillero))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(122, 122, 122)
                                .addComponent(edad_taquillero))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(años_experienca, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(disponibilidad_guardia, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(especialidad_guardia, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(id_guardia, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2)))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(85, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 849, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
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
                    .addComponent(id_guardia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(nom_taquillero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(años_experienca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel15)
                    .addComponent(ape_tequillero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(disponibilidad_guardia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(edad_taquillero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(especialidad_guardia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cel_taquillero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addComponent(jLabel8))
                    .addComponent(fechaNa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(Correo_taquillero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(tipo_sangre_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Modificarjb, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(pais_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        id_guardia.setEditable(true);
    }//GEN-LAST:event_ModificarjbActionPerformed

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
            java.util.logging.Logger.getLogger(Modificar_Guardia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Modificar_Guardia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Modificar_Guardia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Modificar_Guardia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Modificar_Guardia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Ced_Taquillero;
    private javax.swing.JTextField Correo_taquillero;
    private javax.swing.JButton Modificarjb;
    private javax.swing.JTextField ape_tequillero;
    private javax.swing.JTextField años_experienca;
    private javax.swing.JTextField cel_taquillero;
    private javax.swing.JTextField disponibilidad_guardia;
    private javax.swing.JTextField edad_taquillero;
    private javax.swing.JTextField especialidad_guardia;
    private com.toedter.calendar.JDateChooser fechaNa;
    private javax.swing.JTextField id_guardia;
    private javax.swing.JButton jButton2;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtableregistro;
    private javax.swing.JTextField nom_taquillero;
    private javax.swing.JTextField pais_txt;
    private javax.swing.JTextField tipo_sangre_txt;
    // End of variables declaration//GEN-END:variables
}
