package br.com.challenge.dao;

import br.com.challenge.model.Product;

import javax.persistence.EntityManager;
import java.util.List;

public class ProductDao {

    private EntityManager em;

    public ProductDao(EntityManager em) {
        this.em = em;
    }
    public void create(Product product) {
        this.em.persist(product);
    }

    public Product findById(Long id) {
        return em.find(Product.class, id);
    }

    public List<Product> findAll() {
        String jpql = "SELECT p from Product p";
        return em.createQuery(jpql).getResultList();
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
