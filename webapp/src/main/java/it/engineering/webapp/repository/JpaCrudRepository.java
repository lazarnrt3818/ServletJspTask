package it.engineering.webapp.repository;

import java.util.List;
import java.util.Optional;

public interface JpaCrudRepository<T,ID> {
	
	public void save(T t);
	public Optional<T> getById(ID id);
	public void delete(ID id);
	public List<T> getAll();
	public void update(T t);
}
