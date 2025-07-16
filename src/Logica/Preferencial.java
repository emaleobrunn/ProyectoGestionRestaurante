package Logica;

public class Preferencial extends TipoCliente {

    public Preferencial() {
        super("Preferencial");
    }

    @Override
    public double calcularMonto(Dispositivo d) {
        Servicio s = d.getServicio();
        double retorno = 0;
        for (Pedido p : s.getPedidos()) {
           if(p.getItem().getNombre().equalsIgnoreCase("Agua Mineral")){retorno = retorno;}
           else{
            retorno = retorno + p.getItem().getPrecioU();
           }
        }
        
        if(retorno > 2000){
            retorno *= 0.95;
        }

        return retorno;
    }

}
