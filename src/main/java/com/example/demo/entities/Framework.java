package com.example.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "frameworks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Framework {
    @Id
    private String id;
    private String name;
    private String description;
    private List<Domain> domains;

}
