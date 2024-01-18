package com.gcu.interfaces;

import com.gcu.models.ProductModel;
import java.util.List;

public interface ProductBusinessServiceInterface {
    public List<ProductModel> getProducts();
    public boolean deleteProduct(int id);
    public List<ProductModel> searchProduct(String search);
    public ProductModel updateProduct(int id, ProductModel product);
    public int addProduct(ProductModel product);
    public ProductModel getByID(int id);
}
