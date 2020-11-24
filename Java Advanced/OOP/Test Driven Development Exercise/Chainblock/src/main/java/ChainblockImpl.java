import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class ChainblockImpl implements Chainblock{
    private List<Transaction> list;

    public ChainblockImpl() {
        this.list = new ArrayList<>();
    }

    public int getCount() {
        return this.list.size();
    }

    public void add(Transaction transaction) {
        if (!contains(transaction)) {
            this.list.add(transaction);
        }
    }

    public boolean contains(Transaction transaction) {
        return contains(transaction.getId());
    }

    public boolean contains(int id) {
        for (Transaction transaction : list) {
            if (transaction.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public void changeTransactionStatus(int id, TransactionStatus newStatus) {
        for (Transaction transaction : list) {
            if (transaction.getId() == id) {
                transaction.setStatus(newStatus);
                return;
            }
        }
        throw new IllegalArgumentException("Transaction not found");
    }

    public void removeTransactionById(int id) {
        for (Transaction transaction : list) {
            if (transaction.getId() == id) {
                this.list.remove(transaction);
                return;
            }
        }
        throw new IllegalArgumentException("Transaction not found");
    }

    public Transaction getById(int id) {
        for (Transaction transaction : list) {
            if (transaction.getId() == id) {
                return transaction;
            }
        }
        throw new IllegalArgumentException("Transaction not found");
    }

    public Iterable<Transaction> getByTransactionStatus(TransactionStatus status) {
        List<Transaction> transactionsByStatus = this.list.stream()
                .filter(transaction -> transaction.getStatus().equals(status))
                .sorted((a, b) -> Double.compare(b.getAmount(), a.getAmount()))
                .collect(Collectors.toList());
        if (!transactionsByStatus.isEmpty()) {
            return transactionsByStatus;
        }
        throw new IllegalArgumentException("Transaction with such status not found");
    }

    public Iterable<String> getAllSendersWithTransactionStatus(TransactionStatus status) {
        List<String> transactionsByStatus = this.list.stream()
                .filter(transaction -> transaction.getStatus().equals(status))
                .sorted((a, b) -> Double.compare(b.getAmount(), a.getAmount()))
                .map(Transaction::getSender)
                .collect(Collectors.toList());
        if (!transactionsByStatus.isEmpty()) {
            return transactionsByStatus;
        }
        throw new IllegalArgumentException("Transaction with such sender not found");
    }

    public Iterable<String> getAllReceiversWithTransactionStatus(TransactionStatus status) {
        List<String> transactionsByStatus = this.list.stream()
                .filter(transaction -> transaction.getStatus().equals(status))
                .sorted((a, b) -> Double.compare(b.getAmount(), a.getAmount()))
                .map(Transaction::getReceiver)
                .collect(Collectors.toList());
        if (!transactionsByStatus.isEmpty()) {
            return transactionsByStatus;
        }
        throw new IllegalArgumentException("Transaction with such receiver not found");
    }

    public Iterable<Transaction> getAllOrderedByAmountDescendingThenById() {
        return this.list.stream()
                .sorted((a, b) -> {
                    int sort = Double.compare(b.getAmount(), a.getAmount());
                    if (sort == 0) {
                        sort = Integer.compare(a.getId(), b.getId());
                    }
                    return sort;
                })
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getBySenderOrderedByAmountDescending(String sender) {
        List<Transaction> transactionsBySender = this.list.stream()
                .filter(transaction -> transaction.getSender().equals(sender))
                .sorted((a, b) -> a.compareTo((TransactionImpl) b))
                .collect(Collectors.toList());
        if (!transactionsBySender.isEmpty()) {
            return transactionsBySender;
        }
        throw new IllegalArgumentException("Transaction with such sender not found");
    }

    public Iterable<Transaction> getByReceiverOrderedByAmountThenById(String receiver) {
        List<Transaction> transactionsBySender = this.list.stream()
                .filter(transaction -> transaction.getReceiver().equals(receiver))
                .sorted((a, b) -> {
                    int sort = a.compareTo((TransactionImpl) b);
                    if (sort == 0) {
                        sort = Integer.compare(a.getId(), b.getId());
                    }
                    return sort;
                })
                .collect(Collectors.toList());
        if (!transactionsBySender.isEmpty()) {
            return transactionsBySender;
        }
        throw new IllegalArgumentException("Transaction with such receiver not found");
    }

    public Iterable<Transaction> getByTransactionStatusAndMaximumAmount(TransactionStatus status, double amount) {
       return this.list.stream()
                .filter(transaction -> transaction.getStatus().equals(status)
                && transaction.getAmount() <= amount)
                .sorted((a, b) -> a.compareTo((TransactionImpl) b))
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getBySenderAndMinimumAmountDescending(String sender, double amount) {
        List<Transaction> transactionsBySender = this.list.stream()
                .filter(transaction -> transaction.getSender().equals(sender)
                        && transaction.getAmount() > amount)
                .sorted((a, b) -> a.compareTo((TransactionImpl) b))
                .collect(Collectors.toList());

        if (!transactionsBySender.isEmpty()) {
            return transactionsBySender;
        }
        throw new IllegalArgumentException("Transaction with such sender not found");
    }

    public Iterable<Transaction> getByReceiverAndAmountRange(String receiver, double lo, double hi) {
        List<Transaction> transactionsBySender = this.list.stream()
                .filter(transaction -> transaction.getReceiver().equals(receiver)
                        && transaction.getAmount() >= lo
                && transaction.getAmount() < hi)
                .sorted((a, b) -> a.compareTo((TransactionImpl) b))
                .collect(Collectors.toList());

        if (!transactionsBySender.isEmpty()) {
            return transactionsBySender;
        }
        throw new IllegalArgumentException("Transaction with such receiver not found");
    }

    public Iterable<Transaction> getAllInAmountRange(double lo, double hi) {
        return this.list.stream()
                .filter(transaction -> transaction.getAmount() >= lo &&
                        transaction.getAmount() <= hi)
                .collect(Collectors.toList());
    }

    public List<Transaction> getList() {
        return this.list;
    }

    public Iterator<Transaction> iterator() {
        return list.iterator();
    }
}
