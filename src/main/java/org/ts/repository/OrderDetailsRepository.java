package org.ts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.ts.model.Order;
import org.ts.model.OrderDetails;

import java.util.List;

/**
 * Spring Data Jpa-based interface. Thanks Spring, have not implementation at All!
 * Using for realization DAO
 */
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {

    /**
     * DAO method
     *
     * @param id of ordersDetails note in DB
     * @return Only one OrderDetails Object
     */
    OrderDetails findById(Long id);

    /**
     * DAO Method
     * Avanced request
     * @param id Seller ID which have relation with this orderDetails oject
     * @param delivStatus OD delivery status field
     * @return List of OrderDetails entities
     */
    @Query("select od from OrderDetails od where od.seller.id = ?1 and od.deliveryStatus = ?2")
    List<OrderDetails> getAllOrdersBySellerIDAndByDeliveryStatus(Long id, String delivStatus);

}

