package org.ts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.ts.model.Cart;
import org.ts.model.Order;

import java.util.List;

/**
 * Spring Data Jpa-based interface. Thanks Spring, have not implementation at All!
 * Using for realization DAO
 */
public interface OrderRepository extends JpaRepository<Order, Long> {

    /**
     * DAO Method
     * Find all Orders by Customer ID
     * @param id Customer ID
     * @return List of orders
     */
    @Query("select o from Order o where o.customer.id = ?1 order by o.date")
    List<Order> findAllOrdersByCustomerID(Long id);

}
