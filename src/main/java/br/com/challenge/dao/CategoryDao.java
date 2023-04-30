package br.com.challenge.dao;

import br.com.challenge.model.Category;

import javax.persistence.EntityManager;

public class CategoryDao {
    private EntityManager em;

    public CategoryDao(EntityManager em) {
        this.em = em;
    }
    public void create(Category category) {
        this.em.persist(category);
    }
}
