package br.com.robson.completablefeatureimplementation.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "T_USER")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String gender;
}
