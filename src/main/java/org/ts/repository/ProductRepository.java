package org.ts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ts.model.Product;

/**
 * Spring Data Jpa-based interface. Thanks Spring, have not implementation at All!
 * Using for realization DAO
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
    /**
     * DAO Method
     * Find product by Product name field
     * @param name Product name
     * @return Product object
     */
    Product findByName(String name);
}
