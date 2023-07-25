/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Freddy;

import Clases.Cliente;
import Clases.Habilidades;
import Clases.Persona;
import Clases.Tipo_sangre;
import java.util.Date;
import com.db4o.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;
import jose.INICIO;

/**
 *
 * @author Lenovo
 */
public class Crear_Cliente extends javax.swing.JFrame {

    /**
     * Creates new form Crear_Cliente
     */
    
   
    public Crear_Cliente() {
        initComponents();
    }

    String Cedula_per_taq = "";
    String nombre_per_taq = "";
    String apellido_per_taq = "";
    int edad_per_taq = 0;
    char genero_per_taq;
    String celular_per_taq = "";
    Date fechanac_per_taq;
    String correo_per_taq = "";
    String codigo_tipo_sangre = "";
    String codigo_pais_per_taq = "";
    String id_cliente_per = "";
    String codigo_habilidad = "";
    String inter_per = "";

    public void LimpiarCampos() {

        Ced_Taquillero.setText("");
        nom_taquillero.setText("");
        ape_tequillero.setText("");
        edad_taquillero.setText("");
        cel_taquillero.setText("");
        Correo_taquillero.setText("");
        tipo_sangre_txt.setText("");
        pais_txt.setText("");
        pais_txt.setText("");
        id_cliente.setText("");
        txthabilidad.setText("");
        intereses_per_cli.setText("");

    }

    public void asignarVariables(ObjectContainer BaseD) {
        Cedula_per_taq = Ced_Taquillero.getText();
        nombre_per_taq = nom_taquillero.getText();
        apellido_per_taq = ape_tequillero.getText();

        String edadStr = edad_taquillero.getText();
        edad_per_taq = !edadStr.isEmpty() ? Integer.parseInt(edadStr) : 0;

        // genero_per_taq;
        celular_per_taq = cel_taquillero.getText();
        fechanac_per_taq = fechaNa.getDate();
        correo_per_taq = Correo_taquillero.getText();
        codigo_tipo_sangre = tipo_sangre_txt.getText();
        codigo_pais_per_taq = pais_txt.getText();
        codigo_pais_per_taq = pais_txt.getText();
        id_cliente_per = id_cliente.getText();
        codigo_habilidad = txthabilidad.getText();
        inter_per = intereses_per_cli.getText();

    }

    public void crearCliente(ObjectContainer BaseD) {
               boolean error=false;
            if (comprobarCedula(BaseD, Cedula_per_taq) != 0) {
                error = true;
                JOptionPane.showMessageDialog(this, "Ya existe un usuario con esta cedula registrada","ERROR",0);     
            } else {
                Ced_Taquillero.setText("");
            }       
            if (comprobarID(BaseD,id_cliente_per) != 0) {
                error = true;
                JOptionPane.showMessageDialog(this, "Ya existe un Cliente con este ID registrado","ERROR",0);
            } else{
                id_cliente.setText("");
            }       
            if (comprobarHabilidad(BaseD,codigo_habilidad) == 0 ) {
                error = true;
                JOptionPane.showMessageDialog(null, "No existe ninguna Habilidad con este codigo");
            }
            if (comprobarTS(BaseD,codigo_tipo_sangre) == 0 ) {
                error = true;
                JOptionPane.showMessageDialog(null, "No existe ningun tipo de sangre con este codigo");
            }
            
            if (!error) {
                Cliente miUsuario = new Cliente(id_cliente_per, codigo_habilidad, inter_per, Cedula_per_taq, nombre_per_taq, apellido_per_taq, edad_per_taq, genero_per_taq, celular_per_taq, 
                        fechanac_per_taq, correo_per_taq, codigo_tipo_sangre, codigo_pais_per_taq);
                BaseD.set(miUsuario);
                JOptionPane.showMessageDialog(null, "Cliente registrado correctamente");
                LimpiarCampos();
        }
    }
     public static int comprobarCedula(ObjectContainer base, String cedula_per) {
            Persona buscarCedula = new Persona(cedula_per, null, null,0,'\0',null,null,null,null,null);
            ObjectSet result = base.get(buscarCedula);
            return result.size();
    }
    public static int comprobarID(ObjectContainer base, String id_cliente_per) {
            Cliente buscarID = new Cliente(id_cliente_per,null,null,null, null, null,0,'\0',null,null,null,null,null);
            ObjectSet result = base.get(buscarID);
            return result.size();
    }
          
    public static int comprobarHabilidad(ObjectContainer basep, String codigo_habilidad) {

            ObjectSet result = basep.get(new Habilidades(codigo_habilidad,null,null));          
            return result.size();
    }
    public static int comprobarTS(ObjectContainer basep, String codigo_tipo_sangre) {

            ObjectSet result = basep.get(new Tipo_sangre(codigo_tipo_sangre,null,0));          
            return result.size();
    }



    public void mostrarDatos(ObjectSet result) {
        DefaultTableModel model = (DefaultTableModel) jtableregistro.getModel();
        model.setRowCount(0); // Limpiar la tabla

        if (result.size() == 0) {
            JOptionPane.showMessageDialog(null, "El usuario no existe");
        } else {
            while (result.hasNext()) {
                Cliente mitaquillero = (Cliente) result.next();
                Object[] fila = {
                    mitaquillero.getId_cliente(),
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
                    mitaquillero.getCodigo_Habilidad(),
                    mitaquillero.getIntereses_personales(),};
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
        id_cliente = new javax.swing.JTextField();
        txthabilidad = new javax.swing.JTextField();
        intereses_per_cli = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtableregistro = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        tipo_sangre_txt = new javax.swing.JTextField();
        pais_txt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Cliente");

        jLabel2.setText("*Cedula");

        jLabel3.setText("Nombre");

        jLabel4.setText("Apellidos");

        jLabel5.setText("Edad");

        jLabel6.setText("Genero");

        jLabel7.setText("Celular");

        jLabel8.setText("Fecha Nacimiento");

        jLabel9.setText("Correo");

        jLabel10.setText("*Cod_Tipo Sangre");

        jLabel11.setText("Pais");

        jLabel12.setText("ID Cliente");

        jLabel13.setText("*Codigo_Habilidad");

        jLabel15.setText("Intereses Personales");

        jtableregistro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Cliente", "Cedula", "Nombre", "Apellido", "Edad", "Genero", "Celular", "Fecha Nacimiento", "Correo", "cod_Tipo Sangre", "Pais", "Codigo_habilidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jtableregistro);

        jButton1.setText("INGRESAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
                                .addComponent(edad_taquillero))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(112, 112, 112)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(intereses_per_cli, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                            .addComponent(txthabilidad)
                            .addComponent(id_cliente))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(id_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel13)
                    .addComponent(nom_taquillero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txthabilidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel15)
                    .addComponent(ape_tequillero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(intereses_per_cli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(edad_taquillero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(19, 19, 19)
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
                            .addComponent(tipo_sangre_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(pais_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(fechaNa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ObjectContainer BaseD = Db4o.openFile(INICIO.direccionBD);
        crearCliente(BaseD);
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
            java.util.logging.Logger.getLogger(Crear_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Crear_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Crear_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Crear_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Crear_Cliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Ced_Taquillero;
    private javax.swing.JTextField Correo_taquillero;
    private javax.swing.JTextField ape_tequillero;
    private javax.swing.JTextField cel_taquillero;
    private javax.swing.JTextField edad_taquillero;
    private com.toedter.calendar.JDateChooser fechaNa;
    private javax.swing.JTextField id_cliente;
    private javax.swing.JTextField intereses_per_cli;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
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
    private javax.swing.JTextField txthabilidad;
    // End of variables declaration//GEN-END:variables
}
