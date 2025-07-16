/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vistaEscritorio;

import Logica.Exception.GestorException;
import Logica.Fachada;
import Logica.Gestor;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import observador.Observador;

/**
 *
 * @author nicor
 */
public abstract class VistaLoginGestorFrame extends javax.swing.JDialog {

    Fachada fachada = Fachada.getInstancia();

    public VistaLoginGestorFrame(java.awt.Frame parent, boolean modal, String titulo) {
        super(parent, modal);
        setTitle(titulo);
        initComponents();
        setLocationRelativeTo(parent);

    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnLoginGestor = new javax.swing.JButton();
        txtUsuario = new javax.swing.JTextField();
        txtPwd = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Usuario");

        jLabel2.setText("Password");

        btnLoginGestor.setText("Login");
        btnLoginGestor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginGestorActionPerformed(evt);
            }
        });

        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                    .addComponent(txtPwd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                .addComponent(btnLoginGestor)
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnLoginGestor)
                        .addComponent(txtPwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addComponent(jLabel2)))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
        login();
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void btnLoginGestorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginGestorActionPerformed
        login();
    }//GEN-LAST:event_btnLoginGestorActionPerformed

    private void login() {

        String usuarioGestor = txtUsuario.getText();
        String password = new String(txtPwd.getPassword());

        Object resultadoLogin = llamarMetodoLogin(usuarioGestor, password);

        System.out.println(resultadoLogin);
                       
        if (resultadoLogin == null) {
            JOptionPane.showMessageDialog(this, "Login incorrecto", "Acceso al servicio", JOptionPane.ERROR_MESSAGE);
        } else {
            dispose();
            crearProximaVentana(resultadoLogin);

        }

    }

    public abstract Object llamarMetodoLogin(String nombre, String password);

    public abstract void crearProximaVentana(Object resultadoLogin);

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoginGestor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField txtPwd;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
