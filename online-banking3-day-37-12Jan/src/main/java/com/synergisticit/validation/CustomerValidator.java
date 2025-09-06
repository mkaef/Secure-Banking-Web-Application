package com.synergisticit.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.synergisticit.domain.Branch;
import com.synergisticit.domain.Customer;

public class CustomerValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return CustomerValidator.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Customer c = (Customer) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "customerId", "customerId.empty","customerId should not be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "customerName", "customerName.empty","customerName should not be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "customerGender", "genderAddress.empty","genderAddress should not be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "customerAddress", "customerAddress.empty","customerAddress should not be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "customerAccount", "customerAccount.empty","customerAccount should not be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "customerrealId", "customerRealId.empty","customerRealId should not be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "customerMobileNo", "customerMobileNo.empty","customerMobileNo should not be empty");
		
		if(c.getCustomerName().length()<2) {
			errors.rejectValue("customerName", "customerName.minLength", "CustomerName should not be less than 2 characters.");
		}
		
		if(c.getCustomerName().length()>100) {
			errors.rejectValue("customerName", "customerName.maxLength", "CustomerName should not be greater than 100 characters.");
		}
		
	
		
	}

}
