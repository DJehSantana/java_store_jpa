package br.com.challenge.dao;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

public class GenericDao<T, ID extends Serializable> {

    private final Class<T> entityClass;
    private EntityManager em;
    public GenericDao(EntityManager em, Class<T> entityClass) {

        this.em = em;
        this.entityClass = entityClass;
    }
    public void create(T entity) {
        this.em.persist(entity);
    }
    public T findById(Long id) {
        return em.find(entityClass, id);
    }

    public List<T> findAll(T entity) {
        String jpql = "SELECT e from :entity e";
        return em.createQuery(jpql, entityClass).setParameter("entity", entity).getResultList();
    }

}
