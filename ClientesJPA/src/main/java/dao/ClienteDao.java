package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dominio.Cliente;

@Repository
public class ClienteDao implements ClienteInterface {

	@PersistenceContext
	EntityManager em;
	
	@Transactional
	public boolean alta(Cliente cliente) {
		try {
			em.persist(cliente);
			return true;
		}catch(DataAccessException ex) {ex.printStackTrace();}
		return false;
	}

	@Transactional
	public boolean baja(int idCliente) {
		try {
			Cliente cliente=this.consulta(idCliente);
			em.remove(cliente);
			return true;
		}catch(DataAccessException ex) {ex.printStackTrace();}
		return false;
	}
	@Transactional
	public boolean modificacion(Cliente cliente) {
		try {
			em.merge(cliente);
			return true;
		}catch(DataAccessException ex) {ex.printStackTrace();}
		return false;
	}

	public Cliente consulta(int idCliente) {
	
		return (Cliente) em.find(Cliente.class, idCliente);
		
	}

	public List<Cliente> consulta() {
	Query query=em.createQuery("Select c from Cliente c");
	List<Cliente> todoslosClientes = (List<Cliente>) query.getResultList();
	return todoslosClientes;
		
	}

}
