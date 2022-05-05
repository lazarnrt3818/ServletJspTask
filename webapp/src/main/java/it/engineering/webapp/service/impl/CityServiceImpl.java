package it.engineering.webapp.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import it.engineering.webapp.converter.impl.CityConverterDtoEntity;
import it.engineering.webapp.domain.CityEntity;
import it.engineering.webapp.domain.ManufacturerEntity;
import it.engineering.webapp.domain.dto.CityDto;
import it.engineering.webapp.domain.dto.ManufacturerDto;
import it.engineering.webapp.repository.CityRepository;
import it.engineering.webapp.repository.JpaCrudRepository;
import it.engineering.webapp.service.CityService;

@Component
@Transactional
public class CityServiceImpl implements CityService {

	@Autowired
	@Qualifier("cityRepository")
	private JpaCrudRepository<CityEntity, Long> cityRepository;

	@Autowired
	private CityConverterDtoEntity cityConverter;

	@Override
	public void save(CityDto city) {
		cityRepository.save(cityConverter.toEntity(city));
	}

	@Override
	public Optional<CityDto> find(Long id) {
		CityEntity entity = cityRepository.getById(id).orElse(null);

		if (entity != null) {
			return Optional.of(cityConverter.toDto(entity));
		} else
			return null;
	}

	@Override
	public void remove(Long id) {
		cityRepository.delete(id);
	}

	@Override
	public List<CityDto> findAll() {
		List<CityDto> list = new ArrayList<>();

		for (CityEntity city : cityRepository.getAll()) {
			list.add(cityConverter.toDto(city));
		}

		return list;
	}

	@Override
	public void update(CityDto city) {
		cityRepository.update(cityConverter.toEntity(city));
	}

}
