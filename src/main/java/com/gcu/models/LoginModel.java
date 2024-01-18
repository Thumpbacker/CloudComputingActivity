package com.gcu.models;

public class LoginModel {
    
    private int id;
    private String username;
    private String password;
    private String tempPassword;

    public LoginModel()
    {

    }

    public LoginModel(int id, String username, String password)
    {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername()
    {
        return this.username;
    }

    public String getPassword()
    {
        return this.password;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getTempPassword() {
        return tempPassword;
    }

    public void setTempPassword(String tempPassword) {
        this.tempPassword = tempPassword;
    }

    @Override
    public String toString()
    {
        return "LoginModel [username =" + username + ", password =" + password + "]";
    }
}
