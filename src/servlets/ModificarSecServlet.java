package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MedicoDAO;
import dao.MedicoDAOImplementation;
import dao.PacienteDAO;
import dao.PacienteDAOImplementation;
import dao.model.Medico;
import dao.model.Paciente;

@WebServlet("/ModificarSecServlet")
public class ModificarSecServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String paciente_dni= req.getParameter("paciente_modificado");
		String medico_id = req.getParameter("medico_modificado");
		
		PacienteDAO dao = PacienteDAOImplementation.getInstance();
		MedicoDAO mdao = MedicoDAOImplementation.getInstance();
		Paciente paciente = dao.readPaciente(paciente_dni);

		if(paciente != null) {
			req.getSession().setAttribute("paciente", paciente);
			resp.sendRedirect(req.getContextPath() + "/ModificarPacienteSec.jsp");
		}
		else if(mdao.readMedico(Integer.parseInt(medico_id)) != null) {
			Medico medico = mdao.readMedico(Integer.parseInt(medico_id));
			req.getSession().setAttribute("medico", medico);
			resp.sendRedirect(req.getContextPath() + "/ModificarMedicoSec.jsp");
		}
		else { 
			resp.sendRedirect(req.getContextPath() + "/LoginSecretaria.jsp");
		}
	}
}
