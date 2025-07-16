/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controlador;

import Logica.Pedido;
import Logica.Servicio;
import java.util.ArrayList;

/**
 *
 * @author Emanuel
 */
public interface VistaGestor {

    public void cargarListaPedidos(ArrayList<Pedido> pedidos);

    public void cargarTablaPedidosTomados(ArrayList<Pedido> pedidosTomados);
}
