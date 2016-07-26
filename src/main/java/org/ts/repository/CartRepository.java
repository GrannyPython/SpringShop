package org.ts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.ts.model.Cart;

import java.util.List;

/**
 * Spring Data Jpa-based interface. Thanks Spring, have not implementation at All!
 * Using for realization DAO
 */
public interface CartRepository extends JpaRepository<Cart, Long> {

    /**
     * Method using for finding Carts object in database by
     *
     * @param id of the cart
     * @return result of search
     */
    @Query("select sc from Cart sc where sc.warehouse.id = ?1")
    Cart findByWarehouseId(Long id);

    /**
     * Same functionality,
     *
     * @param id necessary
     * @return searh result like a list of objects
     */
    List<Cart> findAllByCustomerId(Long id);


}
