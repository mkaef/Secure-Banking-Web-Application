package com.synergisticit.copntroller;


import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


import com.synergisticit.domain.User;
import com.synergisticit.service.RoleService;
import com.synergisticit.service.UserService;
import com.synergisticit.validation.UserValidator;

import jakarta.validation.Valid;

@Controller
public class UserController {
	@Autowired UserService userService;
	@Autowired RoleService roleService;
	@Autowired UserValidator userValidator;
	
	@InitBinder
	
	public void initBinder(WebDataBinder binder) {
		   binder.addValidators(userValidator);
	   }
	   
	  
	@RequestMapping("/userForm")
	public String userForm(User user, Model model,Principal principal) {
		model.addAttribute("users", userService.findAll());
		model.addAttribute("roles", roleService.findAll());
		if(principal !=null) // fixed issue: Cannot invoke "java.security.Principal.getName()" because "principal" is null
		model.addAttribute("loggedInUser", principal.getName());
		
		return "userForm";
	}
	
	@RequestMapping("/saveUser")
	public String saveUser(@Valid @ModelAttribute User user, BindingResult br, Model model) {
		System.out.println("1.br.hasErrors():"+br.hasErrors());
		model.addAttribute("users", userService.findAll());
		model.addAttribute("roles", roleService.findAll());
		if(br.hasErrors()) {
			model.addAttribute("hasErrors",true);
			System.out.println("2.br.hasErrors():"+br.hasErrors());
			return "userForm";
		}else {
			userService.save(user);
		}
		
		return "redirect:/userForm";
	}
	@RequestMapping("/update")
	public String updateUser(User user, Model model) {
		user = userService.findById(user.getUserId());
		user.setPassword("");
		model.addAttribute("user",user);
		model.addAttribute("retrievedRole",user.getRoles());
		model.addAttribute("users", userService.findAll());
		model.addAttribute("roles", roleService.findAll());
		
		
		return "userForm";
	}
	@RequestMapping("/delete")
	public String deleteUser(User user, Model model) {
		userService.deleteById(user.getUserId());
		return "redierct:userForm";
		
	}
	
}
