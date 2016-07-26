package org.ts.model;

import javax.persistence.*;


/**
 * Created by gp on 6/2/16.
 * <p>Seller - is  a <p><b> NOT </b></p> Basic entity of the application</p>
 * It is necessary for additional feture like <i>dynamic categories</i>
 * Value class <p><b> has additional access rights like visiting warehouse pages</b></p>
 */

@Entity
@Table(name = "value")
public class Value {
    @Id
    @Column(name="valueID", unique=true, nullable=false)
    @GeneratedValue
    private Long valueID;

    @ManyToOne
    @JoinColumn(name = "productID", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "parameterID", nullable = false)
    private Parameter parameter;


    @Column(name = "value", nullable = false)
    private String value;

    public Value() {
    }

    public Long getValueID() {
        return valueID;
    }

    public void setValueID(Long valueID) {
        this.valueID = valueID;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Parameter getParameter() {
        return parameter;
    }

    public void setParameter(Parameter parameter) {
        this.parameter = parameter;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
