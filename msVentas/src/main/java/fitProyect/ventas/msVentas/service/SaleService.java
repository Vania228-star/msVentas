package fitProyect.ventas.msVentas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fitProyect.ventas.msVentas.model.Sale;
import fitProyect.ventas.msVentas.repository.SaleRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SaleService {

    private final SaleRepository saleRepository;

    public List<Sale> findAll(){
        return saleRepository.findAll();
    }

    public Sale save(Sale sale){
        return saleRepository.save(sale);
    }

    public Sale findById(String id){
        return saleRepository.findById(id).orElse(null);
    }
    
}
