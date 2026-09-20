public class Escuela {
    private String nombre;
    private String direccion;
    private String telefono;

    public Escuela(String nombre, String direccion, String telefono){
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }
    public void descripcion() {
        System.out.println("Escuela: " + nombre + " - Direccion: " + direccion + " - Telefono: " + telefono);
    }
}
