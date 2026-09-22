public class Turno {
    //Constante 
    public static final int CUPO_MAXIMO = MainSurf.MAXIMO_TURNOS;

    //Atributos
    private String fecha;
    private String horario;
    private Instructor instructor;
    private Inscripcion[] inscripciones;
    private int cantidadInscriptos;
    private static int cantidadTurnos = 0;

    //Constructor
    public Turno(String fecha, String horario, Instructor instructor){
        this.fecha = fecha;
        this.horario = horario;
        this.instructor = instructor;
        this.inscripciones = new Inscripcion[CUPO_MAXIMO];
        this.cantidadInscriptos = 0;
        cantidadTurnos++;
    }

    //Verific si hay cupo disponible para inscribirse
    public boolean hayCupo(){
        return this.cantidadInscriptos < CUPO_MAXIMO;
    }

    //Para agregar una inscripcion respetando el cupo
    public boolean agregarInscripto(Inscripcion inscripcion){
        if (!hayCupo()){
            System.out.println("Error: El turno de la fecha " + this.fecha + " a las " + this.horario + " llego a su cupo maximo (" + CUPO_MAXIMO + ")");
            return false;
        }
        this.inscripciones[this.cantidadInscriptos] = inscripcion;
        this.cantidadInscriptos++;
        return true;
    }

    //Calcula el porcentaje de asistencia de este turno
    public double calcularPorcentajeAsistencia(){
        if (this.cantidadInscriptos == 0) {
            return 0;
        }
        int presentes = 0;
        for (int i = 0; i < this.cantidadInscriptos; i++){
            if(this.inscripciones[i].getAsistencia().equalsIgnoreCase("presente")){
                presentes++;
            }
        }
        return ((double) presentes / this.cantidadInscriptos) * 100;
    }

    //Getters y Setters
    public String getFecha(){
        return this.fecha;
    }

    public void setFecha(String fecha){
        this.fecha = fecha;
    }

    public String getHorario(){
        return this.horario;
    }
    
    public void setHorario(String horario){
        this.horario = horario;
    }

    public Instructor getInstructor(){
        return this.instructor;
    }
    
    public void setInstructor(Instructor instructor){
        this.instructor = instructor;
    }

    public int getCantidadInscriptos(){
        return this.cantidadInscriptos;
    }
    public Inscripcion[] getInscripciones(){
        return this.inscripciones;
    }
    public static int getCantidadTurnos(){
        return cantidadTurnos;
    }

    public String descripcion(){
        String nombreInstructor;
        if (this.instructor != null){
            nombreInstructor = this.instructor.getApellido() + ", " + this.instructor.getNombre();
        } else {
            nombreInstructor = "No hay Instructor";
        }
        return "Turno - Fecha: " + this.fecha + " - Horario: " + this.horario + "- Instructor: " + nombreInstructor + "- Inscriptos: " + this.getCantidadInscriptos() + " sobre el total: " + CUPO_MAXIMO;
    }
}
