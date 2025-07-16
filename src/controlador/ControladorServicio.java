/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import Logica.Categoria;
import Logica.Dispositivo;
import Logica.Fachada;
import Logica.Item;
import Logica.Pedido;
import Logica.Servicio;
import Logica.Subdominios.SistemaPedido;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import observador.EventoUnidad;
import static observador.EventoUnidad.NUEVO_PEDIDO;
import static observador.EventoUnidad.PEDIDO_FINALIZADO;
import static observador.EventoUnidad.PEDIDO_TOMADO;
import observador.Observable;
import observador.Observador;

/**
 *
 * @author Emanuel
 */
public class ControladorServicio implements Observador {

    private ArrayList<Categoria> resultado = Fachada.getInstancia().obtenerCategorias();
    private ArrayList<Item> resultadoItem = null;
    private SistemaPedido sPedido = Fachada.getInstancia().sistemaPedido();
    private ArrayList<Pedido> resultadoPedido = new ArrayList<Pedido>();
    private VistaServicio vista;
    private Item ItemSeleccionado;
    private Servicio servicio;
    LocalDateTime ahora = LocalDateTime.now();
    private Dispositivo dispositivo;
     ArrayList<Pedido> pedidosConfirmados = new ArrayList<>();

    public ControladorServicio(VistaServicio vista, Servicio servicio) {
        this.vista = vista;
        this.servicio = servicio;
        servicio.agregarObservador(this); //registro a la vista como observador del servicio
        inicializarVista();
    }

    //Eventos del usuario
    private void inicializarVista() {
        vista.mostrarCategorias(Fachada.getInstancia().obtenerCategorias());
        Fachada.getInstancia().AgregarDispositivo(true, servicio, servicio.getCliente());
        dispositivo = servicio.getDispo();
    }

    public void refrescarVistaPedidos() {
        
        ArrayList<Pedido> pedidos = servicio.getPedidos(); //RESULTADO PEDIDOS ESTABA
        
        vista.mostrarTablaPedidos(pedidos);        
       
   }

    public void SeleccionarCategoria(int pos) {
        Categoria seleccionada = resultado.get(pos);
        vista.mostrarItems(seleccionada);

    }

    public void SeleccionarItem(int pos) {
        Item seleccionado = resultadoItem.get(pos);
        ItemSeleccionado = seleccionado;

    }
    
    public void DesSeleccionarItem() {        
        ItemSeleccionado = null;

    }

    public void ObtenerItemsPorCategoria(Categoria seleccionada) {
        ArrayList<Item> items = Fachada.getInstancia().obtenerItemsPorCategoria(seleccionada);
        resultadoItem = items;
        vista.mostrarResultado(items);
    }

    public void AgregarItemAlPedido(String c) {
        Pedido pedidoNuevo = new Pedido("Sin confirmar", ItemSeleccionado.getUnidadProcesadora(), ItemSeleccionado, null, c, servicio);
        resultadoPedido.add(pedidoNuevo);
        sPedido.AgregarPedido(pedidoNuevo);
        
    }

    public void mostrarItemsTabla(Item i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actualizar(EventoUnidad evento, Observable origen) {
        switch (evento) {
            case NUEVO_PEDIDO, PEDIDO_CONFIRMADO, PEDIDO_CANCELADO:                
                refrescarVistaPedidos();                
                calcularMonto();                
                break;
            case  PEDIDO_FINALIZADO:
                refrescarVistaPedidos();                
                vista.mostrarMensaje("Tiene un pedido finalizado y esta listo para retirar");
                break;
            case PEDIDO_ENTREGADO, PEDIDO_TOMADO:
                refrescarVistaPedidos();                
                break;               
            case PEDIDO_SIN_STOCK:
                refrescarVistaPedidos();   
                calcularMonto();
                vista.mostrarMensaje("Hemos eliminado los items que no tienen stock");                
                break;
        }
    }

    public void confirmarPedidos() {

        ArrayList<Pedido> seleccionado = Fachada.getInstancia().ObtenerPedidosDelServicio(servicio);

        if (seleccionado.isEmpty()) {
            throw new IllegalStateException("No hay pedidos para confirmar");
        } else {
            Fachada.getInstancia().confirmarPedidos(seleccionado);
            
        }
    }

    public void EliminarItemDelPedido(int filaSeleccionada) {
        
        //System.out.println(sPedido.ObtenerPedidosDelServicio(servicio));
        
        Pedido p = resultadoPedido.get(filaSeleccionada);

        if (p.getEstadoPedido().equals("Procesando")) {
            throw new IllegalStateException("El pedido ya esta siendo procesado");
        }else if(p.getEstadoPedido().equals("Finalizado")){
            throw new IllegalStateException("El pedido ya esta finalizado");
        }else if(p.getEstadoPedido().equals("Entregado")){
            throw new IllegalStateException("El pedido ya fue entregado");
        }       
                
        Fachada.getInstancia().cancelarPedido(p);    
        resultadoPedido.remove(p);
        
        
    }    

    public void eliminarPedidosDelServicio(ArrayList<Pedido> pedidos) {
    
        for(Pedido p: pedidos){            
            if(p.getEstadoPedido().equals("Confirmado")){
                pedidosConfirmados.add(p);
            }
        }
        
        Fachada.getInstancia().eliminarPedidos(pedidosConfirmados);
    }
    
    
    public void calcularMonto(){
        double monto = 0;
        monto = sPedido.calcularMonto(dispositivo);
        vista.mostrarMonto(monto);
    }

}
