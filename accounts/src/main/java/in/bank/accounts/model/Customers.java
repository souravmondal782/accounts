package in.bank.accounts.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



@Entity
@Getter @Setter @ToString
public class Customers {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)//(AUTO_INCRMENT PRIMARY_KEY)
	@Column(name="customer_id")
	private int CustomerId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="mobile_number")
	private String mobileNumber;
	
	@Column(name="email_id")
	private String emailId;
	
	@Column(name="created_date")
	private LocalDate createdDate;
	
}


