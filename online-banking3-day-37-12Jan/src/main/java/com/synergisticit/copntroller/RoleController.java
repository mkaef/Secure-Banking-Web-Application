package com.synergisticit.copntroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.synergisticit.domain.Role;
import com.synergisticit.service.RoleService;

import ch.qos.logback.core.model.Model;

@Controller
public class RoleController {
	@Autowired RoleService roleService;
	
	@RequestMapping("/roleForm")
	public ModelAndView roleForm(Role role) {
		ModelAndView mav = new ModelAndView("roleForm");
		mav.addObject("roles", roleService.findAll());
		System.out.println("roleForm");
		return mav;
	}
	@RequestMapping("/saveRole")
	public ModelAndView saveRole(Role role, BindingResult br, Model model) {
		ModelAndView mav = new ModelAndView("roleForm");
		mav.setViewName("roleForm");
		if(br.hasErrors()) {
			mav.addObject("roles", roleService.findAll());
			
			return mav;
		}else {
		 roleService.saveRole(role);
		 mav.addObject("roles", roleService.findAll());
		}
		return mav;
	}

}
