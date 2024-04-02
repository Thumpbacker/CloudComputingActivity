package com.gcu.controllers;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.interfaces.LoginBusinessServiceInterface;
import com.gcu.interfaces.ValidateLoginInterface;
import com.gcu.models.LoginModel;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/login")
public class LoginController implements ValidateLoginInterface {

    @Autowired
    private LoginBusinessServiceInterface lbsi;
    @GetMapping("/")
    public String display(Model model)
    {
        model.addAttribute("title", "Login Form");
        model.addAttribute("loginModel", new LoginModel());
        return "login";
    }

    @PostMapping("/doLogin")
    public String doLogin(LoginModel loginModel, Model model)
    {
        model.addAttribute("loginModel", loginModel);

        if(isAuthenticated(loginModel))
        {
            return "redirect:/product/";
        }
        else 
        {
            return "login";
        }
    }

    @PostMapping("create")
    public String create(LoginModel loginModel, Model model)
    {
        model.addAttribute("loginModel", loginModel);
        return "redirect:/new_account/";
    }
    //Validation
    @Override
    public boolean isAuthenticated(LoginModel login) {

        List<String> validUsername = new ArrayList<String>();
        List<String> validPasswords = new ArrayList<String>();
        
        for(int i = 0; i < lbsi.getLogins().size(); i++)
        {
            validUsername.add(lbsi.getLogins().get(i).getUsername());
            validPasswords.add(lbsi.getLogins().get(i).getPassword());
        }

        for(int i = 0; i < validUsername.size(); i++)
        {
            for(int j = 0; j < validPasswords.size(); j++)
            {
                if(login.getUsername().equals(validUsername.get(i)) && login.getPassword().equals(validPasswords.get(j)))
                {
                    return true;
                }
            }
        }

        return false;
    }
}
