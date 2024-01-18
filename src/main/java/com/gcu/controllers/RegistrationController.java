package com.gcu.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.interfaces.LoginBusinessServiceInterface;
import com.gcu.interfaces.ValidateLoginInterface;
import com.gcu.models.LoginModel;

@Controller
@RequestMapping("/new_account")
public class RegistrationController implements ValidateLoginInterface {

    @Autowired
    private LoginBusinessServiceInterface lbsi;

    @GetMapping("/")
    public String display(Model model)
    {
        model.addAttribute("title", "Registration Form");
        model.addAttribute("loginModel", new LoginModel());
        return "register";
    }

    @PostMapping("/registered")
    public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult ,Model model)
    {
        if(isAuthenticated(loginModel))
        {
            return "redirect:/login/";
        }
        return "register";
    }

    @Override
    public boolean isAuthenticated(LoginModel login)
    {
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
                if(login.getUsername().equals(validUsername.get(i)) && login.getPassword().equals(validPasswords.get(j)) || !login.getPassword().equals(login.getTempPassword()))
                {
                    return false;
                }
            }
        }

        lbsi.addLogin(login);
        return true;
    }
}
