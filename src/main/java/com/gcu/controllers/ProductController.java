package com.gcu.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.interfaces.ProductBusinessServiceInterface;
import com.gcu.models.ProductModel;
import com.gcu.models.SearchModel;


@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductBusinessServiceInterface productService;
    
    @GetMapping("/")
    public String showAllProducts(Model model)
    {
        List<ProductModel> products = productService.getProducts();

        model.addAttribute("title", "Current Inventory");
        model.addAttribute("products", products);
        model.addAttribute("searchModel", new SearchModel());
        return "index";
    }

    @PostMapping("/search/")
    public String search(SearchModel search, Model model)
    {
        List<ProductModel> products = productService.searchProduct(search.getSearchTerm());
        
        model.addAttribute("title", "Search results for: " + search.getSearchTerm());
        model.addAttribute("products", products);
        model.addAttribute("searchModel", new SearchModel());
        return "index";
    }
    
    @PostMapping("/delete")
    public String deleteProduct(ProductModel product, Model model)
    {
        boolean deleted = productService.deleteProduct(product.getId());
        System.out.println(deleted);

        List<ProductModel> products = productService.getProducts();
        model.addAttribute("title", "Current Inventory");
        model.addAttribute("products", products);
        model.addAttribute("searchModel", new SearchModel());
        return "redirect:/product/";
    }

    @GetMapping("/update")
    public String showForm(ProductModel productModel, Model model)
    {
        model.addAttribute("productModel", productModel);
        return "update";
    }


    @PostMapping("/updated")
    public String updateOrder(ProductModel productModel)
    {
        productService.updateProduct(productModel.getId(), productModel);
        
        return "redirect:/product/";
    }

    @GetMapping("/details")
    public String showProductDetails(ProductModel product, Model model)
    {
        ProductModel displayedProduct = productService.getByID(product.getId());
        
        model.addAttribute("title", displayedProduct.getGadgetName());
        model.addAttribute("products", displayedProduct);
        model.addAttribute("searchModel", new SearchModel());
        return "detail";
    }
}
