import java.util.Scanner;

public class MainSurf {
    public static final int MAXIMO_INSTRUCTORES = 10;
    public static final int MAXIMO_TABLAS = 20;
    public static final int MAXIMO_ALUMNOS = 50;
    public static final int MAXIMO_TURNOS = 20;
    public static final int MAXIMO_INSCRIPCIONES = 100;

    public static Instructor cargarInstructor(){
        Scanner teclado = new Scanner(System.in);
        Instructor instructor;

        System.out.println("Ingrese el nombre del instructor: ");
        String nombre = teclado.nextLine();
        System.out.println("Ingrese el apellido del instructor: ");
        String apellido = teclado.nextLine();
        System.out.println("Ingrese la matricula del instructor: ");
        String matricula = teclado.nextLine();
        instructor = new Instructor(nombre, apellido, matricula);

        return instructor;
    }
    public static void cargarInstructores(Instructor[] instructores){
        Scanner teclado = new Scanner(System.in);
        String continuar;

        System.out.println();
        System.out.println("A continuacion se le pedira los datos de uno o mas instructores");
        System.out.println("Tenga en cuenta que debe ingresar datos para por lo menos un instructor con un maximo de " + MAXIMO_INSTRUCTORES + " instructores");
        do{
            int cantidadInstructores = Instructor.getCantidadInstructor();
            instructores[cantidadInstructores] = cargarInstructor();
            System.out.println("Si desea agregar otro instructor ingrese 'si'");
            continuar = teclado.nextLine();
        }while(continuar.equalsIgnoreCase("si"));
    }

    public static Tabla cargarTabla(){
        Scanner teclado = new Scanner(System.in);
        Tabla tabla;

        System.out.println("Ingrese el codigo de la tabla: ");
        String codigo = teclado.nextLine();
        System.out.println("Ingrese el largo de la tabla(Debe estar entre 5 y 10): ");
        double largo = teclado.nextDouble();
        teclado.nextLine();
        System.out.println("Ingrese el estado de la tabla('disponible' o 'reparacion'): ");
        String estado = teclado.nextLine();
        tabla = new Tabla(codigo, largo, estado);

        return tabla;
    }
    public static void cargarTablas(Tabla[] tablas){
        Scanner teclado = new Scanner(System.in);
        String continuar;

        System.out.println("A continuacion se le pedira los datos de una o mas tablas");
        System.out.println("Tenga en cuenta que debe ingresar datos para por lo menos una tabla con un maximo de " + MAXIMO_TABLAS + " tablas");
        do{
            int cantidadTablas = Tabla.getCantidadTablas();
            tablas[cantidadTablas] = cargarTabla();
            System.out.println("Si desea agregar otra tabla ingrese 'si'");
            continuar = teclado.nextLine();
        }while(continuar.equalsIgnoreCase("si"));
    }

    public static void cargarTurno(Instructor[] instructores, Escuela escuela){
        Scanner teclado = new Scanner(System.in);
        Turno turno;
        int numeroInstructor;

        System.out.println("Ingrese la fecha del turno: ");
        String fecha = teclado.nextLine();
        System.out.println("Ingrese el horario del turno: ");
        String horario = teclado.nextLine();
        do{
            System.out.println("Ingrese el numero de instructor para el turno (Desde el 1 hasta el " + Instructor.getCantidadInstructor() + " en el orden que fueron ingresados)");
            numeroInstructor = teclado.nextInt();
            teclado.nextLine();
            if (numeroInstructor <= Instructor.getCantidadInstructor()){
                numeroInstructor--;
            } else {
                System.out.println("El numero del instructor debe estar entre el 1 y el " + Instructor.getCantidadInstructor());
            }
        } while (numeroInstructor >= Instructor.getCantidadInstructor());
        turno = new Turno(fecha, horario, instructores[numeroInstructor]);
        escuela.agregarTurno(turno);
    }
    public static void cargarTurnos(Turno[] turnos, Instructor[] instructores, Escuela escuela){
        Scanner teclado = new Scanner(System.in);
        String continuar;

        System.out.println("A continuacion se le pedira los datos de uno o mas turnos");
        System.out.println("Tenga en cuenta que debe ingresar datos para por lo menos un turno con un maximo de " + MAXIMO_TURNOS + " turnos");
        do{
            cargarTurno(instructores, escuela);
            System.out.println("Si desea agregar otro turno ingrese 'si'");
            continuar = teclado.nextLine();
        }while(continuar.equalsIgnoreCase("si"));
    }

    public static Alumno cargarAlumno(){
        Scanner teclado = new Scanner(System.in);
        Alumno alumno;

        System.out.println("Ingrese el nombre del alumno: ");
        String nombre = teclado.nextLine();
        System.out.println("Ingrese el apellido del alumno: ");
        String apellido = teclado.nextLine();
        System.out.println("Ingrese el dni del alumno: ");
        String dni = teclado.nextLine();
        System.out.println("Ingrese el nivel del alumno('principiante' o 'intermedio')");
        String nivel = teclado.nextLine();
        alumno = new Alumno(nombre, apellido, dni, nivel);

        return alumno;
    }
    public static void cargarAlumnos(Alumno[] alumnos){
        Scanner teclado = new Scanner(System.in);
        String continuar;

        System.out.println("A continuacion se le pedira los datos de uno o mas alumnos");
        System.out.println("Tenga en cuenta que debe ingresar datos para por lo menos un alumno con un maximo de " + MAXIMO_ALUMNOS + " alumnos");
        do{
            int cantidadAlumnos = Alumno.getCantidadAlumnos();
            alumnos[cantidadAlumnos] = cargarAlumno();
            System.out.println("Si desea agregar otro alumno ingrese 'si'");
            continuar = teclado.nextLine();
        }while(continuar.equalsIgnoreCase("si"));
    }

    // Se mantiene como un solo metodo para mantener la funcionalidad volver al principio con continue en caso de que el usuario se pase de largo al cargar los datos
    public static void cargarInscripciones(Inscripcion[] inscripciones, Alumno[] alumnos, Turno[] turnos, Tabla[] tablas){
        Scanner teclado = new Scanner(System.in);
        String continuar;

        System.out.println("A continuacion se le pedira los datos de una o mas inscripciones");
        System.out.println("Tenga en cuenta que debe ingresar datos para por lo menos una con un maximo de " + MAXIMO_INSCRIPCIONES + " inscripciones");
        do{
            String continuarInscripciones = "si";
            int alumno = 0;
            int turno = 0;
            int tabla = 0;
            int cantidadInscripciones = Inscripcion.getCantidadInscripciones();
            System.out.println("Ingrese la fecha de la inscripcion: ");
            String fecha = teclado.nextLine();
            for (int i = 0; i < Alumno.getCantidadAlumnos(); i++) {
                System.out.println(alumnos[i].descripcion());
                System.out.println("Es este el alumno que desea inscribir? Si es asi ingrese 'si'");
                continuarInscripciones = teclado.nextLine();
                if (continuarInscripciones.equalsIgnoreCase("si")) {
                    alumno = i;
                    break;
                }
            }
            if (!continuarInscripciones.equalsIgnoreCase("si")){
                System.out.println("No se ha asignado ningun alumno, se volvera al inicio de la inscripcion.");
                continuar = "si";
                continue;
            }
            for (int i = 0; i < Turno.getCantidadTurnos(); i++) {
                System.out.println(turnos[i].descripcion());
                System.out.println("Es este el turno al que desea inscribir? Si es asi ingrese 'si'");
                continuarInscripciones = teclado.nextLine();
                if (continuarInscripciones.equalsIgnoreCase("si")) {
                    turno = i;
                    break;
                }
            }
            if (!continuarInscripciones.equalsIgnoreCase("si")){
                System.out.println("No se ha asignado ningun turno, se volvera al inicio de la inscripcion.");
                continuar = "si";
                continue;
            }
            for (int i = 0; i < Tabla.getCantidadTablas(); i++) {
                System.out.println(tablas[i].descripcion());
                System.out.println("Es esta la tabla que desea asignar? Si es asi ingrese 'si'");
                continuarInscripciones = teclado.nextLine();
                if (continuarInscripciones.equalsIgnoreCase("si")) {
                    tabla = i;
                    break;
                }
            }
            if (!continuarInscripciones.equalsIgnoreCase("si")){
                System.out.println("No se ha asignado ninguna tabla, se volvera al inicio de la inscripcion.");
                continuar = "si";
                continue;
            }
            System.out.println("Ingrese el estado de la asistencia('presente' si asistio, 'ausente' si no asistio o 'indefinido' si el turno todavia no ocurrio): ");
            String asistencia = teclado.nextLine();
            inscripciones[cantidadInscripciones] = new Inscripcion(fecha, alumnos[alumno], turnos[turno], tablas[tabla], asistencia);
            turnos[turno].agregarInscripto(inscripciones[cantidadInscripciones]);
            System.out.println("Si desea agregar otra inscripcion ingrese 'si'");
            continuar = teclado.nextLine();
        }while(continuar.equalsIgnoreCase("si"));
    }

    public static void mostrarEscuela(Escuela escuela){
        System.out.println();
        System.out.println("Datos de la escuela");
        System.out.println(escuela.descripcion());
    }
    public static void mostrarInstructores(Instructor[] instructores){
        System.out.println();
        System.out.println("Datos de los instructores");
        for (int i = 0; i < Instructor.getCantidadInstructor(); i++){
            System.out.println(instructores[i].descripcion());
        }
    }
    public static void mostrarTablas(Tabla[] tablas){
        System.out.println();
        System.out.println("Datos de las tablas");
        for (int i = 0; i < Tabla.getCantidadTablas(); i++){
            System.out.println(tablas[i].descripcion());
        }
    }
    public static void mostrarTurnos(Turno[] turnos){
        System.out.println();
        System.out.println("Datos de los turnos");
        for (int i = 0; i < Turno.getCantidadTurnos(); i++){
            System.out.println(turnos[i].descripcion());
        }
    }
    public static void mostrarAlumnos(Alumno[] alumnos){
        System.out.println();
        System.out.println("Datos de los alumnos");
        for (int i = 0; i < Alumno.getCantidadAlumnos(); i++){
            System.out.println(alumnos[i].descripcion());
        }
    }
    public static void mostrarInscripciones(Inscripcion[] inscripciones){
        System.out.println();
        System.out.println("Datos de las inscripciones");
        for (int i = 0; i < Inscripcion.getCantidadInscripciones(); i++){
            System.out.println(inscripciones[i].descripcion());
        }
    }

    public static void main(String[] args) {
        String continuar;
        Instructor[] instructores = new Instructor[MAXIMO_INSTRUCTORES];
        Tabla[] tablas = new Tabla[MAXIMO_TABLAS];
        Alumno[] alumnos = new Alumno[MAXIMO_ALUMNOS];
        Inscripcion[] inscripciones = new Inscripcion[MAXIMO_INSCRIPCIONES];

        Scanner teclado =  new Scanner(System.in);

        System.out.println("A continuacion se le pediran los datos de la escuela");
        System.out.println("Ingrese el nombre de la escuela: ");
        String nombreEscuela = teclado.nextLine();
        System.out.println("Ingrese la direccion de la escuela: ");
        String direccionEscuela = teclado.nextLine();
        System.out.println("Ingrese el telefono de la escuela: ");
        String telefonoEscuela = teclado.nextLine();
        Escuela escuela = new Escuela(nombreEscuela, direccionEscuela, telefonoEscuela);

        cargarInstructores(instructores);
        cargarTablas(tablas);
        cargarTurnos(escuela.getTurnos(), instructores, escuela);
        cargarAlumnos(alumnos);
        cargarInscripciones(inscripciones, alumnos, escuela.getTurnos(), tablas);

        mostrarEscuela(escuela);
        mostrarInstructores(instructores);
        mostrarTablas(tablas);
        mostrarAlumnos(alumnos);
        mostrarInscripciones(inscripciones);
        mostrarTurnos(escuela.getTurnos());
        System.out.printf("%nPorcentaje de asistencia al primer turno ingresado: %.2f", escuela.getTurnos()[0].calcularPorcentajeAsistencia());

        teclado.close();
    }  
}