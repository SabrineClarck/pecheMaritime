package ma.siig.ui.utils;


public class TabView extends org.primefaces.component.tabview.TabView {

	@Override
	public void processUpdates(javax.faces.context.FacesContext context){
		if("tabChange".equals(javax.faces.context.FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("javax.faces.partial.event"))){
			return;
		}else{
			super.processValidators(context);
		}
	}
	
}
