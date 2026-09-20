public class Turno {
    //Constante 
    public static final int CUPO_MAXIMO = 20;

    //Atributos
    private String fecha;
    private String horario;
    private Instructor instructor;
    private Inscripcion[] incripciones;
    private int catidadInscriptos;

    //Constructor
    public Turno(String fecha, String horario, Instructor instructor){
        this.fecha = fecha;
        this.horario = horario;
        this.instructor = instructor;
        this.inscripciones = new Incripcion[CUPO_MAXIMO];
        this.cantidadInscriptos = 0;
    }

    //Verific si hay cupo disponible para inscribirse
    public boolean hayCupo(){
        return this.cantidadInscriptos < CUPO_MAXIMO;
    }

    //Para agregar una inscripcion respetando el cupo
    public boolean agregarInscripto(Inscripcion inscripcion){
        if (!hayCupo()){
            System.out.println("Error: El turno de la fecha " + this.fecha + " a las " + this.horario + "llego a su cupo maximo (" + CUPO_MAXIMO + ")");
            return false;
        }
        this.inscripciones[this.cantidadInscriptos] = inscripcion;
        this.cantidadInscriptos++;
        return true;
    }

    //Calcula el porcentaje de asistencia de este turno
    public double calcularPorcentajeAsistencia(){
        if (this.catidadInscriptos == 0) {
            return 0;
        }
        int presentes = 0;
        for (int i = 0; i < this.catidadInscriptos; i++){
            Inscripcion inscrip = this.inscripciones[i];
            if(inscrip != null && this.getAsistencia() != null && inscrip.getAsistencia().equalsIgnoreCase("presente")){
                presentes++;
            }
        }
        return ((double) presentes / this.catidadInscriptos) * 100;  
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
        return this.Instructor;
    }
    
    public void setInstructor(Instructor intructor){
        this.instructor = instructor;
    }

    public int getCantidadInscriptos(){
        return this.catidadInscriptos;
    }
    public Inscripcion[] getInscripciones(){
        return this.inscripciones;
    }
    //Metodo descripcion
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
