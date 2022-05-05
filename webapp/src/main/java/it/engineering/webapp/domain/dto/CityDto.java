package it.engineering.webapp.domain.dto;

import java.util.Objects;

public class CityDto {

	private Long zipCode;
	private String name;
	public CityDto(Long zipCode, String name) {
		super();
		this.zipCode = zipCode;
		this.name = name;
	}
	public CityDto() {
		super();
	}
	public Long getZipCode() {
		return zipCode;
	}
	public void setZipCode(Long zipCode) {
		this.zipCode = zipCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return name + ", " +zipCode;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name, zipCode);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CityDto other = (CityDto) obj;
		return Objects.equals(name, other.name) && Objects.equals(zipCode, other.zipCode);
	}
	
	
	
}
