package book_my_show.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;
@Entity
@Component
public class Theater {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String theatername;
	private String username;
	private String password;
	@OneToOne
	private TheaterShows shows;
	
	@ManyToMany
	List<FilmDeatails> deatails;
	
	public TheaterShows getShows() {
		return shows;
	}
	public void setShows(TheaterShows shows) {
		this.shows = shows;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTheatername() {
		return theatername;
	}
	public void setTheatername(String theatername) {
		this.theatername = theatername;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<FilmDeatails> getDeatails() {
		return deatails;
	}
	public void setDeatails(List<FilmDeatails> deatails) {
		this.deatails = deatails;
	}
	
	
}
