package negocioImp;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import configCapas.ConfigDAO;
import entidad.Cliente;
import entidad.Usuario;
import negocio.ClienteN;
import funcionesDAOImp.ClienteDAOImp;

public class ClienteNImp implements ClienteN{

	private ApplicationContext appContext;
	private ClienteDAOImp clientDAO;
	
	public ClienteNImp() {
		Inicializar();
	}

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
		try {
			Cliente cli = new Cliente();
			cli = clientDAO.verificarCliente(DNI);
			return cli;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public void Inicializar() {
		appContext = new AnnotationConfigApplicationContext(ConfigDAO.class);
		clientDAO = (ClienteDAOImp) appContext.getBean("ClienteDAO");
	}

}
