Proyecto que implementa listas doblemente enlazadas para crear el juego del tingo tango. El proyecto se administra utilizando Apache Maven y está diseñado para construir una aplicación web (WAR) que utiliza las bibliotecas JavaServer Faces (JSF) y PrimeFaces.

## Descripción del proyecto

El proyecto TingoTango está diseñado para implementar una lista circular doblemente enlazada para administrar una lista de jugadores en un juego. El proyecto utiliza las bibliotecas JavaServer Faces (JSF) y PrimeFaces para la interfaz de usuario. Los jugadores se pueden agregar, eliminar y ver a través de una interfaz web. El proyecto admite la navegación del jugador y otras funcionalidades relacionadas con el juego.

## Dependencias

El proyecto TingoTango depende de las siguientes librerías:

- **javax.faces**: Proporciona la implementación de JavaServer Faces versión 2.2.7.
- **com.proyectoprogramacion**: Una librería personalizada llamada "ListaDECircularTT" con versión 1.0-SNAPSHOT.
- **javax**: JavaEE Web API versión 7.0 (ámbito proporcionado).
- **org.primefaces**: Biblioteca PrimeFaces versión 8.0.

## Instalación

Para compilar y ejecutar el proyecto TingoTango, siga estos pasos:

1. Asegúrese de tener [Apache Maven](https://maven.apache.org/) instalado en su sistema.
2. Clona el repositorio que contiene el código fuente del proyecto TingoTango.
3. Abra una terminal o símbolo del sistema y navegue hasta el directorio raíz del proyecto (donde se encuentra el archivo `pom.xml`).
4. Ejecute el siguiente comando de Maven para compilar el proyecto:

   mvn clean install

## Configuración

La configuración del proyecto TingoTango se realiza a través del archivo Maven `pom.xml`. Aquí hay algunas configuraciones clave:

### Información del proyecto

- `groupId`: El identificador de grupo para el proyecto.
- `artifactId`: El identificador del artefacto del proyecto.
- `version`: La versión del proyecto.

### Dependencias

La sección `<dependencias>` en el archivo `pom.xml` enumera las bibliotecas necesarias para que el proyecto se compile y ejecute correctamente.

### Construir complementos

La sección `<build>` configura los complementos de compilación utilizados en el proyecto:

- `maven-compiler-plugin`: Configura la versión del compilador de Java.
- `maven-war-plugin`: Configura el empaquetado del proyecto como archivo WAR.
- `maven-dependency-plugin`: Maneja las dependencias, como copiar las bibliotecas requeridas al directorio respaldado.

El proyecto TingoTango está licenciado bajo la Licencia MIT. Usted es libre de usar, modificar y distribuir el código bajo los términos de esta licencia