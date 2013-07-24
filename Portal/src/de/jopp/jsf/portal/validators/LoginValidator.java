/**
 * 
 */
package de.jopp.jsf.portal.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
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
public class LoginValidator implements Validator {
	
	private static Logger logger = Logger.getLogger(LoginValidator.class);


	/* (non-Javadoc)
	 * @see javax.faces.validator.Validator#validate(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object)
	 */
	@Override
	public void validate(FacesContext context, UIComponent component, Object value)
			throws ValidatorException {
		String user = (String) value;
		logger.setLevel(Level.DEBUG);
		logger.debug("validate() for user "+user+" START");
	    
		DbAccess dbAccess = new DbAccess();
		Context initContext;
		try {
			initContext = new InitialContext();
			FacesMessage message = new FacesMessage();
			
			if (!dbAccess.open(initContext)) {
		    	message.setDetail("It was not possible to get the DataSource");
		    	message.setSummary("Cannot connect to DB");
		    	message.setSeverity(FacesMessage.SEVERITY_ERROR);
	    		throw new ValidatorException(message);
		    } else if (dbAccess.userExists(user)) {
	    		logger.debug("User "+user+" is in database.");
			} else {
				logger.debug("User "+user+" does not exists.");
		    	message = new FacesMessage();
		    	message.setDetail("User " + user + " does not exists");
		    	message.setSummary("Login Incorrect");
		    	message.setSeverity(FacesMessage.SEVERITY_ERROR);
		    	throw new ValidatorException(message);
			}
		} catch (NamingException e) {
			logger.error("Cannot get the initial context");
		} finally {
			dbAccess.close();
		}
		
	}

}
