package it.engineering.webapp.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MyEntityManagerFactory {
	private static EntityManagerFactory emf;

	private MyEntityManagerFactory() {
		emf = Persistence.createEntityManagerFactory("webapp");
	}

	public static EntityManagerFactory getInstance() {
		if (emf == null) {
			new MyEntityManagerFactory();
		}
		return emf;
	}

	public static void closeEntityManagerFactory() {
		if (emf != null) {
			emf.close();
		} else {
			throw new RuntimeException("EntityManagerFactory intance is null !");

		}
	}
}
