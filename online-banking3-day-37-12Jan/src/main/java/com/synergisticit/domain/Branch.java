package com.synergisticit.domain;

import java.util.ArrayList;
import java.util.List;



import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




@Entity // make class map with database table
@Setter
@Getter

@NoArgsConstructor
@AllArgsConstructor

@Table(name= "branch")
public class Branch {
 
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long branchId;

public Long getBranchId() {
	return branchId;
}

public void setBranchId(Long branchId) {
	this.branchId = branchId;
}

@NotEmpty
@Size(max = 100, min=2)
@Column(name="branchName")
private String branchName;

public String getBranchName() {
	return branchName;
}

public void setBranchName(String branchName) {
	this.branchName = branchName;
}

@Embedded
private Address branchAddress;

@OneToMany(mappedBy = "accountBranch")
private List<Account> branchAccounts = new ArrayList<>();




}
