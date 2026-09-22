import java.util.Scanner;
public class MainSurf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("----- ESCUELA DE SURF -----");
        
        //pongo los datos
        System.out.print("Nombre de la escuela: ");
        String nombreEscuela = scanner.nextLine();

        System.out.print("Direccion : ");
        String direccionEscuela = scanner.nextLine();

        Escuela escuela = new Escuela(nombreEscuela, direccionEscuela);

        //poner un instructor por teclado
        System.out.println("----- INSTRUCTORES -----");
        System.out.print("Nombre: ");
        String nombreInstructor = scanner.nextLine();

        System.out.print("Apellido: ");
        String apellidoInstructor = scanner.nextLine();

        System.out.print("Matricula: ");
        String matriculaInstructor = scanner.nextLine();

        Instructor instructor = new Instructor(nombreInstructor, apellidoInstructor,matriculaInstructor);

        // ingresar tablas por teclado
        System.out.println("\n----- TABLA ----- ");
        System.out.print("Codigo de la tabla: ");
        int codigoTabla= scanner.nextInt();

        System.out.print("Largo de la tabla en pies: ");
        double largoTabla = scanner.nextDouble();
        scanner.nextLine();

        Tabla tabla = new Tabla(codigoTabla, largoTabla);

        //Crear turno
        System.out.println("\n----- cARGAR TURNO ----- ");
        System.out.print("Fecha: ");
        String fechaTurno= scanner.nextLine();

        System.out.print("Horario: ");
        String horaTurno = scanner.nextLine();

        Turno turno = new Turno(fechaTurno, horaTurno, instructor);

        //Alumno por teclado
        System.out.println("\n----- CARGAR ALUMNO ----- ");
        System.out.print("nombre del alumno: ");
        String nombreAlumno = scanner.nextLine();

        System.out.print("Apellido del alumno: ");
        String apellidoAlumno = scanner.nextLine();

        System.out.print("DNI: ");
        String dniAlumno = scanner.nextLine();

        System.out.print("Nivel del alumno:(principiante/intermedio):  ");
        String nivelAlumno = scanner.nextLine();

        Alumno alumno = new Alumno(nombreAlumno, apellidoAlumno, dniAlumno ,nivelAlumno);

        //hacer la inscripcion
        System.out.println("\n----- INSCRIPCION -----");
        System.out.print("Fecha de inscripcion: ");
        String fechaInscripcion = scanner.nextLine();

        System.out.print("Asistencia: (presente/ausente/indefinido) ");
        String asistencia = scanner.nextLine();
        
        Inscripcion inscripcion = new Inscripcion(fechaInscripcion, alumno, turno, tabla, asistencia);
        boolean bienInscripto = turno.agregarInscripto(inscripcion);
        System.out.println("\n ----- MOSTAR CARGA -----");

        if(bienInscripto){
            System.out.println("Inscripcion realizasa con exito ");
            System.out.println(inscripcion.descripcion());
            System.out.println(alumno.descripcion());
        } else {
            System.out.println("No se pudo realizar la inscripcion por falta de cupo");
        }
        scanner.close();
    }  
}
