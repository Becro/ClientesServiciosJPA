package dao;

import java.util.List;

import dominio.Servicio;

public interface ServicioInterface {
	
	public boolean alta(Servicio servicio);
	public boolean baja(int idServicio);
	public boolean modificacion(Servicio servicio);
	public Servicio consulta(int idServicio);
	public List<Servicio>consulta();

}
