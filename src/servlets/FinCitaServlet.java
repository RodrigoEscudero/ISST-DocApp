package servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CitaDAOImplementation;
import dao.model.Cita;
import dao.model.Medico;

@WebServlet("/FinCitaServlet")
public class FinCitaServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String citaStr = req.getParameter("citaK");
		Cita cita = CitaDAOImplementation.getInstance().readCita(Integer.parseInt(citaStr));
		Medico medico = cita.getMedico();

		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		DateFormat hf = new SimpleDateFormat("HH:mm");
		Date today = Calendar.getInstance().getTime();        
		String reportDate = df.format(today);
		Date hoy;
		try {
			hoy = df.parse(reportDate);
		} catch (ParseException e) {
			hoy=null;	
			e.printStackTrace();
		}
		String reportHour = hf.format(today);
		cita.setStatus(2);
		cita.setHoraFinal(reportHour);
		CitaDAOImplementation.getInstance().updateCita(cita);
		List<Cita> citas = medico.getCitas_medico();
		List <Cita> citasMostrar = new ArrayList<>();
		for (int i = 0; i < citas.size(); i++) {
			System.out.println("VEMOS PPP ("+i+")"+citas.get(i).getStatus());
			if(((citas.get(i).getFechaCita().getTime()))==hoy.getTime()&&citas.get(i).getStatus()!=2 ) {
				System.out.println("añadimos");
				citasMostrar.add(citas.get(i));
			} else {
				System.out.println("No añadimos");
			}
		}
		req.getSession().setAttribute("citaL", citasMostrar);


		resp.sendRedirect(req.getContextPath() + "/AgendaDia.jsp");

	}
}
