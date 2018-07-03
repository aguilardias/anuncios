package com.airhacks.bc;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class AnuncioBC {

	@PersistenceContext
	private EntityManager em;

	public String consultar() {
		System.out.println(em);
		return "consultar2";
	}

}
