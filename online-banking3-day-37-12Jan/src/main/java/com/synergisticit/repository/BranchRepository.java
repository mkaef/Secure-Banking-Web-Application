package com.synergisticit.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.synergisticit.domain.Branch;

@Repository("branchRepository")
public interface BranchRepository extends JpaRepository<Branch, Long> {

	

}
