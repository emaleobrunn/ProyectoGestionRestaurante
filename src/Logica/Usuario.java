package Logica;

public abstract class Usuario {

    public String nombre;
    private String pwd;
    public boolean logueado;

    public Usuario(String nombre, String pwd) {
        this.nombre = nombre;        
        this.pwd = pwd;
        this.logueado = false;
        
    }

    public String getNombre() {
        return nombre;
    }

    public String getPwd() {
        return pwd;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public boolean isLogueado() {
        return logueado;
    }

    public void setLogueado(boolean logueado) {
        this.logueado = logueado;
    }
    
        @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ",  pwd=" + pwd + '}';
    }

}
