package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PacienteDAO;
import dao.PacienteDAOImplementation;
import dao.model.Paciente;

@WebServlet("/VerPacServlet")
public class VerPacServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String paciente_dni= req.getParameter("paciente_elegido");
		PacienteDAO dao = PacienteDAOImplementation.getInstance();
		Paciente paciente = dao.readPaciente(paciente_dni);
		
		req.getSession().setAttribute("paciente", paciente);
		resp.sendRedirect(req.getContextPath() + "/VerPaciente.jsp");
	}
}
