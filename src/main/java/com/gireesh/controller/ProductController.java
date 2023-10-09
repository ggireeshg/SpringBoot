package com.gireesh.controller;

import com.gireesh.ProductServiceImpl;
import com.gireesh.config.ShoppingCartProperties;
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

    @Autowired
    ShoppingCartProperties shoppingCartProperties;

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

    // Get a user by ID using @PathVariable
    @GetMapping("/getProductById/{productId}")
    @ResponseBody
    String getProductsByIdPathparam(@PathVariable int productId) {
        Product product=  productService.getProductById(String.valueOf(productId));
        return product.toString();
    }

    @GetMapping("/getProductByName")
    @ResponseBody
    String getProductsByIdRequestParam(@RequestParam("product_name") String productId) {
        Product product=  productService.getProductById(productId);
        return product.toString();
    }


    @GetMapping("/getAllProducts")
    @ResponseBody
    String getAllProducts() {
        List<Product> productList =  productService.getAllProducts();
        return productList.toString();
    }

    @GetMapping("/error")
    @ResponseBody
    String errorPage() {
        List<Product> productList =  productService.getAllProducts();
        return "This is error page.....";
    }

    @GetMapping("/properties")
    String getproperties() {
        return  shoppingCartProperties.getMessage1();
    }

}
