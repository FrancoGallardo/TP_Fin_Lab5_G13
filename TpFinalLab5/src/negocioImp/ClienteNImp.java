package negocioImp;

import java.util.List;

import entidad.Cliente;
import negocio.ClienteN;
import funcionesDAOImp.ClienteDAOImp;

public class ClienteNImp implements ClienteN{

	ClienteDAOImp clientDAO = new ClienteDAOImp();
	
	@Override
	public Cliente verificarCliente(String Username, String Password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertarCliente(Cliente cli) {
		return clientDAO.insertarCliente(cli);
	}

	@Override
	public boolean buscarCliente(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Cliente> obtenerCliente() {
		return clientDAO.obtenerClientes();
	}

	@Override
	public boolean modificar(Cliente usuario) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Cliente verificarCliente(String Username) {
		// TODO Auto-generated method stub
		return null;
	}

}
