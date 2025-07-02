package edu.ifma.labd.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class GenericDAO<T> {
    protected static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("transportadoraPU");

    private final Class<T> entityClass;

    public GenericDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public void create(T entity) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        em.close();
    }

    public T findById(Long id) {
        EntityManager em = emf.createEntityManager();
        T entity = em.find(entityClass, id);
        em.close();
        return entity;
    }

    public List<T> findAll() {
        EntityManager em = emf.createEntityManager();
        String jpql = "SELECT e FROM " + entityClass.getSimpleName() + " e";
        List<T> result = em.createQuery(jpql, entityClass).getResultList();
        em.close();
        return result;
    }

    public void update(T entity) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.merge(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) transaction.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public void delete(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        T entity = em.find(entityClass, id);
        if (entity != null) {
            em.remove(entity);
        }
        em.getTransaction().commit();
        em.close();
    }

}
