package br.com.challenge.dao;

import br.com.challenge.model.Category;

import javax.persistence.EntityManager;
import java.util.List;

public class CategoryDao {
    private EntityManager em;

    public CategoryDao(EntityManager em) {
        this.em = em;
    }
    public void create(Category category) {
        this.em.persist(category);
    }

    public Category findById(Long id) {
        return em.find(Category.class, id);
    }

    public List<Category> findAll() {
        String jpql = "SELECT c FROM Category c";
        return em.createQuery(jpql).getResultList();
    }
}
