package com.thinatech.helloopenapi.data;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pets")
@Data
public class Pet {

    @Id
    private String id;

    private String name;

    private Category category;
}
