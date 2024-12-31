package model;

public class Product {
    private Long productId;
    private String productName;
    private Float productPrice;
    private Long productStockQuantity;

    public Product (Long productId, String productName, Float productPrice, Long productStockQuantity){
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productStockQuantity = productStockQuantity;
    }

    public void setProductId(Long productId){
        this.productId = productId;
    }
    public Long getProductId (){
        return productId;
    }
    public void setProductName(String productName){
        this.productName = productName;
    }
    public String getProductName (){
        return productName;
    }
    public void setProductPrice (Float productPrice){
        this.productPrice = productPrice;
    }
    public Float getProductPrice (){
        return productPrice;
    }
    public void setProductStockQuantity(Long productStockQuantity){
        this.productStockQuantity = productStockQuantity;
    }
    public Long getProductStockQuantity (){
        return productStockQuantity;
    }
}
