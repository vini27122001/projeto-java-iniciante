package project.control;

import java.util.List;

import project.dao.ClienteDao;
import project.model.Cliente;

public class ClienteController {

	private ClienteDao clienteDao;
	
	public ClienteController() {
		clienteDao = new ClienteDao();
	}
	
	public Cliente getNewCliente() {
		return new Cliente();
	}
	
	public void saveCliente(Cliente produto) {
		clienteDao.saveCliente(produto);
	}
	
	public List<Cliente> listAllClientes(){
		return clienteDao.listAllClientes();
	}
	

}
