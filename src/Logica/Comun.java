package Logica;

public class Comun extends TipoCliente {

    public Comun() {
        super("Comun");
    }

    @Override
    public double calcularMonto(Dispositivo d) {
       Servicio s = d.getServicio();
       double retorno = 0;
       for(Pedido p : s.getPedidos()){
           retorno = retorno + p.getItem().getPrecioU();
       }
       
       return retorno;
    }

}
