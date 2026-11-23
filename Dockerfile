FROM gcr.io/distroless/java25-debian13:nonroot@sha256:59bbb349c9752fc57b75744b41b1614c9dabe8bb4869523aabd5a4288f6c09a0
WORKDIR /deployments
COPY --chown=nonroot:nonroot target/shepet.jar shepet.jar
EXPOSE 8080
CMD ["shepet.jar"]