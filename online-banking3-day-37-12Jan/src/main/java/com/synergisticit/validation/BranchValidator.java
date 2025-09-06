package com.synergisticit.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.synergisticit.domain.Branch;





@Component
public class BranchValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		
		return Branch.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Branch b = (Branch) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "branchId", "branchId.empty","branchId should not be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "branchName", "branchName.empty","branchName should not be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "branchAddress", "branchAddress.empty","branchAddress should not be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "branchAccount", "branchAccount.empty","branchAccount should not be empty");
		
		if(b.getBranchName().length()<2) {
			errors.rejectValue("branchName", "branchName.minLength", "BranchName should not be less than 2 characters.");
		}
		
		if(b.getBranchName().length()>100) {
			errors.rejectValue("branchName", "branchName.maxLength", "BranchName should not be greater than 100 characters.");
		}
		
	}

}
