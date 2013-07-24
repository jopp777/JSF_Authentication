/**
 * 
 */
package de.jopp.jsf.portal.model;

import javax.faces.event.ActionEvent;

import de.jopp.jsf.portal.controller.CloseSessionController;
import de.jopp.jsf.portal.controller.LoginController;

/**
 * @author ex32737
 *
 */
public class User {

	private String username;
	private String password;
	private boolean loggedIn;
	
	public String login(){
		loggedIn = LoginController.checkLogin(username,password);
		setPassword(null);
		if (loggedIn) return "success";
		setUsername(null);
		return "failed";
	}
	
	public String logout(){
		CloseSessionController.closeSession();
		return "exit";
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	
}
