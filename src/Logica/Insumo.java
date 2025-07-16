package Logica;

public class Insumo {

    private String nombre;

    private int StockMinimo;
    private int StockActual;

    public Insumo(String nombre, int StockA, int StockM) {
        this.nombre = nombre;
        this.StockActual = StockA;
        this.StockMinimo = StockM;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStockMinimo() {
        return StockMinimo;
    }

    public void setStockMinimo(int StockMinimo) {
        this.StockMinimo = StockMinimo;
    }

    public int getStockActual() {
        return StockActual;
    }

    public void setStockActual(int StockActual) {
        this.StockActual = StockActual;
    }

    void descontar(int cantidad) {
        StockActual -= cantidad;
    }

    void reponer(int cantidad) {
        StockActual += cantidad;
    }

}
