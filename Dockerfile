FROM gradle:8.2.1-jdk17-alpine as builder
COPY . .
RUN gradle clean
RUN gradle bootJar
RUN gradle unpack

FROM openjdk:17-slim
VOLUME ["/tmp"]
ARG DEPENDENCY=/home/gradle/build/docker
COPY --from=builder ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=builder ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=builder ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","com.github.bohunn.multiplestatestores.MultipleStateStoresApplication"]
VOLUME ["/app/respources"]
EXPOSE 8091