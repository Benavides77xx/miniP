package andrea;

import Clases.Pais;
import Clases.Persona;
import Clases.Tecnico;
import Clases.Tipo_sangre;
import com.db4o.*;
import java.util.Date;
import javax.swing.JOptionPane;
import Clases.Tecnico;
import com.db4o.query.Query;
import jose.INICIO;

public class Tecnico_crud extends javax.swing.JFrame { 
    public Tecnico_crud() {
        initComponents();    
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel10 = new javax.swing.JLabel();
        generos = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        idtecnico = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cedtecnico = new javax.swing.JTextField();
        nomtecnico = new javax.swing.JTextField();
        apetecnico = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        celulartec = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        nacimientotec = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        correotecnico = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        sangretec = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        estudiotec = new javax.swing.JTextField();
        paistec = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        ref = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        edadtecnico = new javax.swing.JSpinner();
        exp = new javax.swing.JSpinner();
        Genero_combobox = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();

        jLabel10.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 14)); // NOI18N
        jLabel10.setText("CORREO ELECTRONICO :");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(188, 206, 223));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TECNICO ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Copperplate Gothic Light", 1, 24))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 14)); // NOI18N
        jLabel1.setText("*CÉDULA  :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));
        jPanel1.add(idtecnico, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 180, -1));

        jLabel2.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 14)); // NOI18N
        jLabel2.setText("NOMBRE :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        jLabel3.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 14)); // NOI18N
        jLabel3.setText("apellido :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        jLabel4.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 14)); // NOI18N
        jLabel4.setText("REFERENCIAS : ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, -1));

        jLabel5.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 14)); // NOI18N
        jLabel5.setText("AÑOS DE EXPERIENCIA  :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 320, -1, 20));

        cedtecnico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cedtecnicoActionPerformed(evt);
            }
        });
        jPanel1.add(cedtecnico, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 180, -1));
        jPanel1.add(nomtecnico, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 180, -1));

        apetecnico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apetecnicoActionPerformed(evt);
            }
        });
        jPanel1.add(apetecnico, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 180, -1));

        jLabel6.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 14)); // NOI18N
        jLabel6.setText("EDAD : ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        jLabel7.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 14)); // NOI18N
        jLabel7.setText("GÉNERO  : ");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));
        jPanel1.add(celulartec, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, 180, -1));

        jLabel8.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 14)); // NOI18N
        jLabel8.setText("*ID TECNICO : ");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));
        jPanel1.add(nacimientotec, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 130, 170, -1));

        jLabel9.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 14)); // NOI18N
        jLabel9.setText("FECHA DE NACIMIENTO : ");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, -1, -1));
        jPanel1.add(correotecnico, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 160, 170, -1));

        jLabel11.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 14)); // NOI18N
        jLabel11.setText("CORREO ELECTRONICO :");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 160, -1, -1));
        jPanel1.add(sangretec, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 200, 170, -1));

        jLabel12.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 14)); // NOI18N
        jLabel12.setText("*Cod_tipo_sangre");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 200, -1, 20));

        jLabel13.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 14)); // NOI18N
        jLabel13.setText("*COD_PAIS :");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 240, -1, 20));

        jLabel14.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 14)); // NOI18N
        jLabel14.setText("NIVEL DE ESTUDIO : ");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 280, -1, 20));
        jPanel1.add(estudiotec, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 280, 170, -1));
        jPanel1.add(paistec, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 240, 170, -1));

        jLabel15.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 14)); // NOI18N
        jLabel15.setText("CELULAR : ");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));
        jPanel1.add(ref, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, 590, -1));

        jButton1.setBackground(new java.awt.Color(96, 153, 210));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton1.setText("GUARDAR ");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 410, 120, 30));
        jPanel1.add(edadtecnico, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 70, -1));
        jPanel1.add(exp, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 320, 40, -1));

        Genero_combobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opcion", "Masculino", "Femenino" }));
        jPanel1.add(Genero_combobox, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, -1, -1));

        jButton2.setText("Regresar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 50, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 789, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cedtecnicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cedtecnicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cedtecnicoActionPerformed

    private void apetecnicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apetecnicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apetecnicoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    ObjectContainer BaseD = Db4o.openFile(INICIO.direccionBD);
    creartecnico(BaseD);
    Cerrar_BDD(BaseD);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        
     
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
        INICIO mostrar = new INICIO();
        mostrar.setVisible(true);         // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed
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
    
    public void limpiar(){
         
        idtecnico.setText("");
        cedtecnico.setText("");
        nomtecnico.setText("");
        apetecnico.setText("");
        edadtecnico.setValue(0);
        generos.clearSelection();
        celulartec.setText("");
        nacimientotec.setDate(null);
        correotecnico.setText("");
        sangretec.setText("");
        paistec.setText("");
        estudiotec.setText("");
        exp.setValue(0);
        ref.setText("");
        
    }
    
    public void asignarVariables(ObjectContainer BaseD){
    
        id_tecnico = idtecnico.getText();
        cedula= cedtecnico.getText();
        nombre= nomtecnico.getText();
        apellido= apetecnico.getText();
        edad= (Integer)edadtecnico.getValue();
        genero = (String) Genero_combobox.getSelectedItem();
        celular = celulartec.getText();
        fecha_nacimiento = nacimientotec.getDate();
        correo = correotecnico.getText();
        codigo_tipo_sangre=sangretec.getText();
        codigo_pais=paistec.getText();
        nivel_estudio_tec = estudiotec.getText();
        a_experiencia_tec=(Integer)exp.getValue();
        referencias_tec =ref.getText();
    
    
    }   
    
    public void creartecnico(ObjectContainer BaseD){
        
           boolean error=false;
            if (comprobarCedula(BaseD, cedula)) {
                error = true;
                JOptionPane.showMessageDialog(this, "Ya existe un usuario con esta cedula registrada","ERROR",0);     
            } else {
                cedtecnico.setText("");
            }       
            if (!comprobarID(BaseD,id_tecnico)) {
                error = true;
                JOptionPane.showMessageDialog(this, "Ya existe un Tecnico con este ID registrado","ERROR",0);
            } else{
                idtecnico.setText("");
            }       
            if (comprobarTS(BaseD,codigo_tipo_sangre) == 0 ) {
                error = true;
                JOptionPane.showMessageDialog(null, "No existe ningun tipo de sangre con este codigo");
            }
            if (comprobarPais(BaseD,codigo_pais) == 0 ) {
                error = true;
                JOptionPane.showMessageDialog(null, "No existe ningun Pais con este codigo");
            }
            
            if (!error) {
                Tecnico Tpnuevo = new Tecnico (id_tecnico,nivel_estudio_tec,a_experiencia_tec,referencias_tec,cedula,nombre,
                        apellido,edad,genero,celular,fecha_nacimiento,correo,codigo_tipo_sangre,codigo_pais);
                BaseD.set(Tpnuevo);
                JOptionPane.showMessageDialog(null, "Cliente registrado correctamente");
                limpiar();
        }
        
    }
    
    public static boolean comprobarCedula(ObjectContainer BaseD, String cedula) {
        Query query = BaseD.query();
        query.constrain(Persona.class);
        query.descend("cedula_per").constrain(cedula).equal();
        ObjectSet result = query.execute();
        return !result.isEmpty();
    }

    public static boolean comprobarID(ObjectContainer BaseD, String id_tecnico) {
        Query query = BaseD.query();
        query.constrain(Tecnico.class);
        query.descend("id_dueño").constrain(id_tecnico).equal();
        ObjectSet result = query.execute();
        return !result.isEmpty();
    }
          
    public static int comprobarTS(ObjectContainer basep, String codigo_tipo_sangre) {

            ObjectSet result = basep.get(new Tipo_sangre(codigo_tipo_sangre,null,0));          
            return result.size();
    }
        public static int comprobarPais(ObjectContainer basep, String codigo_pais_per_taq) {

            ObjectSet result = basep.get(new Pais(codigo_pais_per_taq,null,0));          
            return result.size();
    }    
        

    public static void Cerrar_BDD(ObjectContainer basep) {

        basep.close();
    }

    
    
    

  
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
            java.util.logging.Logger.getLogger(Tecnico_crud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tecnico_crud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tecnico_crud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tecnico_crud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tecnico_crud().setVisible(true);
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
    private javax.swing.JTextField estudiotec;
    private javax.swing.JSpinner exp;
    private javax.swing.ButtonGroup generos;
    private javax.swing.JTextField idtecnico;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    private com.toedter.calendar.JDateChooser nacimientotec;
    private javax.swing.JTextField nomtecnico;
    private javax.swing.JTextField paistec;
    private javax.swing.JTextField ref;
    private javax.swing.JTextField sangretec;
    // End of variables declaration//GEN-END:variables
}
