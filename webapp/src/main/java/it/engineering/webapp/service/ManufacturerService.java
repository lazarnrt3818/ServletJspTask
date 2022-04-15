package it.engineering.webapp.service;

import java.util.List;
import java.util.Optional;

import it.engineering.webapp.domain.Manufacturer;

public interface ManufacturerService {
	public void save(Manufacturer manufacturer);
	public Optional<Manufacturer> find(Long id);
	public void remove(Long id);
	public List<Manufacturer> findAll();
	public void update(Manufacturer manufacturer);
}
