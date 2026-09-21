public class MainSurf {
    public static void main(String[] args) {
        Escuela escuela = new Escuela("NecoQuen Surf", "Monte Pasubio", "2262 443355");

        Instructor instructor1 = new Instructor("Maria", "Perez", "M-001");
        Instructor instructor2 = new Instructor("Ana", "Gomez", "M-002");

        Tabla tablaUno = new Tabla(101, 7.1, "disponible");
        Tabla tablaDos = new Tabla(102, 8.1, "disponible");
        Tabla tablaTres = new Tabla(103, 6.9, "reparacion");
        Tabla tablaCuatro = new Tabla(104, 9.1, "disponible");

        Turno turno1 = new Turno("16-01-26", "08:00", instructor1);
        Turno turno2 = new Turno("17-01-26", "10:00", instructor1);
        Turno turno3 = new Turno("16-01-26", "09:30", instructor2);

        escuela.agregarTurno(turno1);
        escuela.agregarTurno(turno2);
        escuela.agregarTurno(turno3);

        Alumno alumno1 = new Alumno("Mateo","Rodriguez", "37111111", "principiante" );
        Alumno alumno2 = new Alumno("Marcos","Garcia", "37222222", "intermedio" );
        Alumno alumno3 = new Alumno("Lucas","Fernandez", "37333333", "principiante" );
        Alumno alumno4 = new Alumno("Juan","Diaz", "37444444", "intermedio" );
        Alumno alumno5 = new Alumno("Magdalena","Sanchez", "37555555", "principiante" );

        Inscripcion inscripcion1 = new Inscripcion("25-01-26", alumno1, turno1, tablaUno, "presente");
        Inscripcion inscripcion2 = new Inscripcion("18-01-26", alumno1, turno1, tablaDos, "presente");
        Inscripcion inscripcion3 = new Inscripcion("16-01-26", alumno1, turno1, tablaCuatro, "ausente");
        Inscripcion inscripcion4 = new Inscripcion("25-01-26", alumno1, turno1, tablaUno, "presente");
    
        turno1.agregarInscripto(inscripcion1);
        turno1.agregarInscripto(inscripcion2);
        turno2.agregarInscripto(inscripcion3);
        turno2.agregarInscripto(inscripcion4);

        System.out.println("PROBANDO CUPO MAXIMO");
        for(int i = 0; i< 21; i++){
            Inscripcion inscripPrueba = new Inscripcion("22-01-26", alumno4, turno3, tablaCuatro, "presente");
            boolean agregado = turno3.agregarInscripto(inscripPrueba);
            if(!agregado){
                System.out.println("Cupo maximo alcanzado en el intento " + (i+1));
                break;
            }
        }
        System.out.println();
        System.out.println("LISTA DE TURNOS");
        System.out.println(turno1.descripcion());
        System.out.println(turno2.descripcion());
        System.out.println(turno3.descripcion());

        System.out.println();

        System.out.println("ALUMNO Y SUS TURNOS");
        System.out.println(alumno1.descripcion());

        Tabla[] tablas = {tablaUno, tablaDos, tablaTres, tablaCuatro};
        int enReparacion = 0;
        for( Tabla tab : tablas){
            if (tab.getEstado().equalsIgnoreCase("reparacion")){
                enReparacion++;
            }
        }
        System.out.println("Tablas en reparacion: " + enReparacion);
        System.out.println();
        System.out.printf("Porcentaje de asistencia en el turno 1: %.2f%%\n ", turno1.calcularPorcentajeAsistencia());

        System.out.println("NUMEROS DE ALUMNO");
        System.out.println(alumno1.getNombre() + " Nro de Alumno: " + alumno1.getNumeroAlumno());
        System.out.println(alumno2.getNombre() + " Nro de Alumno: " + alumno2.getNumeroAlumno());
        System.out.println(alumno3.getNombre() + " Nro de Alumno: " + alumno3.getNumeroAlumno());
        System.out.println(alumno4.getNombre() + " Nro de Alumno: " + alumno4.getNumeroAlumno());
        System.out.println(alumno5.getNombre() + " Nro de Alumno: " + alumno5.getNumeroAlumno());

    }  
}
