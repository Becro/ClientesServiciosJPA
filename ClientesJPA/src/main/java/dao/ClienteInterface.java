package dao;
import dominio.Cliente;
import java.util.List;
public interface ClienteInterface {
	
	public boolean alta(Cliente cliente);
	public boolean baja(int idCliente);
	public boolean modificacion(Cliente cliente);
	public Cliente consulta(int idCliente);
	public List<Cliente>consulta();

}
