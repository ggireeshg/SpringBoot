package com.gireesh.controller;

import com.gireesh.config.ShoppingCartProperties;
import com.gireesh.domain.Customer;
import com.gireesh.response.SuccessResponse;
import com.gireesh.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerServiceImpl customerService;

    @Autowired
    ShoppingCartProperties shoppingCartProperties;

    @PostMapping("/add")
    @ResponseBody
    String  addproduct(@RequestBody @NonNull Customer customer) {
        System.out.println(customer.getCustomerId() + " : "+ customer.getCustomerName());
        customerService.insertCustomer(customer);
        SuccessResponse response = SuccessResponse.builder().code("001").message("Success").build();
        return response.toString();
    }
/*
    @GetMapping("/getCustomerNames")
    @ResponseBody
    String getProducts() {
        List<String> productList =  customerService.getProductNames();
        return productList.toString();
    }

    // Get a user by ID using @PathVariable
    @GetMapping("/getProductById/{productId}")
    @ResponseBody
    String getProductsByIdPathparam(@PathVariable int productId) {
        Product product=  customerService.getProductById(String.valueOf(productId));
        return product.toString();
    }

    @GetMapping("/getProductByName")
    @ResponseBody
    String getProductsByIdRequestParam(@RequestParam("product_name") String productId) {
        Product product=  customerService.getProductById(productId);
        return product.toString();
    }


    @GetMapping("/getAllProducts")
    @ResponseBody
    String getAllProducts() {
        List<Product> productList =  customerService.getAllProducts();
        return productList.toString();
    }

    @GetMapping("/error")
    @ResponseBody
    String errorPage() {
        List<Product> productList =  customerService.getAllProducts();
        return "This is error page.....";
    }
    */

    @GetMapping("/properties")
    String getproperties() {
        return  shoppingCartProperties.getMessage1();
    }

}
