package com.gcu.interfaces;

import java.util.List;

import com.gcu.models.LoginModel;

public interface LoginBusinessServiceInterface {
    public List<LoginModel> getLogins();
    public boolean deleteLogin(int id);
    public List<LoginModel> searchLogin(String search);
    public LoginModel updateLogin(int id, LoginModel product);
    public int addLogin(LoginModel product);
}
