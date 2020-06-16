package com.nxr.service;

import com.nxr.bean.Product;
import com.nxr.fallback.ProductClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "product-service",fallback = ProductClientFallback.class)
public interface ProductClient {

    @GetMapping("/api/v1/product/find")
    public Product findById(@RequestParam("id") int id);
}