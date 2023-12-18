package book_my_show.controller;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedHashSet;
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

import book_my_show.dto.Theater;
import book_my_show.dto.TheaterShows;
import book_my_show.dto.setShow;

@Controller
public class TheaterController {

	@Autowired
	TheaterDao dao;

	@Autowired
	Theater theater;

	@Autowired
	ProducerDao dao2;

	@Autowired
	FilmDeatails filmDeatails;

	@PostMapping("theaterSignup")

	public ModelAndView saveTheaters(@ModelAttribute Theater theater) {

		dao.save(theater);
		ModelAndView andView = new ModelAndView();
		andView.setViewName("Theaters.jsp");
		andView.addObject("msg", "Theater Owner " + "'" + theater.getTheatername() + "'" + " Account Got created");
		return andView;

	}

	@PostMapping("login")

	public ModelAndView loginTheater(@RequestParam String username, @RequestParam String password,
			HttpSession session) {

		Theater theater = dao.login(username);
		ModelAndView view = new ModelAndView();

		if (theater != null) {
			session.setAttribute("theater", theater);
			if (password.equals(theater.getPassword())) {
				view.setViewName("setShowTiming.jsp");
				view.addObject("msg", "Login SuccessFull Fill The show Timings");
				view.addObject("theater", theater.getTheatername());
			} else {
				view.setViewName("Theaters.jsp");
				view.addObject("msg", "Enter Propper PassWord");
			}
		} else {
			view.setViewName("Theaters.jsp");
			view.addObject("msg", "Enter Proper user Name ");
		}

		return view;

	}

	@RequestMapping("setTiming")
	public ModelAndView savelocation(@ModelAttribute TheaterShows shows, HttpSession session) {
		Theater theater = (Theater) session.getAttribute("theater");
		session.setAttribute("showss", shows);
		ModelAndView view = new ModelAndView();
		TheaterShows shows2 = (TheaterShows) session.getAttribute("showss");

		if (theater.getShows() == null) {
			dao.saveloc(shows);
			theater.setShows(shows2);

			shows2.setTheater(theater);
			dao.update(theater, shows2);

			view.setViewName("Theaters.jsp");
			return view.addObject("msg", "Theater Deatils Add");
		} else {
			view.setViewName("Theaters.jsp");
			return view.addObject("msg", "show Deatils is Already Exist to '" + theater.getTheatername() + "'");
		}

	}

	@RequestMapping("buymovie")
	public ModelAndView buyMovie(@RequestParam int id, HttpSession session) {
		ModelAndView view = new ModelAndView();
		Theater theater = (Theater) session.getAttribute("theater");
		FilmDeatails deatails = dao2.getFilm(id);
		List<FilmDeatails> list1=dao2.getAllMovies();
		Set<FilmDeatails> set=new LinkedHashSet<FilmDeatails>(list1);

		List<FilmDeatails> list = theater.getDeatails();
		List<Theater> list2 = deatails.getTheater();
		
		if (!set.contains(deatails.getId())) {
			list.add(deatails);
			list2.add(theater);
			theater.setDeatails(list);
			deatails.setTheater(list2);
			dao.update1(theater);
			dao2.update2(deatails);

			view.setViewName("moviesRequest.jsp");
			view.addObject("films", list1);
			return view.addObject("msg", "Movie Added");
		} else {

			view.setViewName("setShowTiming.jsp");
			return view.addObject("msg", "Movie Alrady Added");
		}
	}
	@RequestMapping("broughtMovies")
	public ModelAndView movies(HttpSession session){
		ModelAndView view= new ModelAndView();
		
		Theater  theater=(Theater) session.getAttribute("theater");
		List<FilmDeatails> list=theater.getDeatails();
		Set<FilmDeatails> set=new LinkedHashSet<FilmDeatails>(list);
		view.setViewName("borughtMovies.jsp");
		return view.addObject("brought", set);
	}
	
	@GetMapping("showttime")
public ModelAndView movie(@ModelAttribute setShow show,  Date showdate, Time showtime) {
         show.setShowdate(showdate);
         show.setShowtime(showtime);
	dao.set(show);
	ModelAndView andView=new ModelAndView();
	andView.setViewName( "setTime.jsp");
    return andView.addObject("msg", "Added");

}
}
