package Logica;

import Logica.Cliente;
import Logica.Exception.ClienteException;
import Logica.Exception.GestorException;
import Logica.Gestor;
import Logica.UnidadProcesadora;
import Logica.Subdominios.SistemaAcceso;
import Logica.Subdominios.SistemaPedido;
import java.util.ArrayList;
import observador.Observable;

public class Fachada {

    private static final Fachada instancia = new Fachada();

    public enum eventos {
        cambioTablaPedidos
    };

    public static Fachada getInstancia() {
        return instancia;
    }

    private SistemaAcceso sAcceso = new SistemaAcceso();
    private SistemaPedido sPedido = new SistemaPedido();

    // Constructor privado: inicializa todos los subsistemas
    private Fachada() {
       
        this.sAcceso = new SistemaAcceso();
        this.sPedido = new SistemaPedido();
    }

    public void agregarServicio(Cliente c1) {
        sAcceso.agregarServicio(c1);

    }

    public void agregarServiciosPedido(Servicio s1){
        sPedido.agregarServicio(s1);
    }
    public Servicio obtenerServicio(Cliente cli) {
        return sAcceso.obtenerServicio(cli);
    }

    public ArrayList<Servicio> obtenerServicios() {
        return sPedido.getListaServicios();
    }

    public Cliente obtenerCliente(int num) {
        return sAcceso.obtenerCliente(num);
    }

    public Gestor obtenerGestor(String nombre) {
        return sAcceso.obtenerGestor(nombre);
    }

    // Delegaciones a SistemaPedido
    public Categoria agregarCategoria(String nombre) {
        return sPedido.agregarCategoria(nombre);
    }

    // Delegaciones a SistemaAcceso
    public void agregarCliente(String nombre, String pwd, TipoCliente tipoCli) {
        sAcceso.agregarCliente(nombre, pwd, tipoCli);
    }

    public void agregarGestor(String nombre, String pwd, UnidadProcesadora uProcesadora, String nC) {
        sAcceso.agregarGestor(nombre, pwd, uProcesadora, nC);
    }

    public Cliente loginCliente(int numC, String pwd) throws ClienteException {

        return sAcceso.loginCliente(numC, pwd);

    }

    // Delegaciones a SistemaCobranza (ejemplo)
    public Gestor loginGestor(String nom, String pwd){
        return sAcceso.loginGestor(nom, pwd);
    }

    // Aquí podrías añadir más métodos de delegación a cada subsistema...
//    public void AgregarTipoCliente(String tipoCli) {
//        sAcceso.AgregarTipoCliente(tipoCli);
//    }
    public void AgregarDispositivo(boolean e, Servicio servicio, Cliente cliente) {
        sAcceso.AgregarDispositivo(e, servicio, cliente);
    }

    public void LiberarDispositivo(Dispositivo d) {
        sAcceso.liberarDispositivo(d);
    }

    public void AgregarUnidadProcesadora(String nombre) {
        sPedido.AgregarUnidadProcesadora(nombre);
    }

    public Ingrediente AgregarIngrediente(int cant, Insumo ins) {
        return sPedido.AgregarIngrediente(cant, ins);
    }

    public Insumo AgregarInsumo(String nombre, int StockA, int StockM) {
        return sPedido.AgregarInsumo(nombre, StockA, StockM);
    }

    public UnidadProcesadora obtenerUProcesadora(String nombre) {
        return sPedido.obtenerUProcesadora(nombre);
    }

    public void agregarItem(String nombre, double precio, ArrayList<Ingrediente> ingredientes, UnidadProcesadora uProc, Categoria cat) {

        sPedido.AgregarItem(nombre, precio, ingredientes, uProc, cat);
    }

    public ArrayList<Categoria> obtenerCategorias() {
        return sPedido.obtenerCategorias();
    }

    public ArrayList<String> obtenerNombreCategorias() {
        return sPedido.obtenerNombreCategorias();
    }

    public ArrayList<Item> obtenerItemsPorCategoria(Categoria c) {
        return sPedido.obtenerItemsPorCategoria(c);
    }

    public Categoria obtenerCategoriaPorNombre(String nombre) {
        return sPedido.obtenerCategoriaPorNombre(nombre);

    }

    public SistemaPedido sistemaPedido() {
        return sPedido;
    }

    public void AgregarPedido(Pedido p) {
        sPedido.AgregarPedido(p);
    }

    public ArrayList<Pedido> ObtenerPedidos() {
        return sPedido.getListaPedidos();
    }

    public ArrayList<Pedido> ObtenerPedidosDelServicio(Servicio servicio) {
        return sPedido.ObtenerPedidosDelServicio(servicio);
    }

    public ArrayList<Pedido> ObtenerPedidosPorUnidadProcesadora(UnidadProcesadora p) {
        return sPedido.ObtenerPedidosPorUnidadProcesadora(p);
    }

    public void confirmarPedidos(ArrayList<Pedido> pedidos) {
        sPedido.confirmarPedidos(pedidos);
    }

    public void cancelarPedido(Pedido p) {
        sPedido.EliminarPedido(p);
    }

    public void ProcesarPedido(Pedido p) {
        sPedido.procesarPedido(p);
    }

    public void finalizarPedido(Pedido tomado) {
        sPedido.finalizarPedido(tomado);
    }

    public void entregarPedido(Pedido tomado) {
        sPedido.entregarPedido(tomado);
    }

    public void eliminarPedidos(ArrayList<Pedido> pedidosConfirmados) {
        sPedido.eliminarPedidosConfirmados(pedidosConfirmados);
    }

}
