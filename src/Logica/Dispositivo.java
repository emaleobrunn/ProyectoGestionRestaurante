package Logica;

public class Dispositivo {

    private int id;
    
    private static int num = 0;

    private boolean estadoDispositivo;

    private Servicio servicio;

    private Cliente cliente;

    public Dispositivo(boolean estadoDispositivo , Servicio servicio, Cliente cliente) {
        num++;
        this.id = num;
        this.estadoDispositivo = estadoDispositivo;
        this.servicio = servicio;
        this.cliente = cliente;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public boolean isEstadoDispositivo() {
        return estadoDispositivo;
    }

    public void setEstadoDispositivo(boolean estadoDispositivo) {
        this.estadoDispositivo = estadoDispositivo;
    }

    
    
}
