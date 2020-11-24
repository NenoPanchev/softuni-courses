import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ChainblockImplTest {
    private Chainblock chainblock;

    @Before
    public void setup() {
        chainblock = new ChainblockImpl();
        Transaction first = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Neno", "Pesho", 200.);
        Transaction second = new TransactionImpl(2, TransactionStatus.FAILED, "Alice", "Neno", 150.60);
        Transaction third = new TransactionImpl(3, TransactionStatus.ABORTED, "Neno", "Charlie", 188.89);
        Transaction fourth = new TransactionImpl(4, TransactionStatus.SUCCESSFUL, "Bob", "Alice", 350.11);
        Transaction fifth = new TransactionImpl(5, TransactionStatus.FAILED, "Charlie", "Pesho", 200.);
        Transaction sixth = new TransactionImpl(6, TransactionStatus.FAILED, "Pesho", "Neno", 188.89);
        chainblock.add(first);
        chainblock.add(second);
        chainblock.add(third);
        chainblock.add(fourth);
        chainblock.add(fifth);
        chainblock.add(sixth);
    }

    @Test
    public void containsByIdShouldReturnTrueIfTransactionFound() {
        assertTrue(chainblock.contains(2));
    }

    @Test
    public void containsByIdShouldReturnFalseIfTransactionNotFound() {
        assertFalse(chainblock.contains(7));
    }

    @Test
    public void testAdd() {
        Transaction seventh = new TransactionImpl(7, TransactionStatus.FAILED, "Pesho", "Neno", 188.89);
        chainblock.add(seventh);
        assertEquals(seventh, chainblock.getList().get(chainblock.getList().size() - 1));
    }

    @Test
    public void addShouldNotAddIfIdContained() {
        Transaction seventh = new TransactionImpl(5, TransactionStatus.FAILED, "Pesho", "Neno", 188.89);
        chainblock.add(seventh);
        assertEquals(chainblock.getList().get(5), chainblock.getList().get(chainblock.getList().size() - 1));
    }

    @Test
    public void containsShouldReturnTrueIfTransactionPresent() {
        Transaction fourth = new TransactionImpl(4, TransactionStatus.SUCCESSFUL, "Bob", "Alice", 350.11);
        assertTrue(chainblock.contains(fourth));
    }

    @Test
    public void containsShouldReturnFalseIfTransactionAbsent() {
        Transaction seventh = new TransactionImpl(7, TransactionStatus.FAILED, "Pesho", "Neno", 188.89);
        assertFalse(chainblock.contains(seventh));
    }

    @Test
    public void containsIdShouldReturnTrueIfIdPresent() {
        assertTrue(chainblock.contains(3));
    }

    @Test
    public void containsIdShouldReturnFalseIfIdNotPresent() {
        assertFalse(chainblock.contains(8));
    }

    @Test
    public void testCount() {
        assertEquals(6, chainblock.getCount());
    }

    @Test
    public void testChangeTransactionStatusById() {
        Transaction first = new TransactionImpl(1, TransactionStatus.UNAUTHORIZED, "Neno", "Pesho", 200.);
        chainblock.changeTransactionStatus(1, TransactionStatus.UNAUTHORIZED);
        assertEquals(first.getStatus(), chainblock.getList().get(0).getStatus());
    }

    @Test (expected = IllegalArgumentException.class)
    public void changeTransactionStatusShouldThrowIfIdNotPresent() {
        chainblock.changeTransactionStatus(11, TransactionStatus.ABORTED);
    }

    @Test
    public void testRemoveTransactionById() {
        chainblock.removeTransactionById(1);
        assertEquals(2, chainblock.getList().get(0).getId());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testRemoveNonExistentTransaction() {
        chainblock.removeTransactionById(11);
    }

    @Test
    public void testGetById() {
        Transaction transaction = chainblock.getById(3);
        assertEquals(chainblock.getList().get(2).getStatus(), transaction.getStatus());
    }

    @Test (expected = IllegalArgumentException.class)
    public void getByIdShouldThrowIfIdNotPresent() {
        chainblock.getById(8);
    }

    @Test
    public void getByStatusShouldReturnOrderedListByDescendingAmount() {
        List<Transaction> expected = new ArrayList<>();
        expected.add(new TransactionImpl(4, TransactionStatus.SUCCESSFUL, "Bob", "Alice", 350.11));
        expected.add(new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Neno", "Pesho", 200.));
        List<Transaction> actual = (List<Transaction>) chainblock.getByTransactionStatus(TransactionStatus.SUCCESSFUL);
        assertEquals(expected.get(0).getId(), actual.get(0).getId());
        assertEquals(expected.get(1).getId(), actual.get(1).getId());
    }

    @Test (expected = IllegalArgumentException.class)
    public void getByStatusShouldThrowIfStatusNotPresent() {
        chainblock.getByTransactionStatus(TransactionStatus.UNAUTHORIZED);
    }

    @Test
    public void testGetAllSenders() {
        List<String> expected = List.of("Charlie", "Pesho", "Alice");
        List<String> actual = (List<String>) chainblock.getAllSendersWithTransactionStatus(TransactionStatus.FAILED);
        assertEquals(expected.get(0), actual.get(0));
        assertEquals(expected.get(1), actual.get(1));
        assertEquals(expected.get(2), actual.get(2));
    }

    @Test (expected = IllegalArgumentException.class)
    public void getAllSendersShouldThrowIfStatusNotPresent() {
        chainblock.getAllSendersWithTransactionStatus(TransactionStatus.UNAUTHORIZED);
    }

    @Test
    public void testGetAllReceivers() {
        List<String> expected = List.of("Alice", "Pesho");
        List<String> actual = (List<String>) chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.SUCCESSFUL);
        assertEquals(expected.get(0), actual.get(0));
        assertEquals(expected.get(1), actual.get(1));
    }

    @Test (expected = IllegalArgumentException.class)
    public void getAllReceiversShouldThrowIfStatusNotPresent() {
        chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.UNAUTHORIZED);
    }

    @Test
    public void testGetAllOrderedByAmountDescendingThenById() {
        int[] iDs = {4, 1, 5, 3, 6, 2};
        List<Transaction> actual = (List<Transaction>) chainblock.getAllOrderedByAmountDescendingThenById();
        for (int i = 0; i < iDs.length; i++) {
            assertEquals(iDs[i], actual.get(i).getId());
        }
    }

    @Test
    public void testGetBySenderOrderedByAmountDescending() {
        List<Transaction> actual = (List<Transaction>) chainblock.getBySenderOrderedByAmountDescending("Neno");
        assertEquals(1, actual.get(0).getId());
        assertEquals(3, actual.get(1).getId());
    }

    @Test (expected = IllegalArgumentException.class)
    public void getBySenderShouldThrowIfNoSuchSender() {
        chainblock.getBySenderOrderedByAmountDescending("Atanas");
    }

    @Test
    public void testGetByReceiverOrderedByAmountThenById() {
        List<Transaction> actual = (List<Transaction>) chainblock.getByReceiverOrderedByAmountThenById("Pesho");
        assertEquals(1, actual.get(0).getId());
        assertEquals(5, actual.get(1).getId());
    }

    @Test (expected = IllegalArgumentException.class)
    public void getByReceiverShouldThrowIfNoSuchSender() {
        chainblock.getByReceiverOrderedByAmountThenById("Atanas");
    }

    @Test
    public void testGetByTransactionStatusAndMaximumAmount() {
        List<Transaction> actual = (List<Transaction>)
                chainblock.getByTransactionStatusAndMaximumAmount(TransactionStatus.FAILED, 188.89);
        assertEquals(6, actual.get(0).getId());
        assertEquals(2, actual.get(1).getId());
    }

    @Test
    public void getByTransactionStatusAndMaximumAmountShouldReturnEmptyListIfNoSuchStatus() {
        List<Transaction> actual = (List<Transaction>)
                chainblock.getByTransactionStatusAndMaximumAmount(TransactionStatus.UNAUTHORIZED, 188.89);
        assertTrue(actual.isEmpty());
    }

    @Test
    public void testGetBySenderAndMinimumAmount() {
        List<Transaction> actual = (List<Transaction>)
                chainblock.getBySenderAndMinimumAmountDescending("Neno", 188.89);
        for (Transaction transaction : actual) {
            assertEquals(1, transaction.getId());
        }
    }

    @Test (expected = IllegalArgumentException.class)
    public void getBySenderAndMinimumAmountShouldThrowIfEmpty() {
        chainblock.getBySenderAndMinimumAmountDescending("Atanas", 200.);
    }

    @Test
    public void testGetByReceiverAndAmountRange() {
        List<Transaction> actual = (List<Transaction>)
                chainblock.getByReceiverAndAmountRange("Neno", 150.60, 188.89);
        for (Transaction transaction : actual) {
            assertEquals(2, transaction.getId());
        }
    }

    @Test (expected = IllegalArgumentException.class)
    public void getByReceiverAndAmountRangeShouldThrowIfEmpty() {
        chainblock.getByReceiverAndAmountRange("Atanas", 150.60, 188.89);
    }

    @Test
    public void testGetAllInAmountRange() {
        int[] expected = {1, 2, 3, 5, 6};
        List<Transaction> actual = (List<Transaction>)
                chainblock.getAllInAmountRange(150.60, 200);
        for (int i = 0; i < actual.size(); i++) {
            assertEquals(expected[i], actual.get(i).getId());
        }
    }

    @Test
    public void getAllInAmountRangeShouldReturnEmptyListIfNoTransactionsFound() {
        List<Transaction> actual = (List<Transaction>)
                chainblock.getAllInAmountRange(400., 688.89);
        assertTrue(actual.isEmpty());
    }
    @Test
    public void testIterator() {
        Transaction nextChainblock = chainblock.iterator().next();
        List<Transaction> actual = chainblock.getList();
        assertEquals(nextChainblock.getId(), actual.iterator().next().getId());
    }
}