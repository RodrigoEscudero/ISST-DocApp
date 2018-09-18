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

import dao.MedicoDAOImplementation;
import dao.PacienteDAOImplementation;
import dao.model.Cita;
import dao.model.Medico;
import dao.model.Paciente;
import util.Consulta;


@WebServlet("/GestionCitaPacienteServlet")
public class GestionCitaPacienteServlet  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String estado = req.getParameter("estado");
		String dniPaciente = req.getParameter("paciente_dni");
		String citaATratar = req.getParameter("citaA_tratar");
		Paciente paciente_dni = PacienteDAOImplementation.getInstance().readPaciente(dniPaciente);
		List <Cita> citas = paciente_dni.getCitas_paciente();
		
		req.getSession().setAttribute("cita_list", citas);
		req.getSession().setAttribute("estado", estado);
		req.getSession().setAttribute("citaA_tratar", citaATratar);
		resp.sendRedirect(req.getContextPath() + "/GestionCitaPaciente.jsp");

	}
}