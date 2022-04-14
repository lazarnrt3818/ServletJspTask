package it.engineering.webapp.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import it.engineering.webapp.domain.Manufacturer;
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
	public void save(Manufacturer t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Manufacturer> getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}


}