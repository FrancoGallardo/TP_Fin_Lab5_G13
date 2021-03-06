package negocioImp;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import configCapas.ConfigDAO;
import entidad.Cliente;
import entidad.Usuario;
import negocio.ClienteN;
import funcionesDAOImp.ClienteDAOImp;
import funcionesDAOImp.Conexion;

public class ClienteNImp implements ClienteN{

	private ApplicationContext appContext;
	private ClienteDAOImp clientDAO;
	
	public ClienteNImp() {
		appContext = new AnnotationConfigApplicationContext(ConfigDAO.class);
		clientDAO = (ClienteDAOImp) appContext.getBean("ClienteDAO");
	}
	
	@Override
	public boolean insertarCliente(Cliente cli) {
		return clientDAO.insertarCliente(cli);
	}

	@Override
	public boolean verificarCliente(int DNI) {
		clientDAO.verificarCliente(DNI);
		return false;
	}

	@Override
	public List<Cliente> obtenerClientes() {
		return clientDAO.obtenerClientes();
	}

	@Override
	public boolean modificar(Cliente cliente) {
		clientDAO.modificar(cliente);
		return false;
	}

	@Override
	public Cliente buscarCliente(int DNI) {
		try {
			Cliente cli = new Cliente();
			cli = clientDAO.obtenerCliente(DNI);
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

	@Override
	public Cliente obtenerClientexUsuario(String Usuario) {
		List<Cliente> lstCliente = clientDAO.obtenerClientexUsuario(Usuario);
		if(lstCliente != null) {
			for (Cliente cliente : lstCliente) {
				return cliente;
			}
		} 
		return null;
	}

}
