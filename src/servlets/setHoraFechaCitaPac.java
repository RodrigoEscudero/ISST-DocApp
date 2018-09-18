package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import dao.model.Paciente;
import util.EmailHandler;

@WebServlet("/setHoraFechaCitaPac")
public class setHoraFechaCitaPac extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String idCitaStr =req.getParameter("idCita");
		String fechaStr = req.getParameter("fecha");
		String horaStr = req.getParameter("hora");
		String pag = req.getParameter("pag");
		
		int idCita=Integer.parseInt(idCitaStr);
		Date fecha = null;
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

			fecha = formatter.parse(fechaStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Cita cita = CitaDAOImplementation.getInstance().readCita(idCita);
		cita.setFechaCita(fecha);
		cita.setHoraInicio(horaStr);
		
		CitaDAOImplementation.getInstance().updateCita(cita);
		Paciente dniPaciente=PacienteDAOImplementation.getInstance().readPaciente(cita.getPaciente().getDni());
		
		List <Cita> citas = dniPaciente.getCitas_paciente();
		
		String mensaje = "Hola "+cita.getPaciente().getNombre()+" se ha modificado con exito la fecha y hora d e su cita."+'\n'+
				"La cita esta reprogramada con "+ cita.getMedico().getNombre()+" el dia "+fechaStr+'\n'+
				"a las "+cita.getHoraInicio()+" en la consulta "+cita.getMedico().getLugar();

		EmailHandler polo = new EmailHandler();
		polo.sendEmail("DocAppHospitales@gmail.com", cita.getPaciente().getMail(), "Modificacion de cita", mensaje);
		
		
		req.getSession().setAttribute("cita_list", citas);
		req.getSession().setAttribute("estado", 0);
		resp.sendRedirect(req.getContextPath() + pag);
	}
}
