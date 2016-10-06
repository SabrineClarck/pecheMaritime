package ma.siig.tests;




import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import ma.siig.domain.Mission;
import ma.siig.domain.Typemission;
import ma.siig.services.MissionService;
import ma.siig.services.TypemissionService;

import org.apache.log4j.lf5.util.DateFormatManager;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
	/*	ClassPathXmlApplicationContext ctx = 
			new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		
		
		//IBanqueMetier metier=(IBanqueMetier) ctx.getBean("metier");
		//metier.addClient(new Client("C1","AD1"));
	
		MissionService mission = (MissionService) ctx.getBean("missionService");
		
		Mission mi = mission.findById(3);
		mission.delete(mi);
	

*/
		//1. on teste si l'état de la mission est crée
		//DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		//String dt = dateFormat.format(date);
		
		
    	try {
    		Date date1 = dateFormat.parse("2009-12-31");
    		
			Date date2 = dateFormat.parse("2016-10-06");
			
			
			if(date1.after(date)){
        		System.out.println("Date1 is after today");
        	}

        	if(date.before(date2)){
        		System.out.println("today is before Date2");
        	}

        	if(date.equals(date2)){
        		System.out.println("today is equal Date2");
        	}
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		

}
}