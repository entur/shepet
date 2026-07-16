FROM eclipse-temurin:21-jre-alpine
WORKDIR /deployments
COPY target/shepet.jar shepet.jar
# Create group and user (Alpine syntax)
RUN addgroup -g 2000 appuser \
    && adduser -D -u 2000 -G appuser appuser \
    && mkdir -p /deployments/data \
    && chown -R appuser:appuser /deployments/data
USER appuser
EXPOSE 8080
CMD  [ "java", "-jar", "shepet.jar"]