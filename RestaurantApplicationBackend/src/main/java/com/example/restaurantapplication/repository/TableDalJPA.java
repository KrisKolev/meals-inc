package com.example.restaurantapplication.repository;

import com.example.restaurantapplication.dalInterfaces.ITableDal;
import com.example.restaurantapplication.model.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TableDalJPA implements ITableDal
{
    ITableRepository repo;

    @Autowired
    public TableDalJPA(ITableRepository repo)
    {
        this.repo = repo;
//        repo.save(new Table("Table 1"));
//        repo.save(new Table("Table 2"));
//        repo.save(new Table("Table 3"));
//        repo.save(new Table("Table 4"));
//        repo.save(new Table("Table 5"));
    }

    @Override
    public List<Table> getAllTables()
    {
        return repo.findAll();
    }

    @Override
    public void addTable(Table table)
    {
        repo.save(table);
    }

    @Override
    public void deleteTable(Table table)
    {
        repo.delete(table);
    }

    @Override
    public Table saveAndFlush(Table table)
    {
        return repo.saveAndFlush(table);
    }

    @Override
    public Table getById(Integer id)
    {
        return repo.getById(id);
    }
}
