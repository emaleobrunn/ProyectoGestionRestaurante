/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package luEscritorio;

import Logica.Exception.GestorException;
import vistaEscritorio.VistaMenuGestorFrame;
import vistaEscritorio.VistaLoginGestorFrame;
import Logica.Fachada;
import Logica.Gestor;
import java.awt.Frame;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import observador.Observable;


public class AccesoGestor extends VistaLoginGestorFrame{
    
    public AccesoGestor(Frame parent, boolean modal, String titulo) {
        super(parent, modal,"Login Gestor");
    }

    @Override
    public Object llamarMetodoLogin(String nombre, String password) {
        
            return Fachada.getInstancia().loginGestor(nombre, password);
                
    }

    @Override
    public void crearProximaVentana(Object resultadoLogin) {
        new VistaMenuGestorFrame(null, false,(Gestor)resultadoLogin, "Procesar Pedido").setVisible(true);
    }

   

   
    
}
