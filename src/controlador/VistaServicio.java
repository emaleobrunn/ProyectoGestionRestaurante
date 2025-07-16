/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controlador;

import Logica.Categoria;
import Logica.Item;
import Logica.Pedido;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Emanuel
 */
public interface VistaServicio {
    
    
    
    public void mostrarMonto(double valor);

    public void mostrarConfirmacion(String message);

    public void mostrarMensaje(String mensaje);

    public void mostrarPedido();
    public void mostrarCategorias(ArrayList<Categoria> categorias);

    public void mostrarItems(Categoria seleccionada);

    public void mostrarResultado(ArrayList<Item> items);
    
    public void AgregarItem();

    public void mostrarTablaPedidos(ArrayList<Pedido> pedidos);   
  
    
    
    



}
