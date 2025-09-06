package com.synergisticit.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.synergisticit.domain.BankTransaction;

public class BankTransactionValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		
		return BankTransaction.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		BankTransaction bt = (BankTransaction) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bankTransactionId", "bankTransactionId.empty","bankTransactionId should not be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bankTransactionFromAccount", "bankTransactionFromAccount.empty","bankTransactionFromAccount should not be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bankTransactionToAccount", "bankTransactionToAccount.empty","bankTransactionToAccount should not be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bankTransactionAmount", "bankTransactionAmount.empty","bankTransactionAmount should not be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bankTransactionType", "bankTransactionType.empty","bankTransactionType should not be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bankTransactionDateTime", "bankTransactionDateTime","bankTransactionDateTime should not be empty");
		
		
	}

}
