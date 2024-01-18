package com.gcu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.interfaces.ProductBusinessServiceInterface;
import com.gcu.models.ProductModel;

@Controller
@RequestMapping("/update_product")
public class UpdateProductController {
    @Autowired
    private ProductBusinessServiceInterface productService;

    @GetMapping("/")
    public String display(ProductModel productModel, Model model)
    {
        model.addAttribute("title", "Update Product Form");
        model.addAttribute("productModel", productModel);
        model.addAttribute("id", productModel.getId());
        return "update";
    }

    @PostMapping("/update")
    public String updateProduct(@ModelAttribute("productModel") ProductModel productModel)
    {
        productService.updateProduct(productModel.getId(), productModel);
        return "redirect:/product/";
    }
}
