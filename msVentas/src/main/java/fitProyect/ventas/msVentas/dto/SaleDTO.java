package fitProyect.ventas.msVentas.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaleDTO {

    private String saleId;
    
    @NotBlank(message = "El ID de usuario es obligatorio")
    private String userId;

    @NotBlank(message = "El ID del proyecto es obligatorio")
    private String projectId;

    @NotNull(message = "El monto no puede ser nulo")
    private Double amount;

    @NotBlank(message = "El estado de la venta es obligatorio")
    private String status;

    private String createdAt;
}