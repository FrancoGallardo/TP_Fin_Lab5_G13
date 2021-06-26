package negocio;

import java.util.List;

import entidad.Cliente;

public interface ClienteN {
	public Cliente verificarCliente(String Username , String Password);
	public boolean insertarCliente(Cliente cli);
	public boolean buscarCliente(int id);
	public List<Cliente> obtenerCliente();
	public boolean modificar(Cliente usuario);
	public Cliente verificarCliente(String Username);
}
