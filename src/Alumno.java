public class Alumno {
    private final int numeroAlumno;
    private String nombre;
    private String apellido;
    private String dni;
    private String nivel;
    private Inscripcion[] inscripciones;
    private static int cantidadAlumnos = 0;

    // Constructor
    public Alumno(String nombre, String apellido, String dni, String nivel){
        setNombre(nombre);
        setApellido(apellido);
        setDni(dni);
        setNivel(nivel);
        this.numeroAlumno = cantidadAlumnos + 1;
        cantidadAlumnos++;
    }

    // Setters
    private void setNombre(String nombre){
        if (!nombre.isEmpty()){
            this.nombre = nombre;
        }
    }
    private void setApellido(String apellido){
        if (!apellido.isEmpty()){
            this.apellido = apellido;
        }
    }
    private void setDni(String dni){
        if (!dni.isEmpty()){
            this.dni = dni;
        }
    }
    public void setNivel(String nivel){
        if (nivel.equalsIgnoreCase("principiante") || nivel.equalsIgnoreCase("intermedio")){
            this.nivel = nivel;
        }
    }

    // Getters
    public String getNombre(){
        return this.nombre;
    }
    public String getApellido(){
        return this.apellido;
    }
    public String getDni(){
        return this.dni;
    }
    public String getNivel(){
        return this.nivel;
    }
    public int getNumeroAlumno(){
        return this.numeroAlumno;
    }
}
