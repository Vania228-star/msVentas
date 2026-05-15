package fitProyect.ventas.msVentas.model;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "sales")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sale {

    @Id
    @Column(name = "sale_id", nullable = false, unique = true)
    private String saleId;
    
    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "project_id", nullable = false)
    private String projectId;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreated(){
        if (saleId == null){
            saleId = UUID.randomUUID().toString();
        }
        createdAt = LocalDateTime.now();
    }
    
}
