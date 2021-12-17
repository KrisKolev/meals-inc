package com.example.restaurantapplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import com.example.restaurantapplication.model.Table;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@javax.persistence.Table(name = "product")
public class Product
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productID;

    @Column(name = "productName")
    private String productName;

    @Column(name = "productPrice")
    private double productPrice;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "product_place",
            joinColumns = { @JoinColumn(name = "productid") },
            inverseJoinColumns = { @JoinColumn(name = "place_id") }
    )
    @JsonIgnore
    private List<Table> place;

    public Product(String productName, double productPrice)
    {
        this.productName = productName;
        this.productPrice = productPrice;
    }
}

