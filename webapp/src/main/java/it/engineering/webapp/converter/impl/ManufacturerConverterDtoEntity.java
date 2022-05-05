package it.engineering.webapp.converter.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.engineering.webapp.converter.ConverterDtoEntity;
import it.engineering.webapp.domain.ManufacturerEntity;
import it.engineering.webapp.domain.dto.ManufacturerDto;


@Component
public class ManufacturerConverterDtoEntity implements ConverterDtoEntity<ManufacturerDto, ManufacturerEntity>{

	@Autowired
	private CityConverterDtoEntity cityConverter;
	
	@Override
	public ManufacturerDto toDto(ManufacturerEntity entity) {
		return new ManufacturerDto(
				entity.getPib(),
				entity.getCid(),
				entity.getAddress(),
				cityConverter.toDto(entity.getCity())
				);
	}

	@Override
	public ManufacturerEntity toEntity(ManufacturerDto dto) {
		return new ManufacturerEntity(
					dto.getPib(),
					dto.getCid(),
					dto.getAddress(),
					cityConverter.toEntity(dto.getCity())
				);
	}

}
