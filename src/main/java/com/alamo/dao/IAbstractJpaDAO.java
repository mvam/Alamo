package com.alamo.dao;

import java.util.List;

import javax.persistence.EntityManager;

public interface IAbstractJpaDAO<T, I> {

	EntityManager getEntityManager();

	T update(T object);

	void delete(T object);

	void delete(Class<T> type, I id);

	T create(T object);

	T getById(Class<T> type, I id);

	List<T> find(String jpql);

}