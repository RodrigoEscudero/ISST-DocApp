package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CitaDAOImplementation;
import dao.PacienteDAOImplementation;
import dao.model.Cita;
import dao.model.Medico;
import dao.model.Paciente;
import util.Consulta;


@WebServlet("/UrgenciaServlet")
public class UrgenciaServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		String idCitaStr = req.getParameter("citaU");
		String dniStr = req.getParameter("pacientes");
		System.out.println(dniStr+"fhghj");
		Paciente paciente = PacienteDAOImplementation.getInstance().readPaciente(dniStr);
		int idCita = Integer.parseInt(idCitaStr);
		Cita cita = CitaDAOImplementation.getInstance().readCita(idCita);
		Medico medico = cita.getMedico();
		Cita nCita= Consulta.altaCita(paciente, medico, cita.getFechaCita(), cita.getHoraInicio(), "Urgencia",1);
		String nuevaHora = Consulta.sumaCincoMin(cita.getFechaCita(), cita.getHoraInicio());
		cita.setHoraInicio(nuevaHora);
		CitaDAOImplementation.getInstance().updateCita(cita);
		
		Consulta.sendemail(nCita, "Retraso de cita por urgencia", "Su cita ha sufrido un retraso de 5 minutos debido a una urgencia.");
		Consulta.sendemail(cita, "Cita de urgencia", "Es atendido por urgencia a: "+cita.getHoraInicio()+" del dia "+cita.getFechaCita());
		Date hoy = cita.getFechaCita();
		List<Cita> citas = medico.getCitas_medico();
		citas.add(nCita);
		List <Cita> citasMostrar = new ArrayList<>();
		
		for (int i = 0; i < citas.size(); i++) {
			System.out.println("VEMOS XXX ("+i+")"+citas.get(i).getStatus()+"<->"+citas.get(i).getComentarios());
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
