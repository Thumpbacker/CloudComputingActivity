package com.gcu.data;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gcu.models.ProductMapper;
import com.gcu.models.ProductModel;

@Repository
public class ProductDataService implements DataAccessInterface<ProductModel> {
    @Autowired
    DataSource dataSource;
    JdbcTemplate jdbcTemplate;

    ProductDataService(DataSource dataSource)
    {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<ProductModel> getOrders()
    {
        return jdbcTemplate.query("select *  from products", new ProductMapper());
    }

    @Override
    public ProductModel getByID(int id) {
        return jdbcTemplate.queryForObject("select *  from products where ID = ?", new ProductMapper(), new Object[] {id});
    }

    @Override
    public List<ProductModel> searchOrders(String searchTerm) {
        return jdbcTemplate.query("select *  from products where GADGET_NAME like ?", new ProductMapper(), new Object[] {"%" + searchTerm + "%"});
    }

    @Override
    public int addOne(ProductModel newProduct) {
        return jdbcTemplate.update("insert into products (GADGET_NAME,  DATE_OF_ORIGIN, LETHALITY_RATING, PHOTO_FILE_NAME, INSTRUCTIONS, DESCRIPTION, PRICE) values (?, ?, ?, ?, ?, ?, ?)", 
        newProduct.getGadgetName(), 
        newProduct.getDateOfOrigin(),
        newProduct.getLethalityRating(),
        newProduct.getPhotoFileName(),
        newProduct.getInstructions(),
        newProduct.getDescription(),
        newProduct.getPrice()
        );
    }

    @Override
    public boolean deleteOne(long id) {
        int updateResult =jdbcTemplate.update("delete from products where ID = ?", new Object[] {id});
        return updateResult > 0;
    }

    @Override
    public ProductModel updateOne(long idToUpdate, ProductModel updateProduct) {
        int result = jdbcTemplate.update("update products set GADGET_NAME = ?, DATE_OF_ORIGIN = ?, LETHALITY_RATING = ?, PHOTO_FILE_NAME = ?, INSTRUCTIONS = ?, DESCRIPTION = ?, PRICE = ? WHERE ID = ?", 
        updateProduct.getGadgetName(),
        updateProduct.getDateOfOrigin(),
        updateProduct.getLethalityRating(),
        updateProduct.getPhotoFileName(),
        updateProduct.getInstructions(),
        updateProduct.getDescription(),
        updateProduct.getPrice(),
        idToUpdate);

        if(result > 0)
        {
            return updateProduct;
        }
        else
        {
            return null;
        }
    }
}
