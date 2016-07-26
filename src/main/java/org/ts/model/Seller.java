package org.ts.model;

import javax.persistence.*;
import java.util.Set;


/**
 * Created by gp on 6/2/16.
 * <p>Seller - is  a Basic entity of the application</p>
 * Seller class <p><b> has additional access rights like visiting warehouse pages</b></p>
 * Every seller has rating by defalut @zero
 * Contains all requered field from technical documentation
 */

@Entity
@Table(name = "seller")
@PrimaryKeyJoinColumn(name = "id")
public class Seller extends User {
    @Column(name = "rating", columnDefinition = "int default 0")
    private Integer rating;

    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL)
    private Set<Warehouse> warehouse;

    public Seller() {

    }

    public Seller(String name, String surname, String phone, String email, String password, Integer role, Integer rating) {
        super(name, surname, phone, email, password, role);
        this.rating = 0;
    }

    public Integer getRating() {
        return rating;
    }
    public void setRating(Integer rating) {
        this.rating = rating;
    }


    public Set<Warehouse> getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Set<Warehouse> warehouse) {
        this.warehouse = warehouse;
    }
}
