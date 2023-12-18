package book_my_show.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import book_my_show.dto.FilmDeatails;
import book_my_show.dto.Theater;
import book_my_show.dto.TheaterShows;
import book_my_show.dto.setShow;

@Component
public class TheaterDao {

	@Autowired
	EntityManagerFactory factory;

	public void save(Theater theater) {
       
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		transaction.begin();
		manager.persist(theater);
		transaction.commit();

	}

	public Theater login(String username) {
		
		EntityManager manager=factory.createEntityManager();
		
		List<Theater> theaters= manager.createQuery("select x from Theater x where username=?1").setParameter(1, username)
				.getResultList();
		if(theaters.isEmpty()){
			return null;
		}
		return theaters.get(0);
		
	}

	public TheaterShows saveloc(TheaterShows shows) {
		// TODO Auto-generated method stub
	       
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();

			transaction.begin();
			manager.persist(shows);
			transaction.commit();
			return shows;
			
	}

	
	public void update(Theater theater, TheaterShows shows2) {
		// TODO Auto-generated method stub
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		manager.merge(theater);
		manager.merge(shows2);
		transaction.commit();
		
	}

	public void update1(Theater theater) {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		manager.merge(theater);
		transaction.commit();
	}

	public void set(setShow show) {
		// TODO Auto-generated method stub
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(show);
		transaction.commit();
	}



	

}
