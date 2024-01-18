package com.gcu.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ProductMapper implements RowMapper<ProductModel> {
    
    public ProductModel mapRow(ResultSet resultSet, int i) throws SQLException
    {
        ProductModel productModel = new ProductModel(
            resultSet.getInt("ID"),
            resultSet.getString("GADGET_NAME"),
            resultSet.getDate("DATE_OF_ORIGIN"),
            resultSet.getInt("LETHALITY_RATING"),
            resultSet.getString("PHOTO_FILE_NAME"),
            resultSet.getString("INSTRUCTIONS"),
            resultSet.getString("DESCRIPTION"),
            resultSet.getDouble("PRICE")
        );

        return productModel;
    }
}
