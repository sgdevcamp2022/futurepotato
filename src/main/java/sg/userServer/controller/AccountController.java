package sg.userServer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sg.userServer.domain.Account;
import sg.userServer.repository.AccountRepository;
import sg.userServer.service.AccountService;

@Slf4j
@RestController
public class AccountController {
    @Autowired
    AccountService accountService;
    @Autowired
    AccountRepository accountRepository;
    @GetMapping("test")
    public String userServer() {return "user server ok";  }

    @PostMapping("/create")
    public void createUser(@RequestParam(value="accountId", required = true) String accountId,
                           @RequestParam(value="accountName", required = false) String accountName) {
        Account account = new Account(accountId, accountName);
        accountService.saveAccount(account);
    }

}