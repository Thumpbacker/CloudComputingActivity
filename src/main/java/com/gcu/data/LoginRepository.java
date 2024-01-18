package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gcu.models.LoginEntity;
import com.gcu.models.LoginModel;

public class LoginRepository implements DataAccessInterface<LoginModel> {
    @Autowired
    private LoginRepositoryInterface loginRepo;

    @SuppressWarnings("unused")
    private JdbcTemplate jdbcTemplateObject;

    private ModelMapper modelMapper;

    public LoginRepository(DataSource dataSource)
    {
        super();
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    @Override
    public LoginModel getByID(int id) {
        LoginEntity loginEntity = loginRepo.findById((long) id).orElse(null);
        
        LoginModel model = modelMapper.map(loginEntity, LoginModel.class);

        return model;
    }

    @Override
    public List<LoginModel> getOrders() {
        return null;
    }

    @Override
    public List<LoginModel> searchOrders(String searchTerm) {
        Iterable<LoginEntity> entities = loginRepo.findOrderByProductNameContainingIgnoreCase(searchTerm);
        List<LoginModel> orders = new ArrayList<LoginModel>();
        for(LoginEntity oe : entities)
        {
            orders.add(modelMapper.map(oe, LoginModel.class));
        }

        return orders;
    }

    @Override
    public int addOne(LoginModel newLogin) {
        LoginEntity entity = modelMapper.map(newLogin, LoginEntity.class);
        LoginEntity result = loginRepo.save(entity);
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
        loginRepo.deleteById(null);
        return true;
    }

    @Override
    public LoginModel updateOne(long idToUpdate, LoginModel updateLogin) {
        LoginEntity entity = modelMapper.map(updateLogin, LoginEntity.class);
        LoginEntity result = loginRepo.save(entity);
        LoginModel login = modelMapper.map(result, LoginModel.class);
        return login;
    }
}
