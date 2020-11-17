package com.alamo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.alamo.util.JpaUtil;

/**
 * @author Jhonis
 *
 * @param <T>
 * @param <I>
 */
public abstract class AbstractJpaDAO<T,I> implements IAbstractJpaDAO<T, I> {
	
	@Override
	public EntityManager getEntityManager() {
		return JpaUtil.getEntityManager();
	}
	

	@Override
	public T update(T object){
		this.getEntityManager().merge(object);
		return object;
	}
	
	@Override
	public void delete(T object){		
		this.getEntityManager().remove(object);
	}
	
	@Override
	public void delete(Class<T> type,I id){		
		T object = this.getById(type, id);
		this.getEntityManager().remove(object);
	}
	
	@Override
	public T create(T object){
		this.getEntityManager().persist(object);
		return object;
	}
	
	@Override
	public T getById(Class<T> type,I id){
		return (T)this.getEntityManager().find(type, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<T> find(String jpql){
		 Query query = getEntityManager().createQuery(jpql);
		 return query.getResultList(); 
	}
}
