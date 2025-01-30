package bankapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccountTest {
    private Account lumiAccount;

    @BeforeEach
    public void setUp() {
        lumiAccount = new Account();
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
}
