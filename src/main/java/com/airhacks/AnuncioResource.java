package com.airhacks;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.airhacks.bc.AnuncioBC;

@Path("anuncio")
public class AnuncioResource {

	@Inject
	private AnuncioBC anuncioBC;

	@GET
	@Path("obter")
	public String obter() {
		anuncioBC.obter();
		return "obter";
	}

	@GET
	@Path("search")
	public String search() {
		anuncioBC.search();
		return "search";
	}
}
