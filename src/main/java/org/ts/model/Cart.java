package org.ts.model;

import javax.persistence.*;


/**
@author GP
 Basic entity of the application
 Using for saving data about user wishes into db.
 */

@Entity
@Table(name = "shoppingCart")
public class Cart {

    @Id
    @Column(name = "cartID", unique = true, nullable = false)
    @GeneratedValue
    private Long id;

    @Column(name = "amount", nullable = false)
    private Integer amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customerID")
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "sellerID")
    private Warehouse warehouse;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Cart() {
    }

}
