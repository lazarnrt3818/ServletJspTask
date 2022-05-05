package it.engineering.webapp.service;

import java.util.List;
import java.util.Optional;

import it.engineering.webapp.domain.ManufacturerEntity;
import it.engineering.webapp.domain.dto.ManufacturerDto;

public interface ManufacturerService {
	public void save(ManufacturerDto manufacturer);
	public Optional<ManufacturerDto> find(Long id);
	public void remove(Long id);
	public List<ManufacturerDto> findAll();
	public void update(ManufacturerDto manufacturer);
}
