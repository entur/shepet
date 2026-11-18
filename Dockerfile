FROM gcr.io/distroless/java25-debian13:nonroot@sha256:1c4ced761d17961c900cba60c33c8c3c46edbdadaa9d5ef9806eb5a6824fd406
WORKDIR /deployments
COPY --chown=nonroot:nonroot target/shepet.jar shepet.jar
EXPOSE 8080
ENTRYPOINT ["java", "-XX:-UseBASE64Intrinsics", "-jar"]
CMD ["shepet.jar"]