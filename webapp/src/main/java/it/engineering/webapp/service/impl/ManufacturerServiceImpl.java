package it.engineering.webapp.service.impl;

import java.util.List;
import java.util.Optional;

import it.engineering.webapp.domain.Manufacturer;
import it.engineering.webapp.repository.ManufacturerRepository;
import it.engineering.webapp.service.ManufacturerService;

public class ManufacturerServiceImpl implements ManufacturerService {

	private ManufacturerRepository manufacturerRepo;
	
	public ManufacturerServiceImpl() {
		manufacturerRepo = new ManufacturerRepository();
	}
	
	@Override
	public void save(Manufacturer manufacturer) {
		manufacturerRepo.save(manufacturer);
	}

	@Override
	public Optional<Manufacturer> find(Long id) {
		return manufacturerRepo.getById(id);
	}

	@Override
	public void remove(Long id) {
		manufacturerRepo.delete(id);
	}

	@Override
	public List<Manufacturer> findAll() {
		return manufacturerRepo.getAll();
	}

	@Override
	public void update(Manufacturer manufacturer) {
		manufacturerRepo.update(manufacturer);
	}

}
