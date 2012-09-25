package com.marakana.contacts.repositories;

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

	public E find(long id) {
		return em.find(entityClass, id);
	}

	public E save(E entity) {
		try {
			em.getTransaction().begin();
			entity = em.merge(entity);
			em.getTransaction().commit();
			return entity;
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