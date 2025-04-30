package services;

public interface UserServices {

    public boolean login(String username, String password);

    public boolean register(String username, String password);
}
