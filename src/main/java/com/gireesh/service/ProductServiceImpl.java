package com.gireesh.service;

import com.gireesh.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl {
    private final JdbcTemplate jdbcTemplate;
    private  final NamedParameterJdbcTemplate namedJdbcTemplate;
    @Value("${success.code}")
    private String successCode;
    @Value("${success.message}")
    private String successMessage;

    String  INSERT_SQL = "INSERT INTO product VALUES (:proudctId, :productName, :qty, :price)";

    String  SELECT_ALL_PRODUCTS = "Select * from product";

    String  SELECT_PRODUCT_NAMES = "Select product_name from product";

    String  SELECT_PRODUCT_BY_ID = "Select * from product where product_id = :productId";

    String  SELECT_PRODUCT_BY_NAME = "Select * from product where product_name = :productName";


    public ProductServiceImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedJdbcTemplate = namedJdbcTemplate;
    }

    public void insertProduct(Product product) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("proudctId",product.getProduct_id());
        params.addValue("productName",product.getProduct_name());
        params.addValue("qty",product.getProduct_qty());
        params.addValue("price",product.getProduct_price());
        int count = namedJdbcTemplate.update(INSERT_SQL,params);
        if (count>0)
            System.out.println("prodcut added succesfuly...");
    }


    public List<String> getProductNames() {
        List<String> productList = jdbcTemplate.queryForList(SELECT_PRODUCT_NAMES,String.class);
        return productList;
    }

//    public List<Product> getAllProducts() {
//        List<Product> productList = jdbcTemplate.queryForList(SELECT_ALL_PRODUCTS, (rs,rownum)->{
//            Product.bui
//        });
//        return productList;
//    }

    public Product getProductById(String productId) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("productId",productId);
        Product product = (Product) namedJdbcTemplate.queryForObject(SELECT_PRODUCT_BY_ID, params, new BeanPropertyRowMapper(Product.class));
        return  product;

    }

    public Product getProductByName(String productId) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("productId",productId);
        Product product = namedJdbcTemplate.queryForObject(SELECT_PRODUCT_BY_NAME, params, Product.class);
        return  product;

    }

    public List<Product> getAllProducts() {

        List<Product> productList = jdbcTemplate.query(SELECT_ALL_PRODUCTS,new BeanPropertyRowMapper(Product.class));
        return productList;
    }
}
