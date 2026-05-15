package fitProyect.ventas.msVentas.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fitProyect.ventas.msVentas.model.Sale;
import fitProyect.ventas.msVentas.service.SaleService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/sales")
@RequiredArgsConstructor
public class SaleController {
    
    private final SaleService saleService;

    @GetMapping
    public List<Sale> getAll(){
        return saleService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Sale create(@RequestBody Sale sale){
        return saleService.save(sale);
    }
}
