package com.persistence;


import com.connection.SingletonBean;
import javax.persistence.EntityManager;


public class PersistenceUtil {
	public PersistenceUtil() {
	}

	public static EntityManager createEntityManager() {
		try {
			return SingletonBean.getEntityManagerFactory()
					.createEntityManager();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static EntityManager getEntityManager() {
		return createEntityManager();
	}

}
