package Logica;

public class DeLaCasa extends TipoCliente {

    public DeLaCasa() {
        super("DeLaCasa");
    }

    @Override
    public double calcularMonto(Dispositivo d) {
        Servicio s = d.getServicio();
        double retorno = 0;
        for (Pedido p : s.getPedidos()) {            
             retorno = retorno + p.getItem().getPrecioU();
        }
        
        if(retorno-500<0){
            return 0;
        }else{
            return retorno-500;
        }

        
    }

}
