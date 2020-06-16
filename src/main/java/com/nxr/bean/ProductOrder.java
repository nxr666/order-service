package com.nxr.bean;

import lombok.Data;

import java.util.Date;

@Data
public class ProductOrder {
    private int id;
    private String productName;
    private String tradeNo;
    private int price;
    private Date createTime;
    private int userId;
    private String userName;
}
