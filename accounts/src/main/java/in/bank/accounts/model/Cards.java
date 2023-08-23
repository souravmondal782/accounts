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
@Getter
@Setter 
@ToString
public class Cards {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)//(AUTO_INCRMENT PRIMARY_KEY)
	@Column(name = "card_id")
	private int cardId; 
	
	@Column(name = "customer_id")
	private int customerId;

	 @Column(name = "card_type")
	private String cardType;
	
	@Column(name = "card_number ")
	private int cardNumber;
	
	@Column(name = "Expiry_date ")
	private LocalDate expiryDate;


}
