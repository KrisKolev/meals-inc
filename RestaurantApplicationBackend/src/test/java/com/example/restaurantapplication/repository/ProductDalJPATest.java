package com.example.restaurantapplication.repository;

import com.example.restaurantapplication.model.Employee;
import com.example.restaurantapplication.model.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class ProductDalJPATest
{
    @Mock
    private IProductRepository repo;
    private AutoCloseable autoCloseable;
    private ProductDalJPA productDalJPA;

    @BeforeEach
    void setUp()
    {
        autoCloseable = MockitoAnnotations.openMocks(this);
        productDalJPA = new ProductDalJPA(repo);
    }

    @AfterEach
    void tearDown() throws Exception
    {
        autoCloseable.close();
    }

    @Test
    void createProductTest()
    {
        Product prod = getValidProduct();

        repo.saveAndFlush(prod);

        ArgumentCaptor<Product> argumentCaptor = ArgumentCaptor.forClass(Product.class);
        verify(repo).saveAndFlush(argumentCaptor.capture());

        Product capturedProd = argumentCaptor.getValue();
        assertThat(capturedProd).isEqualTo(prod);
    }

    @Test
    void getAllProductsTest()
    {
        productDalJPA.GetAllProducts();
        verify(repo).findAll();
    }

    @Test
    void getByIdTest()
    {
        Product prod = getValidProduct();

        productDalJPA.AddProduct(prod);
        repo.saveAndFlush(prod);

        Product pro = productDalJPA.getById(5);
        verify(repo).getById(5);
    }

    @Test
    void deleteProductTest()
    {
        Product prod = getValidProduct();

        ArgumentCaptor<Product> argumentCaptor = ArgumentCaptor.forClass(Product.class);
        repo.saveAndFlush(prod);
        verify(repo).saveAndFlush(argumentCaptor.capture());
        Product capturedProd = argumentCaptor.getValue();

        productDalJPA.deleteProduct(capturedProd.getProductID());
        assertThat(capturedProd).isEqualTo(prod);
    }

    private Product getValidProduct()
    {
        Product product = new Product("Cool meal",
                                      15.5);

        return product;
    }
}
