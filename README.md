# TPMonitoreo

Maven:
 Goals:
    mvn clean: limpia "artifacts"(projectos) creados previamente
    mvn compile: compila el codigo fuente de el projecto
    mvn package: toma el codigo compilado y lo empaqueta en un formato distribuible, como un JAR.
    mvn install: instala el paquete en el repositorio local para su uso como una dependencia en otros projectos locales
Scope:
 -compile: indica que la dependencia es necesaria para compilar
 -provided: similar al compile pero espera que el contenedor ya tenga la libreria
 -runtime: la dependencia es necesaria en tiempo de ejecucion pero no es necesaria para compilar
 -test: la dependencia es solo para testing
 -system: es como provided pero hay que incluir la dependencia explicitamente.

Arquetype: Es una plantilla, este crea la estructura del projecto, el contenido del pom.xml,la estructura de carpetas y los ficheros que incluye por defecto.
Estructura: se encuentra el pom.xml donde se configura el projecto maven y una carpeta src, dentro de src se encuentra la carpeta main donde va todo el codigo del projecto y la carpeta test donde va el codigo de test.
  segun el arquetipo empleado en el projecto pueden encontrarse mas carpetas

Artifact: un artifact es el resultado de el projecto, ej: un .jar, un arquetype solo una plantilla que se utilizara para dar la estructura del projecto. El artifact a su vez puede ser utilizado como dependencia.
