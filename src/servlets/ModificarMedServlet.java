package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MedicoDAOImplementation;
import dao.model.Medico;
import util.EmailHandler;


@WebServlet("/ModificarMedServlet")
public class ModificarMedServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String med_id= req.getParameter("med_id");
		Medico med = MedicoDAOImplementation.getInstance().readMedico(Integer.parseInt(med_id));
		
		String espec = req.getParameter("especialidad");
		String lugar = req.getParameter("lugar");
		String t = req.getParameter("telefono");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		if(espec != "") {med.setEspecialidad(espec);}
		if(lugar != "") {med.setLugar(lugar);}
		if(t != "") {med.setTfno(t);}
		if(email != "") {med.setMail(email);}
		if(password != "") {med.setPassword(password);}
		
		MedicoDAOImplementation.getInstance().updateMedico(med);
		
		EmailHandler polo = new EmailHandler();
		polo.sendEmail("Secretaria@gmail.com", "medico1@gmail.com", "Modificacion de perfil", "Hola, se ha modificado su perfil");
		
		resp.sendRedirect(req.getContextPath() + "/LoginSecretaria.jsp");
		
	}
}
