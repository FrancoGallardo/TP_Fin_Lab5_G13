package negocio;

import java.util.List;

import entidad.Cliente;

public interface ClienteN {

	public boolean insertarCliente(Cliente cli);
	public boolean verificarCliente(int DNI);
	public List<Cliente> obtenerClientes();
	public boolean modificar(Cliente cli);
	public Cliente buscarCliente(int DNI);
	public void Inicializar();
}
