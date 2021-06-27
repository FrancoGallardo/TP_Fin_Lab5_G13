package negocio;

import java.util.List;

import entidad.Cliente;

public interface ClienteN {

	public boolean insertarCliente(Cliente cli);
	public boolean buscarCliente(int id);
	public List<Cliente> obtenerClientes();
	public boolean modificar(Cliente usuario);
	public Cliente verificarCliente(String Username);
}
