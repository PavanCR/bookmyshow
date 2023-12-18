package book_my_show.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import book_my_show.dto.Audiance;

@Component
public class AudianceDao {

	@Autowired
	EntityManagerFactory factory;

	public void save(Audiance audiance) {

		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		transaction.begin();
		manager.persist(audiance);
		transaction.commit();

	}

	public Audiance login(String email) {
		EntityManager manager = factory.createEntityManager();
		List<Audiance> list= manager.createQuery("select x from Audiance x where email=?1").setParameter(1,email)
				.getResultList();
		if(list.isEmpty()){
			return null;
		}
		return list.get(0);
	}

}
