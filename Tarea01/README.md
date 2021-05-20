# Desafío 1: Periodos perdidos
# Desafío Uno - Nivel 3

## Compilación y Ejecución

El programa Tarea01 es un proyecto maven, utilizando jersey para generar el servicio y consumir otro servicio.

No pude instalar Generador De Datos por lo tanto como entrada tuve que ocupar soapui realizando un mock de la peticion rest, adjunto proyecto para ser implementado, en soapui local.

Ademas adjunto proyecto soapui, para consumir el servicio realizado.

```bash
mvn clean package
```
despues de compilar el proyecto, se genera un war que se encuentra en el directorio target, este war se instala en el servidor de aplicaciones. En mi caso use tomcat 9.0 integrado a eclipse.

La direcccion de consumo es: http://localhost:8080/Tarea01/services/tarea01/obtenerFechas.

