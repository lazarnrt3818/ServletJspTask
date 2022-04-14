package it.engineering.webapp.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.Query;

import it.engineering.webapp.domain.User;
import it.engineering.webapp.util.MyEntityManagerFactory;

public class UserRepository implements JpaCrudRepository<User, Long> {

	
	
	@Override
	public void save(User t) {
		EntityManager manager = MyEntityManagerFactory.getInstance().createEntityManager();
		manager.getTransaction().begin();
		manager.persist(t);
		manager.getTransaction().commit();
		manager.close();
	}

	@Override
	public Optional<User> getById(Long id) {
		EntityManager manager = MyEntityManagerFactory.getInstance().createEntityManager();
		User user = manager.find(User.class, id);
		
		manager.close();
		return Optional.of(user);
	}

	@Override
	public void delete(Long id) {
		EntityManager manager = MyEntityManagerFactory.getInstance().createEntityManager();
		
		User user = manager.find(User.class, id);
		
		manager.getTransaction().begin();
		manager.remove(user);
		manager.getTransaction().commit();
		manager.close();
		
	}

	@Override
	public List<User> getAll() {
		EntityManager manager = MyEntityManagerFactory.getInstance().createEntityManager();
		Query query = manager.createQuery("SELECT c FROM User c");
		
		@SuppressWarnings("unchecked")
		List<User> users = query.getResultList();
		
		return users;
	}
	
	
}
