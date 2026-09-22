public class Escuela {
    private String nombre;
    private String direccion;
    private String telefono;
    private Turno[] turnos;
    private int cantidadTurnos;

    public Escuela(String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.turnos = new Turno[100];
        this.cantidadTurnos = 0;
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
    public Turno[] getTurnos(){
        return turnos;
    }
    public boolean agregarTurno(Turno unTurno){
        if(this.cantidadTurnos<this.turnos.length){
            this.turnos[this.cantidadTurnos] = unTurno;
            this.cantidadTurnos++;
            return true;
        }else{
            System.out.println("Error: La escuela no admite mas turnos.");
            return false;
        }
    }
    public int getCantidadTurnos(){
        return cantidadTurnos;
    }
    public String descripcion() {
        return "Escuela: " + nombre + " - Direccion: " + direccion + " - Telefono: " + telefono;
    }
}
