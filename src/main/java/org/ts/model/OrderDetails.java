package org.ts.model;

import javax.persistence.*;

/**
 * Created by gp on 6/2/16.
 * <p>Basic entity of the application</p>
 * This class using for saving info about <p><b> every product in wishlist</b></p>
 * Contains all requered field from technical documentation
 */


@Entity
@Table(name = "orderDetails")
public class OrderDetails {
    @Id
    @Column(name = "orderDetailsID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "orderID")
    private Order order;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sellerID")
    private Seller seller;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "productID")
    private Product product;

    @Column(name = "amount")
    private int amount;

    @Column(name = "delivery_status")
    private String deliveryStatus;

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
