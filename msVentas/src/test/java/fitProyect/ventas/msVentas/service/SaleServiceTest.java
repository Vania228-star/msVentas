package fitProyect.ventas.msVentas.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import fitProyect.ventas.msVentas.model.Sale;
import fitProyect.ventas.msVentas.repository.SaleRepository;

@ExtendWith(MockitoExtension.class)
public class SaleServiceTest {

    @Mock
    private SaleRepository saleRepository;

    @InjectMocks
    private SaleService saleService;

    @Test
    public void testGuardarVentaExitosamente() {
        Sale ventaMock = Sale.builder()
                            .userId("user-123")
                            .projectId("project-999")
                            .amount(25000.0)
                            .status("APPROVED")
                            .build();

        when(saleRepository.save(ventaMock)).thenReturn(ventaMock);

        Sale resultado = saleService.save(ventaMock);
        assertNotNull(resultado);
    }
}