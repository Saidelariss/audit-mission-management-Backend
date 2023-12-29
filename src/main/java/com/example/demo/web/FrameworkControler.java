package com.example.demo.web;

import com.example.demo.dtos.FrameworkDTO;
import com.example.demo.entities.Framework;
import com.example.demo.repository.FrameworkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/frameworks")
public class FrameworkControler {

    @Autowired
    private FrameworkRepository frameworkRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/all")
    public List<Framework> getAllFrameworks() {
        // Utiliser la méthode findAll avec l'annotation @DBRef pour forcer le chargement des références
        return mongoTemplate.find(new Query(), Framework.class);
    }
    @GetMapping
    public List<FrameworkDTO> getAllFrameworkNames() {
        List<Framework> frameworks = frameworkRepository.findAll();

        // Convertir les Frameworks en FrameworkDTOs
        return frameworks.stream()
                .map(framework -> new FrameworkDTO(framework.getName()))
                .collect(Collectors.toList());
    }
}
