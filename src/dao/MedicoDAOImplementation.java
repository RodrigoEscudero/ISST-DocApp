package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import dao.model.Medico;

public class MedicoDAOImplementation implements MedicoDAO{


	public static MedicoDAOImplementation instance;
	private MedicoDAOImplementation() {

	}
	public static MedicoDAOImplementation getInstance() {
		if(null== instance) {
			instance = new MedicoDAOImplementation();
		}
		return instance;
	}
	@Override
	public void createMedico(Medico medico) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.save(medico);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("MedicoDAOImplementation create:" + e);
		} finally {
			session.close();
		}
	}


	@Override
	public void updateMedico(Medico medico) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(medico);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("MedicoDAOImplementation update:" + e);
		} finally {
			session.close();
		}

	}

	@Override
	public void deleteMedico(Medico medico) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.delete(medico);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("MedicoDAOImplementation delete:" + e);
		} finally {
			session.close();
		}
	}

	@Override
	public Medico readMedico(int id) {

		Session session = SessionFactoryService.get().openSession();
		Medico medico = null;
		try {
			session.beginTransaction();
			medico = (Medico) session.get(Medico.class, id);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("MedicoDAOImplementation readMedico:" + e);
		} finally {
			session.close();
		}

		return medico;
	}

	@Override
	public Medico loginMedico(int id, String password) {
		Session session = SessionFactoryService.get().openSession();
		Medico medico = null;
		try {
			session.beginTransaction();
			medico = (Medico) session.createQuery("select m from  Medico m where m.id = :id and m.password = :password")
					.setParameter("id", id)
					.setParameter("password",password)
					.getSingleResult();
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("MedicoDAOImplementation loginMedico:" + e);
		} finally {
			session.close();
		}
		return medico;
	}

	@Override
	public List<Medico> readAllMedico() {

		Session session = SessionFactoryService.get().openSession();
		List <Medico> medicos= new ArrayList<>();
		try {
			session.beginTransaction();
			medicos.addAll(session.createQuery("from Medico").list());
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("MedicoDAOImplementation readAllMedico:" + e);
		} finally {
			session.close();
		}
		return medicos;
	}

	@Override
	public List<Medico> readMedicoEspecialidad(String especialidad) {
		// TODO Auto-generated method stub
		Session session = SessionFactoryService.get().openSession();
		List <Medico> medicos= new ArrayList<>();
		try {
			session.beginTransaction();
			medicos = session.createQuery("select m from  Medico m where m.especialidad = :especialidad")
					.setParameter("especialidad", especialidad).list();
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("MedicoDAOImplementation readMedicoEspecialidad:" + e);
		} finally {
			session.close();
		}
		return medicos;
	}

	@Override
	public List<String> readEspecialidades() {
		Session session = SessionFactoryService.get().openSession();
		List <String> especialidades= new ArrayList<>();
		try {
			session.beginTransaction();
			especialidades = session.createQuery("select distinct(m.especialidad) from  Medico m")
					.list();
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("MedicoDAOImplementation readEspecialidades:" + e);
		} finally {
			session.close();
		}
		return especialidades;
	}
}
