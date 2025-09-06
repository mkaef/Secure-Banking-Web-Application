package com.synergisticit.copntroller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.synergisticit.domain.Customer;
import com.synergisticit.service.CustomerService;

@Controller
public class CustomerController {
	@Autowired CustomerService customerService;
	
	@RequestMapping("/customerForm")
	public ModelAndView customerForm(Customer customer) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("customrs", customerService.findAll());
		
		return mav;
	}
	@RequestMapping("/saveCustomer")
	public ModelAndView saveCustomer(Customer customer, BindingResult br, Model model) {
		ModelAndView mav = new ModelAndView("customerForm");
		if(br.hasErrors()) {
			mav.addObject("customrs", customerService.findAll());
			mav.setViewName("customerForm");
			return mav;
		}else {
			customerService.save(customer);
			mav.addObject("customrs", customerService.findAll());
			return mav;
			
		}
		
	}
	@RequestMapping("/updateCustomer")
	public String updateCustomer(Customer customer, Model model) {
	customer =	 customerService.updateById(customer.getCustomerId());
	model.addAttribute("customer" ,customer);
		
		return "customerForm";
	}
	
	@RequestMapping("/deleteCustomer")
	public String deleteCustomer(Customer customer, Model model) {
		
		customerService.deleteById(customer.getCustomerId());
		return "redirect:customerForm";
	}
	
	

}
