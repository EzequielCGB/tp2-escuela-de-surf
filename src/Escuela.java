public class Escuela {
    private String nombre;
    private String direccion;
    private String telefono;

    public Escuela(String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Escuela(String nombre, String direccion) {
        this(nombre, direccion, " Sin telefono");
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String descripcion() {
        return "Escuela: " + nombre + " - Direccion: " + direccion + " - Telefono: " + telefono;
    }
}
