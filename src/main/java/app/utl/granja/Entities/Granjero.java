package app.utl.granja.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Granjero")
@Inheritance(strategy = InheritanceType.JOINED) // <-- Indica a JPA que es una clase padre
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Granjero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_granjero;
    private String nombre;
    private Double pago;
    private String rol_trabajo;

}
