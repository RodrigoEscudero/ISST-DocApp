package servlets;

import java.io.IOException;
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
import util.Consulta;

@WebServlet("/InterconsultaServlet")
public class InterconsultaServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String paciente_dni = req.getParameter("paciente_dni");
		String especialidad = req.getParameter("especialidad");
		List<Medico> medicos = MedicoDAOImplementation.getInstance().readAllMedico();
		Date fecha = new Date();
		fecha=Consulta.addDays(fecha, 1);

		for (int i = 0; i < medicos.size(); i++) {
			if(medicos.get(i).getEspecialidad().equals(especialidad)) {
				System.out.println("He encontrado especialista\n");
				String [] horas= Consulta.gethorasLibresDia(medicos.get(i), fecha);
				for (int j = 0; j < horas.length; j++) {
					System.out.println("{"+horas[j]+"}");
					if(!horas[j].equals("") && !horas [j].equals(Consulta.feriado)) {
						Paciente paciente = PacienteDAOImplementation.getInstance().readPaciente(paciente_dni);
						System.out.println("Cita "+ medicos.get(i).getNombre()+"a la hora"+horas[j]+"fecha: "+fecha);
						Cita cita = Consulta.altaCita(paciente, medicos.get(i), fecha, horas[j], "Interconsulta",0);
						String asunto = "Interconsulta para el dia: "+fecha;
						String mensaje = "Hola "+cita.getPaciente().getNombre()+" se ha programado una interconsulta"+'\n'+
								"La interconsulta esta programada con "+ cita.getMedico().getNombre()+" que pasa consula el dia "+fecha+'\n'+
								"a las "+cita.getHoraInicio()+" en la consulta "+cita.getMedico().getLugar();
						Consulta.sendemail(cita, asunto, mensaje);
						resp.sendRedirect(req.getContextPath()+"/AgendaDia.jsp");
						return;
					}
				}
			}
		}
		System.out.println("no cita");
		resp.sendRedirect(req.getContextPath()+"/AgendaDia.jsp");
	}
}
