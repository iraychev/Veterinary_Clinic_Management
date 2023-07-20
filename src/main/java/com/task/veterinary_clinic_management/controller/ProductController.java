package com.task.veterinary_clinic_management.controller;


import com.task.veterinary_clinic_management.model.Patient;
import com.task.veterinary_clinic_management.model.Product;
import com.task.veterinary_clinic_management.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String  getAllProducts(Model model) {
        List<Product> products =  productService.getAllProducts();
        model.addAttribute("products",products);
        return "Products";

    }


    @GetMapping("/{id}")
    public String getProductById(@PathVariable Long id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product",product);
        return "Product";
    }

    @PostMapping
    public void createProduct(@ModelAttribute Product product) {
        productService.createProduct(product);
    }
}
