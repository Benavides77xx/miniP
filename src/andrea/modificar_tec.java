/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package andrea;

import andrea.Tecnico_crud;
import Clases.Tecnico;
import com.db4o.ObjectContainer;
import com.db4o.*;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jose.INICIO;

/**
 *
 * @author Asus
 */
public class modificar_tec extends javax.swing.JFrame {

    String id_tecnico="";
    String cedula="";
    String nombre="";
    String apellido="";
    int edad=0;
    String genero;
    String celular="";
    Date fecha_nacimiento;
    String correo="";
    String codigo_tipo_sangre="";
    String codigo_pais="";
    String nivel_estudio_tec="";
    int a_experiencia_tec=0;
    String referencias_tec="";
    
    public modificar_tec() {
        initComponents();
    }


    public void limpiar(){
         
        idtecnico.setText("");
        cedtecnico.setText("");
        nomtecnico.setText("");
        apetecnico.setText("");
        edadtecnico.setValue(0);
        generosrb.clearSelection();
        celulartec.setText("");
        nacimientotec.setDate(null);
        correotecnico.setText("");
        sangretec.setText("");
        paistec.setText("");
        estudiotec.setText("");
        exp.setValue(0);
        ref.setText(""); 
    }
    
    public void asignarVariables(ObjectContainer basep){
    
        id_tecnico = idtecnico.getText();
        cedula= cedtecnico.getText();
        nombre= nomtecnico.getText();
        apellido= apetecnico.getText();
        edad= (Integer)edadtecnico.getValue();
        genero= (String) Genero_combobox.getSelectedItem();
        celular = celulartec.getText();
        fecha_nacimiento = nacimientotec.getDate();
        correo = correotecnico.getText();
        codigo_tipo_sangre=sangretec.getText();
        codigo_pais=paistec.getText();
        nivel_estudio_tec = estudiotec.getText();
        a_experiencia_tec=(Integer)exp.getValue();
        referencias_tec =ref.getText();
    }  
    
    public void buscar(ObjectContainer basep) {

        modtecnico.setEnabled(false);
        String auxid;
        auxid = idtecnico.getText();

        Tecnico_crud auxtec = new Tecnico_crud();

        if (idtecnico.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Diguite el ID del Tecnico");
        } else {

            if (auxtec.comprobarID(basep,auxid) ) {

                JOptionPane.showMessageDialog(null, "Este tecnico no se encuentra registrado en la base ");
                limpiar();

            } else {

                Tecnico buscartec = new Tecnico (auxid,null,0,null,null,null,null,0,null,null,null,null,null,null);

                ObjectSet result = basep.get(buscartec);
                for (int i = 0; i < result.size(); i++) {

                    Tecnico tec = new Tecnico ();

                    tec = (Tecnico) result.get(i);

                    cedtecnico.setText(tec.getCedula_per());
                    nomtecnico.setText(tec.getNombre_per());
                    apetecnico.setText(tec.getApellido());
                    edadtecnico.setValue(tec.getEdad_per());
                    Genero_combobox.setToolTipText(tec.getGenero());
                    celulartec.setText(tec.getCelular_per());
                    nacimientotec.setDate(tec.getFecha_nac());
                    correotecnico.setText(tec.getCorreo());
                    sangretec.setText(tec.getCodigo_tipo_sangre());
                    paistec.setText(tec.getCodigo_pais());
                    estudiotec.setText(tec.getNivel_estudio_tec());
                    exp.setValue(tec.getA_experiencia_tec());
                    ref.setText(tec.getReferencias_tec()); 
                    

                    modtecnico.setEnabled(true);
                    habilitarcampos();
                    sangretec.setEditable(false);
                    paistec.setEditable(false);
                    idtecnico.setEditable(false);
                    cedtecnico.setEditable(false);

                }

            }

        }
    }
    
    public void habilitarcampos(){
    
    nomtecnico.setEditable(true);
    apetecnico.setEditable(true);
    edadtecnico.setEnabled(true);
    Genero_combobox.setEditable(true);
    celulartec.setEditable(true);
    nacimientotec.setEnabled(true);
    correotecnico.setEditable(true);
    sangretec.setEditable(true);
    paistec.setEditable(true);
    estudiotec.setEditable(true);
    exp.setEnabled(true);
    ref.setEditable(true);
    
    }
    public void modificartecnico (ObjectContainer basep) {

        Tecnico modificartec = new Tecnico(id_tecnico,null,0,null,cedula,null,null,0,null,null,null,null,null,null);
       ObjectSet result = basep.get(modificartec);
        
        Tecnico modificart = (Tecnico) result.next();
        modificart.setNombre_per(nomtecnico.getText());
        modificart.setApellido(apetecnico.getText());
        modificart.setEdad_per((int) edadtecnico.getValue());
        modificart.setCelular_per(celulartec.getText());
        modificart.setCorreo(correotecnico.getText());
        modificart.setNivel_estudio_tec(estudiotec.getText());
        modificart.setA_experiencia_tec((int)exp.getValue());
        modificart.setReferencias_tec(ref.getText());
        ;
        basep.set(modificart);
        JOptionPane.showMessageDialog(null, "Este tecnico fue modificado ");
        limpiar();
    }
    public static void Cerrar_BD(ObjectContainer basep) {

        basep.close();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        generosrb = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        idtecnico = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        edcnico = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cedtecnico = new javax.swing.JTextField();
        nomtecnico = new javax.swing.JTextField();
        apetecnico = new javax.swing.JTextField();
        nacimientotec = new com.toedter.calendar.JDateChooser();
        jSeparator2 = new javax.swing.JSeparator();
        edadtecnico = new javax.swing.JSpinner();
        celulartec = new javax.swing.JTextField();
        ref = new javax.swing.JTextField();
        correotecnico = new javax.swing.JTextField();
        sangretec = new javax.swing.JTextField();
        paistec = new javax.swing.JTextField();
        estudiotec = new javax.swing.JTextField();
        exp = new javax.swing.JSpinner();
        modtecnico = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        Genero_combobox = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(207, 223, 236));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 12)); // NOI18N
        jLabel1.setText("NOMBRE :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        idtecnico.setBackground(new java.awt.Color(207, 223, 236));
        idtecnico.setBorder(null);
        jPanel1.add(idtecnico, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 170, 20));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 170, 30));

        jLabel2.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 12)); // NOI18N
        jLabel2.setText("ID TECNICO :  ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jLabel3.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 12)); // NOI18N
        jLabel3.setText("APELLIDO : ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));

        edcnico.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 12)); // NOI18N
        edcnico.setText("EDAD : ");
        jPanel1.add(edcnico, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, -1));

        jLabel5.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 12)); // NOI18N
        jLabel5.setText("GENERO : ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, -1, 20));

        jLabel6.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 12)); // NOI18N
        jLabel6.setText("CELULAR : ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, -1, -1));

        jLabel7.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 12)); // NOI18N
        jLabel7.setText("REFERENCIAS : ");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, -1, -1));

        jLabel8.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 12)); // NOI18N
        jLabel8.setText("FECHA DE NACIMIENTO :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 160, -1, -1));

        jLabel9.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 12)); // NOI18N
        jLabel9.setText("Cod_TIPO DE SANGRE : ");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, -1, -1));

        jLabel10.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 12)); // NOI18N
        jLabel10.setText("Cod_PAIS :");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 290, -1, -1));

        jLabel11.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 12)); // NOI18N
        jLabel11.setText("NIVEL DE ESTUDIOS : ");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 340, -1, -1));

        jLabel12.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 12)); // NOI18N
        jLabel12.setText("AÑOS DE EXPERIENCIA : ");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 390, -1, -1));

        jLabel13.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 12)); // NOI18N
        jLabel13.setText("CORREO ELECTRONICO : ");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 200, -1, 20));

        jLabel16.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 12)); // NOI18N
        jLabel16.setText("CEDULA : ");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));
        jPanel1.add(cedtecnico, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 180, -1));
        jPanel1.add(nomtecnico, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 180, -1));
        jPanel1.add(apetecnico, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, 180, -1));
        jPanel1.add(nacimientotec, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 160, 180, -1));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, 10, 260));
        jPanel1.add(edadtecnico, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, 50, -1));
        jPanel1.add(celulartec, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 390, 180, -1));
        jPanel1.add(ref, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 440, 540, -1));
        jPanel1.add(correotecnico, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 200, 180, -1));
        jPanel1.add(sangretec, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 240, 180, -1));
        jPanel1.add(paistec, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 280, 180, -1));
        jPanel1.add(estudiotec, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 330, 180, -1));
        jPanel1.add(exp, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 380, 80, -1));

        modtecnico.setBackground(new java.awt.Color(102, 153, 255));
        modtecnico.setText("MODIFICAR");
        modtecnico.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        modtecnico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modtecnicoActionPerformed(evt);
            }
        });
        jPanel1.add(modtecnico, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 500, 140, 30));

        jButton1.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 12)); // NOI18N
        jButton1.setText("BUSCAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, -1, -1));

        Genero_combobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opcion", "Masculino", "Femenino" }));
        jPanel1.add(Genero_combobox, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, -1, -1));

        jButton2.setText("Regresar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 500, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 877, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void modtecnicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modtecnicoActionPerformed
        ObjectContainer BaseD = Db4o.openFile(jose.INICIO.direccionBD);
        modificartecnico(BaseD);
        Cerrar_BD(BaseD);
        idtecnico.setEditable(true);
    }//GEN-LAST:event_modtecnicoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ObjectContainer BaseD = Db4o.openFile(jose.INICIO.direccionBD);
        buscar(BaseD);
        Cerrar_BD(BaseD);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(modificar_tec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(modificar_tec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(modificar_tec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(modificar_tec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new modificar_tec().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Genero_combobox;
    private javax.swing.JTextField apetecnico;
    private javax.swing.JTextField cedtecnico;
    private javax.swing.JTextField celulartec;
    private javax.swing.JTextField correotecnico;
    private javax.swing.JSpinner edadtecnico;
    private javax.swing.JLabel edcnico;
    private javax.swing.JTextField estudiotec;
    private javax.swing.JSpinner exp;
    private javax.swing.ButtonGroup generosrb;
    private javax.swing.JTextField idtecnico;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton modtecnico;
    private com.toedter.calendar.JDateChooser nacimientotec;
    private javax.swing.JTextField nomtecnico;
    private javax.swing.JTextField paistec;
    private javax.swing.JTextField ref;
    private javax.swing.JTextField sangretec;
    // End of variables declaration//GEN-END:variables
}
