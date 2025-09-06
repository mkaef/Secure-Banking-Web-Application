package com.synergisticit.copntroller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.synergisticit.domain.BankTransaction;
import com.synergisticit.service.BankTransactionService;

import jakarta.validation.Valid;

@Controller
public class BankTransactionController {
	@Autowired BankTransactionService bankTransactionService;
	
	@RequestMapping("/transactionForm")
	public ModelAndView transactionForm(BankTransaction bankTransaction) {
		ModelAndView mav = new ModelAndView("transactionForm");
		mav.addObject("transactions", bankTransactionService.getAllTransactions());
		return mav;
	}
	
	@RequestMapping("/saveTransaction")
	public ModelAndView saveTransaction(@Valid @ModelAttribute BankTransaction bankTransaction, BindingResult br, Model model) {
		ModelAndView mav = new ModelAndView("transactionForm");
		if(br.hasErrors()) {
			mav.addObject("transactions", bankTransactionService.getAllTransactions());
			mav.setViewName("transactionForm");
			return mav;
			
		}else {
			bankTransactionService.saveTransaction(bankTransaction);
			mav.addObject("transactions", bankTransactionService.getAllTransactions());
			return mav;
		}
         
}
	@RequestMapping("/updateTransaction")
	public String updateTransaction(BankTransaction bankTransaction, Model model) {
	bankTransaction =	bankTransactionService.getTransactionId(bankTransaction.getBankTransactionId());
	model.addAttribute("bankTransaction", bankTransaction);
	model.addAttribute("transactions", bankTransactionService.getAllTransactions());
		return "transactionForm";
	}
	@RequestMapping("/deleteTransanction")
	public String deleteTransanction(BankTransaction bankTransaction, Model model) {
		bankTransactionService.deleteTransactionById(bankTransaction.getBankTransactionId());
		return "redirect:transactionForm";
	}
	

}