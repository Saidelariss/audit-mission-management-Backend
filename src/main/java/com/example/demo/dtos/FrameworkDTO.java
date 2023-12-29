package com.example.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FrameworkDTO {

    private String name;

    public FrameworkDTO(String name) {
        this.name = name;
    }


}

