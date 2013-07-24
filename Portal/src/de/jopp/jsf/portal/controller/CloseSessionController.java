/**
 * 
 */
package de.jopp.jsf.portal.controller;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 * @author corso
 *
 */
public class CloseSessionController {

	public static void closeSession() {
		((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest())
				.getSession(true).invalidate();
	}

}
