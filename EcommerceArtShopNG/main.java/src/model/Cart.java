package model;

public class Cart {
    private Long id;
    private Float cartTotalAmount;
    private String cartProducts;


    public Cart (Long id, Float cartTotalAmount, String cartProducts){
        this.id = id;
        this.cartTotalAmount = cartTotalAmount;
        this.cartProducts = cartProducts;
    }

    public void setId (Long id){
        this.id = id;
    }
    public Long getId(){
        return id;
    }
    public void setCartTotalAmount (Float cartTotalAmount){
        this.cartTotalAmount = cartTotalAmount;
    }
    public Float getCartTotalAmount() {
        return cartTotalAmount;
    }
    public void setCartProducts (String cartProducts){
        this.cartProducts = cartProducts;
    }
    public String getCartProducts() {
        return cartProducts;
    }
}
