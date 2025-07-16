/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package luEscritorio;

import vistaEscritorio.VistaClienteFrame;

/**
 *
 * @author soporte.onsite
 */
public class MenuDesarrollo extends javax.swing.JFrame {

    /**
     * Creates new form MenuDesarrollo
     */
    public MenuDesarrollo() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnLoginCliente = new javax.swing.JButton();
        btnLoginGestor = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Desarrollo");

        btnLoginCliente.setText("Login Cliente");
        btnLoginCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginClienteActionPerformed(evt);
            }
        });

        btnLoginGestor.setText("Login Gestor");
        btnLoginGestor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginGestorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btnLoginGestor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 154, Short.MAX_VALUE)
                .addComponent(btnLoginCliente)
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLoginCliente)
                    .addComponent(btnLoginGestor))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginClienteActionPerformed
        // TODO add your handling code here:
        
        new VistaClienteFrame(this, false).setVisible(true);
      
    }//GEN-LAST:event_btnLoginClienteActionPerformed

    private void btnLoginGestorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginGestorActionPerformed
        new AccesoGestor(this, false, "LOGIN GESTOR").setVisible(true);
    }//GEN-LAST:event_btnLoginGestorActionPerformed


  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoginCliente;
    private javax.swing.JButton btnLoginGestor;
    // End of variables declaration//GEN-END:variables
}
