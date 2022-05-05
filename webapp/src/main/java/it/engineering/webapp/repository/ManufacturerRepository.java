package it.engineering.webapp.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.hibernate.query.spi.QueryParameterBindingTypeResolver;
import org.springframework.stereotype.Repository;

import it.engineering.webapp.domain.ManufacturerEntity;

@Repository("manufacturerRepository")
@Transactional(value = TxType.MANDATORY)
public class ManufacturerRepository implements JpaCrudRepository<ManufacturerEntity, Long>{

	@PersistenceContext
	private EntityManager entityManager;;
	
	@Override
	public List<ManufacturerEntity> getAll() {
		Query query = entityManager.createQuery("SELECT m FROM ManufacturerEntity m");
		
		@SuppressWarnings("unchecked")
		List<ManufacturerEntity> manufacturers = query.getResultList();
		
		return manufacturers;
	}

	@Override
	public void save(ManufacturerEntity manufacturer) {
		entityManager.persist(manufacturer);
		entityManager.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Optional<ManufacturerEntity> getById(Long id) {
		ManufacturerEntity manufacturer = entityManager.find(ManufacturerEntity.class, id);
		
		Query query = entityManager.createQuery("SELECT m FROM ManufacturerEntity m WHERE m.pib = "+id);
		
		entityManager.close();
		return Optional.of((ManufacturerEntity)query.getSingleResult());
	}

	
	// Get manufacturer by PIB, then delete it
	@Override
	public void delete(Long id) {
		ManufacturerEntity manufacturer = (ManufacturerEntity) entityManager.createQuery("SELECT m FROM ManufacturerEntity m WHERE pib ="+id).getSingleResult();
		System.out.println("DELETE : " + manufacturer);
		entityManager.remove(manufacturer);
		entityManager.close();
	}

	@Override
	public void update(ManufacturerEntity t) {
	
		ManufacturerEntity manufacturer = (ManufacturerEntity) entityManager.createQuery("SELECT m FROM ManufacturerEntity m WHERE pib ="+t.getPib()).getSingleResult();
		
		if(manufacturer != null) {
			manufacturer.setAddress(t.getAddress());
			manufacturer.setCid(t.getCid());
			manufacturer.setPib(t.getPib());
			manufacturer.setCity(t.getCity());
		}
		entityManager.close();
	}


}
