package edu.ifma.labd.dao;

import edu.ifma.labd.model.Frete;
import jakarta.persistence.EntityManager;

import java.util.List;

public  class FreteDAO extends GenericDAO<Frete> {
    public FreteDAO() {
        super(Frete.class);
    }

    public List<Frete> findByCliente(Long clienteId) {
        EntityManager em = emf.createEntityManager();
        String jpql = "SELECT f FROM Frete f WHERE f.cliente.id = :clienteId";
        List<Frete> fretes = em.createQuery(jpql, Frete.class)
                .setParameter("clienteId", clienteId)
                .getResultList();
        em.close();
        return fretes;
    }
}