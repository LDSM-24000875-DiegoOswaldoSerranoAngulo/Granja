package app.utl.granja.DTOs;



import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnimalDTO {

    private Long id_animal;

    @NotBlank(message = "El tipo de animal es obligatorio y no puede estar vacío")
    private String tipo_animal;

    @NotNull(message = "El peso no puede ser nulo")
    @Positive(message = "El peso debe ser mayor a cero")
    private Double peso;

    @PositiveOrZero(message = "Los años no pueden ser negativos")
    private int años;
}