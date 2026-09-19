package PACKAGE_NAME;

public class Turno {
    //Constante 
    public static final int CUPO_MAXIMO = 20;

    //Atributos
    private String fecha;
    private String horario;
    private Instructor instructor;
    private Inscripcion[] incripciones;
    private String catidadInscriptos;

    //Constructor
    public Turno(String fecha, String horario, Instructor instructor){
        this.fecha = fecha;
        this.horario = horario;
        this.instructor = instructor;
        this.inscripciones = new Incripcion[CUPO_MAXIMO];
        this.cantidadInscriptos = 0;
    }
}
