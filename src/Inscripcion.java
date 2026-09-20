public class Inscripcion {
    private String fechaInscripcion;
    private Alumno alumno;
    private Turno turno;
    private Tabla tablaAsignada;
    private String asistencia;

    public Inscripcion(String fechaInscripcion, Alumno alumno, Turno turno, Tabla tabla, String asistencia){
        setFechaInscripcion(fechaInscripcion);
        setAlumno(alumno);
        setTurno(turno);
        setTablaAsignada(tabla);
        setAsistencia(asistencia);
    }
    public Inscripcion(String fechaInscripcion, Alumno alumno, Turno turno, Tabla tabla){
        this(fechaInscripcion, alumno, turno, tabla, "Indefinido");
    }

    // Setters
    private void setFechaInscripcion(String fechaInscripcion){
        if (!fechaInscripcion.isEmpty())
            this.fechaInscripcion = fechaInscripcion;
    }
    private void setAlumno(Alumno alumno){
        this.alumno = alumno;
    }
    private void setTurno(Turno turno){
        if (Turno.hayCupo()){
            this.turno = turno;
        }
    }
    private void setAsistencia(String asistencia){
        if (asistencia.equalsIgnoreCase("presente") || asistencia.equalsIgnoreCase("ausente") || asistencia.equalsIgnoreCase("indefinido"))
            this.asistencia = asistencia;
    }
    public void setTablaAsignada(Tabla tabla){
        this.tablaAsignada = tabla;
    }

    // Getters
    public String getFechaInscripcion(){
        return fechaInscripcion;
    }
    public Alumno getAlumno(){
        return alumno;
    }
    public Turno getTurno(){
        return turno;
    }
    public Tabla getTablaAsignada(){
        return tablaAsignada;
    }
    public String getAsistencia(){
        return asistencia;
    }
}