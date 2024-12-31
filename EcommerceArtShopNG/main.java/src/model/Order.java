package model;

import java.time.LocalDateTime;
import java.util.Date;

public class Order {
    private Long id;
    private LocalDateTime orderDate;
    private Float orderTotalAmount;
    private String orderStatus;


    public Order (Long id, LocalDateTime orderDate, Float orderTotalAmount, String orderStatus){
        this.id = id;
        this.orderDate = orderDate;
        this.orderTotalAmount = orderTotalAmount;
        this.orderStatus = orderStatus;
    }

    public void setId(Long id){
        this.id = id;
    }
    public Long getId() {
        return id;
    }
    public void setOrderDate (LocalDateTime orderDate){
        this.orderDate = orderDate;
    }
    public LocalDateTime getOrderDate() {
        return orderDate;
    }
    public void setOrderTotalAmount (Float orderTotalAmount){
        this.orderTotalAmount = orderTotalAmount;
    }
    public Float getOrderTotalAmount() {
        return orderTotalAmount;
    }
    public void setOrderStatus (String orderStatus){
        this.orderStatus = orderStatus;
    }
    public String getOrderStatus() {
        return orderStatus;
    }
}
