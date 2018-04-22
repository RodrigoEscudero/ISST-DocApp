package servlets;

import java.io.IOException;
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


@WebServlet("/DeleteCitaPacienteServlet")
public class DeleteCitaPacienteServlet  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String dniPaciente = req.getParameter("paciente_dni");
		String idCitaABorrarStr = req.getParameter("citaA_borrar");
		System.out.println("aaaaaaaaaa"+dniPaciente);
		System.out.println("bbbbbbbbbbb"+idCitaABorrarStr);

		if (idCitaABorrarStr != null) {
			int idCitaABorrar = Integer.parseInt(idCitaABorrarStr);
			CitaDAOImplementation.getInstance().deleteById(idCitaABorrar);
		}

		Paciente paciente_dni = PacienteDAOImplementation.getInstance().readPaciente(dniPaciente);
		List <Cita> citas = paciente_dni.getCitas_paciente();
		req.getSession().setAttribute("cita_list", citas);
		resp.sendRedirect(req.getContextPath() + "/DeleteCitaPaciente.jsp");
		System.out.println("5333333");
	}
}
