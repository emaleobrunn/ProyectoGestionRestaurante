package Logica;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Pedido {

    /*private ArrayList<Item> listaItems;*/
    private String Comentario;
    private String estadoPedido;

    private UnidadProcesadora unidadProcesadora;
    private static int idPedido = 0;
    private int id;
    private Gestor gestor;
    private Servicio servicio;
    private Item item;

    private LocalDateTime fechayHora;

    public Pedido(String ep, UnidadProcesadora unidadProcesadora, Item item, Gestor g0, String Comentario, Servicio s) {
        this.estadoPedido = estadoPedido;
        this.unidadProcesadora = unidadProcesadora;
        this.item = item;
        this.gestor = null;
        this.estadoPedido = ep;
        this.Comentario = Comentario;
        this.fechayHora = null;
        this.id = ++idPedido;
        this.servicio = s;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public String getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(String estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public UnidadProcesadora getUnidadProcesadora() {
        return unidadProcesadora;
    }

    public void setUnidadProcesadora(UnidadProcesadora unidadProcesadora) {
        this.unidadProcesadora = unidadProcesadora;
    }

    public Gestor getGestor() {
        return gestor;
    }

    public void setGestor(Gestor gestor) {
        this.gestor = gestor;
    }

    public Item getItem() {
        return item;
    }

    public int getId() {
        return id;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getComentario() {
        return Comentario;
    }

    public void setComentario(String Comentario) {
        this.Comentario = Comentario;
    }

    public void Confirmar() {

        
        this.getItem().descontarStock();

        this.estadoPedido = "Confirmado";

    }

    public void Cancelar() {
        this.estadoPedido = "Cancelado";

    }

    public void Procesar() {
        this.estadoPedido = "Procesando";

        //this.getItem().descontarStock();
    }

    public void Finalizar() {
        this.estadoPedido = "Finalizado";
    }

    public void Entregar() {
        this.estadoPedido = "Entregado";
    }

    public LocalDateTime getFechayHora() {
        return fechayHora;
    }

    public void setFechayHora(LocalDateTime fechayHora) {
        this.fechayHora = fechayHora;
    }

    @Override
    public String toString() {
        return "Pedido{"
                + "item=" + item
                + ", comentario=" + Comentario
                + ", estadoPedido=" + estadoPedido
                + ", unidadProcesadora=" + unidadProcesadora
                + ", gestor=" + gestor
                + '}';
    }

}
