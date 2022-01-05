package com.example.restaurantapplication.service;

import com.example.restaurantapplication.dalInterfaces.IProductDal;
import com.example.restaurantapplication.dto.ProductDTO;
import com.example.restaurantapplication.model.Product;
import com.example.restaurantapplication.serviceInterfaces.IProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProducService implements IProductService
{
    IProductDal dal;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    public ProducService(IProductDal dal)
    {
        this.dal = dal;
    }

    @Override
    public List<ProductDTO> GetAllProducts()
    {
        return dal.GetAllProducts()
                .stream()
                .map(this::ConvertDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void AddProduct(Product product)
    {
        dal.AddProduct(product);
    }

    @Override
    public Product saveAndFlush(Product product)
    {
        return dal.saveAndFlush(product);
    }

    @Override
    public Product getById(Integer id)
    {
        return dal.getById(id);
    }

    @Override
    public void deleteProduct(int id)
    {
        dal.deleteProduct(id);
    }

    private ProductDTO ConvertDTO(Product product)
    {
        ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);
        return productDTO;
    }
}
