package dao;

import java.util.List;

import dao.model.Cita;

public interface CitaDAO {

	public void createCita(Cita cita);
	public void updateCita(Cita cita);
	public void deleteCita(Cita cita);
	public void deleteById(int id);
	public Cita readCita (int id);
	public List <Cita> readAllCita();
}
