package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MedicoDAOImplementation;
import dao.model.Medico;

@WebServlet("/NuevoMedServlet")
public class NuevoMedServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("nombre");
		String a1 = req.getParameter("apellido1");
		String a2 = req.getParameter("apellido2");
		String espec = req.getParameter("especialidad");
		String lugar = req.getParameter("lugar");
		String t = req.getParameter("telefono");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		Medico med = new Medico();
		med.setNombre(name);
		med.setApellido1(a1);
		med.setApellido2(a2);
		med.setEspecialidad(espec);
		med.setLugar(lugar);
		med.setTfno(t);
		med.setMail(email);
		med.setPassword(password);
		
		MedicoDAOImplementation.getInstance().createMedico(med);
		
		resp.sendRedirect(req.getContextPath() + "/LoginSecretaria.jsp");
	}
}
