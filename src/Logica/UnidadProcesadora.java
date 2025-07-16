package Logica;

import java.util.ArrayList;
import observador.EventoUnidad;
import observador.Observable;

public class UnidadProcesadora extends Observable {

    private String nombre;

    private ArrayList<Gestor> listaG = new ArrayList<>();
    private ArrayList<Pedido> pedidosUP = new ArrayList<>();

    public UnidadProcesadora(String nombre) {
        this.nombre = nombre;
        setListaGestores(listaG);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Gestor> getListaGestores() {
        return listaG;
    }

    public void setListaGestores(ArrayList<Gestor> listaGestores) {
        this.listaG = listaGestores;
    }

    @Override
    public String toString() {
        return nombre;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidosUP;
    }

    public void agregarPedido(Pedido p) {
        pedidosUP.add(p);
        avisar(EventoUnidad.PEDIDO_CONFIRMADO);
    }

    public void EliminarPedido(Pedido p) {
        pedidosUP.remove(p);
        avisar(EventoUnidad.PEDIDO_CANCELADO);
    }

    public void procesarPedido(Pedido p) {
        avisar(EventoUnidad.PEDIDO_TOMADO);
    }

    public void finalizarPedido(Pedido p) {
        avisar(EventoUnidad.PEDIDO_FINALIZADO);
    }

    public void EntregarPedido(Pedido p) {
        avisar(EventoUnidad.PEDIDO_ENTREGADO);
    }

    public ArrayList<Pedido> getPedidosConfirmados() {

        ArrayList<Pedido> pedidosConfirmados = new ArrayList<>();

        for (Pedido p : this.pedidosUP) {

            if (p.getEstadoPedido().equals("Confirmado")) {

                pedidosConfirmados.add(p);
            }
        }
        return pedidosConfirmados;
    }

}
