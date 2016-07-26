package org.ts.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by gp on 6/2/16.
 * <p>Product - is a Basic entity of the application</p>
 * Class using for <p><b> saving products to db</b></p>
 * Contains additional features like images
 * Contains all requered field from technical documentation
 */

@Entity
@Table(name = "product")
public class Product {

    @Id
    @Column
    @GeneratedValue
    private Long productID;

    @Column(name = "name", unique = true)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoryID")
    private Category category;
    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private Set<Value> values = new HashSet<Value>();

    @JsonIgnore
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<Warehouse> warehouse;

    /**
     * It contains link on harddrive storage
     */
    @Column(name = "imagePath", nullable = false)
    private String image;

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public Long getProductID() {
        return productID;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Warehouse> getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Set<Warehouse> warehouse) {
        this.warehouse = warehouse;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    public Product() {
    }

    ;


}

