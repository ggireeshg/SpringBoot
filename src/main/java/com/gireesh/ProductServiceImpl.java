package com.gireesh;

import com.gireesh.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl {
    private final JdbcTemplate jdbcTemplate;
    private  final NamedParameterJdbcTemplate namedJdbcTemplate;

    String  INSERT_SQL = "INSERT INTO product VALUES (:proudctId, :productName, :qty, :price)";

    String  SELECT_ALL_PRODUCTS = "Select * from product";

    String  SELECT_PRODUCT_BY_ID = "Select * from product where product_id = :productId";


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
        List<String> productList = jdbcTemplate.queryForList(SELECT_ALL_PRODUCTS,String.class);
        return productList;
    }

    public List<Product> getAllProducts() {
        List<Product> productList = jdbcTemplate.queryForList(SELECT_ALL_PRODUCTS,Product.class);
        return productList;
    }

}
