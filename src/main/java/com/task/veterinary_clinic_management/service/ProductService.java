package com.task.veterinary_clinic_management.service;

import com.task.veterinary_clinic_management.model.Product;
import com.task.veterinary_clinic_management.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService {
    private  final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    public Product getProductById(Long id){
        return productRepository.getById(id);
    }
    public void createProduct(Product product){

         productRepository.save(product);
    }

}
