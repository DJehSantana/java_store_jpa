package br.com.challenge.dao;

import br.com.challenge.model.Product;

import javax.persistence.EntityManager;

public class ProductDao {

    private EntityManager em;

    public ProductDao(EntityManager em) {
        this.em = em;
    }
    public void create(Product product) {
        this.em.persist(product);
    }
}
