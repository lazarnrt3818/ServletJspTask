package it.engineering.webapp.service;

import java.util.List;
import java.util.Optional;
import it.engineering.webapp.domain.CityEntity;
import it.engineering.webapp.domain.dto.CityDto;

public interface CityService {
	public void save(CityDto manufacturer);
	public Optional<CityDto> find(Long id);
	public void remove(Long id);
	public List<CityDto> findAll();
	public void update(CityDto manufacturer);
}
