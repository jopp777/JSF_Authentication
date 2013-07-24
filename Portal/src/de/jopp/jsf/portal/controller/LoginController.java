/**
 * 
 */
package de.jopp.jsf.portal.controller;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import de.jopp.jsf.portal.db.DbAccess;

/**
 * @author corso
 *
 */
public class LoginController {
	
	private static Logger logger = Logger.getLogger(LoginController.class);


	public static boolean checkLogin(String username, String password) {
		
		logger.setLevel(Level.DEBUG);
		logger.debug("checkLogin() for user "+username+" START");
	    
		DbAccess dbAccess = new DbAccess();
		
		Context initContext;
		
		try {
			initContext = new InitialContext();
			dbAccess.open(initContext);
			if (dbAccess.loginOk(username,password)) {
				logger.debug("checkLogin() - user "+username+" authenticated");
				return true;
			} else {
				logger.debug("checkLogin() - Wrong password");
				return false;
			}
		} catch (NamingException e) {
			logger.error("checkLogin() - Cannot get the initial context");
			return false;
		}
		
	}

}
