package dao;

import java.util.List;

import dao.model.Cita;

public interface CitaDAO {

	public void createCita(Cita cita);
	public void updeteCita(Cita cita);
	public void deleteCita(Cita cita);
	public Cita readCita (int id);
	public List <Cita> readAllCita();
}
