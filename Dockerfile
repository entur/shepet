FROM eclipse-temurin:25-jre-alpine@sha256:b7528962e65d43064d8a8b67ba175367896bc948363ea2d3fcd7f10d34e1f048 AS builder
WORKDIR /deployments
COPY target/shepet.jar shepet.jar
RUN mkdir -p /deployments/data \
    && chown -R 2000:2000 /deployments/data

FROM gcr.io/distroless/java25-debian13:nonroot@sha256:5d3177252775d4b01603470fe21c015393019089904f68724bd37242e4bc6e6d
WORKDIR /deployments
COPY --from=builder --chown=nonroot:nonroot /deployments/shepet.jar shepet.jar
COPY --from=builder --chown=nonroot:nonroot /deployments/data /deployments/data
EXPOSE 8080
CMD ["shepet.jar"]