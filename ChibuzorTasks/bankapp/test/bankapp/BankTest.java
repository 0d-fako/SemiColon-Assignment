package bankapp.src.bankapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankTest {
    private Bank bank;

    @BeforeEach
    public void setUp() {
        bank = new Bank("MyBank");
    }

    @Test
    public void createAccount_shouldAddAccountToListTest() {
        bank.createAccount("John", "Doe", "1234");
        assertEquals(1, bank.getAccounts().size());
    }

    @Test
    public void createAccount_withNullValues_throwsExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> bank.createAccount(null, "Doe", "1234"));
        assertThrows(IllegalArgumentException.class, () -> bank.createAccount("John", null, "1234"));
        assertThrows(IllegalArgumentException.class, () -> bank.createAccount("John", "Doe", null));
    }

    @Test
    public void transfer_validTransfer_updatesBalancesTest() {
        bank.createAccount("John", "Doe", "1234");
        bank.createAccount("Jane", "Doe", "5678");

        bank.deposit("0", 1000);
        bank.transfer("0", "1", 500, "1234");

        assertEquals(500, bank.checkBalance("0", "1234"));
        assertEquals(500, bank.checkBalance("1", "5678"));
    }

    @Test
    public void transfer_invalidPin_throwsException() {
        bank.createAccount("John", "Doe", "1234");
        bank.createAccount("Jane", "Doe", "5678");

        bank.deposit("0", 1000);
        assertThrows(IllegalArgumentException.class, () -> bank.transfer("0", "1", 500, "wrongPin"));
    }

    @Test
    public void deposit_validAmount_updatesBalanceTest() {
        bank.createAccount("John", "Doe", "1234");
        bank.deposit("0", 1000);
        assertEquals(1000, bank.checkBalance("0", "1234"));
    }

    @Test
    public void deposit_negativeAmount_throwsExceptionTest() {
        bank.createAccount("John", "Doe", "1234");
        assertThrows(IllegalArgumentException.class, () -> bank.deposit("0", -1000));
    }

    @Test
    public void checkBalance_invalidAccount_throwsExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> bank.checkBalance("999", "1234"));
    }

    @Test
    public void transfer_sameAccount_throwsExceptionTest() {
        bank.createAccount("John", "Doe", "1234");
        bank.deposit("0", 1000);
        assertThrows(IllegalArgumentException.class, () -> bank.transfer("0", "0", 500, "1234"));
    }
}