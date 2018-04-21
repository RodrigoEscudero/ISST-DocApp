package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Synthesizer;

import dao.CitaDAOImplementation;
import dao.MedicoDAOImplementation;
import dao.PacienteDAOImplementation;
import dao.model.Cita;
import dao.model.Medico;
import dao.model.Paciente;


@WebServlet("/SolicitarCitaPacienteServlet")
public class SolicitarCitaPacienteServlet  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String dniPaciente = req.getParameter("paciente_dni");
		String especialidad = req.getParameter("especialidad");
		String idMedicoStr = req.getParameter("medico_elegido");
		System.out.println("CCC"+dniPaciente);
		System.out.println("BBB"+especialidad);
		System.out.println("AAA"+idMedicoStr);
        
	 //dniPaciente  = "1";
		Paciente paciente_dni = PacienteDAOImplementation.getInstance().readPaciente(dniPaciente);

	 	List <Cita> citas = paciente_dni.getCitas_paciente();
		System.out.print("aaaaaaaa"+citas.size());

		System.out.print("ddddddddd"+citas);
        req.getSession().setAttribute("cita_list", citas);
/*
		List <Cita> citas = null;
		Paciente paciente_dni =null;*/
		if (especialidad == null && idMedicoStr == null) {

			List <String> especialidades = MedicoDAOImplementation.getInstance().readEspecialidades();
			paciente_dni = PacienteDAOImplementation.getInstance().readPaciente(dniPaciente);

			req.getSession().setAttribute("paciente_dni", paciente_dni);
			req.getSession().setAttribute("especialidades", especialidades);
			System.out.println("9898989898989898");
			Medico medico = (Medico) MedicoDAOImplementation.getInstance().readMedico(1);

			citas = paciente_dni.getCitas_paciente();

			resp.sendRedirect(req.getContextPath() + "/SolicitarCitaPaciente.jsp");

		}

		if (especialidad !=null && idMedicoStr == null) {

			paciente_dni = PacienteDAOImplementation.getInstance().readPaciente(dniPaciente);
			List <Medico> medicos = MedicoDAOImplementation.getInstance().readMedicoEspecialidad(especialidad);

			req.getSession().setAttribute("paciente_dni", paciente_dni);
			req.getSession().setAttribute("especialidad", especialidad);
			req.getSession().setAttribute("list_medicos", medicos);


			resp.sendRedirect(req.getContextPath() + "/SolicitarCitaPaciente.jsp");
			System.out.println(medicos);
			System.out.println(especialidad);
			System.out.println("555555555");

		}

		if (especialidad != null && idMedicoStr != null) {
			int idMedico= Integer.parseInt(idMedicoStr);
			paciente_dni = PacienteDAOImplementation.getInstance().readPaciente(dniPaciente);
			Medico medico = (Medico) MedicoDAOImplementation.getInstance().readMedico(idMedico);
			citas = paciente_dni.getCitas_paciente();
			
			Cita cita = new Cita();
			cita.setPaciente(paciente_dni);
			cita.setMedico(medico);
			cita.setEspecialidad(medico.getEspecialidad());
			cita.setComentarios("blabla");

			CitaDAOImplementation.getInstance().createCita(cita);
			citas.add(cita);

			paciente_dni.setCitas_paciente(citas);
			medico.setCitas_medico(citas);
			
			PacienteDAOImplementation.getInstance().updatePaciente(paciente_dni);
			MedicoDAOImplementation.getInstance().updateMedico(medico);
			CitaDAOImplementation.getInstance().updeteCita(cita);

			req.getSession().setAttribute("cita_list", citas);

			resp.sendRedirect(req.getContextPath() + "/SolicitarCitaPaciente.jsp");
			System.out.println("5333333");


		}
	}
}
