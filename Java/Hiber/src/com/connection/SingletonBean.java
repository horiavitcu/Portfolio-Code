/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.connection;

import java.io.Serializable;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author HHHHH
 */
public class SingletonBean implements Serializable {

	public SingletonBean() {
	}

	protected static EntityManagerFactory instance;

	public static EntityManagerFactory getEntityManagerFactory() {
		try {
			if (instance == null) {
				instance = Persistence
						.createEntityManagerFactory("Hiber");
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		return instance;
	}

}

