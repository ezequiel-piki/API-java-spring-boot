
package com.bazar.APIBazar.repository;

import com.bazar.APIBazar.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVentaRepository extends JpaRepository<Venta, Long> {
    
}
