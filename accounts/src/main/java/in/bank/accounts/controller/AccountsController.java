package in.bank.accounts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.impl.ObjectIdWriter;

import in.bank.accounts.config.AccountsConfigService;
import in.bank.accounts.model.Accounts;
import in.bank.accounts.model.Cards;
import in.bank.accounts.model.ConfigProp;
import in.bank.accounts.model.CustomerDetails;
import in.bank.accounts.model.Customers;
import in.bank.accounts.repository.AccountsRepository;
import in.bank.cards.model.Customer;



@RestController
public class AccountsController {

    @Autowired
    private AccountsRepository accountsRepository;
    
    @Autowired
    AccountsConfigService accountsConfig;
    
    @Autowired
    in.bank.accounts.service.client.CardsFeignClient CardsFeignClient;

    @PostMapping("/accounts")
    public Accounts getAccountDetails(@RequestBody Customers customer) {
        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId());
        return accounts;
    }
    @GetMapping("/accounts/configProps")
    public String getPropertyDetails() throws JsonProcessingException {
      ObjectMapper objectMapper = new ObjectMapper();
      ConfigProp properties = new ConfigProp(accountsConfig.getMsg(), accountsConfig.getBuildVersion(),
          accountsConfig.getMailDetails(), accountsConfig.getActiveBranches());
      String jsonStr = objectMapper.writeValueAsString(properties);
      return jsonStr;
    }
        
        @PostMapping("/profile")
        public CustomerDetails getCustomerDetails(@RequestBody Customer customer) {
          Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId());
          List<Cards> cards = CardsFeignClient.getCardDetails(customer);
          CustomerDetails customerDetails = new CustomerDetails();
          customerDetails.setAccounts(accounts);
          customerDetails.setCards(cards);
          return customerDetails;
        }
        
        }