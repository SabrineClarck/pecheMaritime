package ma.siig.ui.utils;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;


/**
 * 
 * Helper util to assist in user interfaces
 * 
 * @author SabrineMac
 *
 */
public class UIUtils implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int viewLoadCount = 0;
	
	public void greetOnViewLoad(ComponentSystemEvent event){
		
		FacesContext cntx= FacesContext.getCurrentInstance();
		if(viewLoadCount < 1 && !cntx.isPostback()){
			String firstName = (String) event.getComponent().getAttributes().get("firstName");
			String lastName= (String) event.getComponent().getAttributes().get("lastName");
			
			FacesMessage msg = new FacesMessage(String.format("Bienvenue,%s %s", lastName, firstName));
			cntx.addMessage("growlMessages", msg);
			
			viewLoadCount++;
		}
		
		
	}
	
	
	

}
