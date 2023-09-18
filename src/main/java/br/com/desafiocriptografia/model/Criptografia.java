package br.com.desafiocriptografia.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "criptografia")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Criptografia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "userdocument")
    private String userDocument;
    @Column(name = "creditcardtoken")
    private String creditCardToken;
    @Column(name = "value")
    private Long value;
}
