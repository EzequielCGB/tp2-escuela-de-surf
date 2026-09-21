public class Alumno {
    private final int numeroAlumno;
    private String nombre;
    private String apellido;
    private String dni;
    private String nivel;
    private Inscripcion[] inscripciones;
    public static final int MAXIMO_INSCRIPCIONES = 10;
    private static int cantidadAlumnos = 0;

    // Constructor
    public Alumno(String nombre, String apellido, String dni, String nivel){
        setNombre(nombre);
        setApellido(apellido);
        setDni(dni);
        setNivel(nivel);
        this.inscripciones = new Inscripcion[MAXIMO_INSCRIPCIONES];
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
        return nombre;
    }
    public String getApellido(){
        return apellido;
    }
    public String getDni(){
        return dni;
    }
    public String getNivel(){
        return nivel;
    }
    public int getNumeroAlumno(){
        return numeroAlumno;
    }
    public Inscripcion[] getInscripciones(){
        return inscripciones;
    }

    // Metodos
    public String descripcion(){
        return "Alumno numero " + numeroAlumno + ": " + nombre + " " + apellido + ", DNI " + dni + ", nivel " + nivel;
    }
    public void mostrarInscripciones(){
        if (inscripciones == null){
            System.out.println("El alumno " + nombre + " " + apellido + " no esta inscripto en ningun turno.");
        } else {
            System.out.println("El alumno " + nombre + " " + apellido + "esta inscripto en los siguientes turnos: ");
            for (Inscripcion inscripcion : inscripciones) {
                System.out.println(inscripcion.descripcion());
            }
        }
    }
}
