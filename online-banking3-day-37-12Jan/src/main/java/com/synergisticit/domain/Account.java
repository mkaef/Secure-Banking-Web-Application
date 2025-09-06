package com.synergisticit.domain;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Account {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long accountId;
	
	@Enumerated(EnumType.STRING)
	private AccountType accountType;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	//@DateTimeFormat(pattern = "dd-mm-yyyy")
	private LocalDate accountDateOpened;
	
	private String accountFolder;
	
	private double accountBalance;
	
	@ManyToOne
	@JoinColumn(name ="branchId")
	private Branch accountBranch;
	
	@ManyToOne
	@JoinColumn(name = "customerId")
	private Customer accountCustomer;
	

}
