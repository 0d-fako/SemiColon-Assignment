package bankapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {
    private Account lumiAccount;

    @BeforeEach
    public void setUp() {
        lumiAccount = new Account();
    }


    @Test
    public void balanceIsEmpty_shouldReturnZero() {
        assertEquals(0, lumiAccount.getBalance());
    }
    @Test
    public void deposit5K_balance5kTest() {
        lumiAccount.deposit(5_000);
        assertEquals(5_000, lumiAccount.getBalance());
    }

    @Test
    public void deposit5KTwice_balance10kTest() {
        lumiAccount.deposit(5_000);
        lumiAccount.deposit(5_000);
        assertEquals(10_000, lumiAccount.getBalance());
    }

    @Test
    public void depositNegative5k_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> lumiAccount.deposit(-5_000));
    }
}

