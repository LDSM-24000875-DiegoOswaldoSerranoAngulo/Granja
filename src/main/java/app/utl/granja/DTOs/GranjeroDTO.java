package app.utl.granja.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GranjeroDTO {

    private Long id_granjero;

    @NotBlank(message = "El nombre del granjero es obligatorio")
    private String nombre;

    @NotNull(message = "El pago no puede ser nulo")
    @PositiveOrZero(message = "El pago debe ser cero o mayor")
    private Double pago;

    @NotBlank(message = "El rol de trabajo es obligatorio")
    private String rol_trabajo;
}
