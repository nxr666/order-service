package com.nxr.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.nxr.OrderServer;
import com.nxr.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
    private static Logger logger = LoggerFactory.getLogger(OrderController.class);
    //加点注释
    @Autowired
    OrderService orderService;

    @GetMapping("/save")
    @HystrixCommand(fallbackMethod = "saveFail")
    public Object save(@RequestParam("userId") int userId, @RequestParam("productId") int productId, HttpServletRequest request) {
        logger.info("order service save");
        String token = request.getHeader("token");
        String cookie = request.getHeader("cookie");
        System.out.println("token="+token);
        System.out.println("cookie="+cookie);
        return orderService.save(userId,productId);
    }

    public Object saveFail(@RequestParam("userId") int userId,@RequestParam("productId") int productId,HttpServletRequest request) {
        return "fail";
    }
}
