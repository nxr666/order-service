package com.nxr.fallback;

import com.nxr.bean.Product;
import com.nxr.service.ProductClient;
import org.springframework.stereotype.Component;

@Component
public class ProductClientFallback implements ProductClient  {
    private static final String FALL_BACK = "FALL_BACK";
    @Override
    public Product findById(int id) {
        Product product = new Product();
        product.setName(FALL_BACK);
        return product;
    }
}
