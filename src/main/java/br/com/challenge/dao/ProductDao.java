package br.com.challenge.dao;

import br.com.challenge.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

public class ProductDao extends GenericDao<Product, Long>{
    @PersistenceContext
    private EntityManager em;
    public ProductDao(EntityManager em, Class<Product> entityClass) {
        super(em, entityClass);
        this.em = em;
    }

    public Product findByName(String name) {
        String jpql = "SELECT p from Product p WHERE p.name = :name";
        return em.createQuery(jpql, Product.class).setParameter("name", name).getSingleResult();
    }

    public List<Product> findByCategory(String name) {
        String jpql = "SELECT p from Product p WHERE p.category.name = :name";
        return em.createQuery(jpql, Product.class).setParameter("name", name).getResultList();
    }
}
