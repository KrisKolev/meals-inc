package com.example.restaurantapplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "place")
public class DinnerTable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tableId;

    @Column(name = "tableName", nullable = false)
    private String tableName;

    @JsonManagedReference
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    },
            mappedBy = "place")
    @JsonIgnore
    List<Product> products = new ArrayList<>();

    public DinnerTable(String tableName)
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
