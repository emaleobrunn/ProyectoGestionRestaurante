package Logica;
import java.util.Objects;

public class Cliente extends Usuario {

    private TipoCliente tipoCliente;
    private int id;
    private static int num = 0;
    private Dispositivo dispositivo;

    public Cliente(String nombre, String pwd, TipoCliente tipoCli) {
        super(nombre, pwd);
        num++;
        this.tipoCliente = tipoCli;
        this.id = num;
        
    }

    public Dispositivo getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }
   
    public String getTipoCliente() {
        return tipoCliente.nombre;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public int getNum() {
        return id;
    }

    public void setNum(int num) {
        this.id = num;
    }

    public double calcularMonto(Dispositivo d){
    return tipoCliente.calcularMonto(d);
    }
    //Arreglar metodo
    @Override
    public String toString() {
        return nombre;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

}
