package org.ts.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;


/**
 * Created by gp on 6/2/16.
 * <p>Warehouse - is  a Basic entity of the application</p>
 * Class using for saving products in seller warehouse
 * Value class <p><b> has additional access rights like visiting warehouse pages</b></p>
 */

@Entity
@Table(name = "warehouse")
public class Warehouse {
    @Id
    @GeneratedValue()
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "amount")
    private int amount;

    @Column(name = "price")
    private float price;

    @Column(name = "description")
    private String description;

    @Column(name = "rating", nullable = false)
    private String rating;

    @ManyToOne
    @JoinColumn(name = "sellerID")
    @JsonIgnore
    private Seller seller;

    @ManyToOne
    @JoinColumn(name = "productID")
    private Product product;

    @OneToOne(mappedBy = "warehouse", cascade = {CascadeType.REFRESH})
    private Cart cart;

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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Warehouse() {
    }
}
