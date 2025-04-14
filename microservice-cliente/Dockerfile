#imagen modelo
FROM eclipse-temurin:17.0.14_7-jdk

#informar el puerto donde se ejecuta el contenedor (informativo)
EXPOSE 8090

#definir directorio raíz del contenedor
WORKDIR /root

#copiar y pegar archivos dentro del contenedor
COPY ./pom.xml /root
COPY ./.mvn /root/.mvn
COPY ./mvnw /root

# Da permisos de ejecución al wrapper
RUN chmod +x /root/mvnw

# descargar las dependencias
RUN ./mvnw dependency:go-offline

#copiar el código fuente dentro del contenedor
COPY ./src /root/src

#construir la aplicación
RUN ./mvnw clean install -DskipTests

#levantar el microservicio cuando el contenedor inicie
ENTRYPOINT [ "java", "-jar", "/root/target/microservice-cliente-0.0.1-SNAPSHOT.jar" ]