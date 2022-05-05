package it.engineering.webapp.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import it.engineering.webapp.domain.CityEntity;

@Repository("cityRepository")
@Transactional(value = TxType.MANDATORY)
public class CityRepository implements JpaCrudRepository<CityEntity, Long> {

	
	@PersistenceContext
	private EntityManager entityManager;
	

	@Override
	public void save(CityEntity t) {
		entityManager.persist(t);
		entityManager.close();
	}

	@Override
	public Optional<CityEntity> getById(Long id) {
		CityEntity user = entityManager.find(CityEntity.class, id);
		
		entityManager.close();
		return Optional.of(user);
	}

	@Override
	public void delete(Long id) {

		CityEntity user = entityManager.find(CityEntity.class, id);

		entityManager.remove(user);
		entityManager.close();
	}

	@Override
	public List<CityEntity> getAll() {
		Query query = entityManager.createQuery("SELECT c FROM CityEntity c");
		
		@SuppressWarnings("unchecked")
		List<CityEntity> cities = query.getResultList();
		
		return cities;
	}

	@Override
	public void update(CityEntity t) {
		// TODO Auto-generated method stub
		
	}

}
