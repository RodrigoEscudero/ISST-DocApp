package dao;

import java.util.List;

import dao.model.Cita;
import dao.model.Paciente;

public interface PacienteDAO {

	
	public void createPaciente(Paciente paciente);
	public void updatePaciente(Paciente paciente);
	public void deletePaciente(Paciente paciente);
	public Paciente readPaciente (String dni);
	public Paciente loginPaciente(String dni, String password);
	public List <Paciente> readAllPaciente();
	public List <Cita> readCitasPaciente(String dni);
}
