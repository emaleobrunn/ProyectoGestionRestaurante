package Logica;

public class Frecuente extends TipoCliente {

    public Frecuente() {
        super("Frecuente");
    }

    @Override
    public double calcularMonto(Dispositivo d) {
        Servicio s = d.getServicio();
        double retorno = 0;
        for (Pedido p : s.getPedidos()) {
             if(p.getItem().getNombre().equalsIgnoreCase("Cafe Expresso")){retorno = retorno;}
             else{
             retorno = retorno + p.getItem().getPrecioU();
             }
        
        }

        return retorno;
    }

}
