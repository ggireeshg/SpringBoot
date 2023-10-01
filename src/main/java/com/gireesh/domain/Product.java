package com.gireesh.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    int product_id;
    String product_name;
    int  product_qty;
    double product_price;
}
