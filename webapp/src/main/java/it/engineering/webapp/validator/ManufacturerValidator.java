package it.engineering.webapp.validator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.math.NumberUtils;

import it.engineering.webapp.constraint.MyConstraint;
import it.engineering.webapp.domain.Manufacturer;

public class ManufacturerValidator implements Validator<Manufacturer>{

	@Override
	public List<MyConstraint> validate(Manufacturer obj) {
		
		List<MyConstraint> constraints = new ArrayList<>();
		
		if(!NumberUtils.isDigits(obj.getPib())) {
			constraints.add(MyConstraint.MANUFACTURER_PIB_NUMBER);
		}
		
		if(!NumberUtils.isDigits(obj.getCid())) {
			constraints.add(MyConstraint.MANUFACTURER_CID_NUMBER);
		}
		
		if(obj.getAddress().isEmpty() || obj.getPib().isEmpty() || obj.getCid().isEmpty()) {
			constraints.add(MyConstraint.MANUFACTURER_EMPTY_FIELD);
		}
		
		return constraints;
	}

}
