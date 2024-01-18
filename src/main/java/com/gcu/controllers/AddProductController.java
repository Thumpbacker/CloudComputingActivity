package com.gcu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.gcu.interfaces.ProductBusinessServiceInterface;
import com.gcu.models.ProductModel;

@Controller
@RequestMapping("/add_new_product")
public class AddProductController {
    
    @Autowired
    private ProductBusinessServiceInterface productService;

    @GetMapping("/")
    public String display(Model model)
    {
        ProductModel product = new ProductModel();
        model.addAttribute("title", "Add Product Form");
        model.addAttribute("productModel", product);
        return "creation";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute("productModel") ProductModel productModel)
    {
        productService.addProduct(productModel);
        return "redirect:/product/";
    }

}
