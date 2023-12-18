package book_my_show.dto;

import java.sql.Date;
import java.sql.Time;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity 
@Component
public class setShow {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
     private int id;
	private Date  showdate;
	private Time showtime;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getShowdate() {
		return showdate;
	}
	public void setShowdate(Date showdate) {
		this.showdate = showdate;
	}
	public Time getShowtime() {
		return showtime;
	}
	public void setShowtime(Time showtime) {
		this.showtime = showtime;
	}
	
		
}
