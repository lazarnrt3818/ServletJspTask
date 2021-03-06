package it.engineering.webapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "city")
public class CityEntity {
	@Id
	@Column(name = "Zip_code")
	private Long zipCode;
	private String name;

	public Long getZipCode() {
		return zipCode;
	}

	public CityEntity(Long zipCode, String name) {
		super();
		this.zipCode = zipCode;
		this.name = name;
	}

	public CityEntity() {
		super();
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
		return name+","+zipCode;
	}
}
