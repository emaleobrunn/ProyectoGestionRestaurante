/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Prueba;

import luEscritorio.MenuDesarrollo;

public class Inicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Llamar a la carga de datos y a las pruebas iniciales
        DatosPrueba.cargar();
        DatosPrueba.test();
        
        new MenuDesarrollo().setVisible(true);
        
        //Inicar la IU
//        new MenuDesarrollo().setVisible(true);
    }
}
