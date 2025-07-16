package Logica;

import java.util.ArrayList;
import observador.EventoUnidad;
import observador.Observable;

public class Servicio extends Observable {

    private Cliente cliente;
    private int codigoDelServicio;
    private static int idServicio = 0;
    private Dispositivo dispo;

    private ArrayList<Pedido> listaPedidos = new ArrayList<>();

    public Servicio(Cliente cliente) {
        this.cliente = cliente;
        this.codigoDelServicio = ++idServicio;
        this.dispo = null;
    }

    public int getCodigoDelServicio() {
        return codigoDelServicio;
    }

    public void ProcesarPedido(Pedido p) {
        avisar(EventoUnidad.PEDIDO_TOMADO);
    }

    public void finalizarPedido(Pedido p) {
        avisar(EventoUnidad.PEDIDO_FINALIZADO);
    }

    public void EntregarPedido(Pedido p) {
        //listaPedidos.remove(p);
        p.Entregar();
        avisar(EventoUnidad.PEDIDO_ENTREGADO);
    }

    public void agregarPedido(Pedido p) {
        if (p.getEstadoPedido().equalsIgnoreCase("Sin confirmar")) {
            listaPedidos.add(p);
        }
        avisar(EventoUnidad.NUEVO_PEDIDO);
    }

    public void EliminarPedido(Pedido p) {

        if (p.getEstadoPedido().equals("Confirmado")) {
            p.getItem().reponerStock();            
        }
        listaPedidos.remove(p);
        avisar(EventoUnidad.PEDIDO_CANCELADO);
    }
    
public void PedidoSinStock(ArrayList<Pedido> PedidosSinStock) {
    
    for(Pedido p: PedidosSinStock){        
        listaPedidos.remove(p);       
        UnidadProcesadora up = p.getUnidadProcesadora();
        p.Cancelar();
        up.EliminarPedido(p);        
        avisar(EventoUnidad.PEDIDO_SIN_STOCK);
    }
        
        
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setListaPedidos(ArrayList<Pedido> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Pedido> getPedidos() {
        return listaPedidos;
    }

    public Dispositivo getDispo() {
        return dispo;
    }

    public void setDispo(Dispositivo dispo) {
        this.dispo = dispo;
    }

    public ArrayList<Pedido> revisarStock() {
        
        ArrayList<Pedido> ItemsSinStock = new ArrayList<>();

        for (Pedido p : this.listaPedidos) {
            if (p.getEstadoPedido().equals("Sin confirmar")) {

                if (!p.getItem().ingredientesDisp()) {

                    ItemsSinStock.add(p);
                }
            }

        }
        return ItemsSinStock;
    }

    @Override
    public String toString() {
        return "Servicio de: " + cliente.toString() + " Pedidos: " + this.listaPedidos;
    }

}
