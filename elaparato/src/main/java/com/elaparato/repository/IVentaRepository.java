package com.elaparato.repository;

import com.elaparato.model.Producto;
import com.elaparato.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVentaRepository extends JpaRepository<Venta, Integer> {
}
