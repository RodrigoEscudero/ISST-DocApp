package dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import dao.model.Cita;
import dao.model.Medico;
import dao.model.Paciente;

public class CitaDAOImplementation implements CitaDAO {

	public static CitaDAOImplementation instance;
	private CitaDAOImplementation() {}
	
	public static CitaDAOImplementation getInstance() {
		if(null== instance) {
			instance = new CitaDAOImplementation();
		}
		return instance;
	}
	
	@Override
	public void createCita(Cita cita) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.save(cita);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("CitaDAOImplementation create:" + e);
		} finally {
			session.close();
		}
	}

	@Override
	public void updateCita(Cita cita) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(cita);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("CitaDAOImplementation update:" + e);
		} finally {
			session.close();
		}
	}

	@Override
	public void deleteCita(Cita cita) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.delete(cita);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("CitaDAOImplementation delete:" + e);
		} finally {
			session.close();
		}
	}

	public void deleteById(int id){
		Session session = SessionFactoryService.get().openSession();
		Cita cita = null;
		try {
			session.beginTransaction();
		    cita = (Cita)session.load(Cita.class,id);
			session.delete(cita);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("CitaDAOImplementation deleteById:" + e);
		} finally {
			session.close();
		}
	}

	@Override
	public Cita readCita(int id) {
		Session session = SessionFactoryService.get().openSession();
		Cita cita = null;
		try {
			session.beginTransaction();
			cita = (Cita) session.get(Cita.class, id);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("CitaDAOImplementation readPaciente:" + e);
		} finally {
			session.close();
		}
		return cita;
	}

	@Override
	public List<Cita> readAllCita() {
		Session session = SessionFactoryService.get().openSession();
		List <Cita> citas= new ArrayList<>();
		try {
			session.beginTransaction();
			citas.addAll(session.createQuery("from Cita").list());
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("CitaDAOImplementation readAllCita:" + e);
		} finally {
			session.close();
		}
		return citas;
	}
}
