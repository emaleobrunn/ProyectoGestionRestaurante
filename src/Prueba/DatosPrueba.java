package Prueba;

import Logica.Categoria;
import Logica.Cliente;
import Logica.Comun;
import Logica.DeLaCasa;
import Logica.EstadoDispositivo;
import Logica.Fachada;
import Logica.Frecuente;
import Logica.Gestor;
import Logica.Ingrediente;
import Logica.Insumo;
import Logica.Preferencial;
import Logica.Servicio;
import Logica.Subdominios.SistemaAcceso;
import Logica.TipoCliente;
import Logica.UnidadProcesadora;
import java.util.ArrayList;
import java.util.List;

public class DatosPrueba {

    public static void cargar() {

        Fachada fachada = Fachada.getInstancia();

        Categoria Entrada = fachada.agregarCategoria("Entrada");
        Categoria Principal = fachada.agregarCategoria("Principal");
        Categoria Bebida = fachada.agregarCategoria("Bebida sin alcohol");
        Categoria Postre = fachada.agregarCategoria("Postre");

        //Agrego tipos de cliente
        TipoCliente Comun = new Comun();
        TipoCliente DeLaCasa = new DeLaCasa();
        TipoCliente Frecuente = new Frecuente();
        TipoCliente Preferencial = new Preferencial();

        //Agrego clientes        
        fachada.agregarCliente("Nicolas", "1234", Comun);
        fachada.agregarCliente("Emanuel", "1234", DeLaCasa);
        fachada.agregarCliente("Santiago", "1234", Frecuente);
        fachada.agregarCliente("Tomas", "1234", Preferencial);
        fachada.agregarCliente("Santiago", "1234", Frecuente);
        fachada.agregarCliente("Tomas", "1234", Preferencial);

        fachada.agregarCliente("Agustín", "1234", Comun);
        fachada.agregarCliente("Lucas", "1234", DeLaCasa);
        fachada.agregarCliente("Matías", "1234", Frecuente);
        fachada.agregarCliente("Bruno", "1234", Preferencial);

        fachada.agregarCliente("Facundo", "1234", Comun);
        fachada.agregarCliente("Martín", "1234", DeLaCasa);
        fachada.agregarCliente("Diego", "1234", Frecuente);
        fachada.agregarCliente("Leonel", "1234", Preferencial);

        fachada.agregarCliente("Franco", "1234", Comun);
        fachada.agregarCliente("Pablo", "1234", DeLaCasa);
        fachada.agregarCliente("Rodrigo", "1234", Frecuente);
        fachada.agregarCliente("Juan", "1234", Preferencial);

        fachada.agregarCliente("Joaquín", "1234", Comun);
        fachada.agregarCliente("Emiliano", "1234", DeLaCasa);
        fachada.agregarCliente("Sebastián", "1234", Frecuente);
        fachada.agregarCliente("Gonzalo", "1234", Preferencial);

        fachada.agregarCliente("Valentín", "1234", Comun);
        fachada.agregarCliente("Federico", "1234", DeLaCasa);
        fachada.agregarCliente("Maximiliano", "1234", Frecuente);
        fachada.agregarCliente("Camilo", "1234", Preferencial);

        fachada.agregarCliente("Thiago", "1234", Comun);
        fachada.agregarCliente("Lautaro", "1234", DeLaCasa);
        fachada.agregarCliente("Andrés", "1234", Frecuente);
        fachada.agregarCliente("Adrián", "1234", Preferencial);

        fachada.agregarCliente("Enzo", "1234", Comun);
        fachada.agregarCliente("Leandro", "1234", DeLaCasa);

        Cliente Nicolas = fachada.obtenerCliente(1);
        Cliente Emanuel = fachada.obtenerCliente(2);

        //Agrego Unidad Procesadora
        fachada.AgregarUnidadProcesadora("Cocina");
        fachada.AgregarUnidadProcesadora("Bar");

        UnidadProcesadora Cocina = fachada.obtenerUProcesadora("Cocina");
        UnidadProcesadora Bar = fachada.obtenerUProcesadora("Bar");

        //Agrego gestores
        fachada.agregarGestor("Ernesto", "5678", Cocina, "Ernesto Recoba");
        fachada.agregarGestor("Jose", "5678", Bar, "Jose De Leon");
        fachada.agregarGestor("coc", "coc", Cocina, "Luis Suárez");
        fachada.agregarGestor("coc2", "coc2", Cocina, "Luis Suárez");
        fachada.agregarGestor("bar", "bar", Bar, "Edinson Cavani");
        fachada.agregarGestor("bar2", "bar2", Bar, "Edinson Cavani");
        
        
        Gestor Ernesto = fachada.obtenerGestor("Ernesto");
        Gestor Jose = fachada.obtenerGestor("Jose");

        //Agregar Insumos
        Insumo cebolla = fachada.AgregarInsumo("Cebolla", 100, 20 );
        Insumo tomate = fachada.AgregarInsumo("Tomate", 100, 20 );
        Insumo lechuga = fachada.AgregarInsumo("Lechuga", 100, 20 );
        Insumo queso = fachada.AgregarInsumo("Queso", 100, 20 );
        Insumo jamon = fachada.AgregarInsumo("Jamón", 100, 20 );
        Insumo pan = fachada.AgregarInsumo("Pan", 100, 20 );
        Insumo carne = fachada.AgregarInsumo("Carne", 100, 20 );
        Insumo pollo = fachada.AgregarInsumo("Pollo", 100, 20 );
        Insumo papa = fachada.AgregarInsumo("Papa", 100, 20 );
        Insumo leche = fachada.AgregarInsumo("Leche", 100, 20 );
        Insumo huevo = fachada.AgregarInsumo("Huevo", 100, 20 );
        Insumo azucar = fachada.AgregarInsumo("Azúcar", 100, 20 );
        Insumo dulceLeche = fachada.AgregarInsumo("Dulce de Leche", 100, 20 );
        Insumo cafe = fachada.AgregarInsumo("Cafe", 200, 80 );
        Insumo agua = fachada.AgregarInsumo("Agua", 900, 400 );

        Insumo vodka = fachada.AgregarInsumo("Vodka", 100, 20 );
        Insumo ron = fachada.AgregarInsumo("Ron", 100, 20 );
        Insumo jugoLimon = fachada.AgregarInsumo("Jugo de Limón", 100, 20 );
        Insumo jarabeAzucar = fachada.AgregarInsumo("Jarabe de Azúcar", 100, 20 );
        Insumo hielo = fachada.AgregarInsumo("Hielo", 100, 20 );

// Iingredientes
        Ingrediente cebolla1 = fachada.AgregarIngrediente(1, cebolla);
        Ingrediente tomate2 = fachada.AgregarIngrediente(2, tomate);
        Ingrediente lechuga1 = fachada.AgregarIngrediente(1, lechuga);
        Ingrediente queso2 = fachada.AgregarIngrediente(2, queso);
        Ingrediente jamon1 = fachada.AgregarIngrediente(1, jamon);
        Ingrediente pan1 = fachada.AgregarIngrediente(1, pan);
        Ingrediente pan2 = fachada.AgregarIngrediente(2, pan);
        Ingrediente carne2 = fachada.AgregarIngrediente(2, carne);
        Ingrediente carne1 = fachada.AgregarIngrediente(1, carne);
        Ingrediente pollo3 = fachada.AgregarIngrediente(3, pollo);
        Ingrediente papa3 = fachada.AgregarIngrediente(3, papa);
        Ingrediente leche100 = fachada.AgregarIngrediente(100, leche);      // 100 ml
        Ingrediente huevo1 = fachada.AgregarIngrediente(1, huevo);      // 1 unidad
        Ingrediente azucar20 = fachada.AgregarIngrediente(20, azucar);     // 20 g
        Ingrediente dulceLeche30 = fachada.AgregarIngrediente(30, dulceLeche); // 30 g
        

// --- Bar/Cóckteles 
        Ingrediente vodka50 = fachada.AgregarIngrediente(50, vodka);        // 50 ml de Vodka
        Ingrediente ron50 = fachada.AgregarIngrediente(50, ron);          // 50 ml de Ron
        Ingrediente jugoLimon30 = fachada.AgregarIngrediente(30, jugoLimon);    // 30 ml de Jugo de Limón
        Ingrediente jarabeAzucar10 = fachada.AgregarIngrediente(10, jarabeAzucar); // 10 ml de Jarabe de Azúcar
        Ingrediente hielo5 = fachada.AgregarIngrediente(5, hielo); // 5 cubos de Hielo
        Ingrediente cafe30 = fachada.AgregarIngrediente(30, cafe);
        Ingrediente agua500 = fachada.AgregarIngrediente(500, agua);

        // 1) Ensalada Criolla (Cocina, Entrada)
        ArrayList<Ingrediente> ingredientesEnsaladaCriolla = new ArrayList<>();
        ingredientesEnsaladaCriolla.add(tomate2);
        ingredientesEnsaladaCriolla.add(cebolla1);
        ingredientesEnsaladaCriolla.add(lechuga1);

// 2) Empanada de Carne (Cocina, Entrada)
        ArrayList<Ingrediente> ingredientesEmpanadaCarne = new ArrayList<>();
        ingredientesEmpanadaCarne.add(carne2);
        ingredientesEmpanadaCarne.add(cebolla1);
        ingredientesEmpanadaCarne.add(pan1);

// 3) Chivito (Cocina, Principal)
        ArrayList<Ingrediente> ingredientesChivito = new ArrayList<>();
        ingredientesChivito.add(pan2);
        ingredientesChivito.add(carne1);
        ingredientesChivito.add(jamon1);
        ingredientesChivito.add(queso2);
        ingredientesChivito.add(lechuga1);
        ingredientesChivito.add(tomate2);

// 4) Milanesa con Papas Fritas (Cocina, Principal)
        ArrayList<Ingrediente> ingredientesMilanesaPapas = new ArrayList<>();
        ingredientesMilanesaPapas.add(pollo3);
        ingredientesMilanesaPapas.add(pan2);
        ingredientesMilanesaPapas.add(papa3);

// 5) Mojito (Bar, Bebida)
        ArrayList<Ingrediente> ingredientesMojito = new ArrayList<>();
        ingredientesMojito.add(ron50);
        ingredientesMojito.add(jugoLimon30);
        ingredientesMojito.add(jarabeAzucar10);
        ingredientesMojito.add(hielo5);

// 6) Vodka Sour (Bar, Bebida)
        ArrayList<Ingrediente> ingredientesVodkaSour = new ArrayList<>();
        ingredientesVodkaSour.add(vodka50);
        ingredientesVodkaSour.add(jugoLimon30);
        ingredientesVodkaSour.add(jarabeAzucar10);
        ingredientesVodkaSour.add(hielo5);

// 7) Flan Casero (Cocina, Postre)
        ArrayList<Ingrediente> ingredientesFlanCasero = new ArrayList<>();
        ingredientesFlanCasero.add(leche100);
        ingredientesFlanCasero.add(huevo1);
        ingredientesFlanCasero.add(azucar20);
               
 

// 8) Queso con Dulce de Leche (Cocina, Postre)
        ArrayList<Ingrediente> ingredientesQuesoDulce = new ArrayList<>();
        ingredientesQuesoDulce.add(queso2);
        ingredientesQuesoDulce.add(dulceLeche30);
        
        //9 Agua mineral
        ArrayList<Ingrediente> ingredientesAgua = new ArrayList<>();
        ingredientesAgua.add(agua500);
        
        //10 Cafe negro
        ArrayList<Ingrediente> ingredientesCafe = new ArrayList<>();
        ingredientesCafe.add(cafe30);

        // Entradas
        fachada.agregarItem("Ensalada Criolla", 300.0, ingredientesEnsaladaCriolla, Cocina, Entrada);
        fachada.agregarItem("Empanada de Carne", 180.0, ingredientesEmpanadaCarne, Cocina, Entrada);

        //Principal
        fachada.agregarItem("Chivito", 650.0, ingredientesChivito, Cocina, Principal);
        fachada.agregarItem("Milanesa con Papas Fritas", 550.0, ingredientesMilanesaPapas, Cocina, Principal);

        //Bebidas
        fachada.agregarItem("Mojito", 450.0, ingredientesMojito, Bar, Bebida);
        fachada.agregarItem("Vodka Sour", 400.0, ingredientesVodkaSour, Bar, Bebida);
        fachada.agregarItem("Agua Mineral", 100, ingredientesAgua, Bar, Bebida);
        fachada.agregarItem("Cafe Expresso", 80, ingredientesCafe, Bar, Bebida);

        //Postre
        fachada.agregarItem("Flan Casero", 200.0, ingredientesFlanCasero, Cocina, Postre);
        fachada.agregarItem("Queso con Dulce de Leche", 180.0, ingredientesQuesoDulce, Cocina, Postre);

        //AgregarServiciod
       // fachada.agregarServicio(Nicolas);
        
        //Servicio s1 = fachada.obtenerServicio(Nicolas);

        //Agregar Estado Dispositivo
        EstadoDispositivo Disponible = new EstadoDispositivo(true);

        //Agregar Dispositivos
       // fachada.AgregarDispositivo(Disponible, s1, Emanuel);

        /*SystemOutPrint*/
        System.out.println(fachada.obtenerGestor("Ernesto"));
        System.out.println(fachada.obtenerGestor("Jose"));

        System.out.println(fachada.obtenerCliente(1));
        System.out.println(fachada.obtenerCliente(2));
        System.out.println(fachada.obtenerCliente(3));
        System.out.println(fachada.obtenerCliente(4));
        
        
        System.out.println(fachada.obtenerItemsPorCategoria(Entrada));
        
        //System.out.println(fachada.obtenerServicio(Nicolas));
        

    }
    
    public static void test() {
        
    Fachada fachada = Fachada.getInstancia();
    System.out.println("=== TEST DE DATOS PRECARGADOS ===\n");

  

    // 2) Gestor
    Gestor gestor = fachada.obtenerGestor("Ernesto");
    if (gestor != null) {
        System.out.println("Gestor 'Ernesto': " + gestor.getNombre());
    } else {
        System.out.println("Gestor 'Ernesto': null");
    }

    // 3) Unidad Procesadora
    UnidadProcesadora cocina = fachada.obtenerUProcesadora("Cocina");
    UnidadProcesadora bar    = fachada.obtenerUProcesadora("Bar");
    System.out.println("Unidad Procesadora 'Cocina': " + (cocina != null ? cocina.getNombre() : "null"));
    System.out.println("Unidad Procesadora 'Bar':    " + (bar    != null ? bar.getNombre()    : "null"));

    // 4) Categorías
    System.out.println("\nCategorías:");
   /* for (Categoria cat : fachada.obtenerCategorias()) {
        System.out.println(" - " + cat.getNombre());
    }*/
    Categoria entrada  = fachada.obtenerCategoriaPorNombre("Entrada");
    Categoria principal= fachada.obtenerCategoriaPorNombre("Principal");
    Categoria bebida   = fachada.obtenerCategoriaPorNombre("Bebida sin alcohol");
    Categoria postre   = fachada.obtenerCategoriaPorNombre("Postre");
    System.out.println("Recuperada Categoría 'Entrada': " + (entrada   != null ? entrada.getNombre()   : "null"));
    System.out.println("Recuperada Categoría 'Principal': " + (principal != null ? principal.getNombre() : "null"));

    // 5) Insumos
//    System.out.println("\nInsumos precargados:");
//    for (Insumo ins : fachada.obtenerInsumos()) {
//        System.out.println(" - " + ins.getNombre());
//    }
//
//    // 6) Ingredientes
//    System.out.println("\nIngredientes precargados:");
//    for (Ingrediente ing : fachada.obtenerIngredientes()) {
//        System.out.println(" - " + ing.getCantidad() + " × " + ing.getInsumo().getNombre());
//    }
//
//    // 7) Items
//    System.out.println("\nItems precargados:");
//    for (Item it : fachada.obtenerItems()) {
//        System.out.println(" - " 
//            + it.getNombre() 
//            + " | " + it.getUnidadProcesadora().getNombre() 
//            + " | " + it.getCategoria().getNombre());
//    }
//
//    // 8) Ejemplo de un Item específico
//    Item chivito = fachada.obtenerItem("Chivito");
//    if (chivito != null) {
//        System.out.println("\nDetalle de 'Chivito':");
//        System.out.println("  Precio: " + chivito.getPrecioU());
//        System.out.print("  Ingredientes: ");
//        for (Ingrediente ing : chivito.getListaIngredientes()) {
//            System.out.print(ing.getCantidad() + "×" + ing.getInsumo().getNombre() + "  ");
//        }
//        System.out.println();
//    } else {
//        System.out.println("\nItem 'Chivito' no encontrado");
//    }

    System.out.println("\n=== FIN DEL TEST ===");
    
   
}
}
