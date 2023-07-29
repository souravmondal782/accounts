package in.bank.accounts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.bank.accounts.model.Accounts;

@EnableJpaRepositories("in.bank.accounts.repository") 

@Repository
public interface AccountsRepository extends CrudRepository<Accounts, Long> {
    List<Accounts> findByCustomerId(int customerId);
}
