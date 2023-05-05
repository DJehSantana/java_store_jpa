package br.com.challenge.dao;

import br.com.challenge.model.Category;
import br.com.challenge.model.Order;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class OrderDao extends GenericDao<Order, Long>{
    @PersistenceContext
    private EntityManager em;


    public OrderDao(EntityManager em, Class<Order> entityClass) {
        super(em, entityClass);
        this.em = em;
    }
}
