package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import util.Consulta;
import util.EmailHandler;


@WebServlet("/SolicitarCitaPacienteServlet")
public class SolicitarCitaPacienteServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String dniPaciente = req.getParameter("paciente_dni");
		String especialidad = req.getParameter("especialidad");
		String idMedicoStr = req.getParameter("medico_elegido");
		String fechaStr = req.getParameter("diaCita");
		String horaStr = req.getParameter("h_elegida");
		String estado = req.getParameter("estado");
		String observaciones = req.getParameter("comentarios");
		Paciente paciente_dni = PacienteDAOImplementation.getInstance().readPaciente(dniPaciente);
		List <Cita> citas = paciente_dni.getCitas_paciente();

		req.getSession().setAttribute("cita_list", citas);
		req.getSession().setAttribute("comova", "");
		req.getSession().setAttribute("turu", "Elija fecha");
		
		if (estado.equals("0")) {

			List <String> especialidades = MedicoDAOImplementation.getInstance().readEspecialidades();
			paciente_dni = PacienteDAOImplementation.getInstance().readPaciente(dniPaciente);

			req.getSession().setAttribute("paciente_dni", paciente_dni);
			req.getSession().setAttribute("especialidades", especialidades);
			req.getSession().setAttribute("especialidad", "vacia");
			req.getSession().setAttribute("mimed", "vacia");

			citas = paciente_dni.getCitas_paciente();

			resp.sendRedirect(req.getContextPath() + "/SolicitarCitaPaciente.jsp");
		}

		if (estado.equals("1")) {

			paciente_dni = PacienteDAOImplementation.getInstance().readPaciente(dniPaciente);
			List <Medico> medicos = MedicoDAOImplementation.getInstance().readMedicoEspecialidad(especialidad);

			req.getSession().setAttribute("paciente_dni", paciente_dni);
			req.getSession().setAttribute("especialidad", especialidad);
			req.getSession().setAttribute("list_medicos", medicos);

			resp.sendRedirect(req.getContextPath() + "/SolicitarCitaPaciente.jsp");
		}
		if (estado.equals("2")) {
			int idMedico= Integer.parseInt(idMedicoStr);
			Medico medico = (Medico) MedicoDAOImplementation.getInstance().readMedico(idMedico);
			Date fecha = null;
			try {
				SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

				fecha = formatter.parse(fechaStr);
			} catch (ParseException e) {
				e.printStackTrace();
			}

			req.getSession().setAttribute("medico_elegido", medico);
			req.getSession().setAttribute("mimed", medico.getNombre());

			String [] horas =  Consulta.gethorasLibresDia(medico,fecha);
			String [] horas2 =  Consulta.getHorasDiasSiguientes(medico, fecha, 1);
			String [] horas3 =  Consulta.getHorasDiasSiguientes(medico, fecha, 2);

			req.getSession().setAttribute("h_elegida", horas);
			req.getSession().setAttribute("diaCita", fechaStr);
			req.getSession().setAttribute("turu", fechaStr);

			req.getSession().setAttribute("horas_2", horas2);
			req.getSession().setAttribute("horas_3", horas3);
			req.getSession().setAttribute("Dia2",  Consulta.addDays(fecha, 1));
			req.getSession().setAttribute("Dia3",  Consulta.addDays(fecha, 2));

			resp.sendRedirect(req.getContextPath() + "/SolicitarCitaPaciente.jsp");
		}

		if (estado.equals("3")) {

			int idMedico= Integer.parseInt(idMedicoStr);
			paciente_dni = PacienteDAOImplementation.getInstance().readPaciente(dniPaciente);
			Medico medico = (Medico) MedicoDAOImplementation.getInstance().readMedico(idMedico);
			citas = paciente_dni.getCitas_paciente();

			if(horaStr.equals("") || horaStr.equals(Consulta.feriado)){
				req.getSession().setAttribute("comova", "parametros incorrectos");
				resp.sendRedirect(req.getContextPath() + "/SolicitarCitaPaciente.jsp");
			}else {
				Cita cita = new Cita();
				Date fecha=null;
				try {
					SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
					fecha = formatter.parse(fechaStr);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				cita.setFechaCita(fecha);
				cita.setHoraInicio(horaStr);
				cita.setPaciente(paciente_dni);
				cita.setMedico(medico);
				cita.setEspecialidad(medico.getEspecialidad());
				cita.setComentarios(observaciones);

				CitaDAOImplementation.getInstance().createCita(cita);
				citas.add(cita);
				paciente_dni.setCitas_paciente(citas);
				medico.setCitas_medico(citas);
				
				String mensaje = "Hola "+cita.getPaciente().getNombre()+" se ha procesado con exito el proceso de solicitud de cita"+'\n'+
						"La cita esta programada con "+ cita.getMedico().getNombre()+" que pasa consula el dia "+fechaStr+'\n'+
						"a las "+cita.getHoraInicio()+" en la consulta "+cita.getMedico().getLugar();

				EmailHandler polo = new EmailHandler();
				polo.sendEmail("DocAppHospitales@gmail.com", cita.getPaciente().getMail(), "Solicitud de cita el dia: "+fechaStr, mensaje);
				
				req.getSession().setAttribute("cita_list", citas);
				resp.sendRedirect(req.getContextPath() + "/SolicitarCitaPaciente.jsp");
			}
		}
	}
}
