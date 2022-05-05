package it.engineering.webapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "manufacturer")
public class ManufacturerEntity {
	@Id
	@Column(name = "ID_manufacturer")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String pib;
	private String cid;
	private String address;

	@ManyToOne
	@JoinColumn(name = "ID_city")
	private CityEntity city;

	public ManufacturerEntity(String pib, String cid, String address, CityEntity city) {
		super();
		this.pib = pib;
		this.cid = cid;
		this.address = address;
		this.city = city;
	}

	public ManufacturerEntity() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPib() {
		return pib;
	}

	public void setPib(String pib) {
		this.pib = pib;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public CityEntity getCity() {
		return city;
	}

	public void setCity(CityEntity city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Manufacturer [id=" + id + ", pib=" + pib + ", cid=" + cid + ", address=" + address + ", city=" + city
				+ "]";
	}

}
