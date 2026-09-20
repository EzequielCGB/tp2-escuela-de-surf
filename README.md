# tp2-escuela-de-surf

Materia: Programación II(UTN Necochea)
-----------------------
Profesor: Cesar Augusto Fernandez Carbonell
-----------------------
Alumnos:
*Marcos Acosta
*Bautista Arevalo
*Ezequiel Cepeda
-----------------------
Ruta de trabajo de cada Integrante:
M.Acosta:

B.Arevalo:

E.Cepeda:

-----------------------
Preguntas

1. El enunciado tiene una relación que necesitó una clase propia. Expliquen qué pasaba si no la creaban, con
un ejemplo concreto de este sistema.
    *La relacion que necesita una clase propia es Inscripcion.
    Si no la creabamos teniamos  que relacionar directamente a ALUMNO con TURNO por ejemplo guardando un areglo de Alumno[] dentro de Turno o al reves.
    El problema seria que perderiamos el lugar para guardar los atributos proipos de cada inscripcion. La fecha que se realizo la inscricio(fechaInscripcion), la asistenci del alumno, la tabla.
    Ejemplo concreto:
    Si "Juan" se  incribe al turno mañana a la clase x del mes se le asigna tabla nro9 y asiste(asistencia=presente). a la proxima semana "Juan" se vuelve a inscribir al turno mañana se le asigna tabla nro15 y falta (asistencia = ausente)
    Sin INSCRIPCION si guaradaramos la asistencia en Alumno no podriamos saber a q clase fue y a cual no.
    o si intentaramos guardar la tabla en Alumno
    Si intentamos guardarlo en Turno, el turno sabria que Juan asistio pero no sabria que tabla le dio a "juan".
    Entonces sin clase Inscripcion, no habria forma de asociar la combinacion (alumno, turno, tabla, asistencia) entonses se hace importante la clase porque los datos de asistencia y dar la tabla no pertenece ni al Alumno por si solo ni al Turno por si solo. Sino a la iteraccion entre ambos en el momento que sea necesario.



