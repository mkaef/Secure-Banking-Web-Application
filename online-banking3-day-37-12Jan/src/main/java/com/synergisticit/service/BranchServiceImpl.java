package com.synergisticit.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.synergisticit.domain.Branch;
import com.synergisticit.repository.BranchRepository;


@Service(value="branchService")
public class BranchServiceImpl implements BranchService {
	
	@Autowired BranchRepository branchRepository;

	@Override
	public Branch saveBranch(Branch branch) {
	return branchRepository.save(branch);
		
		
		
	}

	@Override
	public Branch getBranchById(Long branchId) {
	
	return branchRepository.getById(branchId);
	
	}

	@Override
	public List<Branch> getAllbranches() {
		
		return branchRepository.findAll();
	}

	@Override
	public Branch  updateById(Long branchId) {
		
		return branchRepository.findById(branchId).get();
	}

	@Override
	public void deleteById(Long branchId) {
		branchRepository.deleteById(branchId);;
		
	}

	
	

}
