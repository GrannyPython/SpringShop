package org.ts.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by gp on 6/2/16.
 *
 * <p>Basic entity of the application</p>
 * This class using for product classification
 */


@Entity
@Table(name = "category", schema = "TSDB")
public class Category {
    @Id
    @Column(name = "categoryID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name", unique = true)
    private String name;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "parameter_category", joinColumns = {
            @JoinColumn(name = "categoryID")},
            inverseJoinColumns = {@JoinColumn(name = "parameterID")})
    private Set<Parameter> parameters = new HashSet<Parameter>();

    @JsonIgnore
    @OneToMany(mappedBy = "category", cascade = {CascadeType.ALL})
    private Set<Product> products;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Set<Product> getProducts() {
        return this.products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }


    public Set<Parameter> getParameters() {
        return parameters;
    }

    public void setParameters(Set<Parameter> parameters) {
        this.parameters = parameters;
    }

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
