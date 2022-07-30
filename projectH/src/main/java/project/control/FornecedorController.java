package project.control;

import java.util.List;

import project.dao.FornecedorDao;
import project.model.Fornecedor;

public class FornecedorController {
private FornecedorDao fornecedorDao;
	
	public FornecedorController() {
		fornecedorDao = new FornecedorDao();
	}
	
	public Fornecedor getNewCliente() {
		return new Fornecedor();
	}
	
	public void saveFornecedor(Fornecedor produto) {
		fornecedorDao.saveFornecedor(produto);
	}
	
	public List<Fornecedor> listAllFornecedores(){
		return fornecedorDao.listAllFornecedores();
	}
}
