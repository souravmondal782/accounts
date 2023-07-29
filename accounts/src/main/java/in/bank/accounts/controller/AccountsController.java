package in.bank.accounts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.bank.accounts.model.Accounts;
import in.bank.accounts.model.Customers;
import in.bank.accounts.repository.AccountsRepository;



@RestController
public class AccountsController {

    @Autowired
    private AccountsRepository accountsRepository;

    @PostMapping("/accounts")
    public List<Accounts> getAccountDetails(@RequestBody Customers customer) {
        List<Accounts> accounts = accountsRepository.findByCustomerId(customer.getCustomerId());
        return accounts;
    }
}
