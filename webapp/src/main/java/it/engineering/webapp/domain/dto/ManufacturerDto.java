package it.engineering.webapp.domain.dto;

import java.util.Objects;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ManufacturerDto {

	@NotNull
	@NotBlank
	@Digits(fraction = 5, integer = 10,message = "Must have between 2 and 10 numbers")
	private String pib;
	@NotNull
	@NotBlank
	@Digits(fraction = 5, integer = 10,message = "Must have between 2 and 10 numbers")
	private String cid;
	@NotNull
	@NotBlank
	private String address;

	private CityDto city;

	public ManufacturerDto(String pib, String cid, String address, CityDto city) {
		super();
		this.pib = pib;
		this.cid = cid;
		this.address = address;
		this.city = city;
	}

	public ManufacturerDto() {
		super();
	}

	public CityDto getCity() {
		return city;
	}

	public void setCity(CityDto city) {
		this.city = city;
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

	@Override
	public String toString() {
		return "ManufacturerDto [pib=" + pib + ", cid=" + cid + ", address=" + address + ", city=" + city + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, cid, pib);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ManufacturerDto other = (ManufacturerDto) obj;
		return Objects.equals(address, other.address) && Objects.equals(cid, other.cid)
				&& Objects.equals(pib, other.pib);
	}

}
