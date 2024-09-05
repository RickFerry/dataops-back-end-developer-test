
```markdown
# FHIR Data Integration Project

Este projeto tem como objetivo configurar um servidor FHIR localmente, desenvolver uma API para receber dados de pacientes em formato CSV e criar um serviço assíncrono para processar esses dados e enviá-los ao servidor FHIR.

## Estrutura do Projeto

O projeto está dividido em três partes:

1. **fhir-server**: Servidor FHIR rodando localmente usando Docker e HAPI FHIR.
2. **csv-api**: API RESTful em Java para receber arquivos CSV.
3. **async-processor**: Serviço assíncrono em Java para processar os dados e enviá-los ao servidor FHIR.

## Configuração

### 1. Servidor FHIR

- Execute o comando para rodar o servidor FHIR:
    ```bash
    docker-compose up -d
    ```
- O servidor estará disponível em `http://localhost:8080/hapi-fhir-jpaserver/fhir`.

### 2. API CSV

- Entre no diretório `csv-api`:
    ```bash
    cd csv-api
    ```
- Compile e rode o projeto:
    ```bash
    mvn clean install
    mvn spring-boot:run
    ```
- A API estará disponível em `http://localhost:8081/api/pacientes/upload`.

### 3. Processador Assíncrono

- Entre no diretório `async-processor`:
    ```bash
    cd async-processor
    ```
- Compile e rode o projeto:
    ```bash
    mvn clean

 install
    mvn spring-boot:run
    ```

## Fluxo

1. Envie o arquivo CSV para o endpoint `/api/pacientes/upload` da API.
2. O arquivo será salvo temporariamente e o processamento assíncrono será disparado.
3. O serviço assíncrono processará os dados e os enviará ao servidor FHIR.

## Dependências

- Docker
- Maven
- OpenCSV
- HAPI FHIR

## Como Contribuir

1. Fork este repositório.
2. Crie sua branch de feature (`git checkout -b feature/nova-feature`).
3. Commit suas mudanças (`git commit -am 'Adiciona nova feature'`).
4. Push para a branch (`git push origin feature/nova-feature`).
5. Crie um novo Pull Request.

## Licença

Este projeto está licenciado sob a licença MIT.
```

---
