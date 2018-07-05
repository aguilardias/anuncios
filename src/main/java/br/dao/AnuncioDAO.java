package br.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.demoiselle.jee.crud.AbstractDAO;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;

import br.model.Anuncio;

public class AnuncioDAO extends AbstractDAO<Anuncio, Integer> {

	@PersistenceContext
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public String search() {
		try {
			FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(em);
			fullTextEntityManager.createIndexer().startAndWait();

			QueryBuilder qb = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(Anuncio.class)
					.get();
			org.apache.lucene.search.Query query = qb.keyword().onFields("titulo").matching("teste").createQuery();

			// wrap Lucene query in a javax.persistence.Query
			javax.persistence.Query persistenceQuery = fullTextEntityManager.createFullTextQuery(query, Anuncio.class);

			System.out.println(query);

			// execute search
			List result = persistenceQuery.getResultList();

			System.out.println(result);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}

}
