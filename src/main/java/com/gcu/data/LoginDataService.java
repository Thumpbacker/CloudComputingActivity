package com.gcu.data;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gcu.models.LoginMapper;
import com.gcu.models.LoginModel;

@Repository
public class LoginDataService implements DataAccessInterface<LoginModel> {

    @Autowired
    DataSource dataSource;
    JdbcTemplate jdbcTemplate;

    LoginDataService(DataSource dataSource)
    {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<LoginModel> getOrders()
    {
        return jdbcTemplate.query("select *  from users", new LoginMapper());
    }

    @Override
    public LoginModel getByID(int id) {
        return jdbcTemplate.queryForObject("select *  from users where ID = ?", new LoginMapper(), new Object[] {id});
    }

    @Override
    public List<LoginModel> searchOrders(String searchTerm) {
        return jdbcTemplate.query("select *  from users where USERNAME LIKE = ?", new LoginMapper(), new Object[] {"%" + searchTerm + "%"});
    }

    @Override
    public int addOne(LoginModel newLogin) {
        return jdbcTemplate.update("insert into users (USERNAME,  PASSWORD) values (?, ?)", 
        newLogin.getUsername(), 
        newLogin.getPassword()
        );
    }

    @Override
    public boolean deleteOne(long id) {
        int updateResult =jdbcTemplate.update("delete from users where ID = ?", new Object[] {id});
        return updateResult > 0;
    }

    @Override
    public LoginModel updateOne(long idToUpdate, LoginModel updateLogin) {
        int result = jdbcTemplate.update("update users set USERNAME = ?, PASSWORD = ? WHERE ID = ?", 
        updateLogin.getUsername(),
        updateLogin.getPassword(),
        idToUpdate);

        if(result > 0)
        {
            return updateLogin;
        }
        else
        {
            return null;
        }
    }
    


}
