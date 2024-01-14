# Use an official OpenJDK image as a base
FROM openjdk:17

# Set the working directory in the container
WORKDIR /usr/src/app

# Copy the JAR file into the container
COPY target/splytapp-1.0-SNAPSHOT.jar splytapp.jar

# Install necessary dependencies for JavaFX
#RUN apt-get update && \
#    apt-get install -y libopenjfx-java && \
#    rm -rf /var/lib/apt/lists/*

# Set the JavaFX options
# ENV JAVA_OPTS="--module-path /Users/adrianacosta/development/sdk/javafx-sdk-17.0.9/lib --add-modules javafx.controls,javafx.fxml"

# Set the JavaFX options
ENV JAVA_OPTS="--module-path /usr/src/app/javafx-sdk-17.0.9/lib --add-modules javafx.controls,javafx.fxml"

# Expose the port if needed (depends on your application)
# EXPOSE 8080

# Command to run your application
CMD ["java", "$JAVA_OPTS", "-jar", "splytapp.jar"]