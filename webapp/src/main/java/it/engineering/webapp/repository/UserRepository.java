package it.engineering.webapp.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import it.engineering.webapp.domain.UserEntity;

@Repository("userRepository")
@Transactional(value = TxType.MANDATORY)
public class UserRepository implements JpaCrudRepository<UserEntity, Long> {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	public void save(UserEntity t) {
		entityManager.persist(t);
		entityManager.close();
	}

	@Override
	public Optional<UserEntity> getById(Long id) {
		UserEntity user = entityManager.find(UserEntity.class, id);
		
		entityManager.close();
		return Optional.of(user);
	}

	@Override
	public void delete(Long id) {
		
		UserEntity user = entityManager.find(UserEntity.class, id);
		
		entityManager.remove(user);
		entityManager.close();
		
	}

	@Override
	public List<UserEntity> getAll() {
		Query query = entityManager.createQuery("SELECT c FROM UserEntity c");
		
		@SuppressWarnings("unchecked")
		List<UserEntity> users = query.getResultList();
		
		return users;
	}

	@Override
	public void update(UserEntity t) {
		// TODO Auto-generated method stub
		
	}
	
	
}
