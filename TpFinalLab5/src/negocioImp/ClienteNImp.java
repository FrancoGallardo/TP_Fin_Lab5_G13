package negocioImp;

import java.util.List;

import entidad.Cliente;
import negocio.ClienteN;
import funcionesDAOImp.ClienteDAOImp;

public class ClienteNImp implements ClienteN{

	ClienteDAOImp clientDAO = new ClienteDAOImp();

	@Override
	public boolean insertarCliente(Cliente cli) {
		return clientDAO.insertarCliente(cli);
	}

	@Override
	public boolean buscarCliente(int DNI) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Cliente> obtenerClientes() {
		return clientDAO.obtenerClientes();
	}

	@Override
	public boolean modificar(Cliente usuario) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Cliente verificarCliente(int DNI) {
		// TODO Auto-generated method stub
		return null;
	}

}
