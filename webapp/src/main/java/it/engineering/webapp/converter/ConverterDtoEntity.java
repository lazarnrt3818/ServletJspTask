package it.engineering.webapp.converter;

public interface ConverterDtoEntity<DTO,ENTITY> {

	DTO toDto(ENTITY entity);
	ENTITY toEntity(DTO dto);
}
