
package Modelo;


public class Empleado {
    int id;
    String dpi;
    String nombre;
    String telefono;
    String user;

    public Empleado() {
    }

    public Empleado(int id, String dpi, String nombre, String telefono, String user) {
        this.id = id;
        this.dpi = dpi;
        this.nombre = nombre;
        this.telefono = telefono;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
    
    
}
