/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vistaEscritorio;

import Logica.Categoria;
import Logica.Cliente;
import Logica.Dispositivo;
import Logica.Exception.ClienteException;
import Logica.Exception.ServicioException;
import Logica.Fachada;
import Logica.Item;
import Logica.Pedido;
import Logica.Servicio;
import Logica.Usuario;
import controlador.ControladorServicio;
import controlador.VistaServicio;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import observador.EventoUnidad;
import observador.Observable;
import observador.Observador;


public class VistaClienteFrame extends javax.swing.JDialog implements VistaServicio {

    Fachada fachada = Fachada.getInstancia();

    private ArrayList<Item> resultadoItems = new ArrayList<>();
    private ArrayList<Pedido> resultadoPedido = new ArrayList<>();
    private ControladorServicio controlador;

    //private ArrayList<Pedido> resultadoPedido = new ArrayList<>();
    private Cliente cliente;
    private Servicio servicio = null;

    public VistaClienteFrame(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        initComponents();
        setLocationRelativeTo(parent);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jDialog1 = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        txtUsuario = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Comentarios = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaCategorias = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaItems = new javax.swing.JList();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnAgregarPedido = new javax.swing.JButton();
        btnEliminarPedido = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        ConfirmarPedido = new javax.swing.JButton();
        btnFinalizarServicio = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        TablaPedido = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        display = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        intMontoTotal = new javax.swing.JList();

        jButton1.setText("jButton1");

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CU Realizar Pedido");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("Numero Cliente");

        jLabel2.setText("Contraseña");

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        jLabel3.setText("Menu");

        Comentarios.setColumns(20);
        Comentarios.setRows(5);
        jScrollPane1.setViewportView(Comentarios);

        jLabel4.setText("Categorias");

        listaCategorias.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaCategoriasValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(listaCategorias);

        listaItems.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaItemsValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(listaItems);

        jLabel5.setText("Items");

        jLabel6.setText("Comentario");

        btnAgregarPedido.setText("Agregar Item");
        btnAgregarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPedidoActionPerformed(evt);
            }
        });

        btnEliminarPedido.setText("Eliminar Item");
        btnEliminarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPedidoActionPerformed(evt);
            }
        });

        jLabel7.setText("Pedidos del servicio");

        ConfirmarPedido.setText("Confirmar Pedidos");
        ConfirmarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmarPedidoActionPerformed(evt);
            }
        });

        btnFinalizarServicio.setText("Finalizar Servicio");
        btnFinalizarServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarServicioActionPerformed(evt);
            }
        });

        TablaPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Item", "Comentario", "Estado", "Unidad", "Gestor", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane4.setViewportView(TablaPedido);

        jLabel8.setText("Monto Total:");

        jScrollPane5.setViewportView(intMontoTotal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(jLabel2)
                                .addGap(32, 32, 32)
                                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                                .addComponent(btnLogin))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnAgregarPedido)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminarPedido)
                                .addGap(6, 6, 6)))
                        .addGap(21, 21, 21))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(display)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ConfirmarPedido)
                                .addGap(18, 18, 18)
                                .addComponent(btnFinalizarServicio)
                                .addGap(79, 79, 79)
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLogin))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarPedido)
                    .addComponent(btnEliminarPedido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnFinalizarServicio)
                        .addComponent(ConfirmarPedido)
                        .addComponent(jLabel8))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(display, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        try {
            // TODO add your handling code here:

            login();
        } catch (ClienteException ex) {
            JOptionPane.showMessageDialog(this, "No puede loguearse en mas de un dispositivo a la vez", "ERROR", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(VistaClienteFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void listaItemsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaItemsValueChanged
        mostrarPedido();
    }//GEN-LAST:event_listaItemsValueChanged

    private void listaCategoriasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaCategoriasValueChanged
        detalles();
    }//GEN-LAST:event_listaCategoriasValueChanged

    private void btnAgregarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPedidoActionPerformed
        AgregarItem();
    }//GEN-LAST:event_btnAgregarPedidoActionPerformed

    private void btnEliminarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPedidoActionPerformed
        EliminarItem();
    }//GEN-LAST:event_btnEliminarPedidoActionPerformed

    private void ConfirmarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmarPedidoActionPerformed
        // TODO add your handling code here:
        ConfirmarPedidos();

    }//GEN-LAST:event_ConfirmarPedidoActionPerformed

    private void btnFinalizarServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarServicioActionPerformed
        // TODO add your handling code here:
        logout();

    }//GEN-LAST:event_btnFinalizarServicioActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Gracias por utilizar nuestro servicio", "Gracias", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:

        try {
            servicioActivo();
        } catch (ServicioException ex) {

            setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
            display.setText("No puede cerrar la ventana sin finalizar el servicio");

        }

    }//GEN-LAST:event_formWindowClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Comentarios;
    private javax.swing.JButton ConfirmarPedido;
    private javax.swing.JTable TablaPedido;
    private javax.swing.JButton btnAgregarPedido;
    private javax.swing.JButton btnEliminarPedido;
    private javax.swing.JButton btnFinalizarServicio;
    private javax.swing.JButton btnLogin;
    private javax.swing.JTextField display;
    private javax.swing.JList intMontoTotal;
    private javax.swing.JButton jButton1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JList listaCategorias;
    private javax.swing.JList listaItems;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

    private void login() throws ClienteException {

        String texto = txtUsuario.getText().trim();
        if (texto.isBlank()) {
            JOptionPane.showMessageDialog(this, "Ingrese un numero de cliente valido", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        System.out.println("Valor ingresado en txtUsuario: " + texto);
        if (!texto.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "El número de cliente debe contener solo dígitos", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int numCliente = Integer.parseInt(texto);

        String password = new String(txtPassword.getPassword());

        cliente = fachada.loginCliente(numCliente, password);
        servicio = fachada.obtenerServicio(cliente);

        if (cliente == null) {
            JOptionPane.showMessageDialog(this, "Login incorrecto", "Login Incorrecto", JOptionPane.ERROR_MESSAGE);
        } else {

            controlador = new ControladorServicio(this, servicio);
            JOptionPane.showMessageDialog(this, "¡Inicio de sesión exitoso!", "Bienvenido", JOptionPane.INFORMATION_MESSAGE);

        }

    }

    private void logout() {

        boolean tieneFinalizados = false;
        boolean tieneProcesando = false;

        if (servicio != null) {

            if (!servicio.getPedidos().isEmpty()) {

                for (Pedido p : servicio.getPedidos()) {

                    String estado = p.getEstadoPedido();

                    if (estado.equals("Sin confirmar")) {

                        JOptionPane.showMessageDialog(this, "Tienes pedidos sin confirmar", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if (estado.equals("Procesando")) {
                        tieneProcesando = true;

                    } else if (estado.equals("Finalizado")) {
                        tieneFinalizados = true;

                    }
                }

                if (tieneProcesando) {

                    JOptionPane.showMessageDialog(this, "Tiene pedidos procesandose", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                } else if (tieneFinalizados) {
                    JOptionPane.showMessageDialog(this, "Tiene pedidos finalizados, recuerde retirarlos", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                }

                desloguear();

            } else {

                desloguear();
            }

        } else {
            JOptionPane.showMessageDialog(this, "Debe identificarse antes de finalizar el servicio", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void desloguear() {
        
        if(!servicio.getPedidos().isEmpty()){
            JOptionPane.showMessageDialog(this,"Cliente: " + cliente.getTipoCliente() + "\n" + "Su monto total es: $" + this.cliente.calcularMonto(this.servicio.getDispo()) , "Pago confirmado", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(this, "Hasta pronto" , "Gracias", JOptionPane.INFORMATION_MESSAGE);
        }               

        cliente.logueado = false;
        System.out.println(cliente);
        controlador.eliminarPedidosDelServicio(servicio.getPedidos());
        
        dispose();
    }

    private void detalles() {
        int pos = listaCategorias.getSelectedIndex();
        if (pos != -1) { //hay seleccion
            controlador.SeleccionarCategoria(pos);
        } else {//se borro lo seleccionado
            mostrarItems(null);
        }
    }

    public void EliminarItem() {

        int filaSeleccionada = TablaPedido.getSelectedRow();
        DefaultTableModel modelo = (DefaultTableModel) TablaPedido.getModel();

        if (servicio != null) {

            if (filaSeleccionada != -1) { // -1 significa que no hay selección
                int confirm = JOptionPane.showConfirmDialog(
                        null,
                        "¿Estás seguro de que deseas eliminar este ítem?",
                        "Confirmar eliminación",
                        JOptionPane.YES_NO_OPTION
                );

                if (confirm == JOptionPane.YES_OPTION) {

                    try {
                        controlador.EliminarItemDelPedido(filaSeleccionada);

                        modelo.removeRow(filaSeleccionada);

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }

                }
            } else {
                JOptionPane.showMessageDialog(null, "Por favor selecciona un ítem para eliminar.");
            }

        } else {

            JOptionPane.showMessageDialog(this, "Usted no se ha logueado", "Falta Login", JOptionPane.ERROR_MESSAGE);

        }
    }

    public void servicioActivo() throws ServicioException {
        if (servicio != null) {
            throw new ServicioException("Debe finalizar el servicio");
        }
    }

    @Override
    public void mostrarMonto(double valor) {
        ArrayList<String> listado = new ArrayList<String>();
                        
        listado.add("$" + String.valueOf(valor));
        intMontoTotal.setListData(listado.toArray());
        listado = null;
        System.out.println("Monto calculado: " + valor);
    }

    @Override
    public void mostrarConfirmacion(String message) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Aviso", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void mostrarPedido() {
        int pos = listaItems.getSelectedIndex();
        controlador.SeleccionarItem(pos);

    }

    @Override
    public void mostrarCategorias(ArrayList<Categoria> categorias) {
        ArrayList<String> listado = new ArrayList();
        for (Categoria c : categorias) {
            listado.add(c.getNombre());
        }
        listaCategorias.setListData(listado.toArray());
    }

    @Override
    public void mostrarItems(Categoria seleccionada) {
        resultadoItems = new ArrayList<>();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        controlador.ObtenerItemsPorCategoria(seleccionada);

    }

    @Override
    public void mostrarResultado(ArrayList<Item> items) {
        ArrayList<String> listado = new ArrayList();
        for (Item i : items) {
            listado.add(i.getNombre());
        }
        listaItems.setListData(listado.toArray());
    }

    @Override
    public void AgregarItem() {

        int pos = listaItems.getSelectedIndex();
        if (servicio == null) {
            JOptionPane.showMessageDialog(this, "Usted no se ha logueado", "Falta Login", JOptionPane.ERROR_MESSAGE);

        } else if (pos < 0) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un item", "Error", JOptionPane.ERROR_MESSAGE);

        }

        controlador.AgregarItemAlPedido(Comentarios.getText());

        //controlador.mostrarItemsTabla(i);
    }

    private void ConfirmarPedidos() {

        if (servicio == null) {
            JOptionPane.showMessageDialog(this, "Usted no se ha logueado", "Falta Login", JOptionPane.ERROR_MESSAGE);

        } else {
            try {
                controlador.confirmarPedidos();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

        }

    }

    private ArrayList<Pedido> obtenerPedidosSeleccionados() {
        ArrayList<Pedido> seleccionados = new ArrayList<>();

        for (Pedido p : resultadoPedido) {
            if ("Sin confirmar".equals(p.getEstadoPedido())) {
                seleccionados.add(p);
            }
        }

        return seleccionados;
    }

    @Override
    public void mostrarTablaPedidos(ArrayList<Pedido> pedidos) {

        DefaultTableModel datos = new DefaultTableModel();

        datos.addColumn("Item");
        datos.addColumn("Comentario");
        datos.addColumn("Estado");
        datos.addColumn("Unidad");
        datos.addColumn("Gestor");
        datos.addColumn("Precio");

        if (pedidos.isEmpty()) {

            TablaPedido.setModel(datos);

        } else {

            datos.setRowCount(pedidos.size());
            int fila = 0;

            for (Pedido pedido : pedidos) {

                datos.setValueAt(pedido.getItem(), fila, 0);
                datos.setValueAt(pedido.getComentario(), fila, 1);
                datos.setValueAt(pedido.getEstadoPedido(), fila, 2);
                datos.setValueAt(pedido.getUnidadProcesadora(), fila, 3);
                datos.setValueAt((pedido.getGestor() != null) ? pedido.getGestor().getNombre() : "Sin asignar", fila, 4);
                datos.setValueAt(pedido.getItem().getPrecioU(), fila, 5);
                fila++;

            }
             
            TablaPedido.setModel(datos);
            
           
            
        }
    }
    

}
