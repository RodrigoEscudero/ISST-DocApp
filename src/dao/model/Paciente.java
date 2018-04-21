package dao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

@Entity
public class Paciente implements Serializable {
	
	@Id
	private String dni;
	private String password;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private Date nacimiento;
	private String domicilio;
	private String tfno1;
	private String tfno2;
	private String mail;
	
	@Lob
	private byte[] document;
	
	@OneToMany(mappedBy="paciente", fetch= FetchType.EAGER)
	private List <Cita> citas_paciente;
	
	public Paciente () {
		citas_paciente = new ArrayList<>();
	}
	
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public Date getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getTfno1() {
		return tfno1;
	}

	public void setTfno1(String tfno1) {
		this.tfno1 = tfno1;
	}

	public String getTfno2() {
		return tfno2;
	}

	public void setTfno2(String tfno2) {
		this.tfno2 = tfno2;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public byte[] getDocument() {
		return document;
	}

	public void setDocument(byte[] document) {
		this.document = document;
	}

	public List<Cita> getCitas_paciente() {
		return citas_paciente;
	}

	public void setCitas_paciente(List<Cita> citas_paciente) {
		this.citas_paciente = citas_paciente;
	}

	
}
