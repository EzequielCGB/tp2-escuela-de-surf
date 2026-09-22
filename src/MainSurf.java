import java.util.Scanner;

public class MainSurf {
    public static final int MAXIMO_INSTRUCTORES = 10;
    public static final int MAXIMO_TABLAS = 20;
    public static final int MAXIMO_ALUMNOS = 50;
    public static final int MAXIMO_TURNOS = 20;

    public static void main(String[] args) {
        String continuar;
        String nombreEscuela;
        String direccionEscuela;
        String telefonoEscuela;
        String[] nombresInstructores = new String[MAXIMO_INSTRUCTORES];
        String[] apellidoInstructores = new String[MAXIMO_INSTRUCTORES];
        String[] matriculaInstructores = new String[MAXIMO_INSTRUCTORES];
        Instructor[] instructores = new Instructor[MAXIMO_INSTRUCTORES];
        String[] codigosTablas = new String[MAXIMO_TABLAS];
        double[] largoTablas = new double[MAXIMO_TABLAS];
        String[] estadoTablas = new String[MAXIMO_TABLAS];
        Tabla[] tablas = new Tabla[MAXIMO_TABLAS];
        String[] fechasTurnos = new String[MAXIMO_TURNOS];
        String[] horariosTurnos = new String[MAXIMO_TURNOS];
        Turno[] turnos = new Turno[MAXIMO_TURNOS];
        String[] nombresAlumnos = new String[MAXIMO_ALUMNOS];
        String[] apellidosAlumnos = new String[MAXIMO_ALUMNOS];
        String[] dniAlumnos = new String[MAXIMO_ALUMNOS];
        String[] nivelAlumnos = new String[MAXIMO_ALUMNOS];
        Alumno[] alumnos = new Alumno[MAXIMO_ALUMNOS];

        Scanner teclado =  new Scanner(System.in);

        System.out.println("A continuacion se le pediran los datos de la escuela");
        System.out.println("Ingrese el nombre de la escuela: ");
        nombreEscuela = teclado.nextLine();
        System.out.println("Ingrese la direccion de la escuela: ");
        direccionEscuela = teclado.nextLine();
        System.out.println("Ingrese el telefono de la escuela: ");
        telefonoEscuela = teclado.nextLine();
        Escuela escuela = new Escuela(nombreEscuela, direccionEscuela, telefonoEscuela);

        System.out.println("A continuacion se le pedira los datos de uno o mas instructores");
        System.out.println("Tenga en cuenta que debe ingresar datos para por lo menos un instructor con un maximo de " + MAXIMO_INSTRUCTORES + " instructores");
        do{
            int cantidadInstructores = Instructor.getCantidadInstructor();
            System.out.println("Ingrese el nombre del instructor: ");
            nombresInstructores[cantidadInstructores] = teclado.nextLine();
            System.out.println("Ingrese el apellido del instructor: ");
            apellidoInstructores[cantidadInstructores] = teclado.nextLine();
            System.out.println("Ingrese la matricula del instructor: ");
            matriculaInstructores[cantidadInstructores] = teclado.nextLine();
            instructores[cantidadInstructores] = new Instructor(nombresInstructores[cantidadInstructores], apellidoInstructores[cantidadInstructores], matriculaInstructores[cantidadInstructores]);
            System.out.println("Si desea agregar otro instructor ingrese 'si'");
            continuar = teclado.nextLine();
        }while(continuar.equalsIgnoreCase("si"));

        System.out.println("A continuacion se le pedira los datos de una o mas tablas");
        System.out.println("Tenga en cuenta que debe ingresar datos para por lo menos una tabla con un maximo de " + MAXIMO_TABLAS + " tablas");
        do{
            int cantidadTablas = Tabla.getCantidadTablas();
            System.out.println("Ingrese el codigo de la tabla: ");
            codigosTablas[cantidadTablas] = teclado.nextLine();
            System.out.println("Ingrese el largo de la tabla(Debe estar entre 5 y 10): ");
            largoTablas[cantidadTablas] = teclado.nextDouble();
            teclado.nextLine();
            System.out.println("Ingrese el estado de la tabla('disponible' o 'reparacion'): ");
            estadoTablas[cantidadTablas] = teclado.nextLine();
            tablas[cantidadTablas] = new Tabla(codigosTablas[cantidadTablas], largoTablas[cantidadTablas], estadoTablas[cantidadTablas]);
            System.out.println("Si desea agregar otra tabla ingrese 'si'");
            continuar = teclado.nextLine();
        }while(continuar.equalsIgnoreCase("si"));

        System.out.println("A continuacion se le pedira los datos de uno o mas turnos");
        System.out.println("Tenga en cuenta que debe ingresar datos para por lo menos un turno con un maximo de " + MAXIMO_TURNOS + " turnos");
        do{
            int cantidadTurnos = Turno.getCantidadTurnos();
            int numeroInstructor;
            System.out.println("Ingrese la fecha del turno: ");
            fechasTurnos[cantidadTurnos] = teclado.nextLine();
            System.out.println("Ingrese el horario del turno: ");
            horariosTurnos[cantidadTurnos] = teclado.nextLine();
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
            turnos[cantidadTurnos] = new Turno(fechasTurnos[cantidadTurnos], horariosTurnos[cantidadTurnos], instructores[numeroInstructor]);
            escuela.agregarTurno(turnos[cantidadTurnos]);
            System.out.println("Si desea agregar otro turno ingrese 'si'");
            continuar = teclado.nextLine();
        }while(continuar.equalsIgnoreCase("si"));

        System.out.println("A continuacion se le pedira los datos de uno o mas alumnos");
        System.out.println("Tenga en cuenta que debe ingresar datos para por lo menos un alumno con un maximo de " + MAXIMO_ALUMNOS + " alumnos");
        do{
            int cantidadAlumnos = Alumno.getCantidadAlumnos();
            System.out.println("Ingrese el nombre del alumno: ");
            nombresAlumnos[cantidadAlumnos] = teclado.nextLine();
            System.out.println("Ingrese el apellido del alumno: ");
            apellidosAlumnos[cantidadAlumnos] = teclado.nextLine();
            System.out.println("Ingrese el dni del alumno: ");
            dniAlumnos[cantidadAlumnos] = teclado.nextLine();
            System.out.println("Ingrese el nivel del alumno('principiante' o 'intermedio')");
            nivelAlumnos[cantidadAlumnos] = teclado.nextLine();
            alumnos[cantidadAlumnos] = new Alumno(nombresAlumnos[cantidadAlumnos], apellidosAlumnos[cantidadAlumnos], dniAlumnos[cantidadAlumnos], nivelAlumnos[cantidadAlumnos]);
            System.out.println("Si desea agregar otro alumno ingrese 'si'");
            continuar = teclado.nextLine();
        }while(continuar.equalsIgnoreCase("si"));

//        Inscripcion inscripcion1 = new Inscripcion("25-01-26", alumno1, turno1, tablaUno, "presente");
//        Inscripcion inscripcion2 = new Inscripcion("18-01-26", alumno1, turno1, tablaDos, "presente");
//        Inscripcion inscripcion3 = new Inscripcion("16-01-26", alumno1, turno1, tablaCuatro, "ausente");
//        Inscripcion inscripcion4 = new Inscripcion("25-01-26", alumno1, turno1, tablaUno, "presente");
//
//        turno1.agregarInscripto(inscripcion1);
//        turno1.agregarInscripto(inscripcion2);
//        turno2.agregarInscripto(inscripcion3);
//        turno2.agregarInscripto(inscripcion4);
//
//        System.out.println("PROBANDO CUPO MAXIMO");
//        for(int i = 0; i< 21; i++){
//            Inscripcion inscripPrueba = new Inscripcion("22-01-26", alumno4, turno3, tablaCuatro, "presente");
//            boolean agregado = turno3.agregarInscripto(inscripPrueba);
//            if(!agregado){
//                System.out.println("Cupo maximo alcanzado en el intento " + (i+1));
//                break;
//            }
//        }
        System.out.println();
        System.out.println("Datos de la escuela");
        System.out.println(escuela.descripcion());
        System.out.println();
        System.out.println("Datos de los instructores");
        for (int i = 0; i < Instructor.getCantidadInstructor(); i++){
            System.out.println(instructores[i].descripcion());
        }
        System.out.println();
        System.out.println("Datos de las tablas");
        for (int i = 0; i < Tabla.getCantidadTablas(); i++){
            System.out.println(tablas[i].descripcion());
        }
        System.out.println();
        System.out.println("Datos de los turnos");
        for (int i = 0; i < Turno.getCantidadTurnos(); i++){
            System.out.println(turnos[i].descripcion());
        }
        System.out.println();
        System.out.println("Datos de los alumnos");
        for (int i = 0; i < Alumno.getCantidadAlumnos(); i++){
            System.out.println(alumnos[i].descripcion());
        }

        teclado.close();
    }  
}
