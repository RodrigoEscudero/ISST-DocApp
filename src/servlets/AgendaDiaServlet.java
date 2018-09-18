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

import dao.MedicoDAOImplementation;
import dao.PacienteDAOImplementation;
import dao.model.Cita;
import dao.model.Medico;
import dao.model.Paciente;


@WebServlet("/AgendaDiaServlet")
public class AgendaDiaServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idMedicoStr = req.getParameter("medico");
		int idMedico = Integer.parseInt(idMedicoStr);
		List <String> todasEspecialidades = MedicoDAOImplementation.getInstance().readEspecialidades();
		List <String> especialidades = new ArrayList<>();
		List<Paciente> pacientes = PacienteDAOImplementation.getInstance().readAllPaciente();
		
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
		
 		Medico medico = MedicoDAOImplementation.getInstance().readMedico(idMedico);

		for (int i = 0; i < todasEspecialidades.size(); i++) {
			if(!todasEspecialidades.get(i).equals(medico.getEspecialidad())) {
				especialidades.add(todasEspecialidades.get(i));
			}
		}
		
		List <Cita> citas = medico.getCitas_medico();
		List <Cita> citasMostrar = new ArrayList<>();

		System.out.println(citas.size()+"iteraciones");
		
		for (int i = 0; i < citas.size(); i++) {
			System.out.println("Comparo ("+i+")"+citas.get(i).getFechaCita().getTime()+" con "+hoy.getTime());
			if(((citas.get(i).getFechaCita().getTime()))==hoy.getTime()&&citas.get(i).getStatus()!=2 ) {
				citasMostrar.add(citas.get(i));
			}
		}

		System.out.println(citasMostrar.size());
		System.out.println(citas.size());
		System.out.println(citas.get(0).getFechaCita().getTime()/100000);
		req.getSession().setAttribute("citaL", citasMostrar);
		req.getSession().setAttribute("especialidad", especialidades);
		req.getSession().setAttribute("pacientes", pacientes);
		resp.sendRedirect(req.getContextPath() + "/AgendaDia.jsp");
	}
}
