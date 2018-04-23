package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CitaDAOImplementation;
import dao.MedicoDAOImplementation;
import dao.PacienteDAOImplementation;
import dao.model.Cita;
import dao.model.Medico;
import dao.model.Paciente;

@WebServlet ("/LoginServlet")
public class LoginServlet extends HttpServlet{

	private final String USER_SECRETARIA = "root";
	private final String PASS_SECRETARIA = "root";

	public boolean isInteger( String input ) {
		try {
			Integer.parseInt( input );
			return true;
		}
		catch( Exception e ){
			return false;
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String userStr = req.getParameter("email");
		String password = req.getParameter("password");
		boolean redirect=false;

		if (USER_SECRETARIA.equals(userStr) && PASS_SECRETARIA.equals(password)) {
			req.getSession().setAttribute("paciente_list",PacienteDAOImplementation.getInstance().readAllPaciente());
			req.getSession().setAttribute("medico_list",MedicoDAOImplementation.getInstance().readAllMedico());
			req.getSession().setAttribute("cita_list",CitaDAOImplementation.getInstance().readAllCita());
			redirect = true;
			resp.sendRedirect(req.getContextPath() + "/LoginSecretaria.jsp");
		} else {
			Paciente paciente = PacienteDAOImplementation.getInstance().loginPaciente(userStr, password);
			if (paciente!=null){
				req.getSession().setAttribute("paciente", paciente);
				req.getSession().setAttribute("cita_list", paciente.getCitas_paciente());
				redirect = true;
				resp.sendRedirect(req.getContextPath() + "/LoginPaciente.jsp");
			} else {
				if (isInteger (userStr)) {
					Medico medico = MedicoDAOImplementation.getInstance().loginMedico(Integer.parseInt(userStr), password);
					if (null != medico) {
						req.getSession().setAttribute("medico", medico);
						req.getSession().setAttribute("cita_list",medico.getCitas_medico());
						resp.sendRedirect(req.getContextPath() + "/LoginMedico.jsp");	 
						redirect = true;
					} 
				}
			}	
		}	
		if (!redirect) resp.sendRedirect(req.getContextPath() + "/FormLogin.jsp");
	}
}