package com.alamo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.alamo.util.JpaUtil;

public abstract class AbstractJpaDAO<T,I> {
	
	public EntityManager getEntityManager() {
		return JpaUtil.getEntityManager();
	}
	

	public T update(T object){
		this.getEntityManager().merge(object);
		return object;
	}
	
	public void delete(T object){		
		this.getEntityManager().remove(object);
	}
	
	public void delete(Class<T> type,I id){		
		T object = this.getById(type, id);
		this.getEntityManager().remove(object);
	}
	
	public T create(T object){
		this.getEntityManager().persist(object);
		return object;
	}
	
	public T getById(Class<T> type,I id){
		return (T)this.getEntityManager().find(type, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> find(String jpql){
		 Query query = getEntityManager().createQuery(jpql);
		 return query.getResultList(); 
	}
}
