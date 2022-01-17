package com.example.restaurantapplication.repository;

import com.example.restaurantapplication.dto.TableDTO;
import com.example.restaurantapplication.model.DinnerTable;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class TableDalJPATest
{
    @Mock
    private ITableRepository repo;
    private AutoCloseable autoCloseable;
    private TableDalJPA tableDalJPA;

    @BeforeEach
    void setUp()
    {
        autoCloseable = MockitoAnnotations.openMocks(this);
        tableDalJPA = new TableDalJPA(repo);
    }

    @AfterEach
    void tearDown() throws Exception
    {
        autoCloseable.close();
    }

    @Test
    void createTableTest()
    {
        DinnerTable table = getValidTable();

        repo.saveAndFlush(table);

        ArgumentCaptor<DinnerTable> argumentCaptor = ArgumentCaptor.forClass(DinnerTable.class);
        verify(repo).saveAndFlush(argumentCaptor.capture());

        DinnerTable capturedTable = argumentCaptor.getValue();
        assertThat(capturedTable).isEqualTo(table);
    }

    @Test
    void getAllTables()
    {
        tableDalJPA.getAllTables();
        verify(repo).findAll();
    }

    @Test
    void getByIdTest()
    {
        DinnerTable table = getValidTable();

        tableDalJPA.addTable(table);
        repo.saveAndFlush(table);

        DinnerTable tab = tableDalJPA.getById(5);
        verify(repo).getById(5);
    }

    @Test
    void deleteTable()
    {
        DinnerTable table = getValidTable();

        ArgumentCaptor<DinnerTable> argumentCaptor = ArgumentCaptor.forClass(DinnerTable.class);
        repo.saveAndFlush(table);
        verify(repo).saveAndFlush(argumentCaptor.capture());
        DinnerTable capturedTable = argumentCaptor.getValue();

        tableDalJPA.deleteTable(capturedTable.getTableId());
        assertThat(capturedTable).isEqualTo(table);
    }

    private DinnerTable getValidTable()
    {
        DinnerTable table = new DinnerTable("Table 1");

        return table;
    }
}
