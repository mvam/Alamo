package com.alamo.filter;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.alamo.util.JpaUtil;

/**
 * @author Jhonis
 *
 */
@WebFilter(urlPatterns = "/*")
public class OpenSessionAndTransactionInView implements Filter {
	@Override
	public void destroy() {
		JpaUtil.closeEntityManagerFactory();

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		// inicia a transa��o antes de processar o request
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();

			// processa a requisi��o
			chain.doFilter(request, response);

			// faz commit
			tx.commit();
		} catch (Exception e) { 
			// ou em caso de erro faz o rollback
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {

			if (em.isOpen()) {
				em.close();
			}

		}

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

}
