package in.bank.accounts.service.client;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import in.bank.accounts.model.Customers;
import in.bank.cards.model.Cards;
import in.bank.cards.model.Customer;

public interface CardsFeignClient {
@RequestMapping (method =RequestMethod.POST,value="cards", consumes = "application/json")
List<in.bank.accounts.model.Cards> getCardDetails (@RequestBody Customer customer);

void getCardDetails(Customers customer);

}
