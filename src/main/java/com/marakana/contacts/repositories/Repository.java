package com.marakana.contacts.repositories;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

public class Repository<E> {

	private final EntityManager em = Persistence.createEntityManagerFactory("training").createEntityManager();
	private final Class<E> entityClass;

	public Repository(Class<E> entityClass) {
		this.entityClass = entityClass;
	}
	
	public List<E> findAll() {
		return em.createQuery("from " + entityClass.getSimpleName(), entityClass).getResultList();
	}

	public E find(long id) throws SQLException {
		return em.find(entityClass, id);
	}

	public void save(E entity) {
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			if (e instanceof RollbackException) {
				throw (RollbackException) e;
			}
			em.getTransaction().rollback();
			throw new RollbackException(e);
		}
	}

	public void delete(E entity) {
		try {
			em.getTransaction().begin();
			em.remove(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			if (e instanceof RollbackException) {
				throw (RollbackException) e;
			}
			em.getTransaction().rollback();
			throw new RollbackException(e);
		}
	}

}
