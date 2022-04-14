package it.engineering.webapp.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import it.engineering.webapp.domain.City;
import it.engineering.webapp.domain.User;
import it.engineering.webapp.util.MyEntityManagerFactory;

public class CityRepository implements JpaCrudRepository<City, Long> {

	@Override
	public void save(City t) {
		EntityManager manager = MyEntityManagerFactory.getInstance().createEntityManager();
		manager.getTransaction().begin();
		manager.persist(t);
		manager.getTransaction().commit();
		manager.close();
	}

	@Override
	public Optional<City> getById(Long id) {
		EntityManager manager = MyEntityManagerFactory.getInstance().createEntityManager();
		City user = manager.find(City.class, id);
		
		manager.close();
		return Optional.of(user);
	}

	@Override
	public void delete(Long id) {
		EntityManager manager = MyEntityManagerFactory.getInstance().createEntityManager();

		City user = manager.find(City.class, id);

		manager.getTransaction().begin();
		manager.remove(user);
		manager.getTransaction().commit();
		manager.close();
	}

	@Override
	public List<City> getAll() {
		EntityManager manager = MyEntityManagerFactory.getInstance().createEntityManager();
		Query query = manager.createQuery("SELECT c FROM City c");
		
		@SuppressWarnings("unchecked")
		List<City> cities = query.getResultList();
		
		return cities;
	}

	@Override
	public void update(City t) {
		// TODO Auto-generated method stub
		
	}

}
