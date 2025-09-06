package com.synergisticit.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long customerId;
	
	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	@NotEmpty
	private String customerName;
	
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@Enumerated
	private Gender gender;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate customerDOB;
	
	private String customerMobileNo;
	
	@Embedded
	private Address customerAddress;
	
    private String customerRealId;
    
    @OneToMany(mappedBy = "accountCustomer")
    private List<Account> customerAccounts = new ArrayList<>();
    
    @OneToOne
    @JoinColumn(name = "userId")
    private User user;
    
	
	

}
