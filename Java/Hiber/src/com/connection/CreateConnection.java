/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;


/**
 *
 * @author HHHHH
 */
public class CreateConnection {
	public Connection createConnection() {
        try {
            Class.forName(ConnectionProperties.DRIVER);
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace(System.out);
        }
        try {
            return DriverManager.getConnection(ConnectionProperties.URL,
                    ConnectionProperties.USER,
                    ConnectionProperties.PASS);
        } catch (Exception se) {
            se.printStackTrace(System.out);
        }
        return null;

    }
	
	public Connection createConnection(String url, String user, String pass) {
        try {
            Class.forName(ConnectionProperties.DRIVER);
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace(System.out);
        }
        try {
            return DriverManager.getConnection(url, user,pass);
        } catch (Exception se) {
            se.printStackTrace(System.out);
        }
        return null;

    }

}

