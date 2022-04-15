package it.engineering.webapp.validator;

import java.util.List;

import it.engineering.webapp.constraint.MyConstraint;

public interface Validator<T> {

	public List<MyConstraint> validate(T obj);
}
