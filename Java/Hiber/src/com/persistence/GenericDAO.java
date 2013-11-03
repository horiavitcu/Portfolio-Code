package com.persistence;

import com.entities.Identifiable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

public abstract class GenericDAO {
	/**
	 * Creates a brand new EntityManager.
	 * 
	 * Don't forget to close it when you're done.
	 * 
	 * @return
	 */
	public static EntityManager entityManager() {
		return PersistenceUtil.createEntityManager();
	}

	/**
	 * 
	 * @param clazz
	 * @param id
	 * @return
	 */
	public static <T> T findById(Class<T> clazz, int id) {
		EntityManager em = entityManager();
		try {
			T object = em.find(clazz, id);
			return object;
		} finally {
			em.close();
		}
	}

	/**
	 * 
	 * @param queryString
	 * @param param
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected static <T> List<T> getResultList(String queryString,
			Object... param) {
		EntityManager em = entityManager();
		try {
			Query query = em.createQuery(queryString);
			for (int i = 0; i < param.length; i++) {
				query.setParameter(i, param[i]);
			}
			return query.getResultList();
		} finally {
			em.close();
		}
	}

	@SuppressWarnings("unchecked")
	protected static <T> T getSingleResult(String queryString, Object... param) {
		EntityManager em = entityManager();
		try {
			Query query = em.createQuery(queryString);
			for (int i = 0; i < param.length; i++) {
				query.setParameter(i, param[i]);
			}
			return (T) query.getResultList().get(0);
		} catch (NoResultException e) {
			return null;
		} catch (Exception e) {
			System.err.println(e);
			return null;
		} finally {
			em.close();
		}
	}

	/**
	 * 
	 * @param object
	 * @return
	 */
	public static boolean persist(Object object) {
		EntityManager em = entityManager();
		try {
			EntityTransaction t = em.getTransaction();
			try {
				t.begin();
				em.persist(object);
				t.commit();
				return true;
			} finally {
				if (t.isActive()) {
					t.rollback();
				}
			}
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
			return false;
		} finally {
			em.close();
		}
	}

	/**
	 * 
	 * @param object
	 */
	public static boolean update(Identifiable object) {
		EntityManager em = entityManager();
		try {
			EntityTransaction t = em.getTransaction();
			try {
				t.begin();
				if (!em.contains(object)) {
					em.merge(object);
					em.flush();
				}
				t.commit();
				return true;
			} finally {
				if (t.isActive()) {
					t.rollback();
				}
			}
		} catch (Exception e) {
			System.err.println(e);
			return false;
		} finally {
			em.close();
		}
	}

	/**
	 * 
	 * @param object
	 * @return
	 */
	public static boolean remove(Identifiable object) {
		EntityManager em = entityManager();
		try {
			EntityTransaction t = em.getTransaction();
			try {
				t.begin();
				if (!em.contains(object)) {
					object = em.find(object.getClass(), object.getId());
				}
				em.remove(object);
				t.commit();
				return true;
			} finally {
				if (t.isActive()) {
					t.rollback();
				}
			}
		} catch (Exception e) {
			System.err.println(e);
			return false;
		} finally {
			em.close();
		}
	}

	public static boolean refresh(Object object) {
		EntityManager em = entityManager();
		try {
			if (em.contains(object)) {
				em.refresh(object);
			}
			return true;
		} catch (Exception e) {
			System.err.println(e);
			return false;
		} finally {
			em.close();
		}
	}

	/**
	 * Only for 'select count(*) from something'.
	 * 
	 * @param query
	 * @return
	 */
	public static int count(String query) {
		EntityManager em = entityManager();
		try {
			Object result = em.createNativeQuery(query).getSingleResult();
			return convertToInt(result);
		} finally {
			em.close();
		}
	}

	private static int convertToInt(Object obj) {
		if (obj == null) {
			return 0;
		}
		if (obj instanceof Integer) {
			int count = (Integer) obj;
			return count;
		} else if (obj instanceof Long) {
			long count = (Long) obj;
			return (int) count;
		} else if (obj instanceof BigInteger) {
			BigInteger count = (BigInteger) obj;
			return count.intValue();
		} else if (obj instanceof BigDecimal) {
			BigDecimal count = (BigDecimal) obj;
			return count.intValue();
		} else {
			throw new PersistenceException("Cannot convert result to int:"
					+ obj.getClass());
		}
	}

}
