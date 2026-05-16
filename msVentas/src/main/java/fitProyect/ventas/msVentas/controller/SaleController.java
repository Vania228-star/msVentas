package fitProyect.ventas.msVentas.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fitProyect.ventas.msVentas.dto.SaleDTO;
import fitProyect.ventas.msVentas.model.Sale;
import fitProyect.ventas.msVentas.service.SaleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/sales")
@RequiredArgsConstructor
public class SaleController {
    
    private final SaleService saleService;

    @GetMapping
    public List<SaleDTO> getAll(){
        return saleService.findAll().stream()
                .map(sale -> SaleDTO.builder()
                        .saleId(sale.getSaleId())
                        .userId(sale.getUserId())
                        .projectId(sale.getProjectId())
                        .amount(sale.getAmount())
                        .status(sale.getStatus())
                        .createdAt(sale.getCreatedAt() != null ? sale.getCreatedAt().toString() : null)
                        .build())
                .collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SaleDTO create(@Valid @RequestBody SaleDTO saleDTO){
        Sale saleEntity = Sale.builder()
                .userId(saleDTO.getUserId())
                .projectId(saleDTO.getProjectId())
                .amount(saleDTO.getAmount())
                .status(saleDTO.getStatus())
                .build();

        Sale savedSale = saleService.save(saleEntity);

        return SaleDTO.builder()
                .saleId(savedSale.getSaleId())
                .userId(savedSale.getUserId())
                .projectId(savedSale.getProjectId())
                .amount(savedSale.getAmount())
                .status(savedSale.getStatus())
                .createdAt(savedSale.getCreatedAt().toString())
                .build();
    }
}