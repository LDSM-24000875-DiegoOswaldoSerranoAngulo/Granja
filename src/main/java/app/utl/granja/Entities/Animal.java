package app.utl.granja.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Animal")
@Inheritance(strategy = InheritanceType.JOINED) // <-- Indica a JPA que es una clase padre
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_animal;
    private String tipo_animal;
    private Double peso;
    private int años;



}
