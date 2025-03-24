package data.repositories;

import data.models.User;

import java.util.List;

public interface UserRepository {

    User save(User user);
    User findByUsername(String username);
    List<User> findAll();
    long count();
    void delete(User user);
    void delete(long id);
    User findUserById(long id);
}
