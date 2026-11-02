FROM gcr.io/distroless/java25-debian13:nonroot@sha256:5d3177252775d4b01603470fe21c015393019089904f68724bd37242e4bc6e6d
WORKDIR /deployments
COPY --chown=nonroot:nonroot target/shepet.jar shepet.jar
EXPOSE 8080
CMD ["shepet.jar"]