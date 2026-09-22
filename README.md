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

E.Cepeda: Creación y desarrollo de la logica y el codigo de las clases Turno e Instructor. Confeccion del Diagrama UML. Principal desarrollo del README

*El trabajo practico N2 de programacion, en general fue pensado y debatido entre los 3 miembros del equipo, dividiendo tareas y luego unificando ideas individuales en ideas y conclusiones de grupo. Tanto las preguntas de la parte B como de la seccion "Preguntas para el README" fueron charladas y contestadas por todos.
-----------------------
Preguntas

1. Pregunta: El enunciado tiene una relación que necesitó una clase propia. Expliquen qué pasaba si no la creaban, con
   un ejemplo concreto de este sistema.

   Respuesta:

   La relacion que necesita una clase propia es Inscripcion.
   Si no la creabamos teniamos  que relacionar directamente a ALUMNO con TURNO por ejemplo guardando un arreglo de Alumno[] dentro de Turno o al reves.
   Además al perder la posibilidad de guardar una inscripcion con sus datos guardados en los atributos se deberían guardar en arreglos paralelos, lo que supondría un mayor costo de lógica y de memoria.

2. Pregunta: Elijan una de las tres relaciones del diagrama y expliquen por qué le pusieron ese rombo y no otro. No
   repitan la definición: usen la frase del enunciado que los decidió.

   Respuesta:

   Escuela/Turno: Composición.
   “Si la escuela cierra, sus turnos dejan de existir”. Elegimos composicion porque la parte Turno no existe de forma propia sin el todo Escuela.

3. Pregunta: El número de alumno se resolvió con un atributo static. Expliquen qué habría cambiado si ese contador lo
   llevaba el main, y por qué el sistema no debería depender de eso.

   Respuesta:

   El atributo static pertenece a la clase y no a cada objeto, por eso Alumno puede llevar la cuenta global y asignar el número solo, sin que nadie se lo tenga que pasar. Si ese contador lo llevara main, la clase             perderia control de sus propios identificadores y dependeria de que el codigo externo se lo pasara bien por el constructor. Eso rompe el encapsulamiento, la  responsabilidad de generar numero unico deberia ser de Alumno no de quien lo usa.

4. Pregunta: Tuvieron al menos un conflicto de merge. Cuenten cuál fue, qué archivo era y cómo lo resolvieron.

   Respuesta:

   No tuvimos ningún conflicto al mergear.



