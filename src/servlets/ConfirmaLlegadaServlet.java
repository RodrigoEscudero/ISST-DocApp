package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.RespectBinding;

import dao.CitaDAOImplementation;
import dao.model.Cita;

@WebServlet("/ConfirmaLlegadaServlet")
public class ConfirmaLlegadaServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String citaStr = req.getParameter("cita");
			Cita cita = CitaDAOImplementation.getInstance().readCita(Integer.parseInt(citaStr));
			cita.setStatus(1);
			CitaDAOImplementation.getInstance().updateCita(cita);
			
			resp.sendRedirect(req.getContextPath()+"/LoginSecretaria.jsp");
	}

}
