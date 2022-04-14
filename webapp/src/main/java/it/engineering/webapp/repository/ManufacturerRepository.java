package it.engineering.webapp.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import it.engineering.webapp.domain.Manufacturer;
import it.engineering.webapp.domain.User;
import it.engineering.webapp.util.MyEntityManagerFactory;

public class ManufacturerRepository implements JpaCrudRepository<Manufacturer, Long>{

	@Override
	public List<Manufacturer> getAll() {
		EntityManager manager = MyEntityManagerFactory.getInstance().createEntityManager();
		Query query = manager.createQuery("SELECT c FROM User c");
		
		@SuppressWarnings("unchecked")
		List<Manufacturer> manufacturers = query.getResultList();
		
		return manufacturers;
	}

	@Override
	public void save(Manufacturer manufacturer) {
		EntityManager manager = MyEntityManagerFactory.getInstance().createEntityManager();
		manager.getTransaction().begin();
		manager.persist(manufacturer);
		manager.getTransaction().commit();
		manager.close();
	}

	@Override
	public Optional<Manufacturer> getById(Long id) {
		EntityManager manager = MyEntityManagerFactory.getInstance().createEntityManager();
		Manufacturer manufacturer = manager.find(Manufacturer.class, id);
		
		manager.close();
		return Optional.of(manufacturer);
	}

	@Override
	public void delete(Long id) {
		EntityManager manager = MyEntityManagerFactory.getInstance().createEntityManager();
		Manufacturer manufacturer = manager.find(Manufacturer.class, id);
		
		manager.getTransaction().begin();
		manager.remove(manufacturer);
		manager.getTransaction().commit();
		manager.close();
	}

	@Override
	public void update(Manufacturer t) {
		EntityManager manager = MyEntityManagerFactory.getInstance().createEntityManager();
	
		Manufacturer manufacturer = manager.find(Manufacturer.class, t.getId());
		
		manager.getTransaction().begin();
		if(manufacturer != null) {
			manufacturer.setAddress(t.getAddress());
			manufacturer.setCid(t.getCid());
			manufacturer.setPib(t.getPib());
			manufacturer.setCity(t.getCity());
		}
		manager.getTransaction().commit();
		manager.close();
	}


}
