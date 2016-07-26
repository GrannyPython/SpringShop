package org.ts.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by gp on 6/2/16.
 * <p>Basic entity of the application</p>
 * This class using for <p><b> saving MAIN general info about order</b></p>
 * Contains all requered field from technical documentation
 */

@Entity
@Table(name = "order_entity")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_entity_id")
    private Long id;

    @Column(name = "payment_method", length = 20)
    private String paymentMethod;

    @Column(name = "delivery_method", length = 20)
    private String deliveryMethod;


    @Column(name = "payment_status", length = 20)
    private String paymentStatus;

    @ManyToOne()
    @JoinColumn(name = "id")
    private Customer customer;

    @Column(name = "date")
    private String date;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderDetails> order_details = new ArrayList<OrderDetails>();

    public Order() {
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<OrderDetails> getOrder_details() {
        return order_details;
    }

    public void setOrder_details(List<OrderDetails> order_details) {
        this.order_details = order_details;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getDate() {
        return date;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(String deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
