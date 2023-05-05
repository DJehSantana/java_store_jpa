package br.com.challenge.dao;

import br.com.challenge.model.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


public class CategoryDao extends GenericDao<Category, Long>{
    @PersistenceContext
    private EntityManager em;


    public CategoryDao(EntityManager em, Class<Category> entityClass) {
        super(em, entityClass);
        this.em = em;
    }
}
