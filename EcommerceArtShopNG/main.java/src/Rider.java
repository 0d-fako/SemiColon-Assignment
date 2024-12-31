import model.Customer;

public class Rider extends Customer {

    public Rider(Long id, String firstName, String lastName, String customerEmail, String customerPassword) {
        super(Math.toIntExact(id), firstName, lastName, customerEmail, customerPassword);
    }

    public void registerRider(String firstName, String lastName, String customerEmail, String customerPassword){
        Rider rider = new Rider(1L, "Kim",
                "Paul", "kim@gmail.com", "1234");
        rider.setFirstName(firstName);
        rider.setLastName(lastName);
        rider.setCustomerEmail(customerEmail);
        rider.setCustomerPassword(customerPassword);
        if (rider.getFirstName().isEmpty()){
            throw new RuntimeException("Invalid input");
        }
    }
}
