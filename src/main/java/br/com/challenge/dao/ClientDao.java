package br.com.challenge.dao;

import br.com.challenge.model.Category;
import br.com.challenge.model.Client;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class ClientDao extends GenericDao<Client, Long>{
    @PersistenceContext
    private EntityManager em;


    public ClientDao(EntityManager em, Class<Client> entityClass) {
        super(em, entityClass);
        this.em = em;
    }
}
