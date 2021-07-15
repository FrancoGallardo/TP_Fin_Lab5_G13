package funcionesDAO;

import java.util.List;
import entidad.Cliente;
import entidad.Usuario;

public interface ClienteDAO {

	public boolean insertarCliente(Cliente cli);
	public Cliente verificarCliente(int DNI);
	public boolean buscarCliente(int DNI);
	public List<Cliente> obtenerClientes();
	public boolean modificar(Cliente cli);
	public Cliente obtenerCliente(int DNI);
	public void Finalizar();
	public void Inicializar();
	
}
