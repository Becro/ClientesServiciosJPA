package dominio;

import javax.persistence.*;

@Entity
@Table(name="TServicio")
public class Servicio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idServicio",unique=true, nullable = false)
	private Integer idServicio;
	@ManyToOne
	@JoinColumn(name = "IdCliente")
	private Cliente cliente;
	@Column(name="Descripcion")
	private String descripcion;
	
	public Servicio() {}

	public Servicio(Cliente cliente,String descripcion) {
		
		
		this.cliente=cliente;
		this.descripcion=descripcion;
		
	}
	
	public Servicio(Integer idServicio,Cliente cliente,String descripcion) {
		
		this.idServicio=idServicio;
		this.cliente=cliente;
		this.descripcion=descripcion;
		
	}

	public Integer getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(Integer idServicio) {
		this.idServicio = idServicio;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Servicio [idServicio=" + idServicio + ", cliente=" + cliente + ", descripcion=" + descripcion + "]";
	}
	
	
	
	

}
