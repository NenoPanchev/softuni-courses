package services.implementations;

import models.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.AccountRepository;
import services.AccountService;

import java.awt.dnd.InvalidDnDOperationException;
import java.math.BigDecimal;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void withdrawMoney(BigDecimal money, Long id) {
        Account account = accountRepository.findAccountById(id);
        if (account == null)
            throw new IllegalArgumentException();

        if (account.getBalance().compareTo(money) < 0) {
            throw new InvalidDnDOperationException();
        }
        account.setBalance(account.getBalance().subtract(money));
    }

    @Override
    public void transferMoney(BigDecimal money, Long id) {
        Account recipient = accountRepository.findAccountById(id);
        if (recipient == null) {
            throw new IllegalArgumentException();
        }
        if (money.compareTo(new BigDecimal(0)) < 0) {
            throw new InvalidDnDOperationException();
        }
        recipient.setBalance(recipient.getBalance().add(money));
    }
}
