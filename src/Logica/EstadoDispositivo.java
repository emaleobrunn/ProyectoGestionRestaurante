package Logica;

public class EstadoDispositivo {

    public boolean disponible;

    public EstadoDispositivo(boolean disponible) {
        this.disponible = disponible;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    
    
}
