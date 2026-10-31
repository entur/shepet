FROM gcr.io/distroless/java25-debian13:nonroot
WORKDIR /deployments
COPY --chown=nonroot:nonroot deployments/shepet.jar shepet.jar
EXPOSE 8080
CMD ["shepet.jar"]