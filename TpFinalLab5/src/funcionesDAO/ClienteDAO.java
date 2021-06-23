package funcionesDAO;

import java.util.List;
import entidad.Cliente;

public interface ClienteDAO {

	public boolean insertarCliente(Cliente cli);
	public Cliente obtenerCliente(String username);
	public boolean buscarCliente(String username);
	public List<Cliente> obtenerClientes();
	public boolean modificar(Cliente cli);

}
