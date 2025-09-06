package com.synergisticit.domain;



import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BankTransaction {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long bankTransactionId;
	
	public Long getBankTransactionId() {
		return bankTransactionId;
	}

	public void setBankTransactionId(Long bankTransactionId) {
		this.bankTransactionId = bankTransactionId;
	}

	private long bankTransactionFromAccount;
	
	private long bankTransactionToAccount;
	
	private double bankTransactionAmount;
	
	@Enumerated(EnumType.STRING)
	private TransactionType bankTransactionType;
	
	private LocalDateTime bankTransactionDateTime;
	
	private String comment;

}
