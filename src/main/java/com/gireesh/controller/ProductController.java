package com.gireesh.controller;

import com.gireesh.ProductServiceImpl;
import com.gireesh.response.SuccessResponse;
import com.gireesh.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductServiceImpl productService;

    @PostMapping("/add")
    @ResponseBody
    String  addproduct(@RequestBody @NonNull Product product) {
        System.out.println(product.getProduct_id() + " : "+ product.getProduct_name());
        productService.insertProduct(product);
        SuccessResponse response = SuccessResponse.builder().code("001").message("Success").build();
        return response.toString();
    }

    @GetMapping("/getProductNames")
    @ResponseBody
    String getProducts() {
        List<String> productList =  productService.getProductNames();
        return productList.toString();
    }

    @GetMapping("/getAllProducts")
    @ResponseBody
    String getAllProducts() {
        List<Product> productList =  productService.getAllProducts();
        return productList.toString();
    }
}
