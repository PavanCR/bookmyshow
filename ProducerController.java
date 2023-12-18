package book_my_show.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import book_my_show.dao.ProducerDao;
import book_my_show.dao.TheaterDao;
import book_my_show.dto.FilmDeatails;
import book_my_show.dto.Producer;
import book_my_show.dto.Theater;

@Controller
public class ProducerController {

	@Autowired
	ProducerDao dao;
	
	@Autowired
	TheaterDao dao2;
	
	@Autowired
	Theater theater;
	@Autowired
	FilmDeatails filmDeatails;

	@PostMapping("producerSignup")
	public ModelAndView saveProducer(@ModelAttribute Producer producer) {
		
		ModelAndView view = new ModelAndView();
		dao.save(producer);

		
		view.setViewName("ProducerLogin.jsp");
		view.addObject("msg", "Producer " + "'" + producer.getProducername() + "'" + " Account Got Created");
		
		return view;
		
	}
	@PostMapping("producerlogin")
	public ModelAndView loginproducer(@RequestParam String username, @RequestParam String password, HttpSession session ){
		
		Producer producer=dao.login(username);
		ModelAndView view = new ModelAndView();
		session.setAttribute("producer1", producer);
		if(producer!=null){

			if(password.equals(producer.getPassword())){
				view.setViewName("ProducerHome.jsp");
				view.addObject("msg", "Login SuccessFull Fill The show Deatails");
				view.addObject("producer",  producer.getProducername());
				view.addObject("filmTital",  producer.getTitle());

			}
			else{
				view.setViewName("ProducerLogin.jsp");
				view.addObject("msg", "Enter Propper PassWord");
			}
		}
		else{
			view.setViewName("ProducerLogin.jsp");
			view.addObject("msg", "Enter Proper user Name ");
		}
		
		return view;
			
	}
	
	@PostMapping("addfilms")
	public ModelAndView addFilm(@ModelAttribute FilmDeatails deatails, HttpSession session) {
		deatails.setStatus("Avilable");
		ModelAndView view = new ModelAndView();
	
		// FilmDeatails deatails2 =dao.getFilm1(deatails.getFilm());
		// deatails//if(!deatails2.getFilm().equals(deatails.getFilm())){
		dao.saveFilm(deatails);
          
		view.setViewName("ProducerLogin.jsp");
		return view.addObject("msg", "Film Deatails Are Added");
		//  }
		// view.setViewName("ProducerLogin.jsp");
		// return view.addObject("msg","Film Deatails Already Added");

	}
	@GetMapping("moviesRequest")
	public ModelAndView movies(){
		List<FilmDeatails> list=dao.getAllMovies();
		ModelAndView view = new ModelAndView();
		if(list==null){
			view.setViewName("setShowTiming.jsp");
			return view.addObject("msg", "No Films Avilable");
		}
		view.setViewName("moviesRequest.jsp");
		 return view.addObject("films", list);
	}
	 
	
	
}
