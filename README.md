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

M.Acosta: Creación de las clases vacias. Desarrollo de la logica y el codigo de las clases Alumno e Inscripcion. Mergear y correcion de todas las clases en su conjunto. Confeccion del DiagramA UML.

B.Arevalo: Creación y desarrollo de la logica y el codigo de las clases Tabla y Escuela. Confeccion del DIAGRAMA uml, confeccion de los atributos y metodos basicos que irian en cada Clase.

E.Cepeda: Creación y desarrollo de la logica y el codigo de las clases Turno e Instructor. Confeccion del Diagrama UML.

*El trabajo practico N2 de programacion, en general fue pensado y debatido entre los 3 miembros del equipo, dividiendo tareas y luego unificando ideas individuales en ideas y conclusiones de grupo. Tanto las preguntas de la parte B como de la seccion "Preguntas para el README" fueron charladas y contestadas por todos.
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

2. Elijan una de las tres relaciones del diagrama y expliquen por qué le pusieron ese rombo y no otro. No
repitan la definición: usen la frase del enunciado que los decidió.
    *Escuela/Turno: Composición.
    “Si la escuela cierra, sus turnos dejan de existir”. Elegimos composicion porque la parte Turno no existe de forma propia sin el todo Escuela.

3. El número de alumno se resolvió con un atributo static. Expliquen qué habría cambiado si ese contador lo
llevaba el main, y por qué el sistema no debería depender de eso.
    *El atributo static pertenece a la clase y no a cada objeto, por eso Alumno puede llevar la cuenta global y asignar el número solo, sin que nadie se lo tenga que pasar. Si ese contador lo llevara main, la clase perderia control de sus propios identificadores y dependeria de que el codigo externo se lo pasara bien por el constructor. eso rompe encapsulamiento, la  responsabilidad de generar numero unico deberia ser de Alumno no de quien lo usa. Y si hubiera mas de un lugar del programa creando alumnos, seria facil terminar con numeros repetidos o salteados.

4.



