package book_my_show.dao;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.transaction.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import book_my_show.dto.FilmDeatails;
import book_my_show.dto.Producer;
import book_my_show.dto.Theater;

@Component
public class ProducerDao {

	@Autowired
	EntityManagerFactory factory;
	
	public void save(Producer producer) {
	
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		
		transaction.begin();
		manager.persist(producer);
		transaction.commit();
		
		
		
	}

	public Producer login(String username) {
		EntityManager manager=factory.createEntityManager();
		List<Producer> list = manager.createQuery("select x from Producer x where username=?1").setParameter(1, username)
				.getResultList();
		if(list.isEmpty()){
			return null;
		}
		return list.get(0);
	}


	public List<Producer> getAllproducerr() {
		// TODO Auto-generated method stub
		EntityManager manager=factory.createEntityManager();
		return manager.createQuery("select x from Producer x").getResultList();
	}

	public void saveFilm(FilmDeatails deatails) {
		// TODO Auto-generated method stub
		EntityManager manager= factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		manager.persist(deatails);
		transaction.commit();
	}

	public FilmDeatails getFilm1(String film) {
		EntityManager manager=factory.createEntityManager();
		List<FilmDeatails> list= manager.createQuery("select x from FilmDeatails x where film=?1").setParameter(1, film).getResultList();
		if(film.isEmpty()){
			return null;
		}
	return	list.get(0);
	}

	public List<FilmDeatails> getAllMovies() {
		
		EntityManager manager=factory.createEntityManager();
		List<FilmDeatails> deatails= manager.createQuery("select x from FilmDeatails x").getResultList();
		if(deatails.isEmpty()){
			return null;
		}
		return deatails;
	}

	public FilmDeatails getFilm(int id) {
		// TODO Auto-generated method stub
		EntityManager manager=factory.createEntityManager();
		return manager.find(FilmDeatails.class, id);
		
	}

	public void update2(FilmDeatails deatails) {
	
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		manager.merge(deatails);
		transaction.commit();
		
	}


}
