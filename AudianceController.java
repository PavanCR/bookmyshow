package book_my_show.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import book_my_show.dao.AudianceDao;
import book_my_show.dto.Audiance;


@Controller
public class AudianceController {

	@Autowired
	AudianceDao dao;
	
	@PostMapping("audianceSignup")
	public ModelAndView audianceSave(@ModelAttribute Audiance audiance){
		
		dao.save(audiance);
		ModelAndView view = new ModelAndView();
		view.setViewName("AudianceLogin.jsp");
		view.addObject("msg", "Account got Created  Plase Login Here");
		return view;
		
	}
	@PostMapping("audianceLogin")
	public ModelAndView loginaudiance(@RequestParam String email, @RequestParam String password ){
		
		Audiance audiance=dao.login(email);
		ModelAndView view = new ModelAndView();
		
		if(audiance!=null){
		
			if(password.equals(audiance.getPassword())){
				view.setViewName("audianceHome.jsp");
				view.addObject("msg", "Login SuccessFull Fill The show Timings");
			}
			else{
				view.setViewName("AudianceLogin.jsp");
				view.addObject("msg", "Enter Propper PassWord");
			}
		}
		else{
			view.setViewName("AudianceLogin.jsp");
			view.addObject("msg", "Enter Proper user Name ");
		}
		
		return view;
		
		
	}
	
	
}
