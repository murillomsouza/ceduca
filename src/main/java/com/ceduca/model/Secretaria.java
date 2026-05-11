package com.ceduca.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "secretaria")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Secretaria {

    @Id
    private String id;

    @Indexed(unique = true)
    private String email;

    private String senha;
    private String nome;

}
