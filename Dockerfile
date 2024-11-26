# Use uma imagem base para Java (ajuste para sua versão do Java, se necessário)
FROM openjdk:17-jdk

# Define o diretório de trabalho no contêiner
WORKDIR /app

# Copie o arquivo JAR gerado para o contêiner
COPY ./target/App-0.0.1-SNAPSHOT.jar app.jar

# Exponha a porta 8080
EXPOSE 8080

# Comando para rodar a aplicação Java
CMD ["java", "-jar", "app.jar"]
