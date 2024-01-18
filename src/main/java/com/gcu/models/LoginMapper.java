package com.gcu.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class LoginMapper implements RowMapper<LoginModel> {
    
    public LoginModel mapRow(ResultSet resultSet, int i) throws SQLException
    {
        LoginModel loginModel = new LoginModel(
            resultSet.getInt("ID"),
            resultSet.getString("USERNAME"),
            resultSet.getString("PASSWORD")
        );

        return loginModel;
    }

}
