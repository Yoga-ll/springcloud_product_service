package com.alin.service;

import com.alin.entiry.Product;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2019/4/1.
 */

public interface ProductService {

    List<Product> listProduct();

    Product findById(int id);
}
