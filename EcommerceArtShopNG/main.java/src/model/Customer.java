package model;

public class Customer {
    private int id;
    private String firstName;
    private String lastName;
    private String customerEmail;
    private String customerPassword;


    public Customer (int id, String firstName, String lastName, String customerEmail, String customerPassword){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.customerEmail = customerEmail;
        this.customerPassword = customerPassword;
    }

    public void setId (int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public void setFirstName (String firstName){
        this.firstName = firstName;
    }
    public String getFirstName(){
        return firstName;
    }
    public void setLastName (String lastName){
        this.lastName = lastName;
    }
    public String getLastName(){
        return lastName;
    }
    public void setCustomerEmail (String customerEmail){
        this.customerEmail = customerEmail;
    }
    public String getCustomerEmail(){
        return customerEmail;
    }
    public void setCustomerPassword (String customerPassword){
        this.customerPassword = customerPassword;
    }
    public String getCustomerPassword(){
        return customerPassword;
    }
}
