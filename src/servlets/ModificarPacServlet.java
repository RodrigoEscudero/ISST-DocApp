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

@WebServlet("/ModificarPacServlet")
public class ModificarPacServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String pac_dni= req.getParameter("pac_dni");
		Paciente pac = PacienteDAOImplementation.getInstance().readPaciente(pac_dni);
		
		String domicilio = req.getParameter("domicilio");
		String t1 = req.getParameter("telefono1");
		String t2 = req.getParameter("telefono2");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		if(domicilio != "") {pac.setDomicilio(domicilio);}
		if(t1 != "") {pac.setTfno1(t1);}
		if(t2 != "") {pac.setTfno2(t2);}
		if(email != "") {pac.setMail(email);}
		if(password != "") {pac.setPassword(password);}
		
		PacienteDAOImplementation.getInstance().updatePaciente(pac);

		//resp.sendRedirect(req.getContextPath() + "/LoginSecretaria.jsp");
		resp.sendRedirect(req.getContextPath() + "/FormLogin.jsp");
	}
}
