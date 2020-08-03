package dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dominio.Servicio;

@Repository
public class ServicioDao implements ServicioInterface {
		@PersistenceContext
		EntityManager em;
		
		@Transactional
	public boolean alta(Servicio servicio) {
		try{em.persist(servicio);return true; }catch(DataAccessException ex) {ex.printStackTrace();}return false;
	}
		@Transactional
	public boolean baja(int idServicio) {
			try{Servicio servicio=this.consulta(idServicio);em.remove(servicio);return true; }catch(DataAccessException ex) {ex.printStackTrace();}return false;
	}
		@Transactional
	public boolean modificacion(Servicio servicio) {
			try{em.merge(servicio);return true; }catch(DataAccessException ex) {ex.printStackTrace();}return false;
	}

	public Servicio consulta(int idServicio) {
		
		return (Servicio) em.find(Servicio.class, idServicio);
		
	}

	public List<Servicio> consulta() {
		Query query=em.createQuery("Select s from Servicio s");
		return (List<Servicio>) query.getResultList();
	}

}
