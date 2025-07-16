package Logica;

import java.util.ArrayList;

public class Item {

    private String nombre;

    private double precioU;

    private ArrayList<Ingrediente> listaIngredientes;

    private UnidadProcesadora unidadProcesadora;

    private Categoria categoria;

    public Item(String nombre, double precioU, ArrayList<Ingrediente> listaIngredientes, UnidadProcesadora unidadProcesadora, Categoria categoria) {
        this.nombre = nombre;
        this.precioU = precioU;
        this.listaIngredientes = listaIngredientes;
        this.unidadProcesadora = unidadProcesadora;
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return nombre;
    }

    public UnidadProcesadora getUnidadProcesadora() {
        return unidadProcesadora;
    }

    public void setUnidadProcesadora(UnidadProcesadora unidadProcesadora) {
        this.unidadProcesadora = unidadProcesadora;
    }

    public double getPrecioU() {
        return precioU;
    }

    public void setPrecioU(double precioU) {
        this.precioU = precioU;
    }

    void descontarStock() {
        
        for(Ingrediente i: this.listaIngredientes){
            i.descontarInsumo();
        }
    }

    public boolean ingredientesDisp() {  
        
        for(Ingrediente ing: this.listaIngredientes){
                                  
            if(ing.getInsumo().getStockActual()-ing.getInsumo().getStockMinimo()<ing.getCantidad()){
                return false;                
            }            
        }
        
        return true;
    }

    void reponerStock() {
        for(Ingrediente i: this.listaIngredientes){
            i.reponerInsumos();
        }
    }
    
    
    
    
}
