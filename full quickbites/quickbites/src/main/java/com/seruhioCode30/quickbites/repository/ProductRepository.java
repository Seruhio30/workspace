package com.seruhioCode30.quickbites.repository;

import com.seruhioCode30.quickbites.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
