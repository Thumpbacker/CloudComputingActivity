package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gcu.models.ProductEntity;
import com.gcu.models.ProductModel;

public class ProductRepository implements DataAccessInterface<ProductModel> {
    
    @Autowired
    private ProductRepositoryInterface productRepo;

    @SuppressWarnings("unused")
    private JdbcTemplate jdbcTemplateObject;

    private ModelMapper modelMapper;

    public ProductRepository(DataSource dataSource)
    {
        super();
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    @Override
    public ProductModel getByID(int id) {
        ProductEntity productEntity = productRepo.findById((long) id).orElse(null);
        
        ProductModel model = modelMapper.map(productEntity,ProductModel.class);

        return model;
    }

    @Override
    public List<ProductModel> getOrders() {
        Iterable<ProductEntity> enetities = productRepo.findAll();
        List<ProductModel> models = new ArrayList<ProductModel>();

        for(ProductEntity item : enetities)
        {
            models.add(modelMapper.map(item, ProductModel.class));
        }

        return models;
    }

    @Override
    public List<ProductModel> searchOrders(String searchTerm) {
        Iterable<ProductEntity> entities = productRepo.findOrderByProductNameContainingIgnoreCase(searchTerm);
        List<ProductModel> orders = new ArrayList<ProductModel>();
        for(ProductEntity pe : entities)
        {
            orders.add(modelMapper.map(pe, ProductModel.class));
        }

        return orders;
    }

    @Override
    public int addOne(ProductModel newProduct) {
        ProductEntity entity = modelMapper.map(newProduct, ProductEntity.class);
        ProductEntity result = productRepo.save(entity);
        if(result == null)
        {
            return 0;
        }
        else
        {
            return result.getId();
        }
    }

    @Override
    public boolean deleteOne(long id) {
        productRepo.deleteById(id);
        return true;
    }

    @Override
    public ProductModel updateOne(long idToUpdate, ProductModel updateProduct) {
        ProductEntity entity = modelMapper.map(updateProduct, ProductEntity.class);
        ProductEntity result = productRepo.save(entity);
        ProductModel product = modelMapper.map(result, ProductModel.class);
        return product;
    }
}
