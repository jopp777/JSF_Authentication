/**
 * 
 */
package de.jopp.jsf.portal.resources;

import java.util.Locale;


/**
 * @author corso
 *
 */
public class Language {
	
	public String changeLang() {
		
		Locale locale = Locale.getDefault();
		
		System.out.println("Before: "+Locale.getDefault());
		
		if (locale.equals(Locale.ITALY))
			
			Locale.setDefault(Locale.ENGLISH);		
			
		else Locale.setDefault(Locale.ITALY);		

		System.out.println("After: "+Locale.getDefault());

		return "language";
	}

}
