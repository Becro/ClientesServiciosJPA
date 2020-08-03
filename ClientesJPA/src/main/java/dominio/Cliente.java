package dominio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="TCliente")
public class Cliente {
	
	

	@Id
	@Column(name="idCliente")
	private Integer idCliente;
	@Column(name="nombre")
	private String nombre;
	@Column(name="apellidos")
	private String apellidos;
	@Column(name="telefono")
	private String telefono;
	@Column(name="correo")
	private String correo;
	@OneToMany(mappedBy = "cliente", cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	List<Servicio>servicios;
	
	
	public Cliente() {}
	
	
	
public Cliente(Integer idCliente, String nombre, String apellidos, String telefono, String correo, List<Servicio>servicios) {
		
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.correo = correo;
		this.servicios=servicios;
	}
	

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}



	public String getTelefono() {
		return telefono;
	}



	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



	public String getCorreo() {
		return correo;
	}



	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	



	public List<Servicio> getServicios() {
		return servicios;
	}



	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}



	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nombre=" + nombre + ", apellidos=" + apellidos + ", telefono="
				+ telefono + ", correo=" + correo + "]";
	}
	
	
	
	
	
}
