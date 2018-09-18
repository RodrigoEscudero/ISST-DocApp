package util;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import dao.CitaDAOImplementation;
import dao.model.Cita;
import dao.model.Medico;
import dao.model.Paciente;

public class Consulta {

	public static final String feriado = "Festivo";

	private static boolean esFestivo(Date fecha) {

		Calendar cl= Calendar.getInstance();
		cl.setTime(fecha);
		int diaSemana =cl.get(Calendar.DAY_OF_WEEK);

		return diaSemana==1 || diaSemana ==7;
	}

	public static String [] gethorasLibresDia(Medico medico, Date fecha){

		if (esFestivo(fecha)) {
			String [] horas = {feriado};
			return horas;
		}

		List <Cita> citas_medico = medico.getCitas_medico();
		String [] milhoras= medico.getHoras();
		String [] horas = new  String[milhoras.length];
		for (int i=0; i<milhoras.length; i++) {
			horas[i] = milhoras[i];
		}
		System.out.println("horas "+Arrays.toString(horas));
		System.out.println("FECHA  "+fecha);
		for (Cita element : citas_medico) {
			if (fecha.equals(element.getFechaCita())) {
				for (int i = 0; i < horas.length; i++) {
					System.out.println("comparar"+element.getHoraInicio()+" con "+ horas[i]);
					if (horas[i].equals(element.getHoraInicio())) {
						horas[i]="";
					}
				}
			}
		}
		return horas;
	}

	private static Date asDataBase(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.HOUR_OF_DAY, 0);

		return calendar.getTime();
	}

	public static Date addDays(Date date, int days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, days); //minus number would decrement the days
		return asDataBase(cal.getTime());
	}

	public static String [] getHorasDiasSiguientes(Medico medico, Date fecha, int delta) {
		System.out.println("FECHA  "+fecha+ " un delta de "+delta);
		Date  fecha1 = addDays(fecha,delta);
		System.out.println("FECHADELTA  "+fecha1+ " un delta de "+delta);

		String [] horas= gethorasLibresDia(medico, fecha1);

		return horas;
	}


	public static Cita altaCita(Paciente paciente, Medico medico, Date fecha, String hora, String observaciones, int status) {
		Cita cita = new Cita();
		cita.setFechaCita(fecha);
		cita.setHoraInicio(hora);
		cita.setPaciente(paciente);
		cita.setMedico(medico);
		cita.setStatus(status);
		cita.setEspecialidad(medico.getEspecialidad());
		cita.setComentarios(observaciones);

		CitaDAOImplementation.getInstance().createCita(cita);

		return cita;
	}

	public static void sendemail(Cita cita, String asunto, String mensaje) {
		EmailHandler polo = new EmailHandler();
		polo.sendEmail("DocAppHospitales@gmail.com", cita.getPaciente().getMail(), asunto, mensaje);
	}

	public static String sumaCincoMin(Date date, String hora) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		String[] parts = hora.split(":");
		cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(parts[0]));
		cal.set(Calendar.MINUTE, Integer.parseInt(parts[1]));
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		Date pp = new Date (cal.getTime().getTime()+300000);
		Format formatter = new SimpleDateFormat("HH:mm");
		return formatter.format(pp);
	}
}