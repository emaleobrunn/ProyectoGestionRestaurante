package Logica.Subdominios;

import Logica.Cliente;
import Logica.Cliente;
import Logica.Dispositivo;
import Logica.EstadoDispositivo;
import Logica.Exception.ClienteException;
import Logica.Exception.GestorException;
import Logica.Gestor;
import Logica.Gestor;
import Logica.Servicio;
import Logica.Exception.ServicioException;
import Logica.Fachada;
import Logica.TipoCliente;
import Logica.UnidadProcesadora;
import Logica.Usuario;
import Logica.Usuario;
import controlador.ControladorGestor;
import java.util.ArrayList;

public class SistemaAcceso {

    //private ArrayList<Usuario> usuarios = new ArrayList();
    private Servicio servicio;

    private Gestor gestor;

    private ArrayList<Gestor> gestores = new ArrayList();

    private Cliente cliente;

    private ArrayList<Cliente> clientes = new ArrayList();

    private Usuario usuario;

    private TipoCliente tipoCliente;

    private ArrayList<TipoCliente> tipoClientes = new ArrayList();

    private ArrayList<Dispositivo> listaDispositivos = new ArrayList();

    public Cliente obtenerCliente(int num) {
        for (Cliente cli : clientes) {
            if (cli.getNum() == num) {
                return cli;
            }
        }
        return null;
    }

    public Gestor obtenerGestor(String nombreU) {
        for (Gestor ges : gestores) {
            if (ges.getNombre().toLowerCase().equals(nombreU.toLowerCase())) {
                return ges;
            }
        }
        return null;
    }

    public void agregarCliente(String nombre, String pwd, TipoCliente tipoCli) {
        Cliente c = new Cliente(nombre, pwd, tipoCli);
        clientes.add(c);

    }

    public void eliminarGestor(String nombre) {
        Gestor gestorAEliminar = obtenerGestor(nombre);
        gestores.remove(gestorAEliminar);
    }

    public void eliminarCliente(int num) {
        Cliente clienteAEliminar = obtenerCliente(num);
        clientes.remove(clienteAEliminar);
    }

    public void agregarGestor(String nombre, String pwd, UnidadProcesadora uProc, String nC) {
        Gestor g = new Gestor(nombre, pwd, uProc, nC);
        gestores.add(g);
    }

    public Gestor loginGestor(String nom, String pwd){
        for (Gestor gestor : gestores) {
            
            if (gestor.getNombre().toUpperCase().equals(nom.toUpperCase()) && gestor.getPwd().equals(pwd) && !gestor.logueado) {
                gestor.logueado = true;
                return gestor;

            }           
            
        }
        return null;
    }

    public Cliente loginCliente(int num, String pwd) throws ClienteException {
        for (Cliente cliente : clientes) {
            if (cliente.getNum() == num) {
                if (!cliente.getPwd().equals(pwd)) {
                    return null; // contraseña incorrecta
                }
                if (cliente.logueado) {                    
                    throw new ClienteException("No puede loguearse en más de un dispositivo a la vez");
                }
                agregarServicio(cliente);
                cliente.logueado = true;                
                return cliente;
            }
        }
        return null; // no se encontró cliente con ese número
    }

    public void agregarServicio(Cliente c1) {
        servicio = new Servicio(c1);
        Fachada.getInstancia().agregarServiciosPedido(servicio);
        //agregar dispositivo
        
    }

    public Servicio obtenerServicio(Cliente cli) {

        return servicio;

    }

    public void AgregarDispositivo(boolean e, Servicio servicio, Cliente cliente) {
        Dispositivo d = new Dispositivo(e, servicio, cliente);
        listaDispositivos.add(d);
        Servicio s = d.getServicio();
        s.setDispo(d);
        
    }

    public void liberarDispositivo(Dispositivo d) {
        for (Dispositivo dispo : listaDispositivos) {
            if(dispo == d){
                d.getCliente().logueado=false;
                dispo.setEstadoDispositivo(false);
                
            }
        }
    }

}
