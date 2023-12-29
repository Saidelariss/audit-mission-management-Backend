package com.example.demo.repository;
import com.example.demo.entities.Framework;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;

@Component
public class DataInitializer  implements CommandLineRunner{

    @Autowired
    private ControlRepository controlRepository;

    @Autowired
    private DomainRepository domainRepository;

    @Autowired
    private FrameworkRepository frameworkRepository;
    @Autowired
    private MongoTemplate mongoTemplate;


    public void run(String... args) throws Exception {
        // Charger les données à partir du fichier JSON
        ObjectMapper objectMapper = new ObjectMapper();
        List<Framework> frameworks = objectMapper.readValue(
                new File("C:\\Users\\saidb\\Documents\\3A EHTP\\GI3\\Projet de développement\\demo\\src\\main\\resources\\data.json"),
                objectMapper.getTypeFactory().constructCollectionType(List.class, Framework.class)
        );

        // Insérer les données dans la base de données
        frameworkRepository.deleteAll();
        mongoTemplate.getDb().drop();
        mongoTemplate.insertAll(frameworks);

        System.out.println("*******************************");
        // Création d'un objet Writer avec le formateur par défaut (DefaultPrettyPrinter)
        ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();

        // Création d'une liste de frameworks
        List<Framework> frameworks2 = frameworkRepository.findAll();

        // Conversion de la liste en JSON avec une mise en forme lisible
        String jsonOutput = objectWriter.writeValueAsString(frameworks2);

        // Affichage du résultat
        System.out.println(jsonOutput);
    }
}
