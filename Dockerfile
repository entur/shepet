FROM gcr.io/distroless/java25-debian13:nonroot@sha256:a90a5fadd78dc37b643da72dca2f744ef67eba625eca7227a5b375b548e6b1c2
WORKDIR /deployments
COPY --chown=nonroot:nonroot target/shepet.jar shepet.jar
EXPOSE 8080
CMD ["shepet.jar"]