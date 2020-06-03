package com.alin.service.serviceImpl;

import com.alin.entiry.Product;
import com.alin.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Administrator on 2019/4/1.
 */
@Service
public class ProductServiceImpl implements ProductService {

    private static final Map<Integer, Product> map = new HashMap<>();

    static {
        Product product1 = new Product(1, "iphonex", 9999, 10);
        Product product2 = new Product(2, "电视机", 55, 130);
        Product product3 = new Product(3, "洗衣机", 9449, 120);
        Product product4 = new Product(4, "冰箱", 9999, 120);
        Product product5 = new Product(5, "电脑", 922999, 140);

        map.put(1, product1);
        map.put(2, product2);
        map.put(3, product3);
        map.put(4, product4);
        map.put(5, product5);

    }

    @Override
    public List<Product> listProduct() {
        Collection<Product> collection = map.values();
        List<Product> list = new ArrayList<>(collection);
        return list;
    }

    @Override
    public Product findById(int id) {
        return map.get(id);
    }
}
