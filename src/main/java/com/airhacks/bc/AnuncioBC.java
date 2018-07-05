package com.airhacks.bc;

import javax.inject.Inject;

import org.demoiselle.jee.crud.AbstractBusiness;

import br.dao.AnuncioDAO;
import br.model.Anuncio;

public class AnuncioBC extends AbstractBusiness<Anuncio, Integer> {

	@Inject
	private AnuncioDAO anuncioDAO;

	public String obter() {
		System.out.println(dao.find(1));
		return null;
	}

	public String search() {
		return anuncioDAO.search();
	}

}
