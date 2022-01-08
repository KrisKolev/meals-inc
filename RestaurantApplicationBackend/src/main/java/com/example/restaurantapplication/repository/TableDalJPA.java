package com.example.restaurantapplication.repository;

import com.example.restaurantapplication.dalInterfaces.ITableDal;
import com.example.restaurantapplication.model.DinnerTable;
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
    public List<DinnerTable> getAllTables()
    {
        return repo.findAll();
    }

    @Override
    public void addTable(DinnerTable table)
    {
        repo.save(table);
    }

    @Override
    public void deleteTable(DinnerTable table)
    {
        repo.delete(table);
    }

    @Override
    public DinnerTable saveAndFlush(DinnerTable table)
    {
        return repo.saveAndFlush(table);
    }

    @Override
    public DinnerTable getById(Integer id)
    {
        return repo.getById(id);
    }
}
