package Logica;

public class Gestor extends Usuario {


    private UnidadProcesadora uProc;
    private String nCompleto;
    public Gestor(String nombre, String pwd, UnidadProcesadora uProcesadora, String nC) {
        super(nombre, pwd);
        this.nCompleto = nC;
        this.uProc = uProcesadora;
      
    }
   

    @Override
    public String getNombre() {
        return super.nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public UnidadProcesadora getuProc() {
        return uProc;
    }

    public void setuProc(UnidadProcesadora uProc) {
        this.uProc = uProc;
    }

    @Override
    public String toString() {
        return "Usuario = " + super.nombre +" |" + "| Unidad Procesadora = " + uProc +" |" + "| Nombre Completo = " + nCompleto +" |";
    }

}
