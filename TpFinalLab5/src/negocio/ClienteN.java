package negocio;

import java.util.List;

import entidad.Cliente;

public interface ClienteN {

	public boolean insertarCliente(Cliente cli);
	public boolean buscarCliente(int DNI);
	public List<Cliente> obtenerClientes();
	public boolean modificar(Cliente cli);
	public Cliente verificarCliente(int DNI);
}
