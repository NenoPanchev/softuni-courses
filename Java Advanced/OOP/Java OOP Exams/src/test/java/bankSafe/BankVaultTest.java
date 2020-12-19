package bankSafe;


import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class BankVaultTest {
    private BankVault bankVault;

    @Before
    public void setUp() {
        bankVault = new BankVault();
    }

    @Test
    public void constructorShouldCreateMap() {
        BankVault bank = new BankVault();
        assertNull(bank.getVaultCells().get("A2"));
    }

    @Test (expected = UnsupportedOperationException.class)
    public void getVaultCellsShouldBeUnmodifiable() {
        bankVault.getVaultCells().remove("A2");
    }

    @Test (expected = IllegalArgumentException.class)
    public void addingToNonExistentCellShouldThrow() throws OperationNotSupportedException {
        Item item = new Item("Alice", "first");
        bankVault.addItem("H3", item);
    }

    @Test (expected = IllegalArgumentException.class)
    public void addingToTakenCellShouldThrow() throws OperationNotSupportedException {
        Item item = new Item("Alice", "first");
        bankVault.addItem("A3", item);
        bankVault.addItem("A3", new Item("Pesho", "second"));
    }

    @Test (expected = OperationNotSupportedException.class)
    public void addingSameItemTwiceShouldThrow() throws OperationNotSupportedException {
        Item item = new Item("Alice", "first");
        bankVault.addItem("A3", item);
        bankVault.addItem("A1", item);
    }

    @Test
    public void testAddItem() throws OperationNotSupportedException {
        Item item = new Item("Alice", "first");
        assertEquals("Item:first saved successfully!", bankVault.addItem("A3", item));
        assertEquals("Alice", bankVault.getVaultCells().get("A3").getOwner());
        assertEquals("first", bankVault.getVaultCells().get("A3").getItemId());
    }

    @Test (expected = IllegalArgumentException.class)
    public void removeFromWrongCellShouldThrow() {
        Item item = new Item("Alice", "first");
        bankVault.removeItem("A19", item);
    }

    @Test (expected = IllegalArgumentException.class)
    public void removeWrongItemShouldThrow() {
        Item item = new Item("Alice", "first");
        bankVault.removeItem("A3", item);
    }

    @Test
    public void testRemoveItem() throws OperationNotSupportedException {
        Item item = new Item("Alice", "third");
        bankVault.addItem("A2", item);
        assertEquals("Remove item:third successfully!", bankVault.removeItem("A2", item));
        assertNull(bankVault.getVaultCells().get("A2"));
    }
}