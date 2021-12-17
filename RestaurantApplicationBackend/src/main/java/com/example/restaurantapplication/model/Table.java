package com.example.restaurantapplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@javax.persistence.Table(name = "place")
public class Table
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tableId;

    @Column(name = "tableName", nullable = false)
    private String tableName;

    @ManyToMany(mappedBy = "place")
    @JsonIgnore
    List<Product> products;

    public Table(String tableName)
    {
        this.tableName = tableName;
    }

    public int getTableId()
    {
        return tableId;
    }

    public String getTableName()
    {
        return tableName;
    }
}
