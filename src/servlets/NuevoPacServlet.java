package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PacienteDAOImplementation;
import dao.model.Paciente;

@WebServlet("/NuevoPacServlet")
public class NuevoPacServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("nombre");
		String a1 = req.getParameter("apellido1");
		String a2 = req.getParameter("apellido2");
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date bday = null;
		try {
			bday = formato.parse(req.getParameter("nacimiento"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String dni = req.getParameter("dni");
		String domicilio = req.getParameter("domicilio");
		String t1 = req.getParameter("telefono1");
		String t2 = req.getParameter("telefono2");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		Paciente pac = new Paciente();
		pac.setNombre(name);
		pac.setApellido1(a1);
		pac.setApellido2(a2);
		pac.setNacimiento(bday);
		pac.setDni(dni);
		pac.setDomicilio(domicilio);
		pac.setTfno1(t1);
		pac.setTfno2(t2);
		pac.setMail(email);
		pac.setPassword(password);
		
		PacienteDAOImplementation.getInstance().createPaciente(pac);
		resp.sendRedirect(req.getContextPath() + "/FormLogin.jsp");
	}
}
