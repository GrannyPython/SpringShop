package org.ts.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by gp on 6/2/16.
 * <p>Basic entity of the application</p>
 * Parameter class using for <p><b> saving products data fileds </b></p>
 * Contains all requered field from technical documentation
 */

@Entity
@Table(name = "parameter")
public class Parameter {

    @Id
    @Column(name = "parameterID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", unique = true)
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "parameter")
    private Set<Value> values = new HashSet<Value>();

    public Parameter() {
    }

    public Parameter(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Parameter)) return false;

        Parameter parameter = (Parameter) o;

        return name.equals(parameter.name);

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "  " + name;
    }

    public Set<Value> getValues() {
        return values;
    }

    public void setValues(Set<Value> values) {
        this.values = values;
    }
}
