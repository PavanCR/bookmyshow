package book_my_show.helper;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
@Configuration
@ComponentScan("book_my_show")
public class showConfig {

	@Bean
	public EntityManagerFactory getEMF(){
		return Persistence.createEntityManagerFactory("show");
	}
}
