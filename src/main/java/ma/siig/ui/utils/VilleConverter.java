package ma.siig.ui.utils;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import javax.faces.convert.FacesConverter;

import org.apache.commons.lang.StringUtils;

import ma.siig.domain.Ville;
import ma.siig.services.VilleService;



@FacesConverter("ma.siig.ui.utils.VilleConverter")
public class VilleConverter implements Converter {

	VilleService vs;
	
	public Object getAsObject(FacesContext face, UIComponent arg1, String value) {
		
	
		if(value == null || value.isEmpty()){
			return null;// let required="true" do its job on this.
		}
		
		if(!StringUtils.isNumeric(value)){
			throw new ConverterException("Value is not a valid ID of Ville");
		}
		
		Integer id = Integer.parseInt(value);
		
		
		
		return vs.findById(id);
	}

	public String getAsString(FacesContext face, UIComponent arg1, Object value) {
		
		if(value == null){
			return "";// required by spec.
		}
		
		if(!(value instanceof Ville)){
			throw new ConverterException("Value is not a valid instance of Ville");
		}
		Integer id = ((Ville) value).getIdVille();
		
		
		return (id != null) ? id.toString() : "";
	}

}
