# Dispatcher Application

#### Descripción

Existe un call center donde hay 3 tipos de empleados: operador, supervisor
y director. El proceso de la atención de una llamada telefónica en primera
instancia debe ser atendida por un operador, si no hay ninguno libre debe
ser atendida por un supervisor, y de no haber tampoco supervisores libres
debe ser atendida por un director.

### Requerimientos

 - Debe existir una clase Dispatcher encargada de manejar las
llamadas, y debe contener el ...

### Tecnologías usadas

- Java 8
- Spring Boot 2
- JPA
- H2Database
- Maven

>Nota: Dentro de cada clase se puede observar una breve descripción de cada funcionalidad. 

### Construir y ejecutar DispatcherApplication

Primero, utilicemos una consola de comandos para construir la aplicación usando Maven.

```sh
$ mvn clean package install
```

Ahora podemos ejecutar dispactherApplication.jar ubicada en el folder target. 

```sh
$ java -jar dispactherApplication.jar
```
> Nota: Esta applicación utiliza el puerto 8080. Podemos cambiar este parámetro en application.properties.


Una vez la aplicación este corriendo, podemos abrir una nueva consola de comandos para probar algunas funcionalidades.

1. Mostrar todos los empleados

```sh
$ curl localhost:8080/employees
```
> Nota: Esta aplicación inicia con 5 operadores, 3 supervisores y 1 director.

2. Con el siguiente comando, se procesa el número de llamadas especificado en el application.properties. (En este ejemplo calls.number is igual a 20).

```sh
$ curl localhost:8080/processing
```
>Nota: En la consola de comandos donde se inició la aplicación podemos ver la ejecución de las llamadas como especifica el ejercicio y la funcionalidad de los diferentes hilos.

### Extra
En caso que todos los empleados estén ocupados, se hace esperar por 2 segundos para luego tratar de asignarle otro empleado disponible.

Realizado por:

MSc. Carlos Avendaño Arango


