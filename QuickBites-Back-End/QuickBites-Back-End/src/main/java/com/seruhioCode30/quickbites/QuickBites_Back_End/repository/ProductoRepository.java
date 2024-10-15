package com.seruhioCode30.quickbites.QuickBites_Back_End.repository;

import com.seruhioCode30.quickbites.QuickBites_Back_End.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
