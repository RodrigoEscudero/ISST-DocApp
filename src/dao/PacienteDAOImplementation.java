package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import dao.model.Cita;
import dao.model.Paciente;


public class PacienteDAOImplementation implements PacienteDAO {

	public static PacienteDAOImplementation instance;
	private PacienteDAOImplementation() {

	}
	public static PacienteDAOImplementation getInstance() {
		if(null== instance) {
			instance = new PacienteDAOImplementation();
		}
		return instance;
	}

	@Override
	public void createPaciente(Paciente paciente) {

		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.save(paciente);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("PacienteDAOImplementation create:" + e);
		} finally {
			session.close();
		}

	}

	@Override
	public void updatePaciente(Paciente paciente) {

		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(paciente);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("PacienteDAOImplementation update:" + e);
		} finally {
			session.close();
		}

	}

	@Override
	public void deletePaciente(Paciente paciente) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.delete(paciente);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("PacienteDAOImplementation delete:" + e);
		} finally {
			session.close();
		}

	}

	@Override
	public Paciente readPaciente(String dni) {
		Session session = SessionFactoryService.get().openSession();
		Paciente paciente = null;
		try {
			session.beginTransaction();
			paciente = (Paciente) session.get(Paciente.class, dni);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("PacienteDAOImplementation readPaciente:" + e);
		} finally {
			session.close();
		}
		return paciente;
	}

	@Override
	public Paciente loginPaciente(String dni, String password) {

		Session session = SessionFactoryService.get().openSession();
		Paciente paciente = null;
		try {
			session.beginTransaction();
			paciente = (Paciente) session.createQuery("select p from  Paciente p where p.dni = :dni and p.password = :password")
					.setParameter("dni", dni)
					.setParameter("password",password)
					.getSingleResult();
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("PacienteDAOImplementation logiPaciente:" + e);
		} finally {
			session.close();
		}
		return paciente;
	}

	@Override
	public List<Paciente> readAllPaciente() {

		Session session = SessionFactoryService.get().openSession();
		List <Paciente> pacientes= new ArrayList<>();
		try {
			session.beginTransaction();
			pacientes.addAll(session.createQuery("from Paciente").list());
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("PacienteDAOImplementation readAllPaciente:" + e);
		} finally {
			session.close();
		}
		return pacientes;
	}
}
