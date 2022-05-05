package it.engineering.webapp.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import it.engineering.webapp.domain.dto.CityDto;
import it.engineering.webapp.service.CityService;

@Component
public class CityDtoFormatter implements Formatter<CityDto>{

	@Autowired
	private CityService cityService;
	
	@Override
	public String print(CityDto object, Locale locale) {
		return object.getZipCode()+"";
	}

	@Override
	public CityDto parse(String text, Locale locale) throws ParseException {
		CityDto city = cityService.find(Long.parseLong(text)).get();
		System.out.println("FORMATER : " + city);
		System.out.println("FORMATER : " + text);
		return city;
	}

}
