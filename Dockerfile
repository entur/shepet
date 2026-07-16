FROM eclipse-temurin:21-jre-alpine AS builder
WORKDIR /deployments
COPY target/shepet.jar shepet.jar
RUN mkdir -p /deployments/data \
    && chown -R 2000:2000 /deployments/data

FROM gcr.io/distroless/java21-debian12:nonroot
WORKDIR /deployments
COPY --from=builder --chown=nonroot:nonroot /deployments/shepet.jar shepet.jar
COPY --from=builder --chown=nonroot:nonroot /deployments/data /deployments/data
EXPOSE 8080
CMD ["shepet.jar"]