package data.repositories;

import data.models.User;
import java.util.ArrayList;
import java.util.List;

public class Users implements UserRepository {
    private long nextId = 1;
    private final List<User> users = new ArrayList<>();

    @Override
    public User save(User user) {
        if (user.getId() == 0) {
            user.setId((int) nextId++);
        }
        users.add(user);
        return user;
    }

    @Override
    public User findByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users);
    }

    @Override
    public long count() {
        return users.size();
    }

    @Override
    public void delete(User user) {
        users.remove(user);
    }

    @Override
    public void delete(long id) {
        users.removeIf(user -> user.getId() == id);
    }

    @Override
    public User findUserById(long id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }
}