class Account {
    String accountNumber;
    double balance;

    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        return accountNumber.equals(((Account) o).accountNumber);
    }
    @Override
    public int hashCode() { return accountNumber.hashCode(); }
}

class Transaction {
    String id;
    String targetAccountNumber;
    double amount;

    public Transaction(String id, String targetAccountNumber, double amount) {
        this.id = id;
        this.targetAccountNumber = targetAccountNumber;
        this.amount = amount;
    }
}
import java.util.*;

public class BankSystem {
    private Set<Account> validAccounts = new HashSet<>();
    private Queue<Transaction> pendingQueue = new LinkedList<>();
    private List<Transaction> transactionHistory = new ArrayList<>();
    private Stack<Transaction> rollbackStack = new Stack<>();
    public void receiveTransaction(Transaction t) {
        pendingQueue.add(t);
        System.out.println("Transaction " + t.id + " queued.");
    }
    public void processNextTransaction() {
        if (pendingQueue.isEmpty()) return;

        Transaction current = pendingQueue.poll();
        if (isAccountValid(current.targetAccountNumber)) {
            execute(current);
        } else {
            System.out.println("Transaction " + current.id + " rejected: Invalid Account.");
        }
    }

    private boolean isAccountValid(String accNum) {
        return validAccounts.stream().anyMatch(a -> a.accountNumber.equals(accNum));
    }

    private void execute(Transaction t) {
        transactionHistory.add(t);
        rollbackStack.push(t);
        System.out.println("Transaction " + t.id + " executed successfully.");
    }
    public void undoLastTransaction() {
        if (!rollbackStack.isEmpty()) {
            Transaction last = rollbackStack.pop();
            System.out.println("Rolling back transaction: " + last.id);
            transactionHistory.remove(last);
        } else {
            System.out.println("Nothing to rollback.");
        }
    }

    public void addAccount(Account a) { validAccounts.add(a); }
}