package br.com.challenge.dao;

import br.com.challenge.model.Category;
import br.com.challenge.model.OrderItens;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class OrderItensDao extends GenericDao<OrderItens, Long>{
    @PersistenceContext
    private EntityManager em;


    public OrderItensDao(EntityManager em, Class<OrderItens> entityClass) {
        super(em, entityClass);
        this.em = em;
    }
}
