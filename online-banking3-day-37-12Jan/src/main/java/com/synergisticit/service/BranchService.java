package com.synergisticit.service;

import java.util.List;

import com.synergisticit.domain.Branch;



public interface BranchService {
	
	Branch saveBranch(Branch branch);
	Branch getBranchById(Long  branchId);
	List<Branch> getAllbranches();
	Branch updateById(Long branchId);
	void deleteById(Long branchId);
	
	

}
