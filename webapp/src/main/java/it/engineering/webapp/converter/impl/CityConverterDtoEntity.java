package it.engineering.webapp.converter.impl;

import org.springframework.stereotype.Component;

import it.engineering.webapp.converter.ConverterDtoEntity;
import it.engineering.webapp.domain.CityEntity;
import it.engineering.webapp.domain.dto.CityDto;

@Component
public class CityConverterDtoEntity implements ConverterDtoEntity<CityDto, CityEntity>{

	@Override
	public CityDto toDto(CityEntity entity) {
		return new CityDto(entity.getZipCode(), entity.getName());
	}

	@Override
	public CityEntity toEntity(CityDto dto) {
		// TODO Auto-generated method stub
		return new CityEntity(dto.getZipCode(),dto.getName());
	}

}
