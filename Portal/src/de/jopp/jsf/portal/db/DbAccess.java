/**
 * 
 */
package de.jopp.jsf.portal.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * @author corso
 *
 */
public class DbAccess {
	
	private static Logger logger = Logger.getLogger(DbAccess.class);

	private DataSource dataSource;
	private Connection connection;
	private PreparedStatement prStatement;

	public boolean open(Context initContext) {
		logger.setLevel(Level.DEBUG);
		try {
			dataSource = (DataSource) initContext.lookup("java:comp/env/jdbc/mydb");
			logger.debug("open - dataSource loaded");
			return true;
		} catch (NamingException e) {
			logger.error("open - Cannot get the dataSource");
			return false;
		}
	}

	public boolean userExists(String user) {
		ResultSet resultSet = null;
		try {
			connection = dataSource.getConnection();
			logger.debug("userExists - Connection established");
			prStatement = connection.prepareStatement("SELECT U.USERNAME FROM USER U WHERE U.USERNAME=?");
			prStatement.setString(1, user);
			resultSet = prStatement.executeQuery();
			logger.debug("userExists - Query executed");
			return (resultSet.next());
		} catch (SQLException e) {
			logger.error("userExists - Cannot connect to database");
			return false;
		} finally {
            try { if(null!=resultSet)resultSet.close();} catch (SQLException e) 
            {e.printStackTrace();}
            try { if(null!=prStatement)prStatement.close();} catch (SQLException e) 
            {e.printStackTrace();}
            try { if(null!=connection)connection.close();} catch (SQLException e) 
            {e.printStackTrace();}
        }
	}

	public boolean loginOk(String username, String password) {
		ResultSet resultSet = null;
		try {
			connection = dataSource.getConnection();
			logger.debug("loginOk - Connection established");
			prStatement = connection.prepareStatement("SELECT U.USERNAME FROM USER U WHERE U.USERNAME=? AND U.PASSWORD=?");
			prStatement.setString(1, username);
			prStatement.setString(2, password);
			resultSet = prStatement.executeQuery();
			logger.debug("loginOk - Query executed");
			return (resultSet.next());
		} catch (SQLException e) {
			logger.error("loginOk - Cannot connect to database");
			return false;
		} finally {
            try { if(null!=resultSet)resultSet.close();} catch (SQLException e) 
            {e.printStackTrace();}
            try { if(null!=prStatement)prStatement.close();} catch (SQLException e) 
            {e.printStackTrace();}
            try { if(null!=connection)connection.close();} catch (SQLException e) 
            {e.printStackTrace();}
        }
	}

	public void close() {
		
	}

	
}
