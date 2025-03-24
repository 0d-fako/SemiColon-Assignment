package data.repositories;

import data.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UsersTest {

    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        userRepository = new Users();
    }

    @Test
    public void save_shouldAddUserAndAssignId() {
        User user = new User();
        user.setUsername("testUser");

        User savedUser = userRepository.save(user);

        assertNotNull(savedUser.getId());
        assertEquals("testUser", savedUser.getUsername());
    }

    @Test
    public void findByUsername_shouldReturnCorrectUser() {
        User user = new User();
        user.setUsername("testUser");
        userRepository.save(user);

        User foundUser = userRepository.findByUsername("testUser");

        assertNotNull(foundUser);
        assertEquals("testUser", foundUser.getUsername());
    }

    @Test
    public void findAll_shouldReturnAllUsers() {
        User user1 = new User();
        user1.setUsername("user1");
        userRepository.save(user1);

        User user2 = new User();
        user2.setUsername("user2");
        userRepository.save(user2);

        List<User> users = userRepository.findAll();

        assertEquals(2, users.size());
    }

    @Test
    public void count_shouldReturnCorrectNumberOfUsers() {
        assertEquals(0, userRepository.count());

        User user = new User();
        user.setUsername("testUser");
        userRepository.save(user);

        assertEquals(1, userRepository.count());
    }

    @Test
    public void deleteById_shouldRemoveUser() {
        User user = new User();
        user.setUsername("testUser");
        User savedUser = userRepository.save(user);

        userRepository.delete(savedUser.getId());

        assertEquals(0, userRepository.count());
    }

    @Test
    public void findUserById_shouldReturnCorrectUser() {
        User user = new User();
        user.setUsername("testUser");
        User savedUser = userRepository.save(user);

        User foundUser = userRepository.findUserById(savedUser.getId());

        assertNotNull(foundUser);
        assertEquals(savedUser.getId(), foundUser.getId());
    }
}