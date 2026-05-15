package fitProyect.ventas.msVentas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fitProyect.ventas.msVentas.model.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, String>{

}