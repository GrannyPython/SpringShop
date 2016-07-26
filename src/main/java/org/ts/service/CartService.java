package org.ts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ts.model.Cart;
import org.ts.repository.CartRepository;

import java.util.List;

/**
 * Service layer class
 */
@Service
public class CartService {
    @Autowired
    CartRepository cartRepository;

    /**
     * Save product to cart DB
     * @param cart
     */
    @Transactional
    public void addProductToCart(Cart cart){
        Cart cart1 = cartRepository.findByWarehouseId(cart.getWarehouse().getId());
        if (cart1!=null){
            cart1.setAmount(cart.getAmount()+cart1.getAmount());
            cartRepository.save(cart1);
        }
        else{
            cartRepository.save(cart);
        }
    }

    /**
     * Save cart to cart Table
     * @param cart
     * @return Cart entity with id
     */
    @Transactional
    public Cart save(Cart cart){
        return cartRepository.save(cart);
    }

    /**
     * Find all Carts by
     * @param id Customer ID
     * @return List of cart
     */
    @Transactional
    public List<Cart> findAllByCustomerId(Long id){
        return cartRepository.findAllByCustomerId(id);
    }
}
