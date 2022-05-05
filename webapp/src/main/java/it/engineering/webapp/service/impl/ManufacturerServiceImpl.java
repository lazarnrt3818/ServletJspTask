package it.engineering.webapp.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import it.engineering.webapp.converter.impl.ManufacturerConverterDtoEntity;
import it.engineering.webapp.domain.ManufacturerEntity;
import it.engineering.webapp.domain.dto.ManufacturerDto;
import it.engineering.webapp.repository.JpaCrudRepository;
import it.engineering.webapp.repository.ManufacturerRepository;
import it.engineering.webapp.service.ManufacturerService;


@Service
@Transactional
public class ManufacturerServiceImpl implements ManufacturerService {

	@Autowired
	@Qualifier("manufacturerRepository")
	private JpaCrudRepository<ManufacturerEntity, Long> manufacturerRepo;
	
	@Autowired
	private ManufacturerConverterDtoEntity manufacturerConverter;
	
	@Override
	public void save(ManufacturerDto manufacturer) {
		manufacturerRepo.save(manufacturerConverter.toEntity(manufacturer));
	}

	@Override
	public Optional<ManufacturerDto> find(Long id) {
		ManufacturerEntity entity = manufacturerRepo.getById(id).orElse(null);
		
		if(entity !=null) {
			return Optional.of(manufacturerConverter.toDto(entity));
		}
		else 
			return null;
	}

	@Override
	public void remove(Long id) {
		manufacturerRepo.delete(id);
	}

	@Override
	public List<ManufacturerDto> findAll() {
		List<ManufacturerDto> list = new ArrayList<>();
		
		for(ManufacturerEntity manufacturer : manufacturerRepo.getAll()) {
			list.add(manufacturerConverter.toDto(manufacturer));
		}
		
		return list;
	}

	@Override
	public void update(ManufacturerDto manufacturer) {
		manufacturerRepo.update(manufacturerConverter.toEntity(manufacturer));
	}

}
