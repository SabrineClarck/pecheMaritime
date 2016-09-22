package ma.siig.tests;




import java.util.Date;

import ma.siig.domain.Mission;
import ma.siig.domain.Typemission;
import ma.siig.services.MissionService;
import ma.siig.services.TypemissionService;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		ClassPathXmlApplicationContext ctx = 
			new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		
		
		//IBanqueMetier metier=(IBanqueMetier) ctx.getBean("metier");
		//metier.addClient(new Client("C1","AD1"));
	
		MissionService mission = (MissionService) ctx.getBean("missionService");
		
		Mission mi = mission.findById(3);
		mission.delete(mi);
	}

}
