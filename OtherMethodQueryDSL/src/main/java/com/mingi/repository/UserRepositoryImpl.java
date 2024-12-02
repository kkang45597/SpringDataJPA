package com.mingi.repository;

import java.util.List;

import org.springframework.context.annotation.Primary;

import com.mingi.entity.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Primary
public class UserRepositoryImpl implements UserRepositoryCustom {
	
	@PersistenceContext
	private EntityManager entityManager;

	public List<User> QueryMethod() {
		String jpql = "SELECT u FROM User u WHERE u.age > :age";
		return entityManager.createQuery(jpql, User.class)
				.setParameter("age", 18).getResultList();
	}

	public List<User> findByLastname(String lastname) {
		return null;
	}

	@Override
	public List<User> customQueryMethod() {
		return null;
	}

}
