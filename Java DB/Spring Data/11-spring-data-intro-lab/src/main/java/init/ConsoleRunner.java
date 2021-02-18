package init;

import models.Account;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import services.AccountService;
import services.UserService;

import java.math.BigDecimal;
import java.util.HashSet;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private UserService userService;
    private AccountService accountService;

    @Autowired
    public ConsoleRunner(UserService userService, AccountService accountService) {
        this.userService = userService;
        this.accountService = accountService;
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setUsername("Pesho");
        user.setAge(20);

        Account account = new Account();
        account.setBalance(new BigDecimal(25000));

        user.setAccounts(new HashSet<>(){{add(account);}});
        userService.registerUser(user);

        this.accountService.withdrawMoney(new BigDecimal(20000), account.getId());
        this.accountService.transferMoney(new BigDecimal(20000), account.getId());
    }
}
