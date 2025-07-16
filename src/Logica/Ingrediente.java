package Logica;

public class Ingrediente {

	private int cantidad;

	private Insumo insumo;

    public Ingrediente(int cantidad, Insumo insumo) {
        this.cantidad = cantidad;
        this.insumo = insumo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Insumo getInsumo() {
        return insumo;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }
        
        
    public void descontarInsumo(){        
        this.insumo.descontar(this.cantidad);
    }

    void reponerInsumos() {
         this.insumo.reponer(this.cantidad);
    }
    
}
