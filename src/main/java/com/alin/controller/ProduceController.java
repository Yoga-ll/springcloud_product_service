package com.alin.controller;

import com.alin.entiry.Product;
import com.alin.service.ProductService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

/**
 * Created by Administrator on 2019/4/1.
 */
@RestController
@RequestMapping("/api/v1/product")
public class ProduceController {

    @Value("${server.port}")
    private String port;

    @Autowired
    private ProductService productService;

    /**
     * 获取所有商品列表
     *
     * @return Product
     */
    @RequestMapping("list")
    public Object list() {
        return productService.listProduct();
    }

    /**
     * 根据id查找商品
     *
     * @param id
     * @return Product
     */
    @RequestMapping("find")
    public Object find(@RequestParam("id") int id) {
        Product product = productService.findById(id);
        Product result = new Product();
        BeanUtils.copyProperties(product, result);

        result.setName(result.getName() + " data from port:" + port);
        return result;
    }
}
