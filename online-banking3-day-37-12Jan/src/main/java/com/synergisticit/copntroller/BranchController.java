package com.synergisticit.copntroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.synergisticit.domain.Branch;
import com.synergisticit.service.BranchService;


import jakarta.validation.Valid;

@Controller
public class BranchController {
	@Autowired BranchService branchService;
	
	@RequestMapping("/branchForm")
	public ModelAndView branchForm(Branch branch) {
		ModelAndView mav = new ModelAndView("branchForm");
		mav.addObject("branches", branchService.getAllbranches());
		//System.out.println("1.branchForm");
		return mav;
	}
	
	@PostMapping("/saveBranch")
	public ModelAndView saveBranch(@Valid @ModelAttribute Branch branch, BindingResult br, Model model) {
		ModelAndView mav = new ModelAndView("branchForm");// save Branch to database
		//System.out.println("2.branchForm");
		if(br.hasErrors()) {
			mav.addObject("branches",branchService.getAllbranches());
			mav.setViewName("branchForm");
			return mav;
		}else {
			branchService.saveBranch(branch);
			mav.addObject("branches",branchService.getAllbranches());
			return mav;
		}
		
	
	}
	
	@GetMapping("/updateBranch")
	public String updateBranch(Branch branch,Model model) {
		
		
		 branch =  branchService.getBranchById(branch.getBranchId());
		model.addAttribute("branch", branch);
		
		model.addAttribute("branches", branchService.getAllbranches());
		return "branchForm";
	}
	
	@GetMapping("/deleteBranch")
	public String deleteBranch(Branch branch,Model model) {
	branchService.deleteById(branch.getBranchId());
		//model.addAttribute("branches", branch);
	
	
		return "redirect:branchForm";
	}
 
}
