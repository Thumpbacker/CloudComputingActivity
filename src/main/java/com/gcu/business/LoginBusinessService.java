package com.gcu.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.LoginDataService;
import com.gcu.interfaces.LoginBusinessServiceInterface;
import com.gcu.models.LoginModel;

public class LoginBusinessService implements LoginBusinessServiceInterface {
    
    @Autowired
    LoginDataService loginDAO;

    @Override
    public List<LoginModel> getLogins()
    {
        return loginDAO.getOrders();
    }

    @Override
    public boolean deleteLogin(int id) {
        return loginDAO.deleteOne(id);
    }

    @Override
    public List<LoginModel> searchLogin(String search) 
    { 
        return loginDAO.searchOrders(search);
    }

    @Override
    public LoginModel updateLogin(int id, LoginModel login) {
        return loginDAO.updateOne(id, login);
    }

    @Override
    public int addLogin(LoginModel loginModel) {
        return loginDAO.addOne(loginModel);
    }
}
