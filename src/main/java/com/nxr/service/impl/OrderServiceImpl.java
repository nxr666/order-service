package com.nxr.service.impl;

import com.nxr.bean.Product;
import com.nxr.bean.ProductOrder;
import com.nxr.service.OrderService;
import com.nxr.service.ProductClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    ProductClient productClient;
    @Override
    public Object save(int userId, int productId) {
        Product product = productClient.findById(productId);
        ProductOrder order = new ProductOrder();
        order.setCreateTime(new Date());
        order.setUserId(userId);
        order.setTradeNo(UUID.randomUUID().toString());
        order.setProductName(product.getName());
        order.setPrice(product.getPrice());
        return order;
    }
}
