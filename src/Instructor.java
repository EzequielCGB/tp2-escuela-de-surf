public class Instructor {
    //Atributos en privado
    private String nombre;
    private String apellido;
    private String matricula;
    private static int cantidadInstructor = 0;

    //Constructor
    public Instructor(String nombre, String apellido, String matricula){
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
        cantidadInstructor++;
    }

    //Getters y Setters
    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getApellido(){
        return this.apellido;
    }

    public void setApellido(String apellido){
        this.apellido = apellido;
    }

    public String getMatricula(){
        return this.matricula;
    }

    public void setMatricula(String matricula){
        this.matricula = matricula;
    }

    public static int getCantidadInstructor(){
        return cantidadInstructor;
    }
    
    //Metodo de descripcion
    public String descripcion(){
        return "Instructor: " + this.apellido + ", " + this.nombre + "(Matricula: " + this.matricula + ")";
    }
}
