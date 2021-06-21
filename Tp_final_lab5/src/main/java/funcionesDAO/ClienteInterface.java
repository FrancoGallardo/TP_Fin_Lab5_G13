package funcionesDAO;

import java.util.List;

import entidad.Cliente;

public interface ClienteInterface {
	public boolean AddCliente(Cliente cli);
	public Cliente GetCliente(int DNI);
	public List<Cliente> GetClientes();
	public boolean Update(Cliente cli);
}
