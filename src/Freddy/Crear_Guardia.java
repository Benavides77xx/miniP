/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Freddy;

import Clases.Guardia;
import Clases.Pais;
import Clases.Persona;
import Clases.Tipo_sangre;
import com.db4o.*;
import com.db4o.query.Query;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo
 */
public class Crear_Guardia extends javax.swing.JFrame {

    /**
     * Creates new form Crear_Guardia
     */
    public Crear_Guardia() {
        initComponents();
    }

    String Cedula_per_guar = "";
    String nombre_per_guar = "";
    String apellido_per_guar = "";
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

    public void LimpiarCampos() {

        Ced_Taquillero.setText("");
        nom_taquillero.setText("");
        ape_tequillero.setText("");
        edad_taquillero.setText("");
        cel_taquillero.setText("");
        Correo_taquillero.setText("");
        tipo_sangre_txt.setText("");
        pais_txt.setText("");
        id_guardia.setText("");
        años_experienca.setText("");
        disponibilidad_guardia.setText("");
        especialidad_guardia.setText("");

    }

    public void asignarVariables(ObjectContainer BaseD) {
        Cedula_per_guar = Ced_Taquillero.getText();
        nombre_per_guar = nom_taquillero.getText();
        apellido_per_guar = ape_tequillero.getText();

        String edadStr = edad_taquillero.getText();
        edad_per_taq = !edadStr.isEmpty() ? Integer.parseInt(edadStr) : 0;

        genero_per_taq = (String) Genero_combobox.getSelectedItem();
        celular_per_taq = cel_taquillero.getText();
        fechanac_per_taq = fechaNa.getDate();
        correo_per_taq = Correo_taquillero.getText();
        tiposangre_per_taq = tipo_sangre_txt.getText();
        id_guardia_per = id_guardia.getText();

        // Corregir la asignación de años_expreriencia_guar
        String añosExperienciaStr = años_experienca.getText();
        años_expreriencia_guar = !añosExperienciaStr.isEmpty() ? Integer.parseInt(añosExperienciaStr) : 0;

        // Corregir la asignación de disponibilidad_guar
        String disponibilidadStr = disponibilidad_guardia.getText();
        disponibilidad_guar = Boolean.parseBoolean(disponibilidadStr);

        especialidad_guar = especialidad_guardia.getText();
    }

    public void crearGuardia(ObjectContainer BaseD) {
        asignarVariables(BaseD);

        boolean error = false;
        if (comprobarCedula(BaseD, Cedula_per_guar)) {
            error = true;
            JOptionPane.showMessageDialog(this, "Ya existe un Guardia con esta cédula registrada", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            Ced_Taquillero.setText("");
        }
        if (comprobarID(BaseD, id_guardia_per)) {
            error = true;
            JOptionPane.showMessageDialog(this, "Ya existe un Guardia con este ID registrado", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            id_guardia.setText("");
        }

        if (comprobarTS(BaseD, tiposangre_per_taq) == 0) {
            error = true;
            JOptionPane.showMessageDialog(null, "No existe ningun tipo de sangre con este codigo");
        }
        if (comprobarPais(BaseD, codigo_pais_per_taq) == 0) {
            error = true;
            JOptionPane.showMessageDialog(null, "No existe ningun Pais con este codigo");
        }
        if (!error) {
            Guardia miUsuario = new Guardia(id_guardia_per, años_expreriencia_guar, disponibilidad_guar, especialidad_guar, Cedula_per_guar, nombre_per_guar, apellido_per_guar, edad_per_taq, genero_per_taq, celular_per_taq, fechanac_per_taq, correo_per_taq, tiposangre_per_taq, codigo_pais_per_taq);

            BaseD.store(miUsuario);
            JOptionPane.showMessageDialog(null, "Guardia registrado correctamente");
            ObjectSet result = BaseD.queryByExample(new Guardia());
            mostrarDatos(result);
            LimpiarCampos();
        }
    }

    public static boolean comprobarCedula(ObjectContainer BaseD, String Cedula_per_due) {
        Query query = BaseD.query();
        query.constrain(Persona.class);
        query.descend("cedula_per").constrain(Cedula_per_due).equal();
        ObjectSet result = query.execute();
        return !result.isEmpty();
    }

    public static boolean comprobarID(ObjectContainer BaseD, String id_guardia_per) {
        Query query = BaseD.query();
        query.constrain(Guardia.class);
        query.descend("id_dueño").constrain(id_guardia_per).equal();
        ObjectSet result = query.execute();
        return !result.isEmpty();
    }
    
    public static int comprobarTS(ObjectContainer basep, String codigo_tipo_sangre) {

        ObjectSet result = basep.get(new Tipo_sangre(codigo_tipo_sangre, null, 0));
        return result.size();
    }

    public static int comprobarPais(ObjectContainer basep, String codigo_pais_per_taq) {

        ObjectSet result = basep.get(new Pais(codigo_pais_per_taq, null, 0));
        return result.size();
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
        jButton1 = new javax.swing.JButton();
        tipo_sangre_txt = new javax.swing.JTextField();
        pais_txt = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        especialidad_guardia = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtableregistro = new javax.swing.JTable();
        Genero_combobox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Guardia");

        jLabel2.setText("Cedula");

        jLabel3.setText("Nombre");

        jLabel4.setText("Apellidos");

        jLabel5.setText("Edad");

        jLabel6.setText("Genero");

        jLabel7.setText("Celular");

        jLabel8.setText("Fecha Nacimiento");

        jLabel9.setText("Correo");

        jLabel10.setText("Cod Tipo Sangre");

        jLabel11.setText("Cod Tipo Pais");

        jLabel12.setText("ID Guardia");

        jLabel13.setText("Años Expreriencia");

        jLabel15.setText("Disponibilidad");

        jButton1.setText("INGRESAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel16.setText("Especialidad");

        jtableregistro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Guardia", "Cedula", "Nombre", "Apellido", "Edad", "Genero", "Celular", "Fecha Nacimiento", "Correo", "Codigo Tipo Sangre", "Codigo Pais", "Años Experiencia", "Disponibilidad", "Especialidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true, true, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jtableregistro);

        Genero_combobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opcion", "Masculino", "Femenino" }));

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
                                    .addComponent(fechaNa, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                                    .addComponent(Correo_taquillero)
                                    .addComponent(cel_taquillero)
                                    .addComponent(tipo_sangre_txt)
                                    .addComponent(pais_txt))
                                .addGap(150, 150, 150)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(188, 188, 188))))
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
                                .addComponent(edad_taquillero)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16))
                        .addGap(51, 51, 51)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(disponibilidad_guardia, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(especialidad_guardia, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(años_experienca, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(id_guardia, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(65, 65, 65))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(109, 109, 109)
                        .addComponent(Genero_combobox, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 849, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(id_guardia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(Genero_combobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
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
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(pais_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ObjectContainer BaseD = Db4o.openFile(jose.INICIO.direccionBD);
        crearGuardia(BaseD);
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
            java.util.logging.Logger.getLogger(Crear_Guardia.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Crear_Guardia.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Crear_Guardia.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Crear_Guardia.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Crear_Guardia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Ced_Taquillero;
    private javax.swing.JTextField Correo_taquillero;
    private javax.swing.JComboBox<String> Genero_combobox;
    private javax.swing.JTextField ape_tequillero;
    private javax.swing.JTextField años_experienca;
    private javax.swing.JTextField cel_taquillero;
    private javax.swing.JTextField disponibilidad_guardia;
    private javax.swing.JTextField edad_taquillero;
    private javax.swing.JTextField especialidad_guardia;
    private com.toedter.calendar.JDateChooser fechaNa;
    private javax.swing.JTextField id_guardia;
    private javax.swing.JButton jButton1;
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
