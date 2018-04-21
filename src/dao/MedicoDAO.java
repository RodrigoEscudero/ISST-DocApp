package dao;

import java.util.List;

import dao.model.Medico;

public interface MedicoDAO {

	
	public void createMedico(Medico medico);
	public void updateMedico(Medico medico);
	public void deleteMedico(Medico medico);
	public Medico readMedico (int id);
	public Medico loginMedico(int id, String password);
	public List <Medico> readAllMedico();
	public List <Medico> readMedicoEspecialidad(String especialidad);
	public List <String> readEspecialidades();
}
