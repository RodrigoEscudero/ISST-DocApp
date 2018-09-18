import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;  
import javax.mail.*;  
import javax.mail.internet.*;

import util.EmailHandler;  

public class main {
	public static void main(String[] args) {  
	Date date = new Date();
	String hora = "10:15";
	Calendar cal = Calendar.getInstance();
	cal.setTime(date);
	String[] parts = hora.split(":");
	System.out.println(parts[0]);
	System.out.println(parts[1]);
	long po1l = cal.getTime().getTime();
	System.out.println("PPPPP"+po1l);

	cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(parts[0]));
	cal.set(Calendar.MINUTE, Integer.parseInt(parts[1]));
	cal.set(Calendar.SECOND, 0);
	cal.set(Calendar.MILLISECOND, 0);
	long pol = cal.getTime().getTime();
	po1l = cal.getTime().getTime();
	System.out.println("PPPMP"+po1l);
	System.out.println(pol);
	pol += 300000;
	System.out.println(pol);

	Date pp = new Date (pol);
	Format formatter = new SimpleDateFormat("HH:mm");
	System.out.println(formatter.format(pp));
	}	
	
	
	
	
	public static void main1(String[] args) {  
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Date today = Calendar.getInstance().getTime();        
		String reportDate = df.format(today);
		Date hoy;
		try {
			hoy = df.parse(reportDate);
		} catch (ParseException e) {
			hoy=null;	
			e.printStackTrace();
		}
	
		
		
		DateFormat hf = new SimpleDateFormat("HH:mm");
	
		String reportHour = hf.format(today);
		System.out.println("\n"+hoy+"kk"+"\n");
		System.out.println("\n"+hoy.getTime()+"kk"+"\n");
		System.out.println("\n"+reportHour+"kk"+"\n");


	}
}  


