package it.engineering.webapp.service.impl;

import java.util.List;
import java.util.Optional;

import it.engineering.webapp.domain.City;
import it.engineering.webapp.repository.CityRepository;
import it.engineering.webapp.service.CityService;

public class CityServiceImpl implements CityService {

	private CityRepository cityRepository;

	public CityServiceImpl() {
		cityRepository = new CityRepository();
	}

	@Override
	public void save(City city) {
		cityRepository.save(city);
	}

	@Override
	public Optional<City> find(Long id) {
		return cityRepository.getById(id);
	}

	@Override
	public void remove(Long id) {
		cityRepository.delete(id);
	}

	@Override
	public List<City> findAll() {
		return cityRepository.getAll();
	}

	@Override
	public void update(City city) {
		cityRepository.update(city);
	}

}
