/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import Logica.Fachada;
import Logica.Gestor;
import Logica.Item;
import Logica.Pedido;
import Logica.Servicio;
import Logica.UnidadProcesadora;
import java.util.ArrayList;
import observador.EventoUnidad;
import static observador.EventoUnidad.NUEVO_PEDIDO;
import static observador.EventoUnidad.PEDIDO_CANCELADO;
import static observador.EventoUnidad.PEDIDO_ENTREGADO;
import static observador.EventoUnidad.PEDIDO_FINALIZADO;
import static observador.EventoUnidad.PEDIDO_TOMADO;
import observador.Observable;
import observador.Observador;

/**
 *
 * @author Emanuel
 */
public class ControladorGestor implements Observador {

    private VistaGestor vista;
    private Pedido pedidoSeleccionado;
    private Servicio servicioSeleccionado;
    private Servicio servicio;
    private UnidadProcesadora up;
    private Gestor gestor;
    private ArrayList<Pedido> pedidosTomados = new ArrayList<Pedido>();
     ArrayList<Pedido> nuevaPedidos = new ArrayList<Pedido>();
    public ControladorGestor(VistaGestor vista, UnidadProcesadora u) {
        u.agregarObservador(this);
        this.vista = vista;
        this.up = u;
        
        //this.servicio = s;
        inicializarVista();
    }
    

    private void inicializarVista() {
        mostrarListaPedidos(up);
        
    }

    public void tomarPedido(int pos) {
        
        ArrayList<Pedido> resultadoPedido = up.getPedidosConfirmados();        
        
        pedidoSeleccionado = resultadoPedido.get(pos);
        pedidosTomados.add(pedidoSeleccionado);
        Fachada.getInstancia().ProcesarPedido(pedidoSeleccionado);        
        
        
    }
    
      @Override
      public void actualizar(EventoUnidad evento, Observable origen) {
         switch (evento) {
            case NUEVO_PEDIDO, PEDIDO_TOMADO,PEDIDO_CONFIRMADO:
                mostrarListaPedidos(up);
                mostrarTablaPedidos();
                break;
            case PEDIDO_ENTREGADO, PEDIDO_FINALIZADO:
                mostrarTablaPedidos();
                break;
            case PEDIDO_CANCELADO:
                mostrarListaPedidos(up);                
            }           
         
        }
    

    public void mostrarListaPedidos(UnidadProcesadora up) {
        ArrayList<Pedido> pedidos = up.getPedidos();            
      
            vista.cargarListaPedidos(pedidos);
        
       
    }
    
     public void mostrarTablaPedidos() {
            vista.cargarTablaPedidosTomados(pedidosTomados);
            System.out.println("Corte");
        }          

  

    public void finalizarPedido(int pos) {
        
        if(pedidosTomados.isEmpty()){
            throw new IllegalStateException("No tiene pedidos para finalizar");
        }else if(pos==-1){
            throw new IllegalStateException("Debe seleccionar un pedido");
        }
        
        Pedido tomado = pedidosTomados.get(pos);
        
       if(tomado==null){
            throw new IllegalStateException("Debe seleccionar un pedido");
        }    
        else if(tomado.getEstadoPedido().equals("Finalizado")){            
            throw new IllegalStateException("El pedido ya esta finalizado");
        }else if(tomado.getEstadoPedido().equals("Entregado")){
            throw new IllegalStateException("El pedido ya ha sido entregado");
        }
        
        Fachada.getInstancia().finalizarPedido(tomado);
        
    }

    public void entregarPedido(int pos) {    
        
        
        if(pedidosTomados.isEmpty()){
            throw new IllegalStateException("No tiene pedidos para entregar");
        }else if(pos==-1){
            throw new IllegalStateException("Debe seleccionar un pedido");
        }
        
        Pedido tomado = pedidosTomados.get(pos);
        
       if(tomado==null){
            throw new IllegalStateException("Debe seleccionar un pedido");
        }    
        else if(tomado.getEstadoPedido().equals("Entregado")){
            
            throw new IllegalStateException("El pedido ya esta entregado");
        }else if(tomado.getEstadoPedido().equals("Procesando")){
            throw new IllegalStateException("El pedido aun no esta finalizado");
        }          
            
        Fachada.getInstancia().entregarPedido(tomado);
    }


}
