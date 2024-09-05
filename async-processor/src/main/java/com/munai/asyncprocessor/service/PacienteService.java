package com.munai.asyncprocessor.service;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.client.api.IGenericClient;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import com.opencsv.CSVReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@Service
public class PacienteService {

    @Async
    public void processarCSVAssincronamente(File csvFile) {
        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                String nome = nextLine[0];
                String dataNascimento = nextLine[1];
                String observacao = nextLine[2];

                FhirContext ctx = FhirContext.forR4();
                IGenericClient client = ctx.newRestfulGenericClient("http://localhost:8080/hapi-fhir-jpaserver/fhir");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
