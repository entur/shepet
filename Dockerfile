FROM gcr.io/distroless/java25-debian13:nonroot@sha256:8ac5525549d14b8ddd34562f9fc8e6ba4840c995363a1507b17cadf8bb7ab57e
WORKDIR /deployments
COPY --chown=nonroot:nonroot target/shepet.jar shepet.jar
EXPOSE 8080
CMD ["shepet.jar"]