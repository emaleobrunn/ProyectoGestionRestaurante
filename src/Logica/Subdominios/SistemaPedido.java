package Logica.Subdominios;

import Logica.Categoria;
import Logica.Categoria;
import Logica.Cliente;
import Logica.Dispositivo;
import Logica.EstadoDispositivo;
import Logica.Gestor;
import Logica.Ingrediente;
import Logica.Insumo;
import Logica.Item;
import Logica.Pedido;
import Logica.Pedido;
import Logica.Servicio;
import Logica.UnidadProcesadora;
import Logica.UnidadProcesadora;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import observador.EventoUnidad;

public class SistemaPedido {

    private ArrayList<UnidadProcesadora> listaUProcesadoras = new ArrayList();
    private ArrayList<Categoria> listaCategorias = new ArrayList();
    private ArrayList<Servicio> listaServicios = new ArrayList();
    private ArrayList<Dispositivo> listaDispositivos = new ArrayList();
    private ArrayList<Insumo> listaInsumos = new ArrayList();
    private ArrayList<Item> listaItems = new ArrayList();
    private ArrayList<Ingrediente> listaIngredientes = new ArrayList();
    private ArrayList<Pedido> listaPedidos = new ArrayList();

    private Pedido pedido;

    public Categoria agregarCategoria(String nombre) {
        Categoria cat = new Categoria(nombre);
        listaCategorias.add(cat);
        return cat;
    }

    public ArrayList<Servicio> getListaServicios() {
        return listaServicios;
    }

    public void AgregarDispositivo(boolean e, Servicio servicio, Cliente cliente) {
        listaDispositivos.add(new Dispositivo(e, servicio, cliente));
    }

    public void AgregarUnidadProcesadora(String nombre) {
        UnidadProcesadora unidadAdd = new UnidadProcesadora(nombre);

        listaUProcesadoras.add(unidadAdd);
    }

    public Insumo AgregarInsumo(String nombre, int StockA, int StockM) {
        Insumo ins = new Insumo(nombre, StockA, StockM);
        listaInsumos.add(ins);
        return ins;
    }

    public Ingrediente AgregarIngrediente(int cant, Insumo ins) {
        Ingrediente ing = new Ingrediente(cant, ins);
        listaIngredientes.add(ing);

        return ing;
    }

    public UnidadProcesadora obtenerUProcesadora(String nombre) {
        for (UnidadProcesadora up : listaUProcesadoras) {
            if (up.getNombre().equals(nombre)) {
                return up;
            }
        }
        return null;
    }

    public void AgregarItemACategoria(Item i, Categoria c) {
        c.agregarItem(i);
    }

    public void AgregarItem(String nombre, double precio, ArrayList<Ingrediente> ingredientes, UnidadProcesadora uProc, Categoria cat) {
        Item nuevoItem = new Item(nombre, precio, ingredientes, uProc, cat);
        AgregarItemACategoria(nuevoItem, cat);
        listaItems.add(nuevoItem);
    }

    public ArrayList<Categoria> obtenerCategorias() {
        return listaCategorias;
    }

    public Categoria obtenerCategoriaPorNombre(String nombre) {
        for (Categoria cat : listaCategorias) {
            if (cat.getNombre().equals(nombre)) {
                return cat;
            }
        }
        return null;
    }

    public ArrayList<Item> obtenerItemsPorCategoria(Categoria c) {
        return c.getListaItems();
    }

    public ArrayList<String> obtenerNombreCategorias() {
        ArrayList<String> nombres = new ArrayList<>();
        for (Categoria c : listaCategorias) {

            nombres.add(c.nombre);

        }

        return nombres;
    }

    public ArrayList<Pedido> getListaPedidos() {
        return listaPedidos;
    }

    public void AgregarPedido(Pedido p) {

        listaPedidos.add(p);
        Servicio s = p.getServicio();
        s.agregarPedido(p);

    }

    public ArrayList<Pedido> ObtenerPedidosPorUnidadProcesadora(UnidadProcesadora up) {
        ArrayList<Pedido> pedidos = new ArrayList<>();
        for (Pedido p : listaPedidos) {
            if (p.getUnidadProcesadora() == up && "Confirmado".equals(p.getEstadoPedido())) {
                pedidos.add(p);
            }
        }

        return pedidos;
    }

    public void confirmarPedidos(ArrayList<Pedido> pedidos) {

        
        for (Pedido p : pedidos) {

            if (!"Cancelado".equals(p.getEstadoPedido())) {

                Servicio s = p.getServicio();

                p.Confirmar();
                p.setFechayHora(LocalDateTime.now());
                UnidadProcesadora up = p.getUnidadProcesadora();
                up.agregarPedido(p);
                s.agregarPedido(p);

                this.revisarPedidosStock(s);
            }

        }

    }

    public void procesarPedido(Pedido p) {

        Servicio s = p.getServicio();
        p.Procesar();
        UnidadProcesadora up = p.getUnidadProcesadora();
        up.procesarPedido(p);
        s.ProcesarPedido(p);

    }

    public void EliminarPedido(Pedido p) {

        //listaPedidos.remove(p);
        //p.Cancelar();
        if (p.getEstadoPedido().equals("Confirmado")) {
            UnidadProcesadora up = p.getUnidadProcesadora();
            up.EliminarPedido(p);
        }
        listaPedidos.remove(p);
        Servicio s = p.getServicio();
        s.EliminarPedido(p);

    }

    public void revisarPedidosStock(Servicio serv) {

        for (Servicio s : this.listaServicios) {

            ArrayList<Pedido> ItemsSinStock = s.revisarStock();

            if (!ItemsSinStock.isEmpty()) {

                s.PedidoSinStock(ItemsSinStock);

            }

        }

    }

    private void agregarServicioAlSistemaPedidos(Servicio s) {
        if (!listaServicios.contains(s)) {
            listaServicios.add(s);
        }
    }

    public ArrayList<Pedido> ObtenerPedidosDelServicio(Servicio servicio) {
        ArrayList<Pedido> retorno = new ArrayList<>();

        for (Pedido p : listaPedidos) {
            if (p.getServicio() == servicio && "Sin confirmar".equals(p.getEstadoPedido())) {

                retorno.add(p);
            }
        }

        return retorno;
    }

    public void finalizarPedido(Pedido p) {

        p.Finalizar();
        UnidadProcesadora up = p.getUnidadProcesadora();
        Servicio s = p.getServicio();
        s.finalizarPedido(p);
        up.finalizarPedido(p);
    }

    public void agregarServicio(Servicio s1) {
        this.listaServicios.add(s1);
    }

    public void entregarPedido(Pedido p) {

        p.Entregar();
        UnidadProcesadora up = p.getUnidadProcesadora();
        Servicio s = p.getServicio();
        s.EntregarPedido(p);
        up.EntregarPedido(p);
    }

    public void eliminarPedidosConfirmados(ArrayList<Pedido> pedidosConfirmados) {

        for (Pedido p : pedidosConfirmados) {
            UnidadProcesadora up = p.getUnidadProcesadora();
            up.EliminarPedido(p);

            //Eliminar tambien de pedido?
        }
    }

    public double calcularMonto(Dispositivo d) {

        Cliente c = d.getCliente();

        return c.calcularMonto(d);

    }

}
