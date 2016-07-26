package org.ts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ts.model.Order;
import org.ts.model.OrderDetails;
import org.ts.repository.OrderDetailsRepository;
import org.ts.repository.OrderRepository;

import java.util.List;

@Service
/**
 * Service layer class
 */
public class OrderDetailsService {
    @Autowired
    OrderDetailsRepository orderDetailsRepository;

    /**
     * Find OD entity by
     * @param id OD od
     * @return OD entity
     */
    @Transactional
    public OrderDetails findById(Long id) {
        return orderDetailsRepository.findById(id);
    }

    /**
     * Save OD entity
     * @param od OD entity
     * @return OD entity with ID
     */
    @Transactional
    public OrderDetails saveOrUpdate(OrderDetails od){
        return orderDetailsRepository.save(od);
    }


}
