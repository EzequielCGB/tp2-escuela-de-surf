import java.util.Scanner;
public class MainSurf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("----- ESCUELA DE SURF -----");
        
        //pongo los datos de la escuela
        System.out.print("Nombre de la escuela: ");
        String nombreEscuela = scanner.nextLine();

        System.out.print("Direccion : ");
        String direccionEscuela = scanner.nextLine();

        System.out.print("Telefono : ");
        String telefonoEscuela = scanner.nextLine();

        Escuela escuela = new Escuela(nombreEscuela, direccionEscuela, telefonoEscuela);

        //poner un instructor por teclado
        System.out.println("----- INSTRUCTORES -----");

        System.out.println("¿Cuantos Instructores quieres ingresar?: ");

        int cantInstructores = scanner.nextInt();
        scanner.nextLine();

        Instructor[] instructores = new Instructor[cantInstructores];
        for(int i = 0; i< cantInstructores; i++){
            System.out.print("\n----- Instructor nro " + (i+1) + " ----- \n");
            
            System.out.print("Nombre: ");
            String nombreInstructor = scanner.nextLine();

            System.out.print("Apellido: ");
            String apellidoInstructor = scanner.nextLine();

            System.out.print("Matricula: ");
            String matriculaInstructor = scanner.nextLine();

            instructores[i] = new Instructor(nombreInstructor, apellidoInstructor,matriculaInstructor);
        }
        // ingresar tablas por teclado

        System.out.println("\n----- TABLA ----- ");

        System.out.println("\n¿Cuantas tablas quiere ingresar?: ");
        int cantTablas = scanner.nextInt();
        scanner.nextLine();
      
        Tabla[] tablas = new Tabla[cantTablas];

        for(int i = 0; i< cantTablas; i++){
            System.out.print("\n----- Tabla nro " + (i+1) + " ----- \n");

            System.out.print("Codigo de la tabla: ");
            int codigoTabla= scanner.nextInt();

            System.out.print("Largo de la tabla en pies: ");
            double largoTabla = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Estado:(Disponible/Reparacion) :");
            String estadoTabla = scanner.nextLine();

            tablas[i] = new Tabla(codigoTabla, largoTabla, estadoTabla);
        }

        //Crear turnos
        System.out.println("\n----- cARGAR TURNOs ----- ");

        System.out.println("¿Cuantos turnos quiere ingresar?: ");
        int cantTurnos = scanner.nextInt();
        scanner.nextLine();

        Turno[] turnos = new Turno[cantTurnos];

        for(int i = 0; i < cantTurnos; i++){
            System.out.print("\n----- Turno nro " + (i+1) + " ----- \n");

            System.out.print("Fecha: ");
            String fechaTurno= scanner.nextLine();

            System.out.print("Horario: ");
            String horaTurno = scanner.nextLine();

            System.out.println("Instructores disponibles: ");
            for(int j = 0; j < instructores.length; j++){
                System.out.println((j+1) + ". " + instructores[j].getApellido() + ", " + instructores[j].getNombre());
            }
            System.out.println("Seleccione el número de instructores para este turno: ");
            int indiceInstructores = scanner.nextInt() -1;
            scanner.nextLine();

            turnos[i] = new Turno(fechaTurno, horaTurno, instructores[indiceInstructores]);
            escuela.agregarTurno(turnos[i]);
        }

        //Alumno por teclado
        System.out.println("\n----- CARGAR ALUMNOS ----- ");

        System.out.print("¿Cuantos alumnos quieres ingresar?: ");
        int cantAlumnos = scanner.nextInt();
        scanner.nextLine();

        Alumno[] alumnos = new Alumno[cantAlumnos];

        for(int i = 0; i < cantAlumnos; i++){
            System.out.print("\n----- Alumno nro " + (i+1) + " ----- \n");


            System.out.print("Nombre del alumno: ");
            String nombreAlumno = scanner.nextLine();

            System.out.print("Apellido del alumno: ");
            String apellidoAlumno = scanner.nextLine();

            System.out.print("DNI: ");
            String dniAlumno = scanner.nextLine();

            System.out.print("Nivel del alumno:(principiante/intermedio):  ");
            String nivelAlumno = scanner.nextLine();

            alumnos[i] = new Alumno(nombreAlumno, apellidoAlumno, dniAlumno ,nivelAlumno);
        }
        //hacer las inscripciones
        System.out.println("\n----- INSCRIPCIONES -----");
        if(cantAlumnos > 0 && cantTurnos > 0 && cantTablas > 0){
            System.out.println("¿Cuantas inscripciones quiere realizar?: ");
            int cantInscripciones = scanner.nextInt();
            scanner.nextLine();
            
            for(int i = 0; i < cantInscripciones; i++){
            System.out.print("\n----- Inscripcion nro " + (i+1) + " ----- \n");

                System.out.print("Fecha de inscripcion: ");
                String fechaInscripcion = scanner.nextLine();
                //elegir alumno
                System.out.println("Alumnos: ");
                for(int j = 0; j < alumnos.length; j++){
                    System.out.println((j+1) + ". " + alumnos[j].getNombre() + " " + alumnos[j].getApellido());   
                }
                System.out.println("Seleccione el Alumno: ");
                int indiceAlumno = scanner.nextInt() -1;

                //elegir turno
                System.out.println("Turnos: ");
                for(int j = 0; j < turnos.length; j++){
                    System.out.println((j + 1) + ". Fecha: " + turnos[j].getFecha() + " -- Hora: " + turnos[j].getHorario());
                }
                System.out.println("Seleccione turno: ");
                int indiceTurno = scanner.nextInt()-1;

                //elegir tabla
                System.out.println("Tablas: ");
                for(int j = 0; j < tablas.length; j++){
                    System.out.println((j+1) + ". Codigo: " + tablas[j].getCodigo() + " -- Estado: " + tablas[j].getEstado());
                }
                System.out.println("Seleccione tabla: ");
                int indiceTabla = scanner.nextInt()-1;
                scanner.nextLine();

                System.out.print("Asistencia: (presente/ausente/indefinido) ");
                String asistencia = scanner.nextLine();
            
                Inscripcion inscripcion = new Inscripcion(fechaInscripcion, alumnos[indiceAlumno], turnos[indiceTurno], tablas[indiceTabla], asistencia);
                turnos[indiceTurno].agregarInscripto(inscripcion);
            }
        }
        //Mostar datos generales
        System.out.println("\n----- LISTA DE TURNOS -----");

        for(Turno tur : turnos){
            System.out.println(tur.descripcion());
        }

        System.out.println("\n----- ESTADO DE TABLAS ----- ");
        int enReparacion = 0;
        for(Tabla tb : tablas){
            if(tb.getEstado().equalsIgnoreCase("reparacion")){
                enReparacion++;
            }
        }
        System.out.println("Cantidad de tablas en reparación: " + enReparacion);
        
        
        System.out.println("\n----- PORCENTAJES DE ASISTENCIA POR TURNO ----- ");
        for(Turno tur : turnos){
            System.out.printf("Turno %s %s: %.2f%%\n", tur.getFecha(), tur.getHorario(), tur.calcularPorcentajeAsistencia());
        }

        System.out.println("\n----- NROS DE ALUMNOS -----");
        for(Alumno al: alumnos){
            System.out.println(al.getNombre() + " " + al.getApellido() + " Nro de Alumno #" + al.getNumeroAlumno());
        }
        scanner.close();
    }  
}
