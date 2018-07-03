package com.airhacks;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.airhacks.bc.AnuncioBC;

@Path("teste")
public class TesteResource {

	@Inject
	private AnuncioBC anuncioBC;

	@GET
	public String teste() {
		return anuncioBC.consultar();
	}
}
