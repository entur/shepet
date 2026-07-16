FROM gcr.io/distroless/java21-debian12:nonroot
WORKDIR /deployments
COPY --from=builder --chown=nonroot:nonroot /deployments/shepet.jar shepet.jar
COPY --from=builder --chown=nonroot:nonroot /deployments/data /deployments/data
EXPOSE 8080
CMD ["shepet.jar"]