package Logica;

import java.util.ArrayList;

public class Categoria {

    public String nombre;
    private ArrayList<Item> listaItems = new ArrayList<>();
    private Menu menu;

    public Categoria(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }

    public ArrayList<Item> getListaItems() {

        ArrayList<Item> retorno = new ArrayList<Item>();

        for (Item i : listaItems) {

            if (i.ingredientesDisp()) {
                retorno.add(i);
            }
        }
        return retorno;
    }

    public void agregarItem(Item i) {
        listaItems.add(i);
    }

}
