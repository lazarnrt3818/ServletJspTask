package it.engineering.webapp.service;

import java.util.List;
import java.util.Optional;
import it.engineering.webapp.domain.City;

public interface CityService {
	public void save(City manufacturer);
	public Optional<City> find(Long id);
	public void remove(Long id);
	public List<City> findAll();
	public void update(City manufacturer);
}
