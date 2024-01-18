package com.gcu.business;

import com.gcu.data.ProductDataService;
import com.gcu.interfaces.ProductBusinessServiceInterface;
import com.gcu.models.ProductModel;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class ProductBusinessService implements ProductBusinessServiceInterface {
    
    @Autowired
    private ProductDataService productDAO;
    private List<ProductModel> products = new ArrayList<ProductModel>();

    @Override
    public List<ProductModel> getProducts()
    {
        products.clear();
        products = productDAO.getOrders();
        return products;
    }

    @Override
    public boolean deleteProduct(int id) {
        return productDAO.deleteOne(id);
    }

    @Override
    public List<ProductModel> searchProduct(String search) 
    { 
        return productDAO.searchOrders(search);
    }

    @Override
    public ProductModel updateProduct(int id, ProductModel product) {
        return productDAO.updateOne(id, product);
    }

    @Override
    public int addProduct(ProductModel product) {
        return productDAO.addOne(product);
    }

    @Override
    public ProductModel getByID(int id) {
        return productDAO.getByID(id);
    }
}
