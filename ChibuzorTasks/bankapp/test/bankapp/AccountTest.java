package bankapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {
    private Account lumiAccount;

    @BeforeEach
    public void setUp() {
        lumiAccount = new Account("firstName", "lastName", 1, "pin");
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
    public void deposit0_throwException() {
        assertThrows(IllegalArgumentException.class, () -> lumiAccount.deposit(0));
    }

    @Test
    public void deposit5KTwice_balance10kTest() {
        lumiAccount.deposit(5_000);
        lumiAccount.deposit(5_000);
        assertEquals(10_000, lumiAccount.getBalance());
    }

    @Test
    public void depositNegative5k_throwsExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> lumiAccount.deposit(-5_000));
    }

    @Test
    public void deposit5k_withdraw10kThrowsExceptionTest() {
        lumiAccount.deposit(5_000);
        assertThrows(IllegalArgumentException.class, () -> lumiAccount.withdraw(10_000,"pin"));
    }

    @Test
    public void deposit5k_withdraw5kTest() {
        lumiAccount.deposit(5_000);
        assertEquals(5_000, lumiAccount.getBalance());
        lumiAccount.withdraw(5_000,"pin");
        assertEquals(0, lumiAccount.getBalance());
    }

    @Test
    public void withdraw5k_withInvalidPinThrowExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> lumiAccount.withdraw(5_000,"pni"));

    }

    @Test
    public void updatePin_checkPinTest() {
        lumiAccount.updatePin("pin","pmi");
        lumiAccount.deposit(5_000);
        assertEquals(5_000, lumiAccount.getBalance());
        lumiAccount.withdraw(5_000,"pmi");
        assertEquals(0, lumiAccount.getBalance());

    }
}

